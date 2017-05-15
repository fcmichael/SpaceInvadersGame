package spaceinvadersgame;

import javax.swing.ImageIcon;

public class Player extends Character{
    
    private final static int START_X = 390;
    private final static int START_Y = 530;
    
    public Player() {
        super(START_X, START_Y);
        super.setImageIcon(new ImageIcon(this.getClass().getResource("player.png")));
    }
    
    public Laser shot(){
        return new Laser(this.x, this.y-5);
    }
}
