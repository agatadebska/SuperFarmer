package resources;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Panel extends JPanel{

	protected Integer height = new Integer(600);
	protected Integer width = new Integer(800);
	Panel(){
		super();
		setBounds(0,0, width, height);									//granice potrzebne do JLayeredPane
			
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}