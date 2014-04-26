package resources;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Okno extends JFrame{

	Okno(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(800,600));
		setPreferredSize(new Dimension(800,600));
		setMaximumSize(new Dimension(800,600));
		setResizable(false);
		ImageIcon ikona = new ImageIcon("src/graphics/ikona.png");
		setIconImage(ikona.getImage());
		setTitle("SuperFarmer");
		//FlowLayout layout = new FlowLayout();
		//layout.set
	//	setLayout(new FlowLayout());
		
		PlayPanel playPanel = new PlayPanel();
		MainPanel mainPanel = new MainPanel(this, playPanel);
		
		//add(playPanel);
		add(mainPanel);		
		setVisible(true);
	}
}
