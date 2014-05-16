package resources;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Okno extends JFrame implements ActionListener{
	

	private JLayeredPane layeredPane = new JLayeredPane();
	private PlayPanel playPanel = new PlayPanel((ActionListener)this);
	private MenuPanel mainPanel = new MenuPanel((ActionListener)this);
	private RulesPanel rulesPanel = new RulesPanel((ActionListener)this);	
	private Integer height = new Integer(600);
	private Integer width = new Integer(800);
	
	Okno(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(width, height));
		setPreferredSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setResizable(false);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		layeredPane.setBounds(0, 0, width, height);
		//add(lpane, BorderLayout.CENTER);
		
		ImageIcon ikona = new ImageIcon("src/graphics/ikona.png");
		setIconImage(ikona.getImage());
		setTitle("SuperFarmer");
		
		layeredPane.add(mainPanel, new Integer(0), 3);
		layeredPane.add(playPanel, new Integer(0), 2);
		layeredPane.add(rulesPanel, new Integer(0), 1);
		add(layeredPane);
		playPanel.setVisible(false);
		rulesPanel.setVisible(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source instanceof Graj){
			layeredPane.setPosition(mainPanel, 0);
			mainPanel.setVisible(false);
			playPanel.setVisible(true);
		}
		else if(source instanceof Zasady){
			layeredPane.setPosition(rulesPanel, 4);
			mainPanel.setVisible(false);
			rulesPanel.setVisible(true);
		}
		else if(source instanceof Powrot){
			layeredPane.setPosition(rulesPanel, 1);
			layeredPane.setPosition(playPanel, 2);
			layeredPane.setPosition(mainPanel, 3);
			mainPanel.setVisible(true);
			rulesPanel.setVisible(false);
			playPanel.setVisible(false);
		}
	}
}
