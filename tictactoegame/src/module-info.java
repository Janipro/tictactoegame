module javafxapp {
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.controls;

    exports tictactoegame;

	opens tictactoegame to javafx.fxml;
}