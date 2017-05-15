package spaceinvadersgame;

public class LevelsConfiguration {
       
    private final int[][] aliensBeginningPositions1 = new int[][]{
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
    };
    private final int[][] aliensBeginningPositions2 = new int[][]{
        {1,1,1,1,1,1,1,1,1,1,1},
        {0,1,1,1,1,1,1,1,1,1,0},
        {0,0,1,1,1,1,1,1,1,0,0},
        {0,0,0,1,1,1,1,1,0,0,0},
        {0,0,0,0,1,1,1,0,0,0,0},
        {0,0,0,0,0,1,0,0,0,0,0},
    };
    private final int[][] aliensBeginningPositions3 = new int[][]{
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,0,1,1,1,1,1},
        {1,1,1,1,0,0,0,1,1,1,1},
        {1,1,1,0,0,0,0,0,1,1,1},
        {1,1,0,0,0,0,0,0,0,1,1},
        {1,0,0,0,0,0,0,0,0,0,1},
    };
    private final int[][] aliensBeginningPositions4 = new int[][]{
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1},
        
    };
    
    public Level LEVEL1 = new Level(aliensBeginningPositions1, countNumbOfAliens(aliensBeginningPositions1), 5);
    public Level LEVEL2 = new Level(aliensBeginningPositions2, countNumbOfAliens(aliensBeginningPositions2), 6);
    public Level LEVEL3 = new Level(aliensBeginningPositions3, countNumbOfAliens(aliensBeginningPositions3), 8);
    public Level LEVEL4 = new Level(aliensBeginningPositions4, countNumbOfAliens(aliensBeginningPositions4), 7);
    
    private int countNumbOfAliens(int[][] table){
        int number = 0;
        
        for(int i=0; i<table.length;i++){
            for(int j=0; j<table[0].length; j++){
                if(table[i][j] == 1) number++;
            }
        }
        
        return number;
    }
}
