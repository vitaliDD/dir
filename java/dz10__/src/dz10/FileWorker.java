/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author ya
 */
public class FileWorker {

    public static void write(String fileName, String text) {
        File file = new File(fileName);

        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {

                out.print(text);
            } finally {

                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read(String fileName, Student[] st) {
        File fstream = new File(fileName);
        try {

            BufferedReader br = new BufferedReader(new FileReader(fstream.getAbsoluteFile()));

            String strLine;
            int kol = st.length;
            int i = 0;
            st[0] = new Student();
            st[1] = new Student();
            st[2] = new Student();

            while ((strLine = br.readLine()) != null) {

                System.out.println(strLine);
                String[] aa = strLine.split("\\|");
               // System.out.println(strLine.split("\\|").length);
                st[i].setName(aa[0]);
                st[i].setAge(Integer.valueOf(aa[1]));
                st[i].setIsMale(Boolean.valueOf(aa[2]));
                i++;
            }
            for (int j = 0; j < st.length; j++) {
                System.out.println((j + 1) + " student: Imya " + st[j].getName()
                        + " vozrast " + st[j].getAge() + " Myzhik? " + st[j].isIsMale());
            }
            //System.out.println(st[0].getName());
            // String name = strArray[0];
            //System.out.print(aa);
            br.close();

            // System.out.print((char)c);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
