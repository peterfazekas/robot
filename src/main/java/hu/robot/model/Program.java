package hu.robot.model;

import java.util.Arrays;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class Program {

    public static final int LARGE_UNIT = 3;
    public static final int SMALL_UNIT = 1;
    private static int counter;

    private final String program;
    private final int id;

    private final Utility utility;
    private double maxDistance;
    private int maxIndex;
    private Coord coord;

    public Program(final String program) {
        this.program = program;
        id = ++counter;
        coord = new Coord();
        utility = new Utility();
        runProgram();
    }

    public String getProgram() {
        return program;
    }

    public int getId() {
        return id;
    }

    private void runProgram() {
        Direction direction;
        maxDistance = 0;
        for (int i = 0; i < program.length(); i++) {
            direction = Direction.getDirection(program.charAt(i));
            coord.moveTo(direction.getCoord());
            if (coord.distance() > maxDistance) {
                maxDistance = coord.distance();
                maxIndex = i + 1;
            }
        }
    }

    public String printProgramEnergy() {
        return String.format("%n   %d %d", id, getBattery());
    }

    public boolean isReducible() {
        return Arrays.stream(Direction.REDUCIBLES)
                .mapToInt(i -> program.indexOf(i) + 1)
                .sum() > 0;
    }

    public int getBattery() {
        int battery = LARGE_UNIT;
        for (int i = 0; i < program.length() - 1; i++) {
            battery += utility.isActualCharSameAsThePrev(program, i) ? SMALL_UNIT : LARGE_UNIT;
        }
        return battery;
    }

    public String getOrigin() {
        return coord.toString();
    }

    @Override
    public String toString() {
        return String.format("A program végrahjtása során a legtávolabbi pontot a %d. lépést követően érte el, ami %5.3f cm-re volt.", maxIndex, maxDistance);
    }

}
