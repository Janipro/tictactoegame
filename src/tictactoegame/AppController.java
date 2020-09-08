package tictactoegame;

import java.util.ArrayList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AppController {

    private Game game;
    private SaveHandler file = new SaveFileHandler();

    @FXML
    private TextField name;

    @FXML
    private Label lable;

    @FXML
    private GridPane pane;

    private ArrayList<Button> pushedButtons = new ArrayList<Button>();


    @FXML
    public void initialize() {
        game = new Game(3, 3, 'X');
    }


    @FXML
    public void resetButtonPressed(Event event) {
        for (Button buttons : pushedButtons) {
            buttons.setText("");
        }

        pushedButtons.clear();
        lable.setText("Make your move");
        game = new Game(3,3, 'X');

    }

    @FXML
    public void saveButtonPressed() {
        file.SaveFile(game);

    }

    @FXML
    public void loadButtonPressed() {
        game = file.LoadFile();
        game.updateUI(pane, pushedButtons);


    }

    @FXML
    public void tileButtonPressed(Event event) {
        var button = (Button) event.getTarget();
        var id = button.getId();
        var x = Integer.parseInt(id.substring(0, 1));
        var y = Integer.parseInt(id.substring(1, 2));

        if(game.placePiece(x, y)) {
            button.setText("" + game.getPlayerPiece());
            pushedButtons.add(button);
            game.changePlayerPiece();
        }

        if (game.hasWon('X')) {
            lable.setText("Player one wins.");
            return;
        }

        if (game.hasWon('O')) {
            lable.setText("Player two wins.");
            return;
        }

        if (pushedButtons.size() == 9) {
            lable.setText("It's a draw");
        }

    }
}
