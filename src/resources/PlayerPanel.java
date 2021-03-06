package resources;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel{
	
	Tile krolik = new Tile("krolik");
	Tile owca = new Tile("owca");
	Tile swinia = new Tile("swinia");
	Tile krowa = new Tile("krowa");
	Tile kon = new Tile("kon");
	Tile malypies = new Tile("malypies");
	Tile duzypies = new Tile("duzypies");
	
	PlayerPanel(String nazwa_gracza, ActionListener actionL){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		
		JLabel player = new JLabel(nazwa_gracza);
		player.setAlignmentX(CENTER_ALIGNMENT);
		player.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		//player.setForeground(Color.GREEN);
		add(player);
		
		JPanel dogPanel = new JPanel();
		dogPanel.setLayout(new BoxLayout(dogPanel, BoxLayout.X_AXIS));
		dogPanel.setOpaque(false);
		dogPanel.setPreferredSize(new Dimension(600, 90));	
		dogPanel.setMaximumSize(new Dimension(600, 90));
		dogPanel.setMinimumSize(new Dimension(600, 90));
		
		dogPanel.add(Box.createHorizontalGlue());
		dogPanel.add(malypies);
		dogPanel.add(Box.createHorizontalStrut(10));
		dogPanel.add(duzypies);
		dogPanel.add(Box.createHorizontalGlue());
		add(dogPanel);
		
		
		JPanel animalPanel = new JPanel();
		animalPanel.setLayout(new BoxLayout(animalPanel, BoxLayout.X_AXIS));
		animalPanel.setOpaque(false);
		animalPanel.setPreferredSize(new Dimension(600, 90));
		animalPanel.setMaximumSize(new Dimension(600, 90));
		animalPanel.setMinimumSize(new Dimension(600, 90));
		
		animalPanel.add(Box.createHorizontalGlue());
		animalPanel.add(krolik);
		animalPanel.add(Box.createHorizontalStrut(10));
		animalPanel.add(owca);
		animalPanel.add(Box.createHorizontalStrut(10));
		animalPanel.add(swinia);
		animalPanel.add(Box.createHorizontalStrut(10));
		animalPanel.add(krowa);
		animalPanel.add(Box.createHorizontalStrut(10));
		animalPanel.add(kon);
		animalPanel.add(Box.createHorizontalGlue());
		add(animalPanel);
		
	}
	void krolik(int num){
		krolik.changeVal(num);
	}
	void owca(int num){
		owca.changeVal(num);
	}
	void swinia(int num){
		swinia.changeVal(num);
	}
	void krowa(int num){
		krowa.changeVal(num);
	}
	void kon(int num){
		kon.changeVal(num);
	}
	void malyPies(int num){
		malypies.changeVal(num);
	}
	void duzyPies(int num){
		duzypies.changeVal(num);
	}
	
}


class Tile extends JLabel{					//kafelek (obrazek) 
	

	protected BufferedImage img;
	protected int num = 0;
	String name;
	Tile(String s){
		super();
		try {	
			img = ImageIO.read(new File("src/graphics/"+s+".gif"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		name = new String(s);
		//add(num);
		setAlignmentY(Component.CENTER_ALIGNMENT);
		//setBounds(0,0,100,80);
		setIcon(new ImageIcon(img));
		setIconTextGap(-27);
		setVerticalTextPosition(TOP);
		setHorizontalTextPosition(RIGHT);
		setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		if(s!="malypies" && s!="duzypies"){
			setText(""+num);
		}
		if(num==0)
			setVisible(false);
	
	}
	
	public void changeVal(int i){
		num = i;
		if(name != "malypies" && name!= "duzypies"){
			setText(""+num);
		}
		 if(num==0)
			setVisible(false);
		else
			setVisible(true);
		}
}
