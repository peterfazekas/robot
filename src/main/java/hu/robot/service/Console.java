package hu.robot.service;

import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.04.09..
 */
public class Console {

    public int readInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public String readString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
