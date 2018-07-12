package sims;

import java.util.List;

public class User {
	private String ime;
	private String prezime;
	private String username;
	private String password;
	private int type;		//0-obican, 1-premium
	private int bodovi;
	private List<String> sastojci;
	private List<String> oprema;
	private List<Recept> bookmark;
	private List<Recept> unetiRecepti;
	
	
	public User(String ime, String prezime, String username, String password, int type, int bodovi,
			List<String> sastojci, List<String> oprema, List<Recept> bookmark, List<Recept> unetiRecepti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
		this.type = type;
		this.bodovi = bodovi;
		this.sastojci = sastojci;
		this.oprema = oprema;
		this.bookmark = bookmark;
		this.unetiRecepti = unetiRecepti;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getBodovi() {
		return bodovi;
	}
	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}
	public List<String> getSastojci() {
		return sastojci;
	}
	public void setSastojci(List<String> sastojci) {
		this.sastojci = sastojci;
	}
	public List<String> getOprema() {
		return oprema;
	}
	public void setOprema(List<String> oprema) {
		this.oprema = oprema;
	}
	public List<Recept> getBookmark() {
		return bookmark;
	}
	public void setBookmark(List<Recept> bookmark) {
		this.bookmark = bookmark;
	}
	public List<Recept> getUnetiRecepti() {
		return unetiRecepti;
	}
	public void setUnetiRecepti(List<Recept> unetiRecepti) {
		this.unetiRecepti = unetiRecepti;
	}
	
	
	

}
