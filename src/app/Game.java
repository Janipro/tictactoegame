package app;

import java.io.Serializable;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class Game implements Serializable {

    private static final long serialVersionUID = 9060309321837599425L;
    private Tile[][] board;
    private char playerPiece;

    public Game(int width, int height, char playerPiece) {
        board = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                board[x][y] = new Tile(x, y);
            }
        }

        this.playerPiece = playerPiece;
    }

    public void setBoard(Tile[][] board) {
        this.board = board;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public char getPlayerPiece() {
        return playerPiece;
    }

    public boolean isPiecePlaced(int x, int y) {
        return board[x][y].isPiece();
    }

    public boolean placePiece(int x, int y) {
        if (isPiecePlaced(x, y)) {
            return false;
        }

        if (hasWon('X')||hasWon('O')) {
            return false;
        }

        board[x][y].setPiece(playerPiece);
        return true;
    }

    public boolean hasWon(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getPiece() == player && board[i][1].getPiece() == player
                    && board[i][2].getPiece() == player) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i].getPiece() == player && board[1][i].getPiece() == player
                    && board[2][i].getPiece() == player) {
                return true;
            }

        }

        if (board[0][0].getPiece() == player && board[1][1].getPiece() == player && board[2][2].getPiece() == player) {
            return true;
        }

        if (board[0][2].getPiece() == player && board[1][1].getPiece() == player && board[2][0].getPiece() == player) {
            return true;
        }

        return false;

    }

    public void changePlayerPiece() {
        if (playerPiece == 'X') {
            setPlayerPiece('O');
        } else {
            setPlayerPiece('X');
        }
    }

    public void setPlayerPiece(char playerPiece) {
        this.playerPiece = playerPiece;
    }

    public void updateUI(Pane pane, List<Button> pushedButtons) {

        for (var node : pane.getChildren()) {
            if (node instanceof Button) {
                var button = (Button) node;
                var id = button.getId();
                var x = Integer.parseInt(id.substring(0, 1));
                var y = Integer.parseInt(id.substring(1, 2));
                var tile = board[x][y];
                button.setText("" + tile.getPiece());

                if (tile.isPiece()) {
                    pushedButtons.add(button);
                }
            }
        }
    }

    public static void main(String[] args) {
    }

}
