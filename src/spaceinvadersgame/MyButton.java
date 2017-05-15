package spaceinvadersgame;

import java.awt.Color;
import javax.swing.JButton;

public class MyButton extends JButton{
    
    public MyButton(String name, Color color){   
        super(name);
        setFocusPainted(false);
        setBorderPainted(false);
        setBackground(color);
        setForeground(Color.BLACK);  
    }
}
