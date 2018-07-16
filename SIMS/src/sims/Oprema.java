package sims;

public class Oprema {
	private Integer id;
	private String naziv;
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
	public Oprema(Integer id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	
	@Override
	public String toString() {
		return getNaziv()+" ";
	}
	
}
