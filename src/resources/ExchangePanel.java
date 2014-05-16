 	package resources;
 	
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Font;
 	import java.awt.event.ActionListener;
 	
	import javax.swing.JLabel;
 	import javax.swing.JPanel;
 	
 	public class ExchangePanel extends JPanel {
		
		static Zwierze owca1 = new Zwierze("owca1");
		static Zwierze krolik6 = new Zwierze("krolik6");
		static Zwierze swinia1 = new Zwierze("swinia1");
		static Zwierze owca2 = new Zwierze("owca2");
		static Zwierze krowa1 = new Zwierze("krowa1");
		static Zwierze swinia3 = new Zwierze("swinia3");
		static Zwierze kon1 = new Zwierze("kon1");
		static Zwierze krowa2 = new Zwierze("krowa2");
		static Zwierze malypies1 = new Zwierze("malypies1");
		static Zwierze owca1pies = new Zwierze("owca1");
		static Zwierze duzypies1 = new Zwierze("duzypies1");
		static Zwierze krowa1pies = new Zwierze("krowa1");

		ExchangePanel(ActionListener actionL){
			setOpaque(false);
			setOpaque(false);	
			FlowLayout layout = new FlowLayout();
			layout.setHgap(0);
			layout.setVgap(10);
			setLayout(layout);
			JLabel wym = new JLabel("Tabela wymiany");
			wym.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
 			Powrot powrot = new Powrot(actionL);
			
			
			add(wym);
			
			add(owca1);
			add(new Label());		
			add(krolik6);
			
			add(swinia1);
			add(new Label());
			add(owca2);
			
			add(krowa1);
			add(new Label());
			add(swinia3);
			
			add(kon1);
			add(new Label());
			add(krowa2);
			
			add(malypies1);
			add(new Label());
			add(owca1pies);
			
			add(duzypies1);
			add(new Label());
			add(krowa1pies);
			
			add(powrot);
			setBounds( 600, 0, 200, 600);
			setPreferredSize(new Dimension(800,600));
		}
	}
	
	class Label extends JLabel{
		

		Label(){
			super("=");
			setOpaque(false);
			setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		}
	}
