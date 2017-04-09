package hu.robot.model;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class Utility {

    public boolean isSameAsPrev(final String string, final int i) {
        return string.charAt(i) == string.charAt(i + 1);
    }

}
