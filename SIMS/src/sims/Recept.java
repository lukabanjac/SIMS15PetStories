package sims;

import java.util.List;
import java.util.Map;

public class Recept {
	private String naziv;
	private Map<String, Integer> potrebni_sastojci; //int je 0 ako nije kljucni sastojak 1 ako jeste
	private List<String> potrebna_oprema;
	private List<String> komentari;
	private List<String> ocene;
	
	public Recept(String naziv, Map<String, Integer> potrebni_sastojci, List<String> potrebna_oprema,
			List<String> komentari, List<String> ocene) {
		super();
		this.naziv = naziv;
		this.potrebni_sastojci = potrebni_sastojci;
		this.potrebna_oprema = potrebna_oprema;
		this.komentari = komentari;
		this.ocene = ocene;
	}
	
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Map<String, Integer> getPotrebni_sastojci() {
		return potrebni_sastojci;
	}
	public void setPotrebni_sastojci(Map<String, Integer> potrebni_sastojci) {
		this.potrebni_sastojci = potrebni_sastojci;
	}
	public List<String> getPotrebna_oprema() {
		return potrebna_oprema;
	}
	public void setPotrebna_oprema(List<String> potrebna_oprema) {
		this.potrebna_oprema = potrebna_oprema;
	}
	public List<String> getKomentari() {
		return komentari;
	}
	public void setKomentari(List<String> komentari) {
		this.komentari = komentari;
	}
	public List<String> getOcene() {
		return ocene;
	}
	public void setOcene(List<String> ocene) {
		this.ocene = ocene;
	}

	
	
}
