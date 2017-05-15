package spaceinvadersgame;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Character {
    
    protected int x;
    protected int y;
    protected ImageIcon imageIcon;
    
    protected Character(int startX, int startY){
        this.x = startX;
        this.y = startY;
    }
    
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }  
    
    public void setX(int x){
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }  
    
    public Image getImage() {
        return this.imageIcon.getImage();
    }  
    
}
