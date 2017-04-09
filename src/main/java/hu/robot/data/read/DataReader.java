package hu.robot.data.read;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public interface DataReader {

    List<String> read(final String source);

}
