import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Items{

private int x,y;
private BufferedImage img[];//1

//private char  direction;

private int currframe;
private int maxframe;
private int tick;
private final int maxtick=1;
private int cash;

public int getWidth(){ return img[0].getWidth();}
public int getHeight(){ return img[0].getHeight();}
public int getX(){return x;}
public int getY(){return y;}


public Items(int x,int y){
 this.x=x;
 this.y=y;

 cash=5;
 currframe=0;
 maxframe=7;
 tick=0;
// damage=10;
// speed=1;
 	img=new BufferedImage[8];
   try{
       img[0] = ImageIO.read(new File("coinsprites/coin1.png"));
	   img[1] = ImageIO.read(new File("coinsprites/coin2.png"));
	   img[2] = ImageIO.read(new File("coinsprites/coin3.png"));
	   img[3] = ImageIO.read(new File("coinsprites/coin4.png"));
	   img[4] = ImageIO.read(new File("coinsprites/coin5.png"));
	   img[5] = ImageIO.read(new File("coinsprites/coin6.png"));
	   img[6] = ImageIO.read(new File("coinsprites/coin7.png"));
	   img[7] = ImageIO.read(new File("coinsprites/coin8.png"));

  }catch (IOException e)
  {
    e.printStackTrace();
 }
}
// public int getHP(){return hp;}

public void setCash(int c){cash=c;}
public int getCash(){
int c =cash;
cash = 0;
return c;}


//public void setHeroCash(int c){cash=c;}
//public int getHeroCash(){return cash;}




/*
 public void switchDirection(){
  if(direction=='l')direction='r';
  else if(direction=='r')direction='l';
  else if(direction=='u')direction='d';
  else if(direction=='d')direction='u';
 }
 public char getDirection(){return direction;}
 public int getHP(){return hp;}
 public int getSpeed(){return speed;}
 public void takeCash(int v){hp-=v;}
 public int getCash(){return cash;}
 public void draw(Graphics g){
     g.drawImage(img[currframe],x,y,null);

}
public void move(){
if(direction=='u'){y-=5;}
else if(direction=='d'){y+=5;}
else if(direction=='l'){
	System.out.println("left");
	x-=5;}
else if(direction=='r'){
	
	System.out.println("right");
	x+=5;}
}
*/

 public void draw(Graphics g){
 if (cash != 0) {
     g.drawImage(img[currframe],x,y,null);
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

