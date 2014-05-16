package resources;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayPanel extends Panel{
	

	private BufferedImage tlo;
	static Player player1, player2;
	static PlayerPanel panel_pl1, panel_pl2;
	DicePanel dice_panel;
	ExchangePanel exch_panel;
	static int[] tabl_kostki = new int[2];
	static int flaga_tury=1;
	static boolean flaga_wym=true;
	
	
	PlayPanel(ActionListener actionL){								//przekazuje ActionListenera, zeby wiedziec kto bedzie nasluchiwal (Okno)
		
		try {														//Wczytywanie obrazka (tlo)
			tlo = ImageIO.read(new File("src/graphics/trawa.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}	
		
	setLayout(null);
	exch_panel = new ExchangePanel(actionL);
	panel_pl1 = new PlayerPanel(actionL);
	panel_pl2 = new PlayerPanel(actionL);
	dice_panel = new DicePanel();
	
	add(exch_panel);
	add(panel_pl1);
	add(panel_pl2);
	add(dice_panel);
	
	panel_pl1.setBounds( 0, 350, 600, 200);
	panel_pl2.setBounds( 0, 0, 600, 200);
	
	player1 = new Player();
	player2 = new Player();
	
	
	}	
	
	static void countAnimals(){
		if(flaga_tury==1){
			if(tabl_kostki[0]==5 || tabl_kostki[1]==5){
				System.out.println("Wilk lub lis");
				if(tabl_kostki[0]==5 && tabl_kostki[1]==5){		//wypadl Wilk i Lis
					if(player1.count(6)>0){						//jest Duzy Pies
						player1.iloscDPies(0);
					}
					else{										//nie ma Duzego Psa
						player1.iloscMPies(0);
						player1.usunFarme();
					}
					if(player1.count(5)>0){						//jest Maly Pies
						player1.iloscMPies(0);
					}
					else{										//nie ma Malego Psa
						player1.iloscKrolik(0);
					}
				}
				else if(tabl_kostki[0]==5){						//wypadl Wilk i nie Lis
					if(player1.count(6)>0){						//jest Duzy Pies
						player1.iloscDPies(0);
					}
					else{
						player1.usunFarme();
					}
				}
				else if(tabl_kostki[1]==5){						//wypadl nie Wilk i Lis
					if(player1.count(5)>0){						//jest Maly Pies
						player1.iloscMPies(0);
					}
					else{										//nie ma Malego Psa
						player1.iloscKrolik(0);
					}
				}
			}
			else if(tabl_kostki[0]==tabl_kostki[1] && tabl_kostki[0]<4){				//krolik-krolik, owca-owca lub swinia-swinia
				System.out.println("wowo");
				if(tabl_kostki[0]==1){
					System.out.println("Kroliczek");
					player1.iloscKrolik(player1.count(0)+((player1.count(0)+2)/2));
					System.out.println(player1.count(0));
				}
			}
		}
		changeFlag();
	}

	static void changeFlag(){
		panel_pl1.kon(flaga_tury);
		panel_pl1.krolik(player1.count(0));
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}
