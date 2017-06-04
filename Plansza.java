import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import weka.core.converters.ConverterUtils.DataSource;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.evaluation.output.prediction.Null;
import weka.classifiers.trees.J48;



public class Plansza extends JPanel implements ActionListener {
	
	private Rectangle pojazd;
	private Rectangle kontener1;
	private Rectangle kontener2;
	private Rectangle kontener3;
	private Rectangle przeszkoda1;private Rectangle przeszkoda2;private Rectangle przeszkoda3;private Rectangle przeszkoda4;
	private Rectangle przeszkoda5;private Rectangle przeszkoda6;private Rectangle przeszkoda7;private Rectangle przeszkoda8;
	private Rectangle przeszkoda9;private Rectangle przeszkoda10;
	private Rectangle przeszkoda11;private Rectangle przeszkoda12;private Rectangle przeszkoda13;private Rectangle przeszkoda14;
	private Rectangle przeszkoda15;private Rectangle przeszkoda16;private Rectangle przeszkoda17;private Rectangle przeszkoda18;
	private Rectangle przeszkoda19;private Rectangle przeszkoda20;
	
	
	int[][] Blokady = {
			
			{2,1},{2,2},{2,3},{2,15},{2,16},{2,17},
			{1,8},{1,9},{1,10},
			{11,4},{11,5},{11,6},{11,7},{11,8},{11,9},{11,10},{11,11},{11,12},{11,13},{11,14}
	
	
	};
	
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
		
		//Przeszkody
		przeszkoda1 = new Rectangle(40*2,40*6,40,40);
		przeszkoda2 = new Rectangle(40*3,40*6,40,40);
		przeszkoda3 = new Rectangle(40*4,40*6,40,40);
		przeszkoda4 = new Rectangle(40*9,40*5,40,40);
		przeszkoda5 = new Rectangle(40*10,40*5,40,40);
		przeszkoda6 = new Rectangle(40*11,40*5,40,40);
		przeszkoda7 = new Rectangle(40*16,40*6,40,40);
		przeszkoda8 = new Rectangle(40*17,40*6,40,40);
		przeszkoda9 = new Rectangle(40*18,40*6,40,40);
		przeszkoda10 = new Rectangle(40*5,40*15,40,40);
		przeszkoda11 = new Rectangle(40*6,40*15,40,40);
		przeszkoda12 = new Rectangle(40*7,40*15,40,40);
		przeszkoda13 = new Rectangle(40*8,40*15,40,40);
		przeszkoda14 = new Rectangle(40*9,40*15,40,40);
		przeszkoda15 = new Rectangle(40*10,40*15,40,40);
		przeszkoda16 = new Rectangle(40*12,40*15,40,40);
		przeszkoda17 = new Rectangle(40*13,40*15,40,40);
		przeszkoda18 = new Rectangle(40*14,40*15,40,40);
		przeszkoda19 = new Rectangle(40*15,40*15,40,40);
		przeszkoda20 = new Rectangle(40*11,40*15,40,40);
		
		
		
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
		
		setFocusable(true);
		ruch();	
		
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
		//graphics2d.setColor(Color.ORANGE);
		//graphics2d.fill(kontener2);
		//graphics2d.setColor(Color.GREEN);
		//graphics2d.fill(kontener3);
		
		graphics2d.setColor(Color.GRAY);
		graphics2d.fill(przeszkoda1);
		graphics2d.fill(przeszkoda2);
		graphics2d.fill(przeszkoda3);
		graphics2d.fill(przeszkoda4);
		graphics2d.fill(przeszkoda5);
		graphics2d.fill(przeszkoda6);
		graphics2d.fill(przeszkoda7);
		graphics2d.fill(przeszkoda8);
		graphics2d.fill(przeszkoda8);
		graphics2d.fill(przeszkoda9);
		graphics2d.fill(przeszkoda10);
		graphics2d.fill(przeszkoda11);
	 	graphics2d.fill(przeszkoda12);
 		graphics2d.fill(przeszkoda13);
	 	graphics2d.fill(przeszkoda14);
    	graphics2d.fill(przeszkoda15);
	 	graphics2d.fill(przeszkoda16);
		graphics2d.fill(przeszkoda17);
		graphics2d.fill(przeszkoda18);
	 	graphics2d.fill(przeszkoda19);
		graphics2d.fill(przeszkoda20);
	
		
	
		
		droga.setColor(Color.green);
		
		Font font = new Font("Arial", Font.BOLD, 24);
		droga.setFont(font);		
		
		Rectangle2D polka1 = new Rectangle2D.Double(40,40,200,120);
		droga.draw(polka1);
		
		Rectangle2D polka2 = new Rectangle2D.Double(320,40,200,120);
		droga.draw(polka2);
			
		Rectangle2D polka3 = new Rectangle2D.Double(600,40,200,120);
		droga.draw(polka3);
			
		
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
		
