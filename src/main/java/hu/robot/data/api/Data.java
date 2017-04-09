package hu.robot.data.api;

import hu.robot.data.parse.DataParser;
import hu.robot.data.read.DataReader;
import hu.robot.data.read.FileDataReader;
import hu.robot.model.Program;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class Data {

    public final static String PATH = "src\\main\\resources\\";

    private final DataReader file = new FileDataReader();
    private final DataParser data = new DataParser();

    public List<Program> getData(final String source) {
        return data.parse(file.read(source));
    }
}
