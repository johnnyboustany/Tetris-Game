package tetris;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PaneOrganizer {
    private BorderPane _root;
    public PaneOrganizer(){
        _root = new BorderPane();
        Pane boardPane = new Pane();
        _root.setTop(boardPane);
        boardPane.setStyle("-fx-background-color: black");
        this.setupButtonPane();

       new Game(boardPane);
    }

    public Pane getRoot(){
        return _root;
    }

    private void setupButtonPane(){

        HBox buttonPane = new HBox();
        _root.setBottom(buttonPane);

        Button button = new Button("Quit");
        buttonPane.getChildren().add(button);

        buttonPane.setStyle("-fx-background-color: gray");
        buttonPane.setAlignment(Pos.CENTER);

        button.setOnAction(new QuitHandler());
    }


    private class QuitHandler implements EventHandler<ActionEvent> {

        /**
         *  The handle method makes the system exit the DoodleJump program.
         *  The event is passed in when this method is called.
         */
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }

}
