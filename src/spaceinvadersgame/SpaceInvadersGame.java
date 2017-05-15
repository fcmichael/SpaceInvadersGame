package spaceinvadersgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpaceInvadersGame {
  
    private final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final MainMenu menuPanel = new MainMenu();
    private static final LevelChooseMenu levelChoosePanel = new LevelChooseMenu();
    private static final LevelsConfiguration levelsConf = new LevelsConfiguration();
    private static Game game;

    public SpaceInvadersGame() {
        panel.setPreferredSize((new Dimension(800, 600)));
        panel.setLayout(new BorderLayout());
        changePanel("menu");

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Space Invaders");
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public static void changePanel(String option) {
        switch (option) {
            case "menu": {
                panel.setBackground(Color.LIGHT_GRAY);
                panel.add(menuPanel, BorderLayout.CENTER);
                break;
            }
            case "levelChoose": {
                panel.setBackground(Color.LIGHT_GRAY);
                panel.add(levelChoosePanel, BorderLayout.CENTER);
                break;
            }
            case "level1": {
                panel.setBackground(Color.BLACK);
                game = new Game(levelsConf.LEVEL1);
                panel.add(game,BorderLayout.CENTER);  
                break;
            }
            case "level2": {
                panel.setBackground(Color.BLACK);
                game = new Game(levelsConf.LEVEL2);
                panel.add(game, BorderLayout.CENTER);
                break;
            }
            case "level3": {
                panel.setBackground(Color.BLACK);
                game = new Game(levelsConf.LEVEL3);
                panel.add(game, BorderLayout.CENTER);
                break;
            }
            case "level4": {
                panel.setBackground(Color.BLACK);
                game = new Game(levelsConf.LEVEL4);
                panel.add(game, BorderLayout.CENTER);
                break;
            }
        }
    }

    public static void changePanel(String option, JComponent comp) {
        panel.remove(comp); // Removes component
        panel.revalidate(); // Revalidates the panel
        changePanel(option); // Sets up the proper component       
        panel.repaint(); // Repaints the whole panel 
    }
    
    public static void main(String[] args) {
        new SpaceInvadersGame();
    }
    
}
