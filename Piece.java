package tetris;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Piece {

    private TetrisSquare[] _rectArray;
    private int[][] PIECE_COORDS;
    private Pane _boardPane;
    private Color _color;

    public Piece(Pane boardPane) {
        _rectArray = new TetrisSquare[4];
        PIECE_COORDS = new int[2][4];
        _boardPane = boardPane;

        int randInt = (int) (Math.random() * 7);
        switch (randInt) {
            case 0:
                PIECE_COORDS = Constants.I_PIECE_COORDS;
                _color = Color.RED;
                break;
            case 1:
                PIECE_COORDS = Constants.O_PIECE_COORDS;
                _color = Color.CYAN;
                break;
            case 2:
                PIECE_COORDS = Constants.L_PIECE_COORDS;
                _color = Color.LIME;
                break;
            case 3:
                PIECE_COORDS = Constants.INV_L_PIECE_COORDS;
                _color = Color.YELLOW;
                break;
            case 4:
                PIECE_COORDS = Constants.S_PIECE_COORDS;
                _color = Color.ORANGE;
                break;
            case 5:
                PIECE_COORDS = Constants.INV_S_PIECE_COORDS;
                _color = Color.HOTPINK;
                break;
            default:
                PIECE_COORDS = Constants.T_PIECE_COORDS;
                _color = Color.MAGENTA;
                break;
        }

            this.setupPiece(150,0);



    }

//Add to Board method
    public TetrisSquare addtoBoard(int i) {

          return _rectArray[i];
    }


    public void setupPiece(int x, int y) {

        for (int i = 0; i < 4; i++) {
            TetrisSquare rect = new TetrisSquare();
            rect.getRect().setFill(_color);

            rect.setXLocation(x+PIECE_COORDS[i][0]);
            rect.setYLocation(y+PIECE_COORDS[i][1]);

            _rectArray[i] = rect;
            _boardPane.getChildren().add(rect.getRect());
        }
    }

    public void movePieceX(int x) {

        for (int i = 0; i < 4; i++) {
            _rectArray[i].setXLocation(_rectArray[i].getXLocation()+x);
        }
    }

    public void movePieceY(int y) {
        for (int i = 0; i < 4; i++) {
            _rectArray[i].setYLocation(_rectArray[i].getYLocation()+y);
        }
    }

    public void rotatePiece(){

            int centerOfRotationX = _rectArray[0].getXLocation();
            int centerOfRotationY = _rectArray[0].getYLocation();


        for (int i = 1; i < 4; i++) {
            int oldXLocation = _rectArray[i].getXLocation();
            int oldYLocation = _rectArray[i].getYLocation();;
            int newXLoc = centerOfRotationX - centerOfRotationY + oldYLocation;
            int newYLoc = centerOfRotationY + centerOfRotationX - oldXLocation;

            //if(newXLoc < 270 && newXLoc > 30 && newYLoc < 570 && newYLoc > 30){
                _rectArray[i].setXLocation(newXLoc);
                _rectArray[i].setYLocation(newYLoc);
            //} else {
           //     break;
           // }

        }

        }



        


    }


