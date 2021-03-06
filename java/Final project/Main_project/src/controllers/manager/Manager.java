package controllers.manager;

import controllers.adapter.SuperAdapter;
import models.entity.Doctors;
import models.parse.ParseFile;
import models.download.InternetDownload;
import models.parse.XMLParse;
import models.parse.JSONParse;
import controllers.search.SearchDegree;
import controllers.search.SearchType;
import controllers.sort.SortByName;
import controllers.sort.SortByDate;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager {

    private static Manager manager;
    private static volatile ArrayList<Doctors> dList;
    
    private Manager() {
    }

    public static synchronized Manager getManager() {
        if (manager == null) {
            manager = new Manager();
        }
        return manager;
    }

    public static ArrayList<Doctors> getdList() {
        return dList;
    }

    public void sort(int ch) {

        if (ch == 1) {
            Collections.sort(dList, new SortByName());
        } else {
            Collections.sort(dList, new SortByDate());
        }
    } // сортировка по имени и дате рождения

    public void show() {
        if (dList == null) {
            System.err.println("Spisok doctorov pust!");
            return;
        }
        System.out.println(dList.toString());

    }//вывод всех докторов

    public ArrayList<Doctors> searchTypes(String spec) {
        return new SearchType().searchTypesOfDoctors(spec);
    } //поиск доктора по специализации, поиск подходящего доктора для пациента

    public ArrayList<Doctors> searchDegrees(String degree) {
        return new SearchDegree().searchDegreesOfDoctors(degree);
    } //поиск доктора по специализации, поиск подходящего доктора для пациента

    public HashMap<Integer, String> retHmType() {
        return new SearchType().getTypesOfDoctors();
    }

    public HashMap<Integer, String> retHmDegree() {
        return new SearchDegree().getDegreesOfDoctors();
    }

    /* private void download(int choise) {
        new InternetDownload(choise).start();
    }//скачка из интернета*/
    public void parsef(int ch) {
        InternetDownload internetDownload = new InternetDownload(ch);
        // Exception e=null;
        ParseFile pf;
        internetDownload.start();
        try {
            internetDownload.join();
        } catch (InterruptedException ex) {
            System.err.println("Oshibka potokov" + ex.toString());
        }
        if (InternetDownload.dFlag == true) {

            //System.err.println("");
            return;
        }

        if (ch == 1) {
            pf = new XMLParse();
        } else {
            pf = new JSONParse();
        }
        try {
            dList = pf.parse();
        } catch (Exception e) {
            System.err.println("Ne vozmozhno rasparsit file! " + e.toString());

        }

        //System.out.println(dList.toString());
    }//парсинг файлов
}
