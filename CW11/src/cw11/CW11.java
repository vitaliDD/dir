/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 *
 * @author user
 */
public class CW11 {

   
    public static void main(String[] args) {
        
        ArrayList<String> list= new ArrayList<>();
        list.add("pervii");
        list.add("vtoroi");
        list.add("tretii");
        System.out.println(list.toString());
        
        System.out.println("razmer: "+list.size());
        System.out.println("element 2 "+list.get(2));
        /*проблема эррэйлиста в том, что очень медленно добавляет и удаляет из середины коллекции()
        много доп операций требуется*/
        
        ArrayList<Integer> integ=new ArrayList<>();
        ArrayList<Integer> integ2=new ArrayList<>();
        integ.add(1);
        integ.add(34);
        integ.add(32);
        integ.add(22);
        integ.add(66);
        integ.add(32);
        integ.add(17);
        integ.add(18);
        integ.add(18);
        integ.add(15);
        integ.add(16);
        integ.add(32);
        integ2.add(32);
        System.out.println(integ.toString());
        integ.removeAll(integ2);
        System.out.println(integ.toString());
        
        LinkedList<Integer> linkList= new LinkedList<>();
        
        linkList.add(15);
        linkList.add(15);
        linkList.add(15);
        //ЧТО ЛУЧШЕ ЭРРЭЙ ИЛИ ЛИНКЕД? ВСЕ ЗАВИСИТ ОТ КОЛИЧЕСТВА И КАЧЕСТВА ИСХОДНЫХ  ДАННЫХ
        HashMap<Country, Student > hm= new HashMap<>();
        hm.put(new Country("en"), new Student("aa",34));
        hm.put(new Country("ru"), new Student("ff",44));
        hm.put(new Country("by"), new Student("fd",444));
        String name=hm.get(new Country("ru")).getName();
        ArrayList<Student> studM= new ArrayList<>();
        studM.add(new Student("dfsd", 34));
        studM.add(new Student("aaa", 14));
        ArrayList<Student> studW= new ArrayList<>();
        studW.add(new Student("m", 514));
        studW.add(new Student("n", 144));
        HashMap<Country,  ArrayList<Student>> hmq= new HashMap<>();
        hmq.put(new Country("en"), studM);
        hmq.put(new Country("by"), studW);
        
        
        System.out.println(hm.toString());
        System.out.println(hm.get(10));
        
        
        ArrayList<Student> list2= new ArrayList<>();
        list2.add(new Student("dfs",34));
        list2.add(new Student("dfsdas",3224));
        
        Collections.sort(list2);
        
        
        ArrayList<Country> list3= new ArrayList<>();
        list3.add(new Country("ru"));
        list3.add(new Country("by"));
        
        
        Collections.sort(list3,new Comparator<Country>(){
    
            public int compare (Country o1, Country o2){
                
                if(o1.getName().equals(o2.getName()))
                    return 1;
                return 0;
            
            }
    
    
    
    });
        
        private static Comparator<Country> compar= new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            if(o1.getName().equals(o2.getName() ))
                
            return 0;
            return 1;
        }
    };
        
      /*  for(Integer key:hm.keySet()){
        
        System.out.println("key = "+ key+ " value = "+ hm.get(key));
        
        
        TreeMap<Integer, String > tm= new TreeMap<>();
        
        
        
        }*/
        
        
        
        
        
        
        
    }
    
}
