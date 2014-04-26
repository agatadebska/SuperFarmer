package resources;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class Przycisk extends JButton{
	private Dimension wym;
	Przycisk(String s){
		super(s);
		wym = new Dimension(80, 40);
		setPreferredSize(wym);
		setMinimumSize(wym);
		setMaximumSize(wym);
	}
}

class Wyjscie extends Przycisk implements ActionListener{
	Wyjscie(){
		super("Wyjscie");
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}

class Zasady extends Przycisk implements ActionListener{
	Zasady(){
		super("Zasady");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
/*
class Graj extends Przycisk implements ActionListener{
	Graj(Okno o, MainPanel m, PlayPanel p){
		super("Graj");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
*/