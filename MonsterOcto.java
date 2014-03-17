import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class MonsterOcto{

private int x,y,hp;
private BufferedImage img[];//1

private char  direction;

private int currframe;
private int maxframe;
private int tick;
private final int maxtick=1;
private int damage;
private int speed;

public int getWidth(){ return img[0].getWidth();}
public int getHeight(){ return img[0].getHeight();}
public int getX(){return x;}
public int getY(){return y;}
public MonsterOcto(int x,int y){
 this.x=x;
 this.y=y;
 hp=8;
 direction='l';
 currframe=0;
 maxframe=2;
 tick=0;
 damage=3;
 speed=1;
 	img=new BufferedImage[3];
   try{
      img[0] = ImageIO.read(new File(".. /LinkSwagDaddy/enemies/Ghostleft.png"));
      //img[1] = ImageIO.read(new File("enemy/images/enemy1_02.png"));
      //img[2] = ImageIO.read(new File("enemy/images/enemy1_03.png"));

  }catch (IOException e)
  {
    e.printStackTrace();
 }
}
 public void switchDirection(){
  if(direction=='l')direction='r';
  else if(direction=='r')direction='l';
  else if(direction=='u')direction='d';
  else if(direction=='d')direction='u';
 }
 public char getDirection(){return direction;}
 public int getHP(){return hp;}
 public int getSpeed(){return speed;}
 public void takeDamage(int v){hp-=v;}
 public int getDamage(){return damage;}
 public void draw(Graphics g){
     g.drawImage(img[currframe],x,y,null);

}
public void move(){
if(direction=='u'){y-=1;}
else if(direction=='d'){y+=1;}
else if(direction=='l'){
	System.out.println("left");
	x-=1;}
else if(direction=='r'){
	
	System.out.println("right");
	x+=1;}
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