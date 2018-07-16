package sims;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import sims.Window.CheckBoxGrid;

public class Primeni implements ActionListener {
	CheckBoxGrid grid;
	CheckBoxGrid grid2;
	
	
	public Primeni(CheckBoxGrid gridd, CheckBoxGrid gridd2) {
		grid=gridd;
		grid2=gridd2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		java.util.List<Sastojak> sastojci = new ArrayList<>();
		
		int i=0;
		outerloop:
		for (int cbRow = 0; cbRow < grid.getChbx().length; cbRow++) {
    		  for (int cbCol = 0; cbCol < grid.getChbx()[cbRow].length; cbCol++){
    			  if(grid.getChbx()[cbRow][cbCol].isSelected()){
    				  for(Sastojak s:Main.sastojci){
    					  if(s.getNaziv().equals(grid.getChbx()[cbRow][cbCol].getText())){
    						  sastojci.add(s);
    						  break;
    					  }
    				  }
    				  
    				  
    			  }
    			  if(i==Main.sastojci.size()-1){
					  break outerloop;
				  }
				  i++;
    		  }
    		  
		}
		
		java.util.List<Oprema> oprema = new ArrayList<>();
		i=0;
		outerloop:
		for (int cbRow = 0; cbRow < grid2.getChbx1().length; cbRow++) {
    		  for (int cbCol = 0; cbCol < grid2.getChbx1()[cbRow].length; cbCol++){
    			  if(grid2.getChbx1()[cbRow][cbCol].isSelected()){
    				  for(Oprema s:Main.oprema){
    					  if(s.getNaziv().equals(grid2.getChbx1()[cbRow][cbCol].getText())){
    						  oprema.add(s);
    						  break;
    					  }
    				  }
    				  
    				  
    			  }
    			  if(i==Main.oprema.size()-1){
					  break outerloop;
				  }
				  i++;
    		  }
    		  
		}
		if(Main.ulogovan!=null){
			Akcije.updateKorisnika(sastojci,oprema);
		}
		else{
			Main.privremena_oprema=oprema;
			Main.privremeni_sastojci=sastojci;
		}
		

	}

}
