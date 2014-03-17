import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;


public class Link{

private int x;
private int y;
private int Lhp;
private char dir;
private int xspeed,ypseed;
private BufferedImage up[];
private BufferedImage down[];
private BufferedImage left[];
private BufferedImage right[];
private int currframe;
private int maxframe;
private int linkdamage;
private char direction;
private int tick;
private boolean hasSword;
private int damage;
private boolean isAttacking;
private boolean isMoving;
private int attackTimer;
private final int maxtick=1;
private final int LINK_W=50;
private final int LINK_H=50;
private final int viewRange=100;
private int heroCash;
private BufferedImage stab[];

public Link(int _x, int _y){
	x=_x;
	y=_y;
	direction='d';
	attackTimer = 0;
	tick=0;
	Lhp=10;
	currframe=0;
	maxframe=1;
	damage = 10;
	up=new BufferedImage[2];
	down=new BufferedImage[2];
	left=new BufferedImage[2];
	right=new BufferedImage[2];
	heroCash=0;
	setHasSword(true);
	stab=new BufferedImage[4];
	try{

		 for(int i=0;i<2;i++){
	    	 System.out.println("images/LinkForward_0"+(i+1)+".png");
	     down[i] = ImageIO.read(new File("images/LinkForward_0"+(i+1)+".png"));
		 }
	     for(int i=0;i<2;i++){
	    	 System.out.println("images/LinkLeft_0"+(i+1)+".png");
	     left[i] = ImageIO.read(new File("images/LinkLeft_0"+(i+1)+".png"));
	     }
	     for(int i=0;i<2;i++){
	    	 System.out.println("images/LinkBack_0"+(i+1)+".png");
	     up[i] = ImageIO.read(new File("images/LinkBack_0"+(i+1)+".png"));
	     }
	     for(int i=0;i<2;i++){
	    	 System.out.println("images/LinkRight_0"+(i+1)+".png");
	     right[i] = ImageIO.read(new File("images/LinkRight_0"+(i+1)+".png"));
	     }
	stab[0]=ImageIO.read(new File("images/StabDown.png"));
	stab[1]=ImageIO.read(new File("images/StabUp.png"));
	stab[2]=ImageIO.read(new File("images/StabRight.png"));
	stab[3]=ImageIO.read(new File("images/StabLeft.png"));
 }catch (IOException e)
 {
   e.printStackTrace();
}

}

public int getCash(){return heroCash;}
public void gainCash(int c){heroCash+=c;}
public void setCoins(int b){heroCash=b;}

public int getX(){return x;}
public void setX(int i){x=i;}
public int getY(){return y;}
public void setY(int i){y=i;}
public void setLhp(int w){Lhp=w;}
public int getLhp(){return Lhp;}
public int getLinkDamage(){return linkdamage;}
public int getDamage() {return damage; }
public void setDamage(int i) { damage = i; }
public void setHasSword(boolean hasSword) {this.hasSword = hasSword;}
public boolean hasSword() {return hasSword;}
public boolean isAttacking() {return isAttacking; }
public char getDirection() {return direction;}

public void attack(){
	if (hasSword) {isAttacking = true;}
}

public void linkTakedmg(int q){
    Lhp-=q;
}

public void linkExtraHealth(int h){
	Lhp+=h;
}

public void moveLeft(){
	x-=5;
}
public void moveRight(){
	x+=5;
}
public void moveUp(){
	y-=5;
}
public void moveDown(){
	y+=5;
}

public void stop() {
	isMoving = false;
}

public void move(char dir){
direction = dir;
isMoving = true;
self_move();
}

private void self_move() {
	isAttacking = false;
if(direction=='u'){
	y-=5;
}else if(direction=='d'){
	y+=5;
}else if(direction=='r'){
	x+=5;
}else if(direction=='l'){
	x-=5;
}
}


public void detectionField(Graphics g) {
    float y1 = y + (16);
	float x1 = x + (16);
    g.setColor(Color.BLUE);
        g.setColor(Color.RED);
        g.drawOval((int)(x1 - viewRange), (int)(y1 - viewRange), (int)(2 * viewRange), (int)(2 * viewRange));
}
public void update(){
	if (isMoving) {self_move();}
	attackTimer++;
    if (attackTimer == 20) {attackTimer = 0; isAttacking = false; }
	tick++;
	if(tick>maxtick){
		tick=0;
		currframe++;
		if(currframe>maxframe){
			currframe=0;
		}
	}
}

public void draw(Graphics g){
	if (isAttacking) {
	switch (direction) {
	case 'd': g.drawImage(stab[0],x,y,null);
			break;
	case 'l': g.drawImage(stab[3],x-40,y,null);
			break;
	case 'u': g.drawImage(stab[1],x,y-38,null);
			break;
	case 'r': g.drawImage(stab[2],x,y,null);
			break;
}
	}
	else { switch (direction) {
	case 'd': g.drawImage(down[currframe],x,y,null);
			break;
	case 'l': g.drawImage(left[currframe],x,y,null);
			break;
	case 'u': g.drawImage(up[currframe],x,y,null);
			break;
	case 'r': g.drawImage(right[currframe],x,y,null);
			break;
}
}
	if (isAttacking){
        this.detectionField(g);
    }



}
private int top_x,top_y,width,height;

public int getTopX(){return x;}
public int getTopY(){return y;}
public int getWidth(){return LINK_W;}
public int getHeight(){return LINK_H;}


}
