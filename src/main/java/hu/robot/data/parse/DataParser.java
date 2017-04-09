package hu.robot.data.parse;

import hu.robot.model.Program;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class DataParser {

    public List<Program> parse(List<String> lines) {
        return lines.stream()
                .map(Program::new)
                .collect(Collectors.toList());
    }
}
