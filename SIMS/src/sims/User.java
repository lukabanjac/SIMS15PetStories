package sims;

import java.util.List;

public class User {
	private String ime;
	private String prezime;
	private String username;
	private String password;
	private int type;		//0-obican, 1-premium
	private int bodovi;
	private List<Sastojak> sastojci;
	private List<Oprema> oprema;
	private List<Recept> bookmark;
	private List<Recept> unetiRecepti;
	
	
	public User(String ime, String prezime, String username, String password, int type, int bodovi,
			List<Sastojak> sastojci, List<Oprema> oprema, List<Recept> bookmark, List<Recept> unetiRecepti) {
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
	public List<Sastojak> getSastojci() {
		return sastojci;
	}
	public void setSastojci(List<Sastojak> sastojci) {
		this.sastojci = sastojci;
	}
	public List<Oprema> getOprema() {
		return oprema;
	}
	public void setOprema(List<Oprema> oprema) {
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
	
	
	@Override
	public String toString() {
		String sastojci_s = "",oprema_s="",bookmark_s="",uneti_s="";
		if(getSastojci().size()==0){
			sastojci_s = "-1";
		}
		for(int i=0; i<getSastojci().size(); i++){
			if(i!=getSastojci().size()-1){
				sastojci_s+=getSastojci().get(i).getSifra().toString()+",";
			}
			else{
				sastojci_s+=getSastojci().get(i).getSifra().toString();
			}
		}
		if(getOprema().size()==0){
			oprema_s = "-1";
		}
		for(int i=0; i<getOprema().size(); i++){
			if(i!=getOprema().size()-1){
				oprema_s+=getOprema().get(i).getId().toString()+",";
			}
			else{
				oprema_s+=getOprema().get(i).getId().toString();
			}
		}
		if(getBookmark().size()==0){
			bookmark_s = "-1";
		}
		for(int i=0; i<getBookmark().size(); i++){
			if(i!=getBookmark().size()-1){
				bookmark_s+=getBookmark().get(i).getId().toString()+",";
			}
			else{
				bookmark_s+=getBookmark().get(i).getId().toString();
			}
		}
		if(getUnetiRecepti().size()==0){
			uneti_s = "-1";
		}
		for(int i=0; i<getUnetiRecepti().size(); i++){
			if(i!=getUnetiRecepti().size()-1){
				uneti_s+=getUnetiRecepti().get(i).getId().toString()+",";
			}
			else{
				uneti_s+=getUnetiRecepti().get(i).getId().toString();
			}
		}
		return getIme()+"|"+getPrezime()+"|"+getUsername()+"|"+getPassword()+"|"+getType()+"|"+
		getBodovi()+"|"+sastojci_s+"|"+oprema_s+"|"+bookmark_s+"|"+uneti_s;
	}
	
	

}
