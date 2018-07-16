package sims;

import java.util.List;
import java.util.Map;

public class Recept {
	private Integer id;
	private String naziv;
	private List<Sastojak> potrebni_sastojci; //int je 0 ako nije kljucni sastojak 1 ako jeste
	private String priprema;
	private List<Oprema> potrebna_oprema;
	private User kreirao;		//null ako je admin
	private Vrsta vr;
	private Integer posno;		//0-ako nije 1-ako jeste
	private Integer vreme;
	private List<String> komentari;
	private List<String> ocene;
	public Recept(Integer id, String naziv, List<Sastojak> potrebni_sastojci, String priprema,
			List<Oprema> potrebna_oprema, User kreirao, Vrsta vr, Integer posno, Integer vreme, List<String> komentari,
			List<String> ocene) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.potrebni_sastojci = potrebni_sastojci;
		this.priprema = priprema;
		this.potrebna_oprema = potrebna_oprema;
		this.kreirao = kreirao;
		this.vr = vr;
		this.posno = posno;
		this.vreme = vreme;
		this.komentari = komentari;
		this.ocene = ocene;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<Sastojak> getPotrebni_sastojci() {
		return potrebni_sastojci;
	}
	public void setPotrebni_sastojci(List<Sastojak> potrebni_sastojci) {
		this.potrebni_sastojci = potrebni_sastojci;
	}
	public String getPriprema() {
		return priprema;
	}
	public void setPriprema(String priprema) {
		this.priprema = priprema;
	}
	public List<Oprema> getPotrebna_oprema() {
		return potrebna_oprema;
	}
	public void setPotrebna_oprema(List<Oprema> potrebna_oprema) {
		this.potrebna_oprema = potrebna_oprema;
	}
	public User getKreirao() {
		return kreirao;
	}
	public void setKreirao(User kreirao) {
		this.kreirao = kreirao;
	}
	public Vrsta getVr() {
		return vr;
	}
	public void setVr(Vrsta vr) {
		this.vr = vr;
	}
	public Integer getPosno() {
		return posno;
	}
	public void setPosno(Integer posno) {
		this.posno = posno;
	}
	public Integer getVreme() {
		return vreme;
	}
	public void setVreme(Integer vreme) {
		this.vreme = vreme;
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
