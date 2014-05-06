package resources;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class MenuPanel extends Panel{											//Klasa implementujaca menu glowne gry

	private BufferedImage tlo;
	
	MenuPanel(ActionListener actionL){									//przekazuje ActionListenera, zeby wiedziec kto bedzie nasluchiwal (Okno)
		try {															//Wczytywanie obrazka (tlo)
			tlo = ImageIO.read(new File("src/graphics/tlo_new.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}	
				
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Wyjscie wyjscie = new Wyjscie();
		wyjscie.setAlignmentX(Component.CENTER_ALIGNMENT);
		Zasady zasady = new Zasady(actionL);
		zasady.setAlignmentX(Component.CENTER_ALIGNMENT);
		Graj graj = new Graj(actionL);
		graj.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
		add(graj);
		add(Box.createVerticalStrut(10));
		add(zasady);
		add(Box.createVerticalStrut(10));
		add(wyjscie);
		add(Box.createVerticalGlue());
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}
