package resources;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


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