package app;

public interface SaveHandler {

    void SaveFile(Game currentGame);
    Game LoadFile();
}
