import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Enemy{
	private int x,y,hp;
	private BufferedImage img[];
	private char direction;
	private int currframe;
	private int maxframe;
	private int tick;
	private final int maxtick=1;
	private int damage;
	private int speed;
	private boolean Moving;
	
	
public int getWidth(){return 50;}
public int getHeight(){return 50;}
public int getX(){return x;}
public int getY(){return y;}


public Enemy(int x, int y){
	Moving = false;
	this.x=x;
	this.y=y;
	hp=3;
	direction='r';
	currframe=0;
	maxframe=1;
	tick=0;
	damage=1;
	speed=1;
		img=new BufferedImage[2];
	  try{
		img[0] = ImageIO.read(new File("enemies/spiderdown.png"));
		img[1] = ImageIO.read(new File("enemies/spiderup.png"));
	    }catch (IOException e)
		{
		  e.printStackTrace();
		}
	}
	
public Enemy(int x, int y, char d){
	Moving = false;
	this.x=x;
	this.y=y;
	hp=3;
	direction=d;
	currframe=0;
	maxframe=1;
	tick=0;
	damage=1;
	speed=1;
		img=new BufferedImage[2];
	  try{
		img[0] = ImageIO.read(new File("enemies/spiderdown.png"));
		img[1] = ImageIO.read(new File("enemies/spiderup.png"));
	    }catch (IOException e)
		{
		  e.printStackTrace();
		}
	}
	
	
/*

public void setDirection(int i){
if(i==1)dir=u;
else if (i==2)dir=d;
else if (i==3)dir=l;
else if (i==4)dir=r;

}


*/

public void collide() {
	this.switchDirection();
	this.move();
}

public void switchDirection(){
	if(direction=='l')direction='r';
	else if(direction =='r')direction='l';
	else if(direction =='d')direction='u';
	else if(direction =='u')direction='d';
}
public char getDirection(){return direction;}
public int getHp(){return hp;}
public int getSpeed(){return speed;}
public void takeDamage(int v){hp=-v;}
public int getDamage(){return damage;}
public void draw(Graphics g){
	g.drawImage(img[currframe],x,y,null);
}
public void move(){
if(direction=='u'){y-=5;}
else if(direction=='d'){y+=5;}
else if(direction=='l'){x-=5;}
else if(direction=='r'){x+=5;}
}

public void setMove(boolean p) {
Moving = p; }


public void update(){
this.move();
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
