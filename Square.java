package tetris;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square {

    private Rectangle _rect;

    public Square(Color primaryColor){
        _rect = new Rectangle(Constants.SQUARE_WIDTH,Constants.SQUARE_WIDTH, primaryColor);

    }

    public void setLocation(int x, int y){
        _rect.setX(x);
        _rect.setY(y);

    }

    public Rectangle getRect(){
        return _rect;
    }




}
