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

class Zasady extends Przycisk{
	Zasady(ActionListener al){
		super("Zasady");
		addActionListener(al);
	}

}

class Graj extends Przycisk{
	Graj(ActionListener al){
		super("Graj");
		addActionListener(al);
	}	
}

class Powrot extends Przycisk{
	Powrot(ActionListener al){
		super("Powrot");
		addActionListener(al);
	}	
}

class Kostka1 extends JButton{
	private Dimension wym;
	Kostka1(ActionListener al){
		super("Kostka");
		wym = new Dimension(80, 80);
		setPreferredSize(wym);
		setMinimumSize(wym);
		setMaximumSize(wym);
	}
	
}

class Kostka2 extends JButton{
	private Dimension wym;
	Kostka2(ActionListener al){
		super("Kostka");
		wym = new Dimension(80, 80);
		setPreferredSize(wym);
		setMinimumSize(wym);
		setMaximumSize(wym);
		
	}
}