import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Health{

private int x,y;
private BufferedImage img[];//1
private int health;


public int getWidth(){ return img[0].getWidth();}
public int getHeight(){ return img[0].getHeight();}
public int getX(){return x;}
public int getY(){return y;}


public Health(int x,int y){
 this.x=x;
 this.y=y;
 health=3;

img=new BufferedImage[1];
	 try{
       img[0] = ImageIO.read(new File("hearts/full.gif"));
	   
  }catch (IOException e)
  {
    e.printStackTrace();
 }
}

// public int getHP(){return hp;}

public void setHealth(int h){health=h;}
public int getHealth(){
int h =health;
health = 0;
return h;}

 public void draw(Graphics g){
 if(health !=0){
     g.drawImage(img[0],x,y,null);
 }
}

public void update(){
	

}



}

