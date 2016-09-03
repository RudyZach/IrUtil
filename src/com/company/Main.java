package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    /** info stuff
     * http://electronics.stackexchange.com/questions/118336/converting-pronto-hex-codes-to-raw-on-off-pulses
     * http://www.eevblog.com/2013/08/12/eevblog-506-ir-remote-control-arduino-protocol-tutorial/
     */

    public static void main(String[] args) {
        prontoToCommand();
    }

    public void rawToCommand() {
        try {
            Scanner reader = new Scanner(new File("C:/Users/rudyza/Desktop/test.txt"));
            String temp = reader.nextLine();
            String[] t = temp.split(" ");
            int[] fin = new int[t.length];
            for (int i = 0; i < t.length; i++) {
                fin[i] = Integer.parseInt(t[i]);
                if (fin[i] < 0) {
                    fin[i] *= -1;
                }
                System.out.print(fin[i] + ", ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void prontoToCommand() {
        //disregard 1st (doesn't do anything)
        //int freq = (int)(1000000 / (Integer.parseInt("006C", 16) * .241246));
        //System.out.println(freq);

        try {
            Scanner reader = new Scanner(new File("C:/Users/rudyza/Desktop/test.txt"));
            String temp = reader.nextLine();
            String[] t = temp.split(" ");
            int freq = (int)(1000000 / (Integer.parseInt(t[1], 16) * .241246));
            int[] fin = new int[t.length];
            for (int i = 4; i < t.length; i++) {
                fin[i - 4] = (int)(1000000 * Integer.parseInt(t[i], 16) / freq);
            }

            System.out.println("Frequency: " + Integer.toString(freq));
            for (int i = 0; i < fin.length; i++) {
                if (i < fin.length -1)
                    System.out.print(fin[i] + ", ");
                else
                    System.out.print(fin[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
