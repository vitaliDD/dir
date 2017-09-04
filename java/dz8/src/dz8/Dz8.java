package dz8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Dz8 {

    public static void main(String[] args) throws ParseException {

        System.out.println("==================");
        System.out.println("zadanie 2");
        Scanner scan = new Scanner(System.in);
        System.out.println("Vvedite kolichestvo studentov:");
        int kol = scan.nextInt();
        Students[] stud = new Students[kol];
        scan.nextLine();
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < kol; i++) {
            stud[i] = new Students();
            System.out.println("Vvedite imya " + (i + 1) + " studenta:");
            stud[i].setImya(scan.nextLine());
            System.out.println("Vvedite familiyuy " + (i + 1) + " studenta:");
            stud[i].setFamilia(scan.nextLine());
            System.out.println("Vvedite daty rozhdeniya " + (i + 1) + " studenta v formate god-mesyac-data(yyyy-MM-dd):");
            String fam = scan.nextLine();
            stud[i].setData(ff.parse(fam));
        }
        int i = 0;
        for (Students st : stud) {
            System.out.println("Dannie " + (i + 1) + "studenta:" + st.getImya() + " " + st.getFamilia() + " " + ff.format(st.getData()));
            i++;
        }
        int sumMonths = 0;
        for (Students arrayOfStudent : stud) {
            Calendar calendarThis = Calendar.getInstance();
            calendarThis.setTime(arrayOfStudent.getData());
            int hourThis = calendarThis.get(Calendar.HOUR);
            int minThis = calendarThis.get(Calendar.MINUTE);
            int secThis = calendarThis.get(Calendar.SECOND);
            int yearThis = calendarThis.get(Calendar.YEAR);
            int monthThis = calendarThis.get(Calendar.MONTH) + 1;
            int dateThis = calendarThis.get(Calendar.DATE);

            Calendar calendarNow = Calendar.getInstance();
            calendarNow.setTime(new GregorianCalendar().getTime());
            int hour = calendarNow.get(Calendar.HOUR);
            int min = calendarNow.get(Calendar.MINUTE);
            int sec = calendarNow.get(Calendar.SECOND);
            int year = calendarNow.get(Calendar.YEAR);
            int month = calendarNow.get(Calendar.MONTH) + 1;
            int date = calendarNow.get(Calendar.DATE);

            //легкое задание:
            sumMonths += (year - yearThis - 1) * 12 + 12 - monthThis + month;

        }
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(sumMonths / stud.length / 12).append(" лет ").append(sumMonths /
                stud.length % 12).append(" месяцев"));
        
        
        System.out.println("==================");
        System.out.println("zadanie 4");
        String s = "2017-06-05 20:25";
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        //  format.applyPattern("yyyy-MM-dd");
        Date date1= form.parse(s);
        System.out.println(form.format(date1));
        
        
        System.out.println("==================");
        System.out.println("zadanie 5");
        
        String text = "This new text\n This new text2\n This new text3\n This new text4\n";
        //String fileName = "C://Users//ya//Documents//NetBeansProjects//a.txt";
        String fileName = "./b.txt";
        FileWorker.write(fileName, text);
        FileWorker.read(fileName);

    }

}
