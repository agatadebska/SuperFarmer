package resources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;

public class DicePanel extends JPanel implements ActionListener{
	public Kostka1 kostka1;
	public Kostka2 kostka2;
	
	DicePanel(){
		setOpaque(false);
		setBounds( 0, 200, 600, 200);
		kostka1 = new Kostka1(this);
		add(kostka1);
		kostka2 = new Kostka2(this);
		add(kostka2);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if(source instanceof Kostka1){
			Random r = new Random();
			kostka1.setText(kostka1.tabl_wyn.elementAt(r.nextInt(12)));
			kostka1.setEnabled(false);
			}
		
		else if(source instanceof Kostka2){
			Random r = new Random();
			kostka2.setText(kostka2.tabl_wyn.elementAt(r.nextInt(12)));
			kostka2.setEnabled(false);
			}
		if(kostka1.isEnabled()==false && kostka2.isEnabled()==false){
			kostka1.setEnabled(true);
			kostka2.setEnabled(true);
		}
		
	}

	
}
