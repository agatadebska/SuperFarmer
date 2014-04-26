package resources;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class Panel extends JPanel{
	private BufferedImage tlo;
	Panel(){
		super();
	//	setBounds(0,0,800,600);
		try {
			tlo = ImageIO.read(new File("src/graphics/farma.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}		
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, 800, 600, null);
	}
}


class MainPanel extends Panel{
	MainPanel(final Okno okno, final PlayPanel playPanel){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Wyjscie wyjscie = new Wyjscie();
		wyjscie.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Zasady zasady = new Zasady();
		//zasady.setAlignmentX(Component.CENTER_ALIGNMENT);
		Przycisk graj = new Przycisk("Graj");
		graj.setAlignmentX(Component.CENTER_ALIGNMENT);
		graj.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				removePanel(okno);
				okno.repaint();
				okno.add(playPanel);
				okno.repaint();
				
			}
			
		});
		
		add(Box.createVerticalGlue());
		add(graj);
		//add(Box.createVerticalStrut(10));
		//add(zasady);
		add(Box.createVerticalStrut(10));
		add(wyjscie);
		add(Box.createVerticalGlue());
		setVisible(true);
	}
	
	void removePanel(final Okno okno){
		okno.remove(this);
	}
}

class PlayPanel extends Panel{

	
	PlayPanel(){	
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	Wyjscie wyjscie = new Wyjscie();
	wyjscie.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	//Zasady zasady = new Zasady();
	//zasady.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	//Przycisk graj = new Przycisk("lool");
	//graj.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	add(Box.createVerticalGlue());
	//add(graj);
	//add(Box.createVerticalStrut(10));
	//add(zasady);
	//add(Box.createVerticalStrut(10));
	add(wyjscie);
	add(Box.createVerticalGlue());
	//setVisible(false);
}
}