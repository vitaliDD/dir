/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz6;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ya
 */
public class Dz6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random rand = new Random();
        int[] mass1 = new int[10];
        for (int i = 0; i < mass1.length; i++) {
            mass1[i] = rand.nextInt(100);
        }
        System.out.println("Massiv nomer 1: " + Arrays.toString(mass1));
        int[] mass2 = new int[20];

        System.out.println("Massiv nomer 2 ishodniy: " + Arrays.toString(mass2));

        System.arraycopy(mass1, 0, mass2, 5, mass1.length);
        System.out.println("Massiv nomer 2 polse kopirovaniya: " + Arrays.toString(mass2));

    }

}
