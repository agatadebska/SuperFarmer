package resources;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ExchangePanel extends JPanel {
	ExchangePanel(ActionListener actionL){
		setOpaque(false);
		Powrot powrot = new Powrot(actionL);
		add(powrot);
		setBounds( 600, 0, 200, 600);
	}
}
