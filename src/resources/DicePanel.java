package resources;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class DicePanel extends JPanel implements ActionListener{

	public Kostka1 kostka1;
	public Kostka2 kostka2;
	DicePanel(){
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBounds( 0, 200, 600, 150);
		kostka1 = new Kostka1(this);
		kostka1.setAlignmentY(Component.CENTER_ALIGNMENT);
		add(Box.createHorizontalGlue());
		add(kostka1);
		kostka2 = new Kostka2(this);
		kostka2.setAlignmentY(Component.CENTER_ALIGNMENT);
		add(Box.createHorizontalStrut(40));
		add(kostka2);
		add(Box.createHorizontalGlue());
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if(source instanceof Kostka1){
			Random r = new Random();
			int wynik = r.nextInt(12);
			if (wynik>=0 && wynik<=5){
				PlayPanel.tabl_kostki[0] = 1;				//krolik
			}
			else if(wynik>=6 && wynik<=8){
				PlayPanel.tabl_kostki[0] = 2;				//owca
			}
			else if(wynik==9){
				PlayPanel.tabl_kostki[0] = 3;				//swinia
			}
			else if(wynik==10){
				PlayPanel.tabl_kostki[0] = 4;				//krowa
			}
			else if(wynik==11){
				PlayPanel.tabl_kostki[0] = 5;				//wilk
			}
			kostka1.setText(kostka1.tabl_wyn.elementAt(wynik));
			kostka1.setEnabled(false);
			}
		
		else if(source instanceof Kostka2){
			Random r = new Random();
			int wynik = r.nextInt(12);
			if (wynik>=0 && wynik<=5){
				PlayPanel.tabl_kostki[1] = 1;				//krolik
			}
			else if(wynik==6 || wynik==7){
				PlayPanel.tabl_kostki[1] = 2;				//owca
			}
			else if(wynik==8 || wynik==9){
				PlayPanel.tabl_kostki[1] = 3;				//swinia
			}
			else if(wynik==10){
				PlayPanel.tabl_kostki[1] = 4;				//kon
			}
			else if(wynik==11){
				PlayPanel.tabl_kostki[1] = 5;				//lis
			}
			kostka2.setText(kostka2.tabl_wyn.elementAt(wynik));
			kostka2.setEnabled(false);
			}
		if(kostka1.isEnabled()==false && kostka2.isEnabled()==false){
			kostka1.setEnabled(true);
			kostka2.setEnabled(true);

			PlayPanel.countAnimals();
		}
		
	}

	
}
