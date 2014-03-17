import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Sword{

private int x,y;
private BufferedImage img[];
private int damage;
private boolean pickedUp;

public int getWidth(){ return img[0].getWidth();}
public int getHeight(){ return img[0].getHeight();}
public int getX(){return x;}
public int getY(){return y;}
public boolean isPickedUp(){
	return pickedUp;
}


public Sword(int x,int y){
 this.x=x;
 this.y=y; 
 pickedUp=false;		
 	img=new BufferedImage[1];
   try{
       img[0] = ImageIO.read(new File("images/sword.gif"));

  }catch (IOException e)
  {
    e.printStackTrace();
 }
}

public void pickUp() {
	pickedUp = true;
}

public void draw(Graphics g){
 if (!pickedUp) {
     g.drawImage(img[0],x,y,null);
	}
}

}