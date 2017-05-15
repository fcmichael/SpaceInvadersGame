package spaceinvadersgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

public class MainMenu extends JComponent {

    private MyButton start = new MyButton("Start", new Color(225, 124, 100));

    public MainMenu() {

        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                SpaceInvadersGame.changePanel("levelChoose", MainMenu.this);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        start.setBounds(300, 160, 200, 40); // x,y, width, height
        add(start);
    }
}
