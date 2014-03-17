import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;

public class Interface extends JPanel{

private Color color;
private Link l;
private int coinamount;
private int heartamount;
private BufferedImage coinImg;
private BufferedImage swordImg;
private BufferedImage heartImg;
private BufferedImage lifeImg;
private int currframe;
private int maxframe;
private int tick;
private final int maxtick=1;

public Interface(Link p){
	color=Color.WHITE;
	l=p;
}

public void draw( Graphics g ){
		super.paintComponent( g );
		g.setColor(Color.BLACK);
		g.fillRect(1500,0,250,1070);
		this.cash(g);
		//this.hearts();
		//this.life();
		this.sword(g);
}
private void cash( Graphics g) {
	try{
		coinImg=ImageIO.read(new File("coinsprites/coin5.png"));
	 }catch (IOException e) {
   		e.printStackTrace();
	}
	g.drawImage(coinImg, 1530, 669, 36, 36, this);
	int x=1550;
	int y=700;
	int cash=l.getCash();
	Font f=new Font("Arial Black", Font.BOLD, 36);
	g.setColor(color);
    g.setFont(f);
	g.drawString("   X   " +cash, 1570, 700);
}
private void sword( Graphics g) {
	try{
		swordImg=ImageIO.read(new File("images/swordleft.gif"));
	 }catch (IOException e) {
   		e.printStackTrace();
	}
	
	int x=1550;
	int y=700;
	if(l.hasSword()==true){
	g.drawImage(swordImg, 1520, 764, 100, 48, this);
	Font f=new Font("Arial Black", Font.BOLD, 36);
	g.setColor(color);
    g.setFont(f);
	g.drawString("   C   ", 1620, 800);
	}
}


public void update(){
	 tick++;
         if(tick>maxtick){
	   tick=0;
	   currframe++;
	   if(currframe>maxframe){
	 	currframe=0;
	   }
	 }

}
}