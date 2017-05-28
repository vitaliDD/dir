/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ya
 */
public class Dz3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] mass = vvod();
        //int [] mass={2,3,8,5,1,7,5,8,8,4};
        int[] mass2 = new int[mass.length];
        int[] mass3 = new int[mass.length];
        //копируем в новый массив для нового метода сортировки
        System.arraycopy(mass, 0, mass2, 0, mass.length);
        System.arraycopy(mass, 0, mass3, 0, mass.length);
        vivod(mass, "Nachalniy massiv:");
        vivod(sort1(mass), "Otsortirovanii massiv metodom Arrays.sort:");
        vivod(sort2(mass2), "Otsortirovanii massiv metodom puzirka:");
        vivod(sort3(mass3), "Otsortirovanii massiv metodom Sortitovka viborom:");

    }

    static int[] vvod() {// ввод массива с консоли
        Scanner scan = new Scanner(System.in);
        System.out.println("Vvedite razmer massiva: ");
        int razm = scan.nextInt();
        int[] mass1 = new int[razm];
        for (int i = 0; i < razm; i++) {
            System.out.println("Vvedite " + (i + 1) + " clen massiva: ");
            mass1[i] = scan.nextInt();
        }
        return mass1;
    }

    static void vivod(int mass[], String str) {// вывод массива на экран
        System.out.println(str);
        for (int i : mass) {
            System.out.print(i + "| ");
        }
        System.out.println();
    }

    static int[] sort1(int[] mass) {// сортировка Arrays.sort
        Arrays.sort(mass);
        return mass;
    }

    static int[] sort2(int[] mass) {//сортировака методом пузырька

        for (int i = mass.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mass[j] > mass[j + 1]) {
                    int temp = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = temp;
                }
            }
        }
        return mass;
    }

    static int[] sort3(int[] mass) {// sortirovka viborom

        for (int i = 0; i < mass.length; i++) {
            int min_index = i;
            int min_data = mass[i];
            for (int j = i + 1; j < mass.length; j++) {
                if (mass[j] < min_data) {
                    min_index = j;
                    min_data = mass[j];
                }

            }
            if (min_index != i) {
                int temp = mass[min_index];
                mass[min_index] = mass[i];
                mass[i] = temp;
            }
        }
        return mass;
    }

}
