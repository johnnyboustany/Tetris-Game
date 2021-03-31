package tetris;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Game {
    private TetrisSquare[][] _board;
    private Pane _boardPane;
    private Piece _piece;
    private Timeline _timeline;
    private boolean _pause;
    private boolean _disable;
    private boolean _gameOverDisable;

    private Label _label1;
    private Label _label2;


    public Game(Pane boardPane) {
        _board = new TetrisSquare[Constants.NUM_ROWS][Constants.NUM_COLS];
        _boardPane = boardPane;
        _label1 = new Label();
        _label2 = new Label();

        this.setUpBoard();
        _boardPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
        _boardPane.setFocusTraversable(true);

        _pause = false;
        _disable = false;
        _gameOverDisable = false;
        this.setupTimeline();

    }

    public void setUpBoard(){
        for (int row = 0; row < Constants.NUM_ROWS; row++) {
            for (int col = 0; col < Constants.NUM_COLS; col++) {
                if (row == 0 || row == Constants.NUM_ROWS - 1 || col == 0  || col == Constants.NUM_COLS - 1) {

                    TetrisSquare rect = new TetrisSquare();
                    _board[row][col] = rect;
                    _boardPane.getChildren().add(rect.getRect());
                    rect.setXLocation(col * Constants.SQUARE_WIDTH);
                    rect.setYLocation(row * Constants.SQUARE_WIDTH);

                }
            }
        }

        _piece = new Piece(_boardPane, _board);
    }

    private class KeyHandler implements EventHandler<KeyEvent> {

        public void handle(KeyEvent keyEvent) {

            if(_gameOverDisable == false){
                if(keyEvent.getCode()==KeyCode.P){
                    if(!_pause){
                        _timeline.pause();
                        _disable = true;

                        _label1.setText("Game paused. Press 'p' to resume!");
                        _label1.setLayoutX(Constants.LABEL_1_X);
                        _label1.setLayoutY(Constants.LABEL_1_Y);
                        _label1.setTextFill(Color.rgb(255, 255, 255));
                        _label1.setFont(new Font("Arial", Constants.LABEL_1_FONT_SIZE));
                        _boardPane.getChildren().add(_label1);

                    } else {
                        _boardPane.getChildren().remove(_label1);
                        _timeline.play();
                        _disable = false;
                    }
                    _pause=!_pause;
                }

                if(_disable==false){
                    switch (keyEvent.getCode()) {
                        case LEFT:
                            _piece.movePiece(-Constants.SQUARE_WIDTH,0);
                            break;
                        case RIGHT:
                            _piece.movePiece(Constants.SQUARE_WIDTH,0);
                            break;
                        case DOWN:
                            _piece.movePiece(0,Constants.SQUARE_WIDTH);
                            break;
                        case UP:
                            _piece.rotatePiece();
                            break;
                        case SPACE:
                            _piece.dropToLowest();
                            break;
                    }
                }
            }
            keyEvent.consume();
        }
    }

    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), new TimeHandler());
        _timeline = new Timeline(kf);
        _timeline.setCycleCount(Animation.INDEFINITE);
        _timeline.play();
    }

    private class TimeHandler implements EventHandler<ActionEvent> {

        public TimeHandler() {
        }

        public void handle(ActionEvent event) {
            _piece.movePiece(0,30);

            if(_piece.ifMoveIsValid(0,Constants.SQUARE_WIDTH) == false){
                _piece.addToBoard();
                _piece = new Piece(_boardPane, _board);
            }

            clearLines();

            if(gameIsOver()){
                _timeline.stop();
                _label2.setText("Game Over!");
                _label2.setLayoutX(Constants.LABEL_2_X);
                _label2.setLayoutY(Constants.LABEL_2_Y);
                _label2.setTextFill(Color.rgb(255, 255, 255));
                _label2.setFont(new Font("Arial", Constants.LABEL_2_FONT_SIZE));
                _boardPane.getChildren().add(_label2);
                _gameOverDisable = true;
            }
         }
    }

        public void clearLines(){

            for (int row = 1; row < Constants.NUM_ROWS-1; row++) {
                if (rowIsFull(row)) {

                    for (int col = 1; col < Constants.NUM_COLS-1; col++) {
                        _boardPane.getChildren().remove(_board[row][col].getRect());
                    }
                    for (int i = row ; i > 1; i--) {
                        for (int j = 1; j < Constants.NUM_COLS-1; j++) {

                            if(_board[i-1][j] != null) {
                                _board[i - 1][j].setYLocation(_board[i - 1][j].getYLocation() + Constants.SQUARE_WIDTH);
                            }
                            _board[i][j] = _board[i-1][j];
                        }
                    }
                }
            }
        }

        public boolean rowIsFull(int row){
                for (int col = 1; col < Constants.NUM_COLS-1; col++) {
                    if (_board[row][col] == null) {
                        return false;
                    }
                }
                return true;
        }

    public boolean gameIsOver(){
        for (int col = 1; col < Constants.NUM_COLS-1; col++) {
            if (_board[1][col] != null) {
                return true;
            }
        }
        return false;
    }
}