package tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{


    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(final String[] args) {
        Application.launch(App.class,args);
    }

    public void startUp(Stage primaryStage) throws Exception {
        start(primaryStage);
    }

}
