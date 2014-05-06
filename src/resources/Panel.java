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


class MainPanel extends Panel{											//Klasa implementujaca menu glowne gry

	private BufferedImage tlo;
	
	MainPanel(ActionListener actionL){									//przekazuje ActionListenera, zeby wiedziec kto bedzie nasluchiwal (Okno)
		try {															//Wczytywanie obrazka (tlo)
			tlo = ImageIO.read(new File("src/graphics/tlo_new.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}	
				
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Wyjscie wyjscie = new Wyjscie();
		wyjscie.setAlignmentX(Component.CENTER_ALIGNMENT);
		Zasady zasady = new Zasady(actionL);
		zasady.setAlignmentX(Component.CENTER_ALIGNMENT);
		Graj graj = new Graj(actionL);
		graj.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(Box.createVerticalGlue());
		add(graj);
		add(Box.createVerticalStrut(10));
		add(zasady);
		add(Box.createVerticalStrut(10));
		add(wyjscie);
		add(Box.createVerticalGlue());
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}


class PlayPanel extends Panel{										//Klasa implementujaca panel do gry
	private BufferedImage tlo;
	
	PlayPanel(ActionListener actionL){								//przekazuje ActionListenera, zeby wiedziec kto bedzie nasluchiwal (Okno)
		
		try {														//Wczytywanie obrazka (tlo)
			tlo = ImageIO.read(new File("src/graphics/trawa.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}	
	setLayout(new BoxLayout());
		
	JPanel panel_wym = new JPanel();
	panel_wym.setPreferredSize(new Dimension(200, 600));
	panel_wym.setMinimumSize(new Dimension(200, 600));
	panel_wym.setMaximumSize(new Dimension(200, 600));
	panel_wym.setOpaque(false);
	Powrot powrot = new Powrot(actionL);
	panel_wym.add(powrot);
	add(panel_wym, BorderLayout.EAST);
	
	JPanel panel_pl2 = new JPanel();
	panel_pl2.setPreferredSize(new Dimension(400, 200));
	panel_pl2.setMinimumSize(new Dimension(400, 200));
	panel_pl2.setMaximumSize(new Dimension(400, 200));
	add(panel_pl2, BorderLayout.NORTH);
	
/*		
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	Wyjscie wyjscie = new Wyjscie();
	wyjscie.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	Powrot powrot = new Powrot(actionL);
	powrot.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	add(Box.createVerticalGlue());	
	add(powrot);
	add(Box.createVerticalStrut(10));
	add(wyjscie);
	add(Box.createVerticalGlue());
*/	
	/*setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	
	Kostka kostka1 = new Kostka(actionL);
	kostka1.setAlignmentY(Component.LEFT_ALIGNMENT);
	
	Kostka kostka2 = new Kostka(actionL);
	kostka2.setAlignmentY(Component.RIGHT_ALIGNMENT);
	
	add(Box.createHorizontalGlue());	
	add(kostka1);
	add(Box.createHorizontalStrut(10));
	add(kostka2);
	add(Box.createHorizontalGlue());*/
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}

class RulesPanel extends Panel{
	private BufferedImage tlo;
	private JTextArea text = new JTextArea("Wszyscy gracze rozpoczynaj¹ grê z pustymi zagrodami. Gracz, na którego przypada kolejka, rzuca dwiema dwunastoœciennymiymi kostkami. Gdy gracz nie ma jeszcze ¿adnych zwierz¹t w swojej zagrodzie, a na kostkach wypadn¹ ró¿ne obrazki, to nic siê nie dzieje. Je¿eli jednak na obu kostkach wypadnie obrazek takiego samego zwierzêcia, gracz dostaje to zwierzê z banku, a w³aœciwie ze stada, bo takiej nazwy u¿ywa siê w grze. Gdy gracz ma ju¿ jakieœ zwierzêta, dodaje siê ich liczbê do tego co wypad³o na kostkach i wynik dzieli przez dwa (z ewentualnym zaokr¹gleniem w dó³). Je¿eli gracz ma na przyk³ad 5 królików, 3 owce i 2 œwinie, a na kostkach wypad³ królik i owca, to dostaje 3 króliki i 2 owce. Mo¿e siê jednak zdarzyæ, ¿e w stadzie jest mniej zwierz¹t, niz graczowi nale¿y sie w wyniku rzutu. W takiej sytuacji gracz otrzymuje tylko tyle, ile jest w stadzie, a reszta przepada.Przed rzutem kostkami mo¿na dokonaæ jednej wymiany ze stadem, po kursie podanym w specjalnej tabeli. Jedna owca jest warta 6 królików, jedn¹ œwiniê mo¿na wymieniæ na dwie owce itd. Mo¿na albo wymieniæ jedno cenniejsze zwierzê na odpowiedni¹ liczbê tañszych (np. jedn¹ œwiniê ma owcê i 6 królików), albo z³o¿yæ kilka mniej cennych na jedno dro¿sze (np. jedn¹ krowê, dwie œwinie i dwie owce na jednego konia).Gra trwa do chwili, gdy jeden z graczy zbierze przynajmniej po jednym przedstawicielu ka¿dego z piêciu gatunków zwierz¹t: królika, owcê, œwiniê, krowê i konia.Gra nie by³aby specjalnie ciekawa, gdyby nie element ryzyka. Na kostkach jest takze lis i wilk. Co siê dzieje , gdy gracz wylosuje jednego z drapie¿ników? Je¿eli na kostce wypadnie lis, gracz traci wszystkie króliki. Inne zwierzêta nie s¹ przez lisa zagro¿one. Gorzej jest wtedy, gdy wypadnie wilk. Gracz traci wówczas wszystkie zwierzêta z wyj¹tkiem konia.Ale przed zagro¿eniem ze strony lisa i wilka mo¿na siê zabezpieczyæ, kupuj¹c psy. Ma³y pies, który jest wart tyle co owca, czyli 6 królików, chroni przed atakiem lisa. Gdy gracz ma ma³ego psa, a na kostce wypadnie lis, gracz oddaje do stada ma³ego psa, a króliki pozostaj¹ w jego zagrodzie. Analogicznie du¿y pies, stanowi¹cy równowartoœæ krowy, chroni przed wilkiem. ");	
	RulesPanel(ActionListener actionL){								//przekazuje ActionListenera, zeby wiedziec kto bedzie nasluchiwal (Okno)
		
		try {														//Wczytywanie obrazka (tlo)
			tlo = ImageIO.read(new File("src/graphics/trawa.jpg"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}	
	text.setPreferredSize(new Dimension(700,400));
	text.setMinimumSize(new Dimension(700,400));
	text.setMaximumSize(new Dimension(700,400));
	text.setAlignmentX(Component.CENTER_ALIGNMENT);
	text.setLineWrap(true);
	text.setWrapStyleWord(true);
	//text.setOpaque(false);
	text.setBackground(new Color(255, 255, 255, 180));
	text.setEditable(false);
	text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	Powrot powrot = new Powrot(actionL);
	powrot.setAlignmentX(Component.CENTER_ALIGNMENT);
	JLabel zas = new JLabel("Zasady gry");
	zas.setAlignmentX(Component.CENTER_ALIGNMENT);
	zas.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));

	add(Box.createVerticalGlue());
	add(zas);
	add(Box.createVerticalStrut(10));
	add(text);
	add(Box.createVerticalStrut(20));
	add(powrot);
	add(Box.createVerticalGlue());
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(tlo, 0, 0, width, height, null);
	}
}