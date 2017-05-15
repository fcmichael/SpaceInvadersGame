package spaceinvadersgame;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private final int[][] aliensBeginningPositions;
    private final int numberOfAliens;
    private final int bombFallingSpeed;
    private List<Alien> aliens = new ArrayList<>();

    public Level(int[][] aliensBeginningPositions, int numberOfAliens, int bombFallingSpeed) {
        this.numberOfAliens = numberOfAliens;
        this.aliensBeginningPositions = aliensBeginningPositions;
        this.bombFallingSpeed = bombFallingSpeed;
    }

    public int getNumberOfAliens() {
        return numberOfAliens;
    }

    public int getBombFallingSpeed() {
        return bombFallingSpeed;
    }

    private void createAliens() {
        for (int i = 0; i < aliensBeginningPositions.length; i++) {
            for (int j = 0; j < aliensBeginningPositions[0].length; j++) {
                if (this.aliensBeginningPositions[i][j] == 1) {
                    aliens.add(new Alien((47 + (j * 64)), (50 + (i * 50))));

                }
            }
        }
    }

    public List<Alien> getAliens() {
        this.aliens.removeAll(aliens);
        createAliens();
        return aliens;
    }

}
