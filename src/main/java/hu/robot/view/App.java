package hu.robot.view;

import hu.robot.data.log.DataLogger;
import hu.robot.data.log.FileDataLogger;
import hu.robot.service.Console;
import hu.robot.service.Robot;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
class App {

    private final DataLogger log;
    private final Robot robot;
    private final Console console;

    private App() {
        robot = new Robot("program.txt");
        log = new FileDataLogger("ujprog.txt");
        console = new Console();
    }

    public static void main(String[] args) {
        App app = new App();
        app.println();
    }

    private void println() {
        System.out.print("2. feladat: Kérem adja meg egy program sorszámát: ");
        System.out.println(robot.programAnalysis(console.readInt()));
        System.out.println("3. feladat: A kis akkus programok:" + robot.getLowEnergyPrograms());
        log.println(robot.getNewFormatPrograms());
        System.out.print("5. feladat: Kérem adja meg az új formátumú programot: ");
        System.out.println(robot.getOldFormatProgram(console.readString()));
    }
}
