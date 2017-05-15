package spaceinvadersgame;

import javax.swing.ImageIcon;

public class Bomb extends Character{
    
    public Bomb(int startX, int startY) {
        super(startX, startY);
        super.setImageIcon(new ImageIcon(this.getClass().getResource("bomb.png")));    
    }   
}
