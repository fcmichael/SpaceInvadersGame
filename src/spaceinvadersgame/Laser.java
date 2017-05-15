package spaceinvadersgame;

import javax.swing.ImageIcon;

public class Laser extends Character{
    
    public Laser(int startX, int startY) {
        super(startX, startY);
        super.setImageIcon(new ImageIcon(this.getClass().getResource("laser.png")));
    
    }  
}
