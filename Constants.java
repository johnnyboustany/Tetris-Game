package tetris;

public class Constants {
     // TODO: fill this class in with any more constants you might need!

    // width of each square
    public static final int SQUARE_WIDTH = 30;
    public static final int PIECE_START_X = 150;
    public static final int PIECE_START_Y = 30;

    public static final int FACTOR_RANDOM = 7;
    public static final int SQUARE_ARRAY_NUM_IND = 4;
    public static final int PIECE_ARRAY_NUM_ROW = 2;
    public static final int PIECE_ARRAY_NUM_COL = 4;


    // coordinates for squares in each tetris piece
    public static final int[][] I_PIECE_COORDS = { {0, 0}, {0, SQUARE_WIDTH}, {0, 2*SQUARE_WIDTH}, {0, 3*SQUARE_WIDTH} };
    public static final int[][] T_PIECE_COORDS = { {-1*SQUARE_WIDTH, 0}, {-1*SQUARE_WIDTH, SQUARE_WIDTH}, {-1*SQUARE_WIDTH, 2*SQUARE_WIDTH}, {0, SQUARE_WIDTH}};
    public static final int[][] O_PIECE_COORDS = { {-1*SQUARE_WIDTH, 0}, {-1*SQUARE_WIDTH, SQUARE_WIDTH}, {0, 0}, {0, SQUARE_WIDTH} };
    public static final int[][] L_PIECE_COORDS = { {-1*SQUARE_WIDTH, 0}, {-1*SQUARE_WIDTH, SQUARE_WIDTH}, {-1*SQUARE_WIDTH, 2*SQUARE_WIDTH}, {0, 0}};
    public static final int[][] INV_L_PIECE_COORDS = { {-1*SQUARE_WIDTH, 0}, {0, 0}, {0, SQUARE_WIDTH}, {0, 2*SQUARE_WIDTH}};
    public static final int[][] S_PIECE_COORDS = { {-1*SQUARE_WIDTH, SQUARE_WIDTH}, {-1*SQUARE_WIDTH, 0}, {0, SQUARE_WIDTH}, {0, 2*SQUARE_WIDTH}};
    public static final int[][] INV_S_PIECE_COORDS = {{-1*SQUARE_WIDTH, SQUARE_WIDTH}, {-1*SQUARE_WIDTH, 2*SQUARE_WIDTH}, {0, 0},  {0, SQUARE_WIDTH}};

    // App Size
    public static final int PANE_WIDTH = 360; // (UNITS: pixels)
    public static final int PANE_HEIGHT = 625; // (UNITS: pixels)

    public static final int LABEL_1_X = 40; // (UNITS: pixels)
    public static final int LABEL_1_Y = 40; // (UNITS: pixels)
    public static final int LABEL_1_FONT_SIZE = 14; // (UNITS: pixels)

    public static final int LABEL_2_X = 70; // (UNITS: pixels)
    public static final int LABEL_2_Y = 200; // (UNITS: pixels)
    public static final int LABEL_2_FONT_SIZE = 40; // (UNITS: pixels)

    // width of each square
    public static final int NUM_ROWS = 20;
    public static final int NUM_COLS = 12;


    public static final double DURATION = 0.5; // KeyFrame duration (UNITS: s)


}
