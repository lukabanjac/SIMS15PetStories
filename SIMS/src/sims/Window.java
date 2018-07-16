package sims;
import javax.swing.*;
import javax.swing.event.CellEditorListener;

import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.String;
import sims.Akcije.*;
import java.lang.Math;

public class Window {
	private JFrame f;
	private JFrame login_win;
	private JFrame register_win;
	private JPanel glavni;
	private JPanel log;
	private JPanel chbox;
	private JPanel opcija;
	private JTabbedPane tabovi;
	private JPanel oprema;
	private JPanel sastojci;
	private JButton trazi;
	private JLabel login;
	private JLabel register;
	private JLabel logout;
	private JLabel mojFrizider;
	private JLabel mojaOprema;
	private JLabel Bookmark;
	private JLabel unetiRecepti;
	private CheckBoxGrid grid;
	private CheckBoxGrid grid2;
	
	
	
	public Window(int i){
		
		if (i==1){
			neulogovan();
		}
		else{
			ulogovan();
		}
		
		
	}
	
	
	public void neulogovan(){
		f = new JFrame("Dine");
		f.setVisible(true);
		f.setSize(700, 600);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		glavni = new JPanel();
		glavni.setLayout(new BorderLayout());
		f.setContentPane(glavni);
		login = new JLabel("Login");
		login.setFont(new Font(login.getName(), Font.PLAIN, 18));
		register = new JLabel("   Register");
		register.setFont(new Font(register.getName(), Font.PLAIN, 18));
		grid = new CheckBoxGrid("Sastojci", 0);
		grid2 = new CheckBoxGrid("Oprema", 0);
		oprema = new JPanel();
		sastojci = new JPanel();
		trazi = new JButton("Pretrazi");
		
		log = new JPanel();
		log.setLayout(new BorderLayout());
		JPanel podpanel = new JPanel();
	    podpanel.add(login);
	    podpanel.add(register);
		log.add(podpanel, BorderLayout.EAST);
	
		tabovi = new JTabbedPane();
		oprema.setLayout(new GridLayout());
		oprema.add(grid2);
		sastojci.setLayout(new GridLayout());
		sastojci.add(grid);
		tabovi.addTab("Sastojci", sastojci);
		tabovi.addTab("Oprema", oprema);
	
		
		opcija = new JPanel();
		opcija.setLayout(new FlowLayout());
		opcija.add(trazi);
		

		glavni.add(log, BorderLayout.NORTH);
		glavni.add(tabovi, BorderLayout.CENTER);
		glavni.add(opcija, BorderLayout.SOUTH);
		
		login.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e)  
		    {
			Akcije.do_login(login_win,f);
		    }}); 
		register.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e)  
	    {  
			Akcije.do_register(register_win,f);
	    }}); 
		
		
		
	}
	public void ulogovan(){
		f = new JFrame("Dine");
		f.setVisible(true);
		f.setSize(700, 600);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		glavni = new JPanel();
		glavni.setLayout(new BorderLayout());
		f.setContentPane(glavni);
		logout = new JLabel("Logout");
		logout.setFont(new Font(logout.getName(), Font.PLAIN, 18));
		grid = new CheckBoxGrid("Sastojci",1);
		grid2 = new CheckBoxGrid("Oprema",1);
		oprema = new JPanel();
		sastojci = new JPanel();
		trazi = new JButton("Pretrazi");
		
		log = new JPanel();
		log.setLayout(new BorderLayout());
		JPanel podpanel = new JPanel();
	    podpanel.add(logout);
		log.add(podpanel, BorderLayout.EAST);
	
		
		tabovi = new JTabbedPane();
		oprema.setLayout(new GridLayout());
		oprema.add(grid2);
		sastojci.setLayout(new GridLayout());
		sastojci.add(grid);
		tabovi.addTab("Sastojci", sastojci);
		tabovi.addTab("Oprema", oprema);
	
		
		opcija = new JPanel();
		opcija.setLayout(new FlowLayout());
		opcija.add(trazi);
		

		glavni.add(log, BorderLayout.NORTH);
		glavni.add(tabovi, BorderLayout.CENTER);
		glavni.add(opcija, BorderLayout.SOUTH);
		
		
		
	}
	
	
	class CheckBoxGrid extends JPanel {
		   
		   private final int koloneS = (int) Math.ceil(Main.sastojci.size()/10.0);		//izracunati iz sastojaka kolone su uvek 10 a redovi ceil(listofingred.size()/10) :)
		   private final int koloneO = (int) Math.ceil(Main.oprema.size()/10.0);
		   private final int redovi = 10;
		   private final int GAP = -5;
		   private JCheckBox[][] checkBoxes = new JCheckBox[redovi][koloneS];
		   private JCheckBox[][] checkBoxes1 = new JCheckBox[redovi][koloneO];
		   private ItemListener itemListener;
		   

		   public CheckBoxGrid(String naziv, int log) { //log je 0 ako je neulogovan 1 ako logovani menja da bi bili
			   															  //check oni koje ima vec
		
		      setBorder(BorderFactory.createTitledBorder(naziv));
		      if(naziv=="Sastojci"){
		    	  setLayout(new GridLayout(redovi, koloneS, GAP, GAP));
		      
		      
		      int i = 0;
		      if(log==0){
		    	  
		    	  for (int cbRow = 0; cbRow < checkBoxes.length; cbRow++) {
		    		  for (int cbCol = 0; cbCol < checkBoxes[cbRow].length; cbCol++) {
		    			  
		    			  JCheckBox checkBox = new JCheckBox();
				          checkBox.setText(Main.sastojci.get(i).getNaziv());			//ovde staviti iz liste sastojaka i-ti element
				          checkBox.addItemListener(itemListener);
				          add(checkBox);
				          checkBoxes[cbRow][cbCol] = checkBox;
				          if(i==Main.sastojci.size()-1){
		    				  return;
		    			  }
				          i++;
				         }
				  }
		      }
		      else{
		    	  for (int cbRow = 0; cbRow < checkBoxes.length; cbRow++) {
		    		  for (int cbCol = 0; cbCol < checkBoxes[cbRow].length; cbCol++) {
		    			  JCheckBox checkBox = new JCheckBox();
				          checkBox.setText(Main.sastojci.get(i).getNaziv());			//ovde staviti iz liste sastojaka i-ti element
				          for(int j=0; j<Main.ulogovan.getSastojci().size();j++){
				        	  if (Main.sastojci.get(i).equals(Main.ulogovan.getSastojci().get(j))){
				        		  checkBox.setSelected(true);
				        		  break;
				        	  }
				          }
				          checkBox.addItemListener(itemListener);
				          add(checkBox);
				          checkBoxes[cbRow][cbCol] = checkBox;
				          if(i==Main.sastojci.size()-1){
		    				  return;
		    			  }
				          i++;
				         }
				  }
		      }
		   }
		      
		      else{
		    	  setLayout(new GridLayout(redovi, koloneO, GAP, GAP));
			      
			      
			      int i = 0;
			      if(log==0){
			    	  
			    	  for (int cbRow = 0; cbRow < checkBoxes.length; cbRow++) {
			    		  for (int cbCol = 0; cbCol < checkBoxes[cbRow].length; cbCol++) {
			    			  JCheckBox checkBox = new JCheckBox();
					          checkBox.setText(Main.oprema.get(i).getNaziv());			//ovde staviti iz liste sastojaka i-ti element
					          checkBox.addItemListener(itemListener);
					          add(checkBox);
					          checkBoxes[cbRow][cbCol] = checkBox;
					          if(i==Main.oprema.size()-1){
			    				  return;
			    			  }
					          i++;
					         }
					  }
			      }
			      else{
			    	  for (int cbRow = 0; cbRow < checkBoxes.length; cbRow++) {
			    		  for (int cbCol = 0; cbCol < checkBoxes[cbRow].length; cbCol++) {
			    			  JCheckBox checkBox = new JCheckBox();
					          checkBox.setText(Main.oprema.get(i).getNaziv());			//ovde staviti iz liste sastojaka i-ti element
					          for(int j=0; j<Main.ulogovan.getOprema().size();j++){
					        	  if (Main.oprema.get(i).equals(Main.ulogovan.getOprema().get(j))){
					        		  checkBox.setSelected(true);
					        		  break;
					        	  }
					          }
					          checkBox.addItemListener(itemListener);
					          add(checkBox);
					          checkBoxes[cbRow][cbCol] = checkBox;
					          if(i==Main.oprema.size()-1){
			    				  return;
			    			  }
					          i++;
					         }
					  }
			      }
			   
		    	  
		      }
		   }
	}


	
}
