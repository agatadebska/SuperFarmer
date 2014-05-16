package resources;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayPanel extends Panel implements ActionListener{
	

	static BufferedImage tlo;
	static Player player1, player2;
	static PlayerPanel panel_pl1, panel_pl2;
	DicePanel dice_panel;
	ExchangePanel exch_panel;
	static int[] tabl_kostki = new int[2];
	static int flaga_tury=1;
	static boolean flaga_wym=true;
	
	
	PlayPanel(ActionListener actionL){								//przekazuje ActionListenera, zeby wiedziec kto bedzie nasluchiwal (Okno)
		
		try {														//Wczytywanie obrazka (tlo)
			tlo = ImageIO.read(new File("src/graphics/player1.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}	
		
	setLayout(null);
	exch_panel = new ExchangePanel(actionL, this);
	panel_pl1 = new PlayerPanel("Gracz 1", actionL);
	panel_pl2 = new PlayerPanel("Gracz 2", actionL);
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
				
				if(tabl_kostki[0]==1){
					if(player1.count(0)+((player1.count(0)+2)/2)+player2.count(0)<=60){
						player1.iloscKrolik(player1.count(0)+((player1.count(0)+2)/2));
					}
					else if(60-player2.count(0)>=0){
						player1.iloscKrolik(60-player2.count(0));
					}
				}
				else if(tabl_kostki[0]==2){
					if(player1.count(1)+((player1.count(1)+2)/2)+player2.count(1)<=24){
						player1.iloscOwca(player1.count(1)+((player1.count(1)+2)/2));
					}
					else if(24-player2.count(1)>=0){
						player1.iloscOwca(24-player2.count(1));
					}
				}
				else if(tabl_kostki[0]==3){
					if(player1.count(2)+((player1.count(2)+2)/2)+player2.count(2)<=20){
						player1.iloscSwinia(player1.count(2)+((player1.count(2)+2)/2));
					}
					else if(20-player2.count(2)>=0){
						player1.iloscSwinia(20-player2.count(2));
					}
				}
			}
			else{
				if(tabl_kostki[0]==1 || tabl_kostki[1]==1){
					if(player1.count(0)+((player1.count(0)+1)/2)+player2.count(0)<=60){
						player1.iloscKrolik(player1.count(0)+((player1.count(0)+1)/2));
					}
					else if(60-player2.count(0)>=0){
						player1.iloscKrolik(60-player2.count(0));
					}
				}
				if(tabl_kostki[0]==2 || tabl_kostki[1]==2){
					if(player1.count(1)+((player1.count(1)+1)/2)+player2.count(1)<=24){
						player1.iloscOwca(player1.count(1)+((player1.count(1)+1)/2));
					}
					else if(24-player2.count(1)>=0){
						player1.iloscOwca(24-player2.count(1));
					}
				}
				if(tabl_kostki[0]==3 || tabl_kostki[1]==3){
					if(player1.count(2)+((player1.count(2)+1)/2)+player2.count(2)<=20){
						player1.iloscSwinia(player1.count(2)+((player1.count(2)+1)/2));
					}
					else if(20-player2.count(2)>=0){
						player1.iloscSwinia(20-player2.count(2));
					}
				}
				if(tabl_kostki[0]==4){
					if(player1.count(3)+((player1.count(3)+1)/2)+player2.count(3)<=12){
						player1.iloscKrowa(player1.count(3)+((player1.count(3)+1)/2));
					}
					else if(12-player2.count(3)>=0){
						player1.iloscKrowa(12-player2.count(3));
					}
				}
				if(tabl_kostki[1]==4){
					if(player1.count(4)+((player1.count(4)+1)/2)+player2.count(4)<=6){
						player1.iloscKon(player1.count(4)+((player1.count(4)+1)/2));
					}
					else if(6-player2.count(4)>=0){
						player1.iloscKon(6-player2.count(4));
					}
				}
			}
		}
		//-------------------------------player2------------------
		if(flaga_tury==2){
			if(tabl_kostki[0]==5 || tabl_kostki[1]==5){
				
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
				
				if(tabl_kostki[0]==1){
					if(player2.count(0)+((player2.count(0)+2)/2)+player1.count(0)<=60){
						player2.iloscKrolik(player2.count(0)+((player2.count(0)+2)/2));
					}
					else if(60-player1.count(0)>=0){
						player2.iloscKrolik(60-player1.count(0));
					}
				}
				else if(tabl_kostki[0]==2){
					if(player2.count(1)+((player2.count(1)+2)/2)+player1.count(1)<=24){
						player2.iloscOwca(player2.count(1)+((player2.count(1)+2)/2));
					}
					else if(24-player1.count(1)>=0){
						player2.iloscOwca(24-player1.count(1));
					}
				}
				else if(tabl_kostki[0]==3){
					if(player2.count(2)+((player2.count(2)+2)/2)+player1.count(2)<=20){
						player2.iloscSwinia(player2.count(2)+((player2.count(2)+2)/2));
					}
					else if(20-player1.count(2)>=0){
						player2.iloscSwinia(20-player1.count(2));
					}
				}
			}
			else{
				if(tabl_kostki[0]==1 || tabl_kostki[1]==1){
					if(player2.count(0)+((player2.count(0)+1)/2)+player1.count(0)<=60){
						player2.iloscKrolik(player2.count(0)+((player2.count(0)+1)/2));
					}
					else if(60-player1.count(0)>=0){
						player2.iloscKrolik(60-player1.count(0));
					}
				}
				if(tabl_kostki[0]==2 || tabl_kostki[1]==2){
					if(player2.count(1)+((player2.count(1)+1)/2)+player1.count(1)<=24){
						player2.iloscOwca(player2.count(1)+((player2.count(1)+1)/2));
					}
					else if(24-player1.count(1)>=0){
						player2.iloscOwca(24-player1.count(1));
					}
				}
				if(tabl_kostki[0]==3 || tabl_kostki[1]==3){
					if(player2.count(2)+((player2.count(2)+1)/2)+player1.count(2)<=20){
						player2.iloscSwinia(player2.count(2)+((player2.count(2)+1)/2));
					}
					else if(20-player1.count(2)>=0){
						player2.iloscSwinia(20-player1.count(2));
					}
				}
				if(tabl_kostki[0]==4){
					if(player2.count(3)+((player2.count(3)+1)/2)+player1.count(3)<=12){
						player2.iloscKrowa(player2.count(3)+((player2.count(3)+1)/2));
					}
					else if(12-player1.count(3)>=0){
						player2.iloscKrowa(12-player1.count(3));
					}
				}
				if(tabl_kostki[1]==4){
					if(player2.count(4)+((player2.count(4)+1)/2)+player1.count(4)<=6){
						player2.iloscKon(player2.count(4)+((player2.count(4)+1)/2));
					}
					else if(6-player1.count(4)>=0){
						player2.iloscKon(6-player1.count(4));
					}
			}
		}
	}
		updateAnimals();
		switchPlayer();
		changeExDisable();
	}

	static void updateAnimals(){
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
	}
	static void switchPlayer(){
		if(PlayPanel.flaga_tury==1){
		PlayPanel.flaga_tury=2;
		try {														//Wczytywanie obrazka (tlo)
			tlo = ImageIO.read(new File("src/graphics/player2.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
	}
		else if(PlayPanel.flaga_tury==2){
			PlayPanel.flaga_tury=1;
			try {														//Wczytywanie obrazka (tlo)
				tlo = ImageIO.read(new File("src/graphics/player1.jpg"));
			} catch (IOException e) {
				System.err.println("Blad odczytu obrazka");
				e.printStackTrace();
			}
		}
	}
	
	static void changeExDisable(){
		if(flaga_tury==1){
			if(player1.count(0)<6 || player1.count(1)+1+player2.count(1)>=24){
				ExchangePanel.owca1.setEnabled(false);
			}
			else{
				ExchangePanel.owca1.setEnabled(true);
			}
			if(player1.count(1)<1 || player1.count(0)+6+player2.count(0)>=60){
				ExchangePanel.krolik6.setEnabled(false);
			}
			else{
				ExchangePanel.krolik6.setEnabled(true);
			}
			if(player1.count(1)<2 || player1.count(2)+1+player2.count(2)>=20){									//2 owce= 1 swinia
				ExchangePanel.swinia1.setEnabled(false);
			}
			else{
				ExchangePanel.swinia1.setEnabled(true);
			}
			if(player1.count(2)<1 || player1.count(1)+2+player2.count(1)>=24){									//1 swinia=2 owce
				ExchangePanel.owca2.setEnabled(false);
			}
			else{
				ExchangePanel.owca2.setEnabled(true);
			}
			if(player1.count(2)<3 || player1.count(3)+1+player2.count(3)>=12){									//3 swnie=1 krowa
				ExchangePanel.krowa1.setEnabled(false);
			}
			else{
				ExchangePanel.krowa1.setEnabled(true);
			}
			if(player1.count(3)<1 || player1.count(2)+3+player2.count(2)>=20){									//1 krowa=3 swinie
				ExchangePanel.swinia3.setEnabled(false);
			}
			else{
				ExchangePanel.swinia3.setEnabled(true);
			}
			if(player1.count(3)<2 || player1.count(4)+1+player2.count(4)>=6){									//2 krowy= 1 kon
				ExchangePanel.kon1.setEnabled(false);
			}
			else{
				ExchangePanel.kon1.setEnabled(true);
			}
			if(player1.count(4)<1 || player1.count(3)+2+player2.count(3)>=12){									//1 kon=2 krowy
				ExchangePanel.krowa2.setEnabled(false);
			}
			else{
				ExchangePanel.krowa2.setEnabled(true);
			}
			if(player1.count(1)<1 || player1.count(5)>0){			//1 owca=1 maly pies
				ExchangePanel.malypies1.setEnabled(false);
			}
			else{
				ExchangePanel.malypies1.setEnabled(true);
			}
			if(player1.count(5)<1 || player1.count(1)+1+player2.count(1)>=24){									//1 maly pies=1 owca
				ExchangePanel.owca1pies.setEnabled(false);
			}
			else{
				ExchangePanel.owca1pies.setEnabled(true);
			}
			if(player1.count(3)<1 || player1.count(6)>0){			//1 krowa=1 duzy pies
				ExchangePanel.duzypies1.setEnabled(false);
			}
			else{
				ExchangePanel.duzypies1.setEnabled(true);
			}
			if(player1.count(6)<1 || player1.count(3)+1+player2.count(3)>=12){									//1 duzy pies=1 krowa
				ExchangePanel.krowa1pies.setEnabled(false);
			}
			else{
				ExchangePanel.krowa1pies.setEnabled(true);
			}
		}
		else if(flaga_tury==2){
			if(player2.count(0)<6 || player1.count(1)+1+player2.count(1)>=24){
				ExchangePanel.owca1.setEnabled(false);
			}
			else{
				ExchangePanel.owca1.setEnabled(true);
			}
			if(player2.count(1)<1 || player1.count(0)+6+player2.count(0)>=60){
				ExchangePanel.krolik6.setEnabled(false);
			}
			else{
				ExchangePanel.krolik6.setEnabled(true);
			}
			if(player2.count(1)<2 || player1.count(2)+1+player2.count(2)>=20){									//2 owce= 1 swinia
				ExchangePanel.swinia1.setEnabled(false);
			}
			else{
				ExchangePanel.swinia1.setEnabled(true);
			}
			if(player2.count(2)<1 || player1.count(1)+2+player2.count(1)>=24){									//1 swinia=2 owce
				ExchangePanel.owca2.setEnabled(false);
			}
			else{
				ExchangePanel.owca2.setEnabled(true);
			}
			if(player2.count(2)<3 || player1.count(3)+1+player2.count(3)>=12){									//3 swnie=1 krowa
				ExchangePanel.krowa1.setEnabled(false);
			}
			else{
				ExchangePanel.krowa1.setEnabled(true);
			}
			if(player2.count(3)<1 || player1.count(2)+3+player2.count(2)>=20){									//1 krowa=3 swinie
				ExchangePanel.swinia3.setEnabled(false);
			}
			else{
				ExchangePanel.swinia3.setEnabled(true);
			}
			if(player2.count(3)<2 || player1.count(4)+1+player2.count(4)>=6){									//2 krowy= 1 kon
				ExchangePanel.kon1.setEnabled(false);
			}
			else{
				ExchangePanel.kon1.setEnabled(true);
			}
			if(player2.count(4)<1 || player1.count(3)+2+player2.count(3)>=12){									//1 kon=2 krowy
				ExchangePanel.krowa2.setEnabled(false);
			}
			else{
				ExchangePanel.krowa2.setEnabled(true);
			}
			if(player2.count(1)<1 || player2.count(5)>0){			//1 owca=1 maly pies
				ExchangePanel.malypies1.setEnabled(false);
			}
			else{
				ExchangePanel.malypies1.setEnabled(true);
			}
			if(player2.count(5)<1 || player1.count(1)+1+player2.count(1)>=24){									//1 maly pies=1 owca
				ExchangePanel.owca1pies.setEnabled(false);
			}
			else{
				ExchangePanel.owca1pies.setEnabled(true);
			}
			if(player2.count(3)<1 || player2.count(6)>0){			//1 krowa=1 duzy pies
				ExchangePanel.duzypies1.setEnabled(false);
			}
			else{
				ExchangePanel.duzypies1.setEnabled(true);
			}
			if(player2.count(6)<1 || player1.count(3)+1+player2.count(3)>=12){									//1 duzy pies=1 krowa
				ExchangePanel.krowa1pies.setEnabled(false);
			}
			else{
				ExchangePanel.krowa1pies.setEnabled(true);
			}
		}
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
	
	static void disableExchButtons(){
		ExchangePanel.owca1.setEnabled(false);
		ExchangePanel.krolik6.setEnabled(false);
		ExchangePanel.swinia1.setEnabled(false);
		ExchangePanel.owca2.setEnabled(false);
		ExchangePanel.krowa1.setEnabled(false);
		ExchangePanel.swinia3.setEnabled(false);
		ExchangePanel.kon1.setEnabled(false);
		ExchangePanel.krowa2.setEnabled(false);
		ExchangePanel.malypies1.setEnabled(false);
		ExchangePanel.owca1pies.setEnabled(false);
		ExchangePanel.duzypies1.setEnabled(false);
		ExchangePanel.krowa1pies.setEnabled(false);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		disableExchButtons();
		if(flaga_tury==1){
			if(source == ExchangePanel.owca1){
				player1.iloscKrolik(player1.count(0)-6);
				player1.iloscOwca(player1.count(1)+1);
			}
			else if(source == ExchangePanel.krolik6){
				player1.iloscOwca(player1.count(1)-1);
				player1.iloscKrolik(player1.count(0)+6);
			}
			else if(source == ExchangePanel.swinia1){
				player1.iloscOwca(player1.count(1)-2);
				player1.iloscSwinia(player1.count(2)+1);
			}
			else if(source == ExchangePanel.owca2){
				player1.iloscSwinia(player1.count(2)-1);
				player1.iloscOwca(player1.count(1)+2);
			}
			else if(source == ExchangePanel.krowa1){
				player1.iloscSwinia(player1.count(2)-3);
				player1.iloscKrowa(player1.count(3)+1);
			}
			else if(source == ExchangePanel.swinia3){
				player1.iloscKrowa(player1.count(3)-1);
				player1.iloscSwinia(player1.count(2)+3);
			}
			else if(source == ExchangePanel.kon1){
				player1.iloscKrowa(player1.count(3)-2);
				player1.iloscKon(player1.count(4)+1);
			}
			else if(source == ExchangePanel.krowa2){
				player1.iloscKon(player1.count(4)-1);
				player1.iloscKrowa(player1.count(3)+2);
			}
			else if(source == ExchangePanel.malypies1){
				player1.iloscOwca(player1.count(1)-1);
				player1.iloscMPies(player1.count(5)+1);
			}
			else if(source == ExchangePanel.owca1pies){
				player1.iloscMPies(player1.count(5)-1);
				player1.iloscOwca(player1.count(1)+1);
			}
			else if(source == ExchangePanel.duzypies1){
				player1.iloscKrowa(player1.count(3)-1);
				player1.iloscDPies(player1.count(6)+1);
			}
			else if(source == ExchangePanel.krowa1pies){
				player1.iloscDPies(player1.count(6)-1);
				player1.iloscKrowa(player1.count(3)+1);
			}
		}
		else if(flaga_tury==2){
			if(source == ExchangePanel.owca1){
				player2.iloscKrolik(player2.count(0)-6);
				player2.iloscOwca(player2.count(1)+1);
			}
			else if(source == ExchangePanel.krolik6){
				player2.iloscOwca(player2.count(1)-1);
				player2.iloscKrolik(player2.count(0)+6);
			}
			else if(source == ExchangePanel.swinia1){
				player2.iloscOwca(player2.count(1)-2);
				player2.iloscSwinia(player2.count(2)+1);
			}
			else if(source == ExchangePanel.owca2){
				player2.iloscSwinia(player2.count(2)-1);
				player2.iloscOwca(player2.count(1)+2);
			}
			else if(source == ExchangePanel.krowa1){
				player2.iloscSwinia(player2.count(2)-3);
				player2.iloscKrowa(player2.count(3)+1);
			}
			else if(source == ExchangePanel.swinia3){
				player2.iloscKrowa(player2.count(3)-1);
				player2.iloscSwinia(player2.count(2)+3);
			}
			else if(source == ExchangePanel.kon1){
				player2.iloscKrowa(player2.count(3)-2);
				player2.iloscKon(player2.count(4)+1);
			}
			else if(source == ExchangePanel.krowa2){
				player2.iloscKon(player2.count(4)-1);
				player2.iloscKrowa(player2.count(3)+2);
			}
			else if(source == ExchangePanel.malypies1){
				player2.iloscOwca(player2.count(1)-1);
				player2.iloscMPies(player2.count(5)+1);
			}
			else if(source == ExchangePanel.owca1pies){
				player2.iloscMPies(player2.count(5)-1);
				player2.iloscOwca(player2.count(1)+1);
			}
			else if(source == ExchangePanel.duzypies1){
				player2.iloscKrowa(player2.count(3)-1);
				player2.iloscDPies(player2.count(6)+1);
			}
			else if(source == ExchangePanel.krowa1pies){
				player2.iloscDPies(player2.count(6)-1);
				player2.iloscKrowa(player2.count(3)+1);
			}
		}
	updateAnimals();
	}
}
