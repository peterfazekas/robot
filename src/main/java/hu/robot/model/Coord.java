package hu.robot.model;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class Coord {

    private int x;
    private int y;

    public Coord() {
        this(0, 0);
    }

    public Coord(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(final Coord direction) {
        this.x += direction.x;
        this.y += direction.y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return Math.abs(y) + " lépést kell tenni az ED, " + Math.abs(x) + " lépést a KN tengely mentén.";
    }
}
