package tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TetrisSquare {

private Rectangle _rect;

public TetrisSquare(){
    _rect = new Rectangle(Constants.SQUARE_WIDTH, Constants.SQUARE_WIDTH, Color.LIGHTGRAY);
    _rect.setStroke(Color.BLACK);
    _rect.setStrokeWidth(2);
}

    public void setLocation(int x, int y){
        _rect.setX(x);
        _rect.setY(y);
    }

    public Rectangle getRect(){
         return _rect;
    }

    public void setXLocation(int x){
        _rect.setX(x);
    }

    public void setYLocation(int y){
        _rect.setY(y);
    }


    public int getXLocation(){
        return (int) (_rect.getX());
    }

    public int getYLocation(){
        return (int) (_rect.getY());
    }
}
