package sims;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class Akcije {
	private static int i=0;

	public static void do_login(JFrame login_win, JFrame parent)  
	{  
	       login_win = new JFrame("Login");
	       login_win.setVisible(true);
	       login_win.setSize(300, 160);
	       login_win.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	       
	       JPanel panel = new JPanel();
	       panel.setLayout(null);

	       JLabel korisnicko_lab = new JLabel("Username");
	       korisnicko_lab.setFont(new Font(korisnicko_lab.getName(), Font.PLAIN, 18));
	       korisnicko_lab.setBounds(10, 10, 100, 25);
	       panel.add(korisnicko_lab);

	       JTextField korisnicko = new JTextField(20);
	       korisnicko.setBounds(100, 10, 160, 25);
	       panel.add(korisnicko);

	       JLabel password_lab = new JLabel("Password");
	       password_lab.setFont(new Font(password_lab.getName(), Font.PLAIN, 18));
	       password_lab.setBounds(10, 40, 100, 25);
	       panel.add(password_lab);

	       JPasswordField password = new JPasswordField(20);
	       password.setBounds(100, 40, 160, 25);
	       panel.add(password);

	       JButton loginButton = new JButton("login");
	       loginButton.setFont(new Font(loginButton.getName(), Font.PLAIN, 18));
	       loginButton.setBounds(100, 80, 80, 25);
	       panel.add(loginButton);
	       login_win.add(panel);
	       
	       
	       loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
			       /*for(Map.Entry<String, User> pair : mapa_korisnika.entrySet()) {
			    	    if(pair.getKey()==korisnicko.getText()){
			    	    	if(pair.getValue().getPassword()!=String.valueOf(password.getPassword())){
			    	    		JOptionPane.showMessageDialog(null, "Incorrect password!", "Warning", JOptionPane.WARNING_MESSAGE); 
			    	    	}
			    	    	else{
			    	    	found=true;
			    	    	break;
			    	    	}
			    	    }
			    	}*/
			       
			       if(!found){
			    	   JOptionPane.showMessageDialog(null, "Incorrect username and password", "Wrong!", JOptionPane.INFORMATION_MESSAGE); 
			       }
			       else{
			    	   parent.dispose();
			    	   new Window(0);
			    	   
			       }
			} 
		});
	     
	}
	public static void do_register(JFrame register_win, JFrame parent)  
	{  
	     register_win = new JFrame("Register");
	     register_win.setVisible(true);
	     register_win.setSize(300, 230);
	     register_win.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	       
	     JPanel panel = new JPanel();
	     panel.setLayout(null);

	     JLabel ime_lab = new JLabel("Ime");
	     ime_lab.setFont(new Font(ime_lab.getName(), Font.PLAIN, 18));
	     ime_lab.setBounds(10, 10, 100, 25);
	     panel.add(ime_lab);

	     JTextField ime = new JTextField(20);
	     ime.setBounds(100, 10, 160, 25);
	     panel.add(ime);
	     
	     JLabel prz_lab = new JLabel("Prezime");
	     prz_lab.setFont(new Font(prz_lab.getName(), Font.PLAIN, 18));
	     prz_lab.setBounds(10, 40, 100, 25);
	     panel.add(prz_lab);

	     JTextField prezime = new JTextField(20);
	     prezime.setBounds(100, 40, 160, 25);
	     panel.add(prezime);
	     
	     JLabel username_lab = new JLabel("Username");
	     username_lab.setFont(new Font(username_lab.getName(), Font.PLAIN, 18));
	     username_lab.setBounds(10, 70, 100, 25);
	     panel.add(username_lab);

	     JTextField username = new JTextField(20);
	     username.setBounds(100, 70, 160, 25);
	     panel.add(username);
	     
	     JLabel password_lab = new JLabel("Password");
	     password_lab.setFont(new Font(password_lab.getName(), Font.PLAIN, 18));
	     password_lab.setBounds(10, 100, 100, 25);
	     panel.add(password_lab);

	     JPasswordField password = new JPasswordField(20);
	     password.setBounds(100, 100, 160, 25);
	     panel.add(password);
	       

	     JButton registerButton = new JButton("register");
	     registerButton.setFont(new Font(registerButton.getName(), Font.PLAIN, 18));
	     registerButton.setBounds(100, 140, 100, 25);
	     panel.add(registerButton);
	     register_win.add(panel);
	     
	     
	     /*registerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					boolean found = false;
				       for(Map.Entry<String, User> pair : mapa_korisnika.entrySet()) {
				    	    if(pair.getKey()==username.getText()){
				    	    	found=true;
				    	    	break;
				    	    }
				    }
				    	
				       
				       if(found){
				    	   JOptionPane.showMessageDialog(null, "Username already exists!", "Wrong!", JOptionPane.INFORMATION_MESSAGE); 
				       }
				       else{
				    	   User u = new User(ime.getText(), prezime.getText(), username.getText(), String.valueOf(password.getPassword()),0,0,null,null,null,null);
				   	       mapa_korisnika.put(username.getText(), u);
				    	   parent.dispose();
				    	   new Window(0);
				    	   
				       }
				} 
			});*/
	}
};
