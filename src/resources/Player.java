package resources;


public class Player{

	public int[] tabl_player= new int[7];
	
	public Player(){
		for (int i=0; i<=6; i++){
			tabl_player[i]= 0;
		}
		//tabl_player[0]=0;
	}
	int count(int nr_zw){
		return tabl_player[nr_zw];
	}
	
	void iloscKrolik(int ile){
		tabl_player[0] = ile;
	}
	void iloscOwca(int ile){
		tabl_player[1] = ile;
	}

	void iloscSwinia(int ile){
		tabl_player[2] = ile;
	}

	void iloscKrowa(int ile){
		tabl_player[3] = ile;
	}

	void iloscKon(int ile){
		tabl_player[4] = ile;
	}
	void iloscMPies(int ile){
		tabl_player[5] = ile;
	}

	void iloscDPies(int ile){
		tabl_player[6] = ile;
	}

	void usunFarme(){
		for (int i=0; i<=4; i++){
			tabl_player[i]=0;
		}
	}


}

