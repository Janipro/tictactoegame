package tictactoegame;

public interface SaveHandler {

    void SaveFile(Game currentGame);
    Game LoadFile();
}
