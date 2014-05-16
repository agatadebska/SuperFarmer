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
					System.out.println("2xKrolik");
					player1.iloscKrolik(player1.count(0)+((player1.count(0)+2)/2));
				}
				else if(tabl_kostki[0]==2){
					System.out.println("2xOwca");
					player1.iloscOwca(player1.count(1)+((player1.count(1)+2)/2));
				}
				else if(tabl_kostki[0]==3){
					System.out.println("2xSwinia");
					player1.iloscSwinia(player1.count(2)+((player1.count(2)+2)/2));
				}
			}
			else{
				if(tabl_kostki[0]==1 || tabl_kostki[1]==1){
					player1.iloscKrolik(player1.count(0)+((player1.count(0)+1)/2));
				}
				if(tabl_kostki[0]==2 || tabl_kostki[1]==2){
					player1.iloscOwca(player1.count(1)+((player1.count(1)+1)/2));
				}
				if(tabl_kostki[0]==3 || tabl_kostki[1]==3){
					player1.iloscSwinia(player1.count(2)+((player1.count(2)+1)/2));
				}
				if(tabl_kostki[0]==4){
					player1.iloscKrowa(player1.count(3)+((player1.count(3)+1)/2));
				}
				if(tabl_kostki[1]==4){
					player1.iloscKon(player1.count(4)+((player1.count(4)+1)/2));
				}
			}
		}
		//-------------------------------player2------------------
		if(flaga_tury==2){
			if(tabl_kostki[0]==5 || tabl_kostki[1]==5){
				System.out.println("Wilk lub lis");
				if(tabl_kostki[0]==5 && tabl_kostki[1]==5){		//wypadl Wilk i Lis
					if(player2.count(6)>0){						//jest Duzy Pies
						player2.iloscDPies(0);
					}
					else{										//nie ma Duzego Psa
						player2.iloscMPies(0);
						player2.usunFarme();
					}
					if(player2.count(5)>0){						//jest Maly Pies
						player2.iloscMPies(0);
					}
					else{										//nie ma Malego Psa
						player2.iloscKrolik(0);
					}
				}
				else if(tabl_kostki[0]==5){						//wypadl Wilk i nie Lis
					if(player2.count(6)>0){						//jest Duzy Pies
						player2.iloscDPies(0);
					}
					else{
						player2.usunFarme();
					}
				}
				else if(tabl_kostki[1]==5){						//wypadl nie Wilk i Lis
					if(player2.count(5)>0){						//jest Maly Pies
						player2.iloscMPies(0);
					}
					else{										//nie ma Malego Psa
						player2.iloscKrolik(0);
					}
				}
			}
			else if(tabl_kostki[0]==tabl_kostki[1] && tabl_kostki[0]<4){				//krolik-krolik, owca-owca lub swinia-swinia
				System.out.println("wowo");
				if(tabl_kostki[0]==1){
					System.out.println("2xKrolik");
					player2.iloscKrolik(player2.count(0)+((player2.count(0)+2)/2));
				}
				else if(tabl_kostki[0]==2){
					System.out.println("2xOwca");
					player2.iloscOwca(player2.count(1)+((player2.count(1)+2)/2));
				}
				else if(tabl_kostki[0]==3){
					System.out.println("2xSwinia");
					player2.iloscSwinia(player2.count(2)+((player2.count(2)+2)/2));
				}
			}
			else{
				if(tabl_kostki[0]==1 || tabl_kostki[1]==1){
					player2.iloscKrolik(player2.count(0)+((player2.count(0)+1)/2));
				}
				if(tabl_kostki[0]==2 || tabl_kostki[1]==2){
					player2.iloscOwca(player2.count(1)+((player2.count(1)+1)/2));
				}
				if(tabl_kostki[0]==3 || tabl_kostki[1]==3){
					player2.iloscSwinia(player2.count(2)+((player2.count(2)+1)/2));
				}
				if(tabl_kostki[0]==4){
					player2.iloscKrowa(player2.count(3)+((player2.count(3)+1)/2));
				}
				if(tabl_kostki[1]==4){
					player2.iloscKon(player2.count(4)+((player2.count(4)+1)/2));
				}
			}
		}
		switchPlayer();
	}

	static void switchPlayer(){
		panel_pl1.krolik(player1.count(0));
		panel_pl1.owca(player1.count(1));
		panel_pl1.swinia(player1.count(2));
		panel_pl1.krowa(player1.count(3));
		panel_pl1.kon(player1.count(4));
		panel_pl1.malyPies(player1.count(5));
		panel_pl1.duzyPies(player1.count(6));
		panel_pl2.krolik(player2.count(0));
		panel_pl2.owca(player2.count(1));
		panel_pl2.swinia(player2.count(2));
		panel_pl2.krowa(player2.count(3));
		panel_pl2.kon(player2.count(4));
		panel_pl2.malyPies(player2.count(5));
		panel_pl2.duzyPies(player2.count(6));
		if(PlayPanel.flaga_tury==1){
		PlayPanel.flaga_tury=2;
	}
		else if(PlayPanel.flaga_tury==2){
			PlayPanel.flaga_tury=1;
		}
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}
