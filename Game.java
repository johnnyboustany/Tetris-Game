package tetris;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game {

    private TetrisSquare[][] _board;
    private Pane _boardPane;
    private Piece _piece;

    public Game(Pane boardPane) {
        _board = new TetrisSquare[Constants.NUM_ROWS][Constants.NUM_COLS];
        _boardPane = boardPane;

        this.setUpBoard();

        _boardPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
        _boardPane.setFocusTraversable(true);

        this.setupTimeline();

    }

    public void setUpBoard(){
        for (int row = 0; row < Constants.NUM_ROWS; row++) {
            for (int col = 0; col < Constants.NUM_COLS; col++) {

                if (row == 0 || row == Constants.NUM_ROWS - 1 || col == 0  || col == Constants.NUM_COLS - 1) {

                    TetrisSquare rect = new TetrisSquare();

                    _board[row][col] = rect;
                    _boardPane.getChildren().add(rect.getRect());
                    rect.setLocation(col * Constants.SQUARE_WIDTH, row * Constants.SQUARE_WIDTH);
                }
            }
        }



        _piece = new Piece(_boardPane);


       // for (int i = 0; i < 4; i++) {
       //     tricky.addtoBoard(i);

       // }



    }

    private class KeyHandler implements EventHandler<KeyEvent> {

        public void handle(KeyEvent e) {
            KeyCode keyPressed = e.getCode();


            if (keyPressed == KeyCode.LEFT) {
                _piece.movePieceX(-30);

            } else if(keyPressed == KeyCode.RIGHT) {

                _piece.movePieceX(30);

            }

            if (keyPressed == KeyCode.DOWN){
                _piece.movePieceY(30);
            } else if (keyPressed == KeyCode.UP){

                _piece.rotatePiece();

            }

            e.consume();


        }


    }


    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {

        public TimeHandler() {
        }

        public void handle(ActionEvent event) {

            _piece.movePieceY(30);
        }
    }
    }


