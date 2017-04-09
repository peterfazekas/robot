package hu.robot.model;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public enum Direction {

    E(0, 1), D(0, -1), K(1, 0), N(-1, 0);

    public static final String[] REDUCIBLES = { "ED", "DE", "KN", "NK"};
    private final Coord coord;

    Direction(final int x, final int y) {
        coord = new Coord(x, y);
    }

    public Coord getCoord() {
        return coord;
    }

    public static Direction getDirection(final char ch) {
        Direction actDir = null;
        String newDir = String.valueOf(ch);
        for (Direction direction : Direction.values()) {
            if (direction.toString().equals(newDir)) actDir = direction;
        }
        return actDir;
    }

}
