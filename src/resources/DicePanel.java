package resources;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class DicePanel extends JPanel{
	DicePanel(ActionListener actionL){
		setOpaque(false);
		setBounds( 0, 200, 600, 200);
		Kostka1 kostka1 = new Kostka1(actionL);
		add(kostka1);
		Kostka2 kostka2 = new Kostka2(actionL);
		add(kostka2);
	}
}
