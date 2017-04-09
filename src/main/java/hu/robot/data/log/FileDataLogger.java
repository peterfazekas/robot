package hu.robot.data.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static hu.robot.data.api.Data.PATH;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class FileDataLogger implements DataLogger {

    private final String fileName;

    public FileDataLogger(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void println(final String text) {
        try (PrintWriter out = new PrintWriter(new FileWriter(PATH + fileName))) {
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