		droga.setStroke(new BasicStroke(3));
		droga.setColor(Color.black);
		droga.draw(new Line2D.Double(40, 160, 20*40, 160));
		droga.draw(new Line2D.Double(40, 18*40, 20*40, 18*40));
		droga.draw(new Line2D.Double(40, 160, 40, 18*40));
		droga.draw(new Line2D.Double(20*40, 160, 20*40, 18*40));
		
		
		droga.setStroke(new BasicStroke(1));
		droga.setColor(Color.gray);
		droga.setColor(Color.blue);
		droga.drawString("Polka 1", 55, 70);
		droga.drawString("Polka 2", 330, 70);
		droga.drawString("Polka 3", 610, 70);
		
		droga.drawString("0", 5, 190);
		droga.drawString("2", 5, 190+2*40);
		droga.drawString("4", 5, 190+4*40);
		droga.drawString("6", 5, 190+6*40);
		droga.drawString("8", 5, 190+8*40);
		droga.drawString("10", 5, 190+10*40);
		droga.drawString("12", 5, 190+12*40);
		
		droga.drawString("0", 45, 190+14*40);
		droga.drawString("2", 45+2*40, 190+14*40);
		droga.drawString("4", 45+4*40, 190+14*40);
		droga.drawString("14", 45+14*40, 190+14*40);
		droga.drawString("16", 45+16*40, 190+14*40);
		droga.drawString("18", 45+18*40, 190+14*40);
	
		
		droga.drawString("Polka 4", 255, 750); //zamienilem tylko napis OUT na TREE na potrzeby decision tree
		droga.drawString("IN", 455, 750);
	}
		
	
	public void przesunPojazdX(int przesuniecie){	
		pojazd.setBounds((int)pojazd.getX()+przesuniecie, (int)pojazd.getY(), (int)pojazd.getWidth(), (int)pojazd.getHeight());		
	}
	
	public void przesunPojazdY(int przesuniecie){
		pojazd.setBounds((int)pojazd.getX(), (int)pojazd.getY()+przesuniecie, (int)pojazd.getWidth(), (int)pojazd.getHeight());
	}
	
	
	
	public void ruch(){
		timer = new Timer();
	}
	
	//wspolrzedne kontenerow
	int[] kontener1xy = {485,765};
	int[] kontener2xy = {525,765};
	int[] kontener3xy = {565,765};
	
	int[] polka1temp={0,0}; 
	int polka2temp=0, polka3temp=0, polka4temp=0, polka5temp=0, intemp=0;
	//polka 1
	int[] polka1miejsce1 = {85,85,0};
	int[] polka1miejsce2 = {165,85,0};
	//polka 2
	int[] polka2miejsce1 = {365,85,0};
	int[] polka2miejsce2 = {445,85,0};
	//polka 3
	int[] polka3miejsce1 = {645,85,0}; //645, 85
	int[] polka3miejsce2 = {725,85,0}; //725, 85
	//polka 4
	int[] polka4miejsce1 = {85,365,0}; //85, 365
	int[] polka4miejsce2 = {85,445,0}; //85, 445
	int[] polka4miejsce3 = {85,525,0}; //85, 525
	//polka 5
	int[] polka5miejsce1 = {725,365,0}; //725, 365
	int[] polka5miejsce2 = {725,445,0}; // 725, 445
	int[] polka5miejsce3 = {725,525,0}; //725, 525
	//out
	int[] outmiejsce1 = {285,765,0}; //
	int[] outmiejsce2 = {325,765,0}; //
	
	//Wazna funkcja, po przeniesieniu robi puste miejsce na polce
	public void WstawZero(int x, int y){
		//polka1
		if(polka1miejsce1[0]==x && polka1miejsce1[1]==y){polka1miejsce1[2]=0;}
		if(polka1miejsce2[0]==x && polka1miejsce2[1]==y){polka1miejsce2[2]=0;}
		//polka2
		if(polka2miejsce1[0]==x && polka2miejsce1[1]==y){polka2miejsce1[2]=0;}
		if(polka2miejsce2[0]==x && polka2miejsce2[1]==y){polka2miejsce2[2]=0;}
		//polka3
		if(polka3miejsce1[0]==x && polka3miejsce1[1]==y){polka3miejsce1[2]=0;}
		if(polka3miejsce2[0]==x && polka3miejsce2[1]==y){polka3miejsce2[2]=0;}
		//polka4
		if(polka4miejsce1[0]==x && polka4miejsce1[1]==y){polka4miejsce1[2]=0;}
		if(polka4miejsce2[0]==x && polka4miejsce2[1]==y){polka4miejsce2[2]=0;}
		if(polka4miejsce1[0]==x && polka4miejsce1[1]==y){polka4miejsce1[2]=0;}
		//polka5
		if(polka5miejsce1[0]==x && polka5miejsce1[1]==y){polka5miejsce1[2]=0;}
		if(polka5miejsce2[0]==x && polka5miejsce2[1]==y){polka5miejsce2[2]=0;}
		if(polka5miejsce1[0]==x && polka5miejsce1[1]==y){polka5miejsce1[2]=0;}
		//polka out
		if(outmiejsce1[0]==x && outmiejsce1[1]==y){outmiejsce1[2]=0;}
		if(outmiejsce2[0]==x && outmiejsce2[1]==y){outmiejsce2[2]=0;}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int[] zajetosc_in = {1,1};
		
		if(e.getSource()==pole2 || e.getSource()==potwierdz){
			
		int pom_x = -1; int pom_y = -1;
			
			
		String sciezka_astar="";
		String Komunikat2="";
		
		
					
		// poczatek tree decision, budujemy drzewo na podst danych z pliku ------------------------------------------------------------
							DataSource source = null;
							try {
								source = new DataSource("resources/plik.arff");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							 Instances data = null;
							try {
								data = source.getDataSet();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							 // setting class attribute if the data format does not provide this information
							 // For example, the XRFF format saves the class attribute information as well
							 if (data.classIndex() == -1)
							   data.setClassIndex(data.numAttributes() - 1);
							 
							 String[] options = new String[1];
							 options[0] = "-U";            
							 J48 tree = new J48();         
							 try {
								tree.setOptions(options);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}     // set the options
							 try {
								tree.buildClassifier(data);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}   // build classifier
							 
							 System.out.println(tree);
		// koniec budowania drzewa -----------------------------------------------------------------	
							 
			
							 
							 
		// ruch wozka od srodka do strefy in --------------------------------------------------------
							 
		pole.append("W->: Ruszam do strefy IN.\n");
								
		sciezka_astar=AStar.test(1, 14, 19, 6, 9, 13, 11, Blokady);
		//pole.append("W->:"+ sciezka_astar +"\n");						 
		
		sciezka_astar.substring(0,sciezka_astar.length()-1);
		
		String[] tab_sciezka = sciezka_astar.split("\\s+");
		
		for (int i = tab_sciezka.length-1; i >= 1 ; i--) {
			
			String temp;
			temp = tab_sciezka[i].replace("[", "");
			temp = temp.replace("]", "");
			
		   	//pole.append("W->:"+ temp +"\n");
		   	
		   	String[] parts = temp.split(",");
		   	String part1 = parts[0]; 
		   	String part2 = parts[1]; 
		   	
		   	//pole.append("W->:"+ part1 + " i " + part2 +"\n");
		   	
		   	int y = Integer.parseInt(part1);
		   	int x = Integer.parseInt(part2);
		   	
		   	pojazd.setLocation(x*40 + 40, y*40 + 160);
			paint(getGraphics());
		   	
			try {     // krok co 0.5 sekundy
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
						
		}
		
	
		// koniec ruchu wozka od srodka do strefy in --------------------------------------------------------
		
		
		
		try {  // pauza pomocnicza
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		
		// wybor polki docelowej na podstawie treedecision	------				 
		
		Instance instance = new DenseInstance(7);
		instance.setDataset(data);
		instance.setValue(data.attribute(0), "false");
		instance.setValue(data.attribute(1), "true");
		instance.setValue(data.attribute(2), "light");
		instance.setValue(data.attribute(3), 12.0);
		instance.setValue(data.attribute(4), 123.0);
		instance.setValue(data.attribute(5), 14.0);
		 
		int result = -1;
		 
		try {
			result = (int) tree.classifyInstance(instance);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		result++;
		 
		System.out.println(result);
		 
		pole.append("W->: Za pomoca treedecision wybrano polke: "+ (result) +".\n");
		
			
		// koniec wyboru polki za pomoca treedecison ----------------------------------------------------------
		
		
		
		if (result == 1){
			
			pom_x = 0;
			pom_y = 2;
			
		} else if (result == 2){
			
			pom_x = 0;
			pom_y = 9;
			
		} else if (result == 3){
			
			pom_x = 0;
			pom_y = 16;
			
		} else if (result == 4){
			
			pom_x = 13;
			pom_y = 6;
			
		}
		 
			
		sciezka_astar=AStar.test(1, 14, 19, 13, 11, pom_x, pom_y, Blokady);
		sciezka_astar.substring(0,sciezka_astar.length()-1);
		
		String[] tab_sciezka2 = sciezka_astar.split("\\s+");
		
		for (int i = tab_sciezka2.length-1; i >= 1 ; i--) {
			
			String temp;
			temp = tab_sciezka2[i].replace("[", "");
			temp = temp.replace("]", "");
			
		   	//pole.append("W->:"+ temp +"\n");
		   	
		   	String[] parts = temp.split(",");
		   	String part1 = parts[0]; 
		   	String part2 = parts[1]; 
		   	
		   	//pole.append("W->:"+ part1 + " i " + part2 +"\n");
		   	
		   	int y = Integer.parseInt(part1);
		   	int x = Integer.parseInt(part2);
		   	
		   	pojazd.setLocation(x*40 + 40, y*40 + 160);
		   	kontener1.setLocation(x*40 + 40, y*40 + 160);
			paint(getGraphics());
		   	
			try {     // krok co 0.5 sekundy
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
						
		}
		
		kontener1.setLocation(polka1miejsce1[0],polka1miejsce1[1]);
		paint(getGraphics());
		pole.append("W:-> Przeniesiono paczke na polke: " + result + ".\n");
	
		// koniec ruchu wozka od in do polki --------------------------------------------------------
		
		
		
	
	
		
		
		}
		
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		repaint();

	}
}
