package sims;

public class Sastojak {
	
	private String naziv;
	private Integer sifra;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Integer getSifra() {
		return sifra;
	}
	public void setSifra(Integer sifra) {
		this.sifra = sifra;
	}
	public Sastojak(String naziv, Integer sifra) {
		super();
		this.naziv = naziv;
		this.sifra = sifra;
	}
	
	@Override
	public String toString() {
		return getNaziv()+" ";
	}
}
