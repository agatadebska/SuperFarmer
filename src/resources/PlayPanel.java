package resources;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.tools.javac.util.Pair;

public class PlayPanel extends Panel{										//Klasa implementujaca panel do gry
	private BufferedImage tlo;
	Player player1, player2;
	PlayerPanel panel_pl1, panel_pl2;
	DicePanel dice_panel;
	ExchangePanel exch_panel;
	Integer[] tabl_kostki = new Integer[2];
	Integer flaga_tury=1;
	
	PlayPanel(ActionListener actionL){								//przekazuje ActionListenera, zeby wiedziec kto bedzie nasluchiwal (Okno)
		
		try {														//Wczytywanie obrazka (tlo)
			tlo = ImageIO.read(new File("src/graphics/trawa.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}	
		
	setLayout(null);
	exch_panel = new ExchangePanel(actionL);
	panel_pl1 = new PlayerPanel(actionL);
	panel_pl2 = new PlayerPanel(actionL);
	dice_panel = new DicePanel(tabl_kostki, flaga_tury);
	
	add(exch_panel);
	add(panel_pl1);
	add(panel_pl2);
	add(dice_panel);
	
	panel_pl1.setBounds( 0, 350, 600, 200);
	panel_pl2.setBounds( 0, 0, 600, 200);
	
	
	
	player1 = new Player();
	player2 = new Player();
	
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
	
	void change(){
		
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}
