import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Plansza extends JPanel implements ActionListener {
	
	private Rectangle pojazd;
	private Rectangle kontener1;
	private Rectangle kontener2;
	private Rectangle kontener3;
	static Timer timer;
	private int rozmiarPojazdu = 40;
	private int rozmiarPlanszy=880;
	JTextArea pole;
	JTextField pole2;
	JButton potwierdz;
	private int x=400;
	private int y=400;
	Plansza(){

		pojazd = new Rectangle(x,y,rozmiarPojazdu,rozmiarPojazdu);
		kontener1 = new Rectangle(485,765,30,30);
		kontener2 = new Rectangle(525,765,30,30);
		kontener3 = new Rectangle(565,765,30,30);
		
		
		setBackground(Color.white);
		setPreferredSize(new Dimension(500,500));
		setLayout(null);
		JPanel polecenia=new Polecenia();
		polecenia.setBounds(rozmiarPlanszy,0, 300, rozmiarPlanszy);
		add(polecenia);
		polecenia.setLayout(null);
		
		pole = new JTextArea();
		pole2 = new JTextField();
		
		JScrollPane sp = new JScrollPane(pole);
		sp.setBounds(10, 10, 275, 700);
		pole2.setBounds(10, 710, 275, 40);
		pole2.addActionListener(this);
		polecenia.add(pole2);
		polecenia.add(sp);
		potwierdz = new JButton("potwierdz");
		potwierdz.setBounds(10, 755, 200,50);
		polecenia.add(potwierdz);
		potwierdz.addActionListener(this);
		
	}
	public void paintComponent(Graphics graphics){
		
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		Graphics2D droga = (Graphics2D) graphics;
		droga.setStroke(new BasicStroke(5));
		graphics2d.setColor(Color.BLUE);
		graphics2d.fill(pojazd);
		graphics2d.setColor(Color.RED);
		graphics2d.fill(kontener1);
		graphics2d.setColor(Color.ORANGE);
		graphics2d.fill(kontener2);
		graphics2d.setColor(Color.GREEN);
		graphics2d.fill(kontener3);
		droga.setColor(Color.green);
		
		Font font = new Font("Arial", Font.BOLD, 24);
		droga.setFont(font);		
		
		Rectangle2D polka1 = new Rectangle2D.Double(40,40,200,120);
		droga.draw(polka1);
		
		Rectangle2D polka2 = new Rectangle2D.Double(320,40,200,120);
		droga.draw(polka2);
			
		Rectangle2D polka3 = new Rectangle2D.Double(600,40,200,120);
		droga.draw(polka3);
		
		Rectangle2D polka4 = new Rectangle2D.Double(40,280,120,320);
		droga.draw(polka4);	
		
		Rectangle2D polka5 = new Rectangle2D.Double(680,280,120,320);
		droga.draw(polka5);		
		
		Rectangle2D wyjazd = new Rectangle2D.Double(240,720,160,120);
		droga.draw(wyjazd);		
		
		Rectangle2D przyjazd = new Rectangle2D.Double(440,720,160,120);
		droga.draw(przyjazd);
		
		droga.setStroke(new BasicStroke(1));
		droga.setColor(Color.gray);
		for(int i=0; i<rozmiarPojazdu; i++){
			droga.draw(new Line2D.Double(i*rozmiarPojazdu, 0, i*rozmiarPojazdu, rozmiarPlanszy));
			droga.draw(new Line2D.Double(0, i*rozmiarPojazdu, rozmiarPlanszy, i*rozmiarPojazdu));
		}
		droga.setColor(Color.blue);
		droga.drawString("Polka 1", 55, 70);
		droga.drawString("Polka 2", 330, 70);
		droga.drawString("Polka 3", 610, 70);
		droga.drawString("Polka 4", 55, 310);
		droga.drawString("Polka 5", 695, 310);
		droga.drawString("OUT", 255, 750);
		droga.drawString("IN", 455, 750);
	}
	
	
	
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
	
}


/*case "prawo" : pojazd.setLocation(x+40,y); x=x+40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "lewo" : pojazd.setLocation(x-40,y); x=x-40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "dol" : pojazd.setLocation(x,y+40); y=y+40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "gora" : pojazd.setLocation(x,y-40); y=y-40;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "Idz do polki 1" : pojazd.setLocation(120, 160);x=120;y=160;pole.append("U->: "+pole2.getText()+"\n");pole.append("W:-> OK\n");break;
case "Idz do polki 2" : pojazd.setLocation(400, 160);x=400;y=160;break;
case "Idz do polki 3" : pojazd.setLocation(680, 160);x=680;y=160;break;
case "Idz do polki 4" : pojazd.setLocation(160, 400);x=160;y=320;break;
case "Idz do polki 5" : pojazd.setLocation(640, 480);x=600;y=480;break;
case "out" : pojazd.setLocation(320, 680);x=320;y=680;break;
case "in" : pojazd.setLocation(520, 680);x=120;y=680;break;*/