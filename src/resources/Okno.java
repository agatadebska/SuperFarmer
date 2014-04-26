package resources;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Okno extends JFrame{
	private JLayeredPane layeredPane = new JLayeredPane();
	Okno(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(800,600));
		setPreferredSize(new Dimension(800,600));
		setMaximumSize(new Dimension(800,600));
		setResizable(false);
		setLayout(new BorderLayout());
		layeredPane.setBounds(0, 0, 800, 600);
		//add(lpane, BorderLayout.CENTER);
		
		ImageIcon ikona = new ImageIcon("src/graphics/ikona.png");
		setIconImage(ikona.getImage());
		setTitle("SuperFarmer");
		//FlowLayout layout = new FlowLayout();
		//layout.set
	//	setLayout(new FlowLayout());
		
		PlayPanel playPanel = new PlayPanel();
		MainPanel mainPanel = new MainPanel(layeredPane, playPanel);
		
		//add(playPanel);
		layeredPane.add(mainPanel, new Integer(0));
		layeredPane.add(playPanel, new Integer(0));
		add(layeredPane);
		layeredPane.moveToFront(mainPanel);
		layeredPane.moveToBack(playPanel);
		playPanel.setVisible(false);
		setVisible(true);
	}
}
