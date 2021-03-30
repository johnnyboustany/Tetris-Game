package tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board {

    private Rectangle[][] _board;

    private Rectangle _rect;
    public Board(Pane boardPane){
        _board = new Rectangle[Constants.NUM_ROWS][Constants.NUM_COLS];

        for(int row=0; row < Constants.NUM_ROWS; row++){
            for(int col=0; col < Constants.NUM_COLS; col++){

            if(row==0 || col == 0 || row==Constants.NUM_ROWS-1 || col==Constants.NUM_COLS-1){

                int x = col*Constants.SQUARE_WIDTH;
                int y = row*Constants.SQUARE_WIDTH;

                _rect = new Rectangle(Constants.SQUARE_WIDTH, Constants.SQUARE_WIDTH);

                boardPane.getChildren().add(_rect);
                this.setLocation(x,y);
                _board[row][col] = _rect;

                }
            }
        }

    }


    public void setLocation(int x, int y){

        _rect.setX(x);
        _rect.setY(y);
    }
    public Rectangle getRect(){

        return _rect;
    }


}
