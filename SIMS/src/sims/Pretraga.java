package sims;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import sims.prikazRecepta;

public class Pretraga implements ActionListener {
	int posna,slatka,vreme_s;
	
	
	
	public Pretraga(int posno, int slatko, int vreme) {
		posna=posno;
		slatka=slatko;
		vreme_s=vreme;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ArrayList<Recept> nadjeni = new ArrayList<>();
		if(Main.ulogovan!=null){
			loop:
			for(Recept r:Main.recepti){
				for(Sastojak s:r.getPotrebni_sastojci()){
					if(!Main.ulogovan.getSastojci().contains(s)){
						break loop;
					}
				}
				
				for(Oprema o:r.getPotrebna_oprema()){
					if(!Main.ulogovan.getOprema().contains(o)){
						break loop;
					}
				}
				
				
				if(posna!=r.getPosno()){
				}
				
				switch (vreme_s) {
				case 0:
					if(!(r.getVreme()>100)){
						break loop;
					}
					break;
				case 1:
					if(!(r.getVreme()<100&&r.getVreme()>30)){
						break loop;
					}
					break;
				case 2:
					if(!(r.getVreme()<30)){
						break loop;
					}
					break;
				default:
					break;
				}
				
				if(r.getVr().ordinal()!=slatka){
					break loop;
				}
				nadjeni.add(r);
				
			}
			
		}
		else{
			loop:
				for(Recept r:Main.recepti){
					for(Sastojak s:r.getPotrebni_sastojci()){
						if(!Main.privremeni_sastojci.contains(s)){
							break loop;
						}
					}
					
					for(Oprema o:r.getPotrebna_oprema()){
						if(!Main.privremena_oprema.contains(o)){
							break loop;
						}
					}
					
					
					if(posna!=r.getPosno()){
						break loop;
					}
					
					switch (vreme_s) {
					case 0:
						if(!(r.getVreme()>100)){
							break loop;
						}
						break;
					case 1:
						if(!(r.getVreme()<100&&r.getVreme()>30)){
							break loop;
						}
						break;
					case 2:
						if(!(r.getVreme()<30)){
							break loop;
						}
						break;
					default:
						break;
					}
					
					if(r.getVr().ordinal()!=slatka){
						break loop;
					}
					nadjeni.add(r);
					
				}
		}
		
		new prikazRecepta(nadjeni);
		

	}

	

}
