package hu.robot.service.convert;

import hu.robot.model.Utility;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class ConvertProgram {

    private final Utility utility;

    public ConvertProgram() {
        utility = new Utility();
    }

    public String toNewFormat(final String program) {
        String oldFormat = program + " ";
        StringBuilder newFormat = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < program.length(); i++) {
            if (utility.isActualCharSameAsThePrev(oldFormat, i)) {
                counter++;
            } else {
                if (counter > 1){
                    newFormat.append(counter);
                }
                newFormat.append(oldFormat.charAt(i));
                counter = 1;
            }
        }
        return newFormat.toString();
    }

    public String toOldFormat(final String newFormat){
        StringBuilder oldFormat = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < newFormat.length(); i++) {
            char ch = newFormat.charAt(i);
            if(isNumber(ch)) {
                number.append(ch);
            } else {
                int value = 1;
                if(number.length()>0) {
                    value = Integer.parseInt(number.toString());
                }
                for (int j = 1; j <= value; j++) {
                    oldFormat.append(ch);
                }
                number = new StringBuilder();
            }
        }
        return oldFormat.toString();
    }

    private static boolean isNumber(char ch) {
        return (ch >= '0' && ch <='9');
    }


}
