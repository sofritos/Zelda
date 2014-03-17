import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GraphicsPanel2 extends JPanel{

private Screen2 s;
private Link hero;
private Link z, z2;
//private Interface inter;

public GraphicsPanel2(){
 s=new Screen2();
 s.setLevel(1);
 hero=new Link(700,530);
 inter=new Interface(hero);
}


public void moveDir(char c){
	int tx=hero.getX();
	int ty=hero.getY();
	if (c == 's') {
		hero.attack();
		return;
		}
	if(c=='l'){
		tx-=5;
		if(!s.level_collision(tx,ty,hero.getWidth(),hero.getHeight())){
		hero.move(c);
		}
		}
		if(c=='r'){
			tx+=5;
		    if(!s.level_collision(tx,ty,hero.getWidth(),hero.getHeight())){
		      hero.move(c);
		    }
		}
		if(c=='u'){
			ty-=5;
		    if(!s.level_collision(tx,ty,hero.getWidth(),hero.getHeight())){
		      hero.move(c);
		    }
		}
		if(c=='d'){
			ty+=5;
		    if(!s.level_collision(tx,ty,hero.getWidth(),hero.getHeight())){
		      hero.move(c);
		    }
		}
		if(c=='x') {
		hero.stop();
	}
}

public void reset(){
		 s.setLevel(1);
		 hero.setCoins(0);
		 hero.setX(700);
		 hero.setY(520);
	 }

public void update(){
	int tx=hero.getX();
	int ty=hero.getY();
	System.out.println(tx + " , " + ty);
		if(hero.getDirection()=='l'){
		tx-=5;
		if(s.level_collision(tx,ty,hero.getWidth(),hero.getHeight())){
		hero.stop();
		}
		}
		if(hero.getDirection()=='r'){
			tx+=5;
		    if(s.level_collision(tx,ty,hero.getWidth(),hero.getHeight())){
		      hero.stop();
		    }
		}
		if(hero.getDirection()=='u'){
			ty-=5;
		    if(s.level_collision(tx,ty,hero.getWidth(),hero.getHeight())){
		      hero.stop();
		    }
		}
		if(hero.getDirection()=='d'){
			ty+=5;
		    if(s.level_collision(tx,ty,hero.getWidth(),hero.getHeight())){
		      hero.stop();
		    }
	}

	int cash=s.checkCoins(hero.getX(),hero.getY(),hero.getWidth(),hero.getHeight());//h.ispickingupcoins());
	hero.gainCash(cash);
	if (! hero.hasSword( ) ) {
		if (s.getLevel() == 3) {
		if (s.checkSword(tx,ty,hero.getWidth(),hero.getHeight()) ) {
			hero.setHasSword(true);
			}
		}
		}

	hero.update();
 	s.update();
	System.out.println(hero.hasSword()+ " + "+ hero.isAttacking());
	int x = 0; //link's collision damage
    //int dmg=s.checkEnemy(hero.getX(),hero.getY(),hero.getWidth(),hero.getHeight(),5);//hero.isAttacking());
	int dmg=s.checkEnemy(hero.getX(),hero.getY(),hero.getWidth(),hero.getHeight(),x);
    hero.linkTakedmg(dmg);
    int swordDamage = hero.getDamage(); //How much damage the sword deals
    
    if (hero.isAttacking() ) {
    switch (hero.getDirection() ) {
    	case 'l':s.checkEnemy( hero.getX()-40,hero.getY(),hero.getWidth(),12, swordDamage  );
    			break;
    	case 'r':s.checkEnemy( hero.getX()+40,hero.getY(),hero.getWidth(),12, swordDamage  );
    			break;
    	case 'u':s.checkEnemy( hero.getX()+12,hero.getY()-38,12,hero.getHeight(), swordDamage  );
    			break;
    	case 'd':s.checkEnemy( hero.getX()+21,hero.getY()+38,12,hero.getHeight(), swordDamage  );
    			break;
    		default:System.out.println("Sword error, no direction");
    	}
    } //end sword checks
	s.update();

	if(hero.getLhp()<=0){
	System.out.println("lol");
    reset();
    hero.setLhp(10);
    s.update();
	}


	int extrahearts=s.checkHearts(hero.getX(),hero.getY(),hero.getWidth(),hero.getHeight());
	hero.linkExtraHealth(extrahearts);
	hero.update();
	s.update();

if(s.getLevel()==1){
 if ((hero.getTopY() < 0)){
 s.setLevel(2);
 hero.setX(700);
 hero.setY(1000);
 }
 else if ((hero.getTopY() > 1000)){
 s.setLevel(4);
 //hero.setX(700);
 hero.setY(0);
 }
else if ((hero.getTopX() < 0)){
 s.setLevel(3);
 hero.setX(1450);
 hero.setY(530);
 }
 else if ((hero.getTopX() > 1500)){
 s.setLevel(5);
 hero.setX(0);
 hero.setY(530);

 	}
 }

//Level 2
if(s.getLevel()==2){
if ((hero.getTopY() > 1020)){
 s.setLevel(1);
 hero.setX(700);
 hero.setY(0);
 }

}

 //Level3
if(s.getLevel()==3){
	if ((hero.getTopX() > 1450)){
		s.setLevel(1);
 		hero.setX(0);
		hero.setY(530);
	}
}

 //Level4
if(s.getLevel()==4){
	if ((hero.getTopY() < 0)){
		s.setLevel(1);
 		hero.setX(700);
		hero.setY(1000);
	}
}

 //Level5
if(s.getLevel()==5){
	if ((hero.getTopX() < 0)){
		s.setLevel(1);
 		hero.setX(1450);
		hero.setY(530);
	}
}
//Level 6
if(s.getLevel()==6){
	if ((hero.getTopY() < 0)){
		s.setLevel(4);
 		hero.setX(950);
		hero.setY(1000);
	}else if((hero.getTopY()==900 && hero.getTopX()==200)){
		s.setLevel(7);
 		hero.setX(50);
		hero.setY(100);
	}
}
//Level 7
if(s.getLevel()==7){
	if ((hero.getTopY()==50 && hero.getTopX()==50)){
		s.setLevel(6);
 		hero.setX(200);
		hero.setY(950);
	}
 
}



}

public void paint(Graphics g){
  s.draw(g);
  hero.draw(g);
  //inter.draw(g);
}


}