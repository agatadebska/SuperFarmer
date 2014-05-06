package resources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;

public class DicePanel extends JPanel{
	public Kostka1 kostka1;
	public Kostka2 kostka2;
	
	DicePanel(ActionListener actionL){
		setOpaque(false);
		setBounds( 0, 200, 600, 200);
		kostka1 = new Kostka1(actionL);
		add(kostka1);
		kostka2 = new Kostka2();
		add(kostka2);
	}
}
