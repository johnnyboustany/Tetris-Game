package tetris;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Piece {
    private TetrisSquare[] _squareArray;
    private int[][] _pieceCoordsArray;
    private Pane _boardPane;
    private Color _color;
    private TetrisSquare[][] _board;

    public Piece(Pane boardPane, TetrisSquare[][] _board2D) {
        _squareArray = new TetrisSquare[Constants.SQUARE_ARRAY_NUM_IND];
        _pieceCoordsArray = new int[Constants.PIECE_ARRAY_NUM_ROW][Constants.PIECE_ARRAY_NUM_COL];
        _boardPane = boardPane;
        _board = _board2D;

        int randInt = (int) (Math.random() * Constants.FACTOR_RANDOM);
        switch (randInt) {
            case 0:
                _pieceCoordsArray = Constants.I_PIECE_COORDS;
                _color = Color.RED;
                break;
            case 1:
                _pieceCoordsArray = Constants.O_PIECE_COORDS;
                _color = Color.CYAN;
                break;
            case 2:
                _pieceCoordsArray = Constants.L_PIECE_COORDS;
                _color = Color.LIME;
                break;
            case 3:
                _pieceCoordsArray= Constants.INV_L_PIECE_COORDS;
                _color = Color.YELLOW;
                break;
            case 4:
                _pieceCoordsArray = Constants.S_PIECE_COORDS;
                _color = Color.ORANGE;
                break;
            case 5:
                _pieceCoordsArray = Constants.INV_S_PIECE_COORDS;
                _color = Color.HOTPINK;
                break;
            default:
                _pieceCoordsArray = Constants.T_PIECE_COORDS;
                _color = Color.MAGENTA;
                break;
        }
            this.setUpPiece(Constants.PIECE_START_X,Constants.PIECE_START_Y);
    }

    public void addToBoard() {
        for (int i = 0; i < Constants.SQUARE_ARRAY_NUM_IND; i++) {
            int row = _squareArray[i].getYLocation()/Constants.SQUARE_WIDTH;
            int col = _squareArray[i].getXLocation()/Constants.SQUARE_WIDTH;
            _board[row][col] = _squareArray[i];
        }
    }

    public void setUpPiece(int x, int y) {
        for (int i = 0; i < Constants.SQUARE_ARRAY_NUM_IND; i++) {
            TetrisSquare rect = new TetrisSquare();
            rect.getRect().setFill(_color);
            rect.setXLocation(x+_pieceCoordsArray[i][0]);
            rect.setYLocation(y+_pieceCoordsArray[i][1]);

            _squareArray[i] = rect;
            _boardPane.getChildren().add(rect.getRect());
        }
    }

    public void movePiece(int x, int y) {
        if(ifMoveIsValid(x,y) == true){
            for (int i = 0; i < Constants.SQUARE_ARRAY_NUM_IND; i++) {
                int xPosition = _squareArray[i].getXLocation()+x;
                int yPosition = _squareArray[i].getYLocation()+y;
                _squareArray[i].setXLocation(xPosition);
                _squareArray[i].setYLocation(yPosition);
            }
        }
    }

    public boolean ifMoveIsValid(int x, int y){
        for (int i = 0; i < Constants.SQUARE_ARRAY_NUM_IND; i++) {
            int xPosition = _squareArray[i].getXLocation()+x;
            int yPosition = _squareArray[i].getYLocation()+y;
            int row = yPosition/Constants.SQUARE_WIDTH;
            int col = xPosition/Constants.SQUARE_WIDTH;

            if(_board[row][col] != null){
                return false;
            }
        }
        return true;
        }

    public void rotatePiece(){
        int centerOfRotationX = _squareArray[0].getXLocation();
        int centerOfRotationY = _squareArray[0].getYLocation();

        if(ifRotationIsValid()){
            for (int i = 1; i < Constants.SQUARE_ARRAY_NUM_IND; i++) {
                int oldXLocation = _squareArray[i].getXLocation();
                int oldYLocation = _squareArray[i].getYLocation();;
                int newXLoc = centerOfRotationX - centerOfRotationY + oldYLocation;
                int newYLoc = centerOfRotationY + centerOfRotationX - oldXLocation;

                _squareArray[i].setXLocation(newXLoc);
                _squareArray[i].setYLocation(newYLoc);
            }
        }
    }

    public boolean ifRotationIsValid(){
        int centerOfRotationX = _squareArray[0].getXLocation();
        int centerOfRotationY = _squareArray[0].getYLocation();

        for (int i = 1; i < Constants.SQUARE_ARRAY_NUM_IND; i++) {
            int oldXLocation = _squareArray[i].getXLocation();
            int oldYLocation = _squareArray[i].getYLocation();

            int newXLoc = centerOfRotationX - centerOfRotationY + oldYLocation;
            int newYLoc = centerOfRotationY + centerOfRotationX - oldXLocation;

            int row = newYLoc/Constants.SQUARE_WIDTH;
            int col = newXLoc/Constants.SQUARE_WIDTH;

            if (_board[row][col] != null) {
                return false;
            }
        }
        return true;
    }

    public void dropToLowest(){
        while(ifMoveIsValid(0, Constants.SQUARE_WIDTH)){

            for (int i = 0; i < Constants.SQUARE_ARRAY_NUM_IND; i++) {
                int yPosition = _squareArray[i].getYLocation()+Constants.SQUARE_WIDTH;
                _squareArray[i].setYLocation(yPosition);
            }
        }
    }
}








