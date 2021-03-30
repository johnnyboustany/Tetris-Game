package tetris;

import javafx.scene.paint.Color;

public class Constants {
     // TODO: fill this class in with any more constants you might need!

    // width of each square
    public static final int SQUARE_WIDTH = 30;

    // coordinates for squares in each tetris piece
    public static final int[][] I_PIECE_COORDS = { {0, 0}, {0, SQUARE_WIDTH}, {0, 2*SQUARE_WIDTH}, {0, 3*SQUARE_WIDTH} };
    public static final int[][] T_PIECE_COORDS = { {-1*SQUARE_WIDTH, 0}, {-1*SQUARE_WIDTH, SQUARE_WIDTH}, {-1*SQUARE_WIDTH, 2*SQUARE_WIDTH}, {0, SQUARE_WIDTH}};
    public static final int[][] O_PIECE_COORDS = { {-1*SQUARE_WIDTH, 0}, {-1*SQUARE_WIDTH, SQUARE_WIDTH}, {0, 0}, {0, SQUARE_WIDTH} };
    public static final int[][] L_PIECE_COORDS = { {-1*SQUARE_WIDTH, 0}, {-1*SQUARE_WIDTH, SQUARE_WIDTH}, {-1*SQUARE_WIDTH, 2*SQUARE_WIDTH}, {0, 0}};
    public static final int[][] INV_L_PIECE_COORDS = { {0, 0}, {0, SQUARE_WIDTH}, {0, 2*SQUARE_WIDTH}, {-1*SQUARE_WIDTH, 0}};
    public static final int[][] S_PIECE_COORDS = { {-1*SQUARE_WIDTH, SQUARE_WIDTH}, {0, SQUARE_WIDTH}, {0, 2*SQUARE_WIDTH}, {-1*SQUARE_WIDTH, 0}};
    public static final int[][] INV_S_PIECE_COORDS = { {0, SQUARE_WIDTH}, {-1*SQUARE_WIDTH, SQUARE_WIDTH}, {-1*SQUARE_WIDTH, 2*SQUARE_WIDTH}, {0, 0}};

    // App Size
    public static final int PANE_WIDTH = 300; // (UNITS: pixels)
    public static final int PANE_HEIGHT = 625; // (UNITS: pixels)

    // width of each square
    public static final int NUM_ROWS = 20;
    public static final int NUM_COLS = 10;


    public static final double DURATION = 0.5; // KeyFrame duration (UNITS: s)


}
