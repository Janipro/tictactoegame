package tictactoegame;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AppController {

    private Game game;
    private SaveHandler file = new SaveFileHandler();

    @FXML
    private Label lable;
    @FXML
    private GridPane pane;
    @FXML
    private ArrayList<Button> buttons = new ArrayList<>();

    @FXML
    public void initialize() {
        game = new Game(3, 3, 'X');
        for (var node : pane.getChildren()) {
            if (node instanceof Button) {
                var button = (Button) node;
                buttons.add(button);
            }
        }
    }

    @FXML
    public void resetButtonPressed(Event event) {
        for (var button : buttons) {
            button.setText("");
        }

        lable.setText("Make your move");
        game = new Game(3, 3, 'X');
    }

    @FXML
    public void saveButtonPressed() {
        file.SaveFile(game);
    }

    @FXML
    public void loadButtonPressed() {
        game = file.LoadFile();
        game.updateUI(pane, buttons);
    }

    @FXML
    public void tileButtonPressed(Event event) {
        var button = (Button) event.getTarget();
        var id = button.getId();
        var x = Integer.parseInt(id.substring(0, 1));
        var y = Integer.parseInt(id.substring(1, 2));

        if (game.placePiece(x, y, game.getPlayerPiece())) {
            button.setText("" + game.getPlayerPiece());
        }

        if (game.hasWon('X')) {
            lable.setText("Player one wins.");
            return;
        }

        if (checkDraw(buttons)) {
            lable.setText("It's a draw.");
            return;
        }

        game.aiPlacePiece(buttons);
        if (game.hasWon('O')) {
            lable.setText("AI wins.");
        }
    }

    public boolean checkDraw(ArrayList<Button> buttons) {
        var temp = 0;
        for (var item : buttons) {
            if (!item.getText().isEmpty()) {
                temp += 1;
            }
        }

        return temp == 9;
    }
}
