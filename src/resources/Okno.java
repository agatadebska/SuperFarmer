package resources;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Okno extends JFrame{
	private JLayeredPane lpane = new JLayeredPane();
	Okno(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(800,600));
		setPreferredSize(new Dimension(800,600));
		setMaximumSize(new Dimension(800,600));
		setResizable(false);
		setLayout(new BorderLayout());
		lpane.setBounds(0, 0, 800, 600);
		//add(lpane, BorderLayout.CENTER);
		add(lpane);
		ImageIcon ikona = new ImageIcon("src/graphics/ikona.png");
		setIconImage(ikona.getImage());
		setTitle("SuperFarmer");
		//FlowLayout layout = new FlowLayout();
		//layout.set
	//	setLayout(new FlowLayout());
		
		PlayPanel playPanel = new PlayPanel();
		MainPanel mainPanel = new MainPanel(playPanel);
		
		//add(playPanel);
		lpane.add(mainPanel, 1);
		lpane.add(playPanel, 0);
		setVisible(true);
	}
}
