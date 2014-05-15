package resources;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel{
	PlayerPanel(ActionListener actionL){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setOpaque(false);
		Tile krolik = new Tile("krolik");
		Tile owca = new Tile("owca");
		Tile swinia = new Tile("swinia");
		Tile krowa = new Tile("krowa");
		Tile kon = new Tile("kon");
		Tile malypies = new Tile("malypies");
		Tile duzypies = new Tile("duzypies");
		JLabel player = new JLabel("Gracz 1");
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
		dogPanel.add(Box.createHorizontalStrut(20));
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
}


class Tile extends JLabel{					//kafelek (obrazek) 
	protected BufferedImage img;
	protected int num = 0;
	Tile(String s){
		super();
		try {	
			img = ImageIO.read(new File("src/graphics/"+s+".gif"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		//add(num);
		setAlignmentY(Component.CENTER_ALIGNMENT);
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
		setText(""+num);
		 
		 if(num==0)
			setVisible(false);
		else
			setVisible(true);
			
	}
}
