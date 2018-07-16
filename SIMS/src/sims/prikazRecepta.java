package sims;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class prikazRecepta extends JFrame{
	
	@SuppressWarnings("rawtypes")
	private JComboBox nadjeni_cmb;
	private JButton prikazi;
	private JLabel naziv,priprema,kreirao,vreme;
	@SuppressWarnings("rawtypes")
	private JList oprema,sastojci;
	private JPanel glavni;
	private JPanel pomocni;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public prikazRecepta(ArrayList<Recept> nadjeni) {
		
		String[] lista=new String[nadjeni.size()];
		int i=0;
		for(Recept r : nadjeni){
			lista[i] = r.getNaziv();
			i++;
		}
		setVisible(true);
		setSize(700, 600);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setName("Dine");
		
		nadjeni_cmb = new JComboBox(lista);
		prikazi = new JButton("Prikazi");
		glavni = new JPanel();
		glavni.setLayout(new BorderLayout());
		nadjeni_cmb.setSelectedIndex(0);
		MyItemListener actionListener = new MyItemListener();
		nadjeni_cmb.addItemListener(actionListener);
		
		prikazi.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  Recept rn=null;
					
						//JComboBox cb = (JComboBox)e.getSource();
						String nazivv = (String) nadjeni_cmb.getSelectedItem();
						for(Recept r:nadjeni){
							if(r.getNaziv().equals(nazivv)){
								rn=r;
								break;
							}
						}
						naziv = new JLabel(rn.getNaziv());
						String[] sast = new String[rn.getPotrebni_sastojci().size()];
						int i=0;
						for(Sastojak s:rn.getPotrebni_sastojci()){
							sast[i] = s.getNaziv();
							i++;
						}
						sastojci = new JList(sast);
						String[] opr = new String[rn.getPotrebna_oprema().size()];
						i=0;
						for(Oprema s:rn.getPotrebna_oprema()){
							opr[i] = s.getNaziv();
							i++;
						}
						
						oprema = new JList(opr);
						priprema = new JLabel(rn.getPriprema());
						if(rn.getKreirao()==null){
							kreirao = new JLabel("Admin");
						}else{
							kreirao = new JLabel(rn.getKreirao().getIme());
						}
						
						vreme = new JLabel(String.valueOf(rn.getVreme()));
						
						
						pomocni = new JPanel(new BorderLayout());
						pomocni.add(naziv, BorderLayout.NORTH);
						JPanel pom1 = new JPanel(new GridLayout(0,2));
						pom1.add(sastojci);
						pom1.add(oprema);
						JPanel pom2 = new JPanel(new BorderLayout());
						pom2.add(priprema, BorderLayout.NORTH);
						JPanel pom3 = new JPanel(new BorderLayout());
						pom3.add(kreirao, BorderLayout.WEST);
						pom3.add(vreme, BorderLayout.EAST);
						JPanel pom4 = new JPanel(new BorderLayout());
						pom4.add(pom2, BorderLayout.NORTH);
						pom4.add(pom3,BorderLayout.SOUTH);
						pomocni.add(pom1,BorderLayout.CENTER);
						pomocni.add(pom4,BorderLayout.SOUTH);
						glavni.add(pomocni, BorderLayout.CENTER);
						revalidate();
						repaint();
						
						
						
					
			  } 
			} );
		
		
		glavni.add(nadjeni_cmb,BorderLayout.NORTH);
		glavni.add(prikazi, BorderLayout.SOUTH);
		add(glavni);
		
		
		
		
	}

	
	
	
	

		
}
class MyItemListener implements ItemListener {
	 
	@Override
	public void itemStateChanged(ItemEvent evt) {
		@SuppressWarnings("rawtypes")
		JComboBox cb = (JComboBox) evt.getSource();

	    Object item = evt.getItem();

	    if (evt.getStateChange() == ItemEvent.SELECTED) {
	      
	    } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
	     
	    }
		
	}
	}


