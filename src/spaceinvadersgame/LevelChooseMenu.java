package spaceinvadersgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

public class LevelChooseMenu extends JComponent {

    private final MyButton level1 = new MyButton("Level 1", new Color(0, 153, 0));
    private final MyButton level2 = new MyButton("Level 2", new Color(225, 0, 100));
    private final MyButton level3 = new MyButton("Level 3", new Color(51, 51, 255));
    private final MyButton level4 = new MyButton("Level 4", new Color(255, 255, 102));
    private final MyButton backToMenu = new MyButton("Back to menu", new Color(210, 105, 30));

    public LevelChooseMenu() {

        level1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                SpaceInvadersGame.changePanel("level1", LevelChooseMenu.this);
            }
        });

        level2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                SpaceInvadersGame.changePanel("level2", LevelChooseMenu.this);
            }
        });

        level3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                SpaceInvadersGame.changePanel("level3", LevelChooseMenu.this);
            }
        });

        level4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                SpaceInvadersGame.changePanel("level4", LevelChooseMenu.this);
            }
        });

        backToMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                SpaceInvadersGame.changePanel("menu", LevelChooseMenu.this);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        //Sets up the buttons position 
        level1.setBounds(300, 120, 200, 40); // x,y, width, height
        level2.setBounds(300, 220, 200, 40);
        level3.setBounds(300, 320, 200, 40);
        level4.setBounds(300, 420, 200, 40);
        backToMenu.setBounds(620, 550, 150, 40);

        // Adds buttons to the ui
        add(level1);
        add(level2);
        add(level3);
        add(level4);
        add(backToMenu);
    }
}
