package sims;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sims.Window;



public class Main {
	
	
	public static ArrayList<Sastojak> sastojci = ucitajSastojke();
	public static ArrayList<Oprema> oprema = ucitajOpremu();
	public static ArrayList<Recept> recepti = ucitajRecepte(sastojci, oprema);
	public static ArrayList<User> mapa_korisnika = ucitajKorisnike();
	public static User ulogovan;
	public static List<Oprema> privremena_oprema = new ArrayList<Oprema>();
	public static List<Sastojak> privremeni_sastojci = new ArrayList<Sastojak>();
	
	
	public static void main(String[] args) {
		new Window(1);
		
		
		
		
		
		
		
	}
	
	

	private static ArrayList<User> ucitajKorisnike() {
		ArrayList<User> rez =new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("Fajlovi\\Korisnici.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] rec = line.split("\\|");
		    	String[] sast = rec[6].split(",");
		    	String[] opr = rec[7].split(",");
		    	String[] book = rec[8].split(",");
		    	String[] dodao = rec[9].split(",");
		    	List<Sastojak> sastojci=new ArrayList<>();
		    	List<Oprema> oprema = new ArrayList<>();
		    	List<Recept> bookmark = new ArrayList<>();
		    	List<Recept> unetiRecepti = new ArrayList<>();
		    	
		    	if(!(sast.length==1 && Integer.valueOf(sast[0])==-1)){
		    		for(String s:sast){
		    			for(Sastojak s1:Main.sastojci){
		    				if(Integer.valueOf(s)==s1.getSifra()){
		    					sastojci.add(s1);
		    				}
		    			}
		    		}
		    	}
		    	if(!(opr.length==1 && Integer.valueOf(opr[0])==-1)){
		    		for(String s:opr){
		    			for(Oprema s1:Main.oprema){
		    				if(Integer.valueOf(s)==s1.getId()){
		    					oprema.add(s1);
		    				}
		    			}
		    		}
		    	}
		    	if(!(book.length==1 && Integer.valueOf(book[0])==-1)){
		    		for(String s:book){
		    			for(Recept s1:Main.recepti){
		    				if(Integer.valueOf(s)==s1.getId()){
		    					bookmark.add(s1);
		    				}
		    			}
		    		}
		    	}
		    	if(!(dodao.length==1 && Integer.valueOf(dodao[0])==-1)){
		    		for(String s:dodao){
		    			for(Recept s1:Main.recepti){
		    				if(Integer.valueOf(s)==s1.getId()){
		    					unetiRecepti.add(s1);
		    					
		    				}
		    			}
		    		}
		    	}
		    	User u = new User(rec[0],rec[1],rec[2],rec[3],Integer.valueOf(rec[4]),Integer.valueOf(rec[5]),sastojci,oprema,bookmark,unetiRecepti);
		    	for(Recept r:unetiRecepti){
		    		r.setKreirao(u);
		    	}
		    	rez.add(u);
		    	
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rez;
	}



	private static ArrayList<Oprema> ucitajOpremu() {
		ArrayList<Oprema> rez =new ArrayList<Oprema>();
		try (BufferedReader br = new BufferedReader(new FileReader("Fajlovi\\Oprema.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] rec = line.split("\\|");
		    	Oprema o = new Oprema(Integer.valueOf(rec[0]), rec[1]);
		    	rez.add(o);
		    	
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rez;
	}

	public static ArrayList<Sastojak> ucitajSastojke(){
		ArrayList<Sastojak> rez =new ArrayList<Sastojak>();
		try (BufferedReader br = new BufferedReader(new FileReader("Fajlovi\\Sastojci.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] rec = line.split("\\|");
		    	Sastojak s = new Sastojak(rec[1], Integer.valueOf(rec[0]));
		    	rez.add(s);
		    	
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rez;
	}

	
	private static ArrayList<Recept> ucitajRecepte(ArrayList<Sastojak> sastojci, ArrayList<Oprema> oprema) {
		ArrayList<Recept> rez =new ArrayList<Recept>();
		List<Sastojak> potrebni_sastojci = new ArrayList<Sastojak>();
		List<Oprema> potrebna_oprema = new ArrayList<Oprema>();
		try (BufferedReader br = new BufferedReader(new FileReader("Fajlovi\\Recepti.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] rec = line.split("\\|");
		    	String[] sastt = rec[2].split(",");
		    	
		    	for(String ss:sastt){
		    		String[] sast = ss.split("\\-");
		    		for(Sastojak s: sastojci){
		    			
		    			if(Integer.valueOf(sast[1])==s.getSifra()){
		    				potrebni_sastojci.add(s);
		    				break;
		    			}
		    			
		    		}
		    	}
		    	String[] opr = rec[4].split("\\,");
		    	for(Oprema o:oprema){
		    		for(String o1:opr){
		    			if(Integer.valueOf(o1)==o.getId()){
		    				potrebna_oprema.add(o);
		    				break;
		    			}
		    		}
		    	}
		    	
		    	User dodao=null;
		    	
		    	Vrsta vrsta=null;
		    	for(Vrsta v: Vrsta.values()){
		    		if(v.name().equals(rec[6])){
		    			vrsta=v;
		    		}
		    	}
		    	
		    	
				
				Recept s = new Recept(Integer.valueOf(rec[0]), rec[1], potrebni_sastojci, rec[3],potrebna_oprema,dodao,vrsta,Integer.valueOf(rec[7]), Integer.valueOf(rec[8]), null,null);
		    	rez.add(s);
		    	
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rez;
	}
}
