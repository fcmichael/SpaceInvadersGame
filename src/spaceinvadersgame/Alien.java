package spaceinvadersgame;

import javax.swing.ImageIcon;

public class Alien extends Character{
    
    public Alien(int startX, int startY) {
        super(startX, startY);
        super.setImageIcon(new ImageIcon(this.getClass().getResource("alien.png"))); 
    }       
    
    public Bomb bomb(){
        return new Bomb(this.x+18, this.y+20);
    }
}
