package tictactoegame;
import java.io.Serializable;

public class Tile implements Serializable{

    private static final long serialVersionUID = -6317629534123190182L;
    private int x;
    private int y;
    private char piece;

    public Tile (int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPiece() {
        return (piece == 'X' || piece == 'O');
    }

    @Override
    public String toString() {
        return ""+x+", "+y+", "+piece;
    }

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }

}
