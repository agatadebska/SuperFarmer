package resources;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PlayPanel extends Panel{										//Klasa implementujaca panel do gry
	private BufferedImage tlo;
	
	PlayPanel(ActionListener actionL){								//przekazuje ActionListenera, zeby wiedziec kto bedzie nasluchiwal (Okno)
		
		try {														//Wczytywanie obrazka (tlo)
			tlo = ImageIO.read(new File("src/graphics/trawa.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}	
		
	setLayout(null);
	JPanel panel_wym = new JPanel();
	panel_wym.setOpaque(false);
	Powrot powrot = new Powrot(actionL);
	panel_wym.add(powrot);
	add(panel_wym);
	panel_wym.setBounds( 600, 0, 200, 600);
	
	JPanel panel_pl2 = new JPanel();
	panel_pl2.setOpaque(true);
	add(panel_pl2);
	panel_pl2.setBounds( 0, 0, 600, 200);
	
	JPanel panel_pl1 = new JPanel();
	panel_pl1.setOpaque(false);
	add(panel_pl1);
	panel_pl1.setBounds( 0, 400, 600, 200);
	
	JPanel panel_dice = new JPanel();
	panel_dice.setOpaque(false);
	add(panel_dice);
	panel_dice.setBounds( 0, 200, 600, 200);
	Kostka kostka1 = new Kostka(actionL);
	panel_dice.add(kostka1);
	Kostka kostka2= new Kostka(actionL);
	panel_dice.add(kostka2);
	
	}	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}
