package tictactoegame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveFileHandler implements SaveHandler {

    @Override
    public void SaveFile(Game currentGame) {
        FileOutputStream file;
        try {
            var fileName = new File("game.dat");
            file = new FileOutputStream(fileName);
            var out = new ObjectOutputStream(file);
            out.writeObject(currentGame);

            out.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public Game LoadFile() {
        Game currentGame = null;
        FileInputStream file;
        try {
            file = new FileInputStream("game.dat");
            var in = new ObjectInputStream(file);
            currentGame = (Game) in.readObject();

            in.close();
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return currentGame;

    }

}
