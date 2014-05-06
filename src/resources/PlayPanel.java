package resources;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

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
	ExchangePanel exch_panel = new ExchangePanel(actionL);
	PlayerPanel panel_pl1 = new PlayerPanel(actionL);
	PlayerPanel panel_pl2 = new PlayerPanel(actionL);
	DicePanel dice_panel = new DicePanel(actionL);
	
	add(exch_panel);
	add(panel_pl1);
	add(panel_pl2);
	add(dice_panel);
	
	panel_pl1.setBounds( 0, 400, 600, 200);
	panel_pl2.setBounds( 0, 0, 600, 200);
	
	
	
	
	}	
	
	/*public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		System.out.println("1");
		if(source instanceof Kostka1){
			Random r = new Random();
			kostka1.setText(kostka1.tabl_wyn.elementAt(r.nextInt(12)));
			System.out.println("2");
			setEnabled(true);
			}
		}*/
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}
