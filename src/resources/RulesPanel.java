package resources;

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
import javax.swing.JTextArea;

public class RulesPanel extends Panel{
	private BufferedImage tlo;
	private JTextArea text = new JTextArea("Wszyscy gracze rozpoczynaj� gr� z pustymi zagrodami. Gracz, na kt�rego przypada kolejka, rzuca dwiema dwunasto�ciennymiymi kostkami. Gdy gracz nie ma jeszcze �adnych zwierz�t w swojej zagrodzie, a na kostkach wypadn� r�ne obrazki, to nic si� nie dzieje. Je�eli jednak na obu kostkach wypadnie obrazek takiego samego zwierz�cia, gracz dostaje to zwierz� z banku, a w�a�ciwie ze stada, bo takiej nazwy u�ywa si� w grze. Gdy gracz ma ju� jakie� zwierz�ta, dodaje si� ich liczb� do tego co wypad�o na kostkach i wynik dzieli przez dwa (z ewentualnym zaokr�gleniem w d�). Je�eli gracz ma na przyk�ad 5 kr�lik�w, 3 owce i 2 �winie, a na kostkach wypad� kr�lik i owca, to dostaje 3 kr�liki i 2 owce. Mo�e si� jednak zdarzy�, �e w stadzie jest mniej zwierz�t, niz graczowi nale�y sie w wyniku rzutu. W takiej sytuacji gracz otrzymuje tylko tyle, ile jest w stadzie, a reszta przepada.Przed rzutem kostkami mo�na dokona� jednej wymiany ze stadem, po kursie podanym w specjalnej tabeli. Jedna owca jest warta 6 kr�lik�w, jedn� �wini� mo�na wymieni� na dwie owce itd. Mo�na albo wymieni� jedno cenniejsze zwierz� na odpowiedni� liczb� ta�szych (np. jedn� �wini� ma owc� i 6 kr�lik�w), albo z�o�y� kilka mniej cennych na jedno dro�sze (np. jedn� krow�, dwie �winie i dwie owce na jednego konia).Gra trwa do chwili, gdy jeden z graczy zbierze przynajmniej po jednym przedstawicielu ka�dego z pi�ciu gatunk�w zwierz�t: kr�lika, owc�, �wini�, krow� i konia.Gra nie by�aby specjalnie ciekawa, gdyby nie element ryzyka. Na kostkach jest takze lis i wilk. Co si� dzieje , gdy gracz wylosuje jednego z drapie�nik�w? Je�eli na kostce wypadnie lis, gracz traci wszystkie kr�liki. Inne zwierz�ta nie s� przez lisa zagro�one. Gorzej jest wtedy, gdy wypadnie wilk. Gracz traci w�wczas wszystkie zwierz�ta z wyj�tkiem konia.Ale przed zagro�eniem ze strony lisa i wilka mo�na si� zabezpieczy�, kupuj�c psy. Ma�y pies, kt�ry jest wart tyle co owca, czyli 6 kr�lik�w, chroni przed atakiem lisa. Gdy gracz ma ma�ego psa, a na kostce wypadnie lis, gracz oddaje do stada ma�ego psa, a kr�liki pozostaj� w jego zagrodzie. Analogicznie du�y pies, stanowi�cy r�wnowarto�� krowy, chroni przed wilkiem. ");	
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
