package spaceinvadersgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends JComponent implements Runnable {

    Thread thread;
    private boolean run = false;
    private final Player player = new Player();
    private Laser laser;
    private boolean laserFlag = false;
    private boolean rightMove = false;
    private boolean leftMove = false;
    private int currentScore = 0;
    private final Level level;
    private final List<Alien> aliens;
    private int aliensChange = 1;
    private Bomb bomb;
    private boolean bombFlag = false;

    private final MyButton exit = new MyButton("Exit", new Color(222, 77, 92));
    private final MyButton startGame = new MyButton("Start", new Color(1, 100, 2));
    private final JLabel scoreLabel = new JLabel();
    private boolean scorePanel = false;
    private MyButton youScored;
    private final KeysAdapter keysAdapter = new KeysAdapter();

    Game(Level level) {
        this.level = level;
        this.aliens = level.getAliens();
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(keysAdapter);
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (run) {
                    stopGame();
                }
                SpaceInvadersGame.changePanel("menu", Game.this);
            }
        });

        startGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                startGame.setVisible(false);
                run = true;
                startGame();
            }
        });

    }

    public void startGame() {
        thread = new Thread(this, "Game Loop");
        thread.start();
    }

    @Override
    public void run() {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        long lastFpsTime = 0;
        while (run) {
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            lastFpsTime += updateLength;
            if (lastFpsTime >= 1000000000) {
                lastFpsTime = 0;
            }

            tick();
            repaint();

            if(aliens.isEmpty()){
                stopGame();
            }
            
            try {
                Thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
            } catch (Exception e) {
            }
        }
    }

    public void stopGame() {
        run = false;
        scorePanel = true;
        repaint();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Exception occured while finishing thread:");
            e.printStackTrace();
        }
    }

    public void tick() {
        int i = 0;

        if (player.getX() >= 20 && player.getX() <= 745) {
            if (rightMove) {
                if (player.getX() + 6 > 745) {
                    player.setX(745);
                } else {
                    player.setX(player.getX() + 6);
                }
            } else if (leftMove) {
                if (player.getX() - 6 < 20) {
                    player.setX(20);
                } else {
                    player.setX(player.getX() - 6);
                }
            }
        }

        if (laserFlag && laser != null) {
            if (laser.getY() < 45) {
                laserFlag = false;
                laser = null;

            } else {
                laser.setY(laser.getY() - 10);

                boolean aliensCollision = true;

                while (aliensCollision && i < aliens.size()) {
                    Alien a = aliens.get(i);
                    if (((laser.getX() > a.getX()) && (laser.getX() < a.getX() + 35))
                            && ((laser.getY() > a.getY()+10) && (laser.getY() < a.getY() + 20))) {
                        aliensCollision = false;
                        aliens.remove(i);
                        collision(a, laser);
                        laserFlag = false;
                        laser = null;
                    }
                    i++;
                }
            }
        }

        boolean alienStopFlag = true;
        i = 0;
        if (aliensChange == -1) {
            while (alienStopFlag && i < aliens.size()) {
                Alien a = aliens.get(i);
                if (a.getX() - 1 < 10) {
                    alienStopFlag = false;
                    aliensChange = 1;
                } else {
                    a.setX(a.getX() - 1);
                }
                i++;
            }
        } else if (aliensChange == 1) {
            while (alienStopFlag && i < aliens.size()) {
                Alien a = aliens.get(i);
                if (a.getX() + 1 > 740) {
                    alienStopFlag = false;
                    aliensChange = -1;
                } else {
                    a.setX(a.getX() + 1);
                }
                i++;
            }
        }

        if (bomb != null && bombFlag) {
            if (bomb.getY() < 555) {
                bomb.setY(bomb.getY() + level.getBombFallingSpeed());

                if (((bomb.getX() > player.getX()) && (bomb.getX() < player.getX() + 28))
                        && ((bomb.getY() > player.getY()) && (bomb.getY() < player.getY() + 30))) {
                    collision(player, bomb);
                }

            } else {
                bombFlag = false;
                bomb = null;
            }

        } else {
            int randomNum = ThreadLocalRandom.current().nextInt(0, aliens.size());
            bombFlag = true;
            Alien a = aliens.get(randomNum);
            bomb = a.bomb();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2d = (Graphics2D) g;

        g.setColor(new Color(0, 255, 255));
        g.drawRect(10, 40, 780, 550);
        g.drawRect(20, 50, 760, 530);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        g.drawString("Score: ", 10, 20);
        scoreLabel.setForeground(Color.red);
        scoreLabel.setBounds(80, 5, 100, 20);
        scoreLabel.setText("  " + currentScore + " points");
        exit.setBounds(690, 5, 100, 20);
        startGame.setBounds(300, 250, 200, 100);
        add(scoreLabel);
        add(exit);
        if (!run) {
            add(startGame);
        }

        graphics2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        for (int i = 0; i < aliens.size(); i++) {
            Alien a = aliens.get(i);
            graphics2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
        }

        if (laserFlag && laser != null) {
            graphics2d.drawImage(laser.getImage(), laser.getX(), laser.getY(), this);
        }

        if (bombFlag && bomb != null) {
            graphics2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
        }

        if (scorePanel) {
            youScored = new MyButton("You've scorred: " + currentScore, Color.blue);
            youScored.setBounds(300, 250, 200, 100);
            youScored.setEnabled(false);
            add(youScored);
        }
    }

    private class KeysAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT: {
                    leftMove = true;
                    rightMove = false;
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    leftMove = false;
                    rightMove = true;
                    break;
                }
                case KeyEvent.VK_SPACE: {
                    if (laser == null) {
                        laserFlag = true;
                        laser = player.shot();
                    }
                    break;
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private void collision(Character who, Character weapon) {
        if (who instanceof Player && weapon instanceof Bomb) {
            stopGame();
        } else if (who instanceof Alien && weapon instanceof Laser) {
            currentScore += 100;
        }
    }
}
