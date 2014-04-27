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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class Panel extends JPanel{
	private BufferedImage tlo;
	private Integer height = new Integer(600);
	private Integer width = new Integer(800);
	Panel(){
		super();
		setBounds(0,0, width, height);
		try {
			tlo = ImageIO.read(new File("src/graphics/tlo_new.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}		
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}


class MainPanel extends Panel{
	
	//private static JLayeredPane lpane;
	//private static PlayPanel ppanel;	
	
	
	MainPanel(final JLayeredPane lp, final PlayPanel pp){
		//lpane = lp;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Wyjscie wyjscie = new Wyjscie();
		wyjscie.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Zasady zasady = new Zasady();
		//zasady.setAlignmentX(Component.CENTER_ALIGNMENT);
		Przycisk graj = new Przycisk("Graj");
		graj.setAlignmentX(Component.CENTER_ALIGNMENT);
		graj.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				move(lp,pp);
			}
			
		});	
		
		add(Box.createVerticalGlue());
		add(graj);
		//add(Box.createVerticalStrut(10));
		//add(zasady);
		add(Box.createVerticalStrut(10));
		add(wyjscie);
		add(Box.createVerticalGlue());
		//setOpaque(true);
	}
	void move(final JLayeredPane lp, final PlayPanel pp){		//przekazuje ale dziala
		lp.moveToBack(this);
		setVisible(false);
		pp.setVisible(true);
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
	//setOpaque(true);
}
}