package resources;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
class Zwierze extends JButton{
	private BufferedImage img;
	private Dimension wym;
	Zwierze(String s){
		super();
		String src = "src/graphics/"+s+".gif";
		try {
			img = ImageIO.read(new File(src));
			setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		wym = new Dimension(80,52);
		setPreferredSize(wym);
		setMinimumSize(wym);
		setMaximumSize(wym);
	}
}


class Kostka1 extends JButton{
	private Dimension wym;
	public Vector<String> tabl_wyn;
	Kostka1(ActionListener al){
		super("Kostka1");
		wym = new Dimension(80, 80);
		tabl_wyn = new Vector<String>(12);
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("owca");
		tabl_wyn.addElement("owca");
		tabl_wyn.addElement("owca");
		tabl_wyn.addElement("swinia");
		tabl_wyn.addElement("krowa");
		tabl_wyn.addElement("wilk");
		setPreferredSize(wym);
		setMinimumSize(wym);
		setMaximumSize(wym);
		addActionListener(al);
	}
	
}

class Kostka2 extends JButton{
	private Dimension wym;
	public Vector<String> tabl_wyn;
	Kostka2(ActionListener al){
		super("Kostka2");
		wym = new Dimension(80, 80);
		tabl_wyn = new Vector<String>(12);
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("krolik");
		tabl_wyn.addElement("owca");
		tabl_wyn.addElement("owca");
		tabl_wyn.addElement("swinia");
		tabl_wyn.addElement("swinia");
		tabl_wyn.addElement("kon");
		tabl_wyn.addElement("lis");
		setPreferredSize(wym);
		setMinimumSize(wym);
		setMaximumSize(wym);
		addActionListener(al);
	}
	
	/*public void actionPerformed(ActionEvent e) {
		Random r = new Random();
		setText(tabl_wyn.elementAt(r.nextInt(12)));
		setEnabled(false);
	}*/
}


