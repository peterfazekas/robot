package hu.robot.service;

import hu.robot.data.api.Data;
import hu.robot.model.Program;
import hu.robot.service.convert.ConvertProgram;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class Robot {

    public static final int BATTERY_LIMIT = 100;

    private final List<Program> programList;
    private final Data data;
    private final ConvertProgram convert;

    public Robot(final String source) {
        data = new Data();
        convert = new ConvertProgram();
        programList = data.getData(source);
    }

    public String programAnalysis(final int id) {
        Program program = programList.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .get();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("   a. feladat: A program %s%n", reducible(program)));
        sb.append(String.format("   b. feladat: %s%n", program.getOrigin()));
        sb.append(String.format("   c. feladat: %s", program));
        return sb.toString();
    }

    private String reducible(Program program) {
        return program.isReducible() ? "egyszerűsithető" : "nem egyszerűsithető";
    }

    public String getLowEnergyPrograms() {
        StringBuilder sb = new StringBuilder();
        programList.stream()
                .filter(i -> i.getBattery() <= BATTERY_LIMIT)
                .map(Program::printProgramEnergy)
                .forEach(sb::append);
        return sb.toString();
    }

    public String getNewFormatPrograms() {
        StringBuilder sb = new StringBuilder();
        programList.forEach(i -> sb.append(String.format("%s%n", convert.toNewFormat(i.getProgram()))));
        return sb.toString();
    }

    public String getOldFormatProgram(final String newFormatProgram) {
        return "   " + convert.toOldFormat(newFormatProgram);
    }


}
