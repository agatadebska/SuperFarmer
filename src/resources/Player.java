package resources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Player implements ActionListener{

	public Vector<Integer> tabl_player;
	
	public Player(){
		tabl_player = new Vector<Integer>(7);
		for (int i=1; i<=7; i++){
			tabl_player.addElement(0);
		}
	}


	public void actionPerformed(ActionEvent a) {
		
		
	}
}

