

package dz19;

import java.util.Iterator;

/**
 *
 * @author ya
 */
public class Dz19 {

    public static void main(String[] args) {
//типизация методов и классов
       
    StaffCollection<People> staffCollection=new StaffCollection<>();
    
    People Director =new People("Alex");
    staffCollection.addDirector(Director);
    
     //   System.out.println("director: "+ staffCollection.getDirector());
    
    People Ivan1 =new People("Ivan1");
    People Ivan2 =new People("Ivan2");
    People Ivan3 =new People("Ivan3");
    People Ivan4 =new People("Ivan4");
    People Ivan5 =new People("Ivan5");
    
    People Serg1 =new People("Serg1");
    People Serg2 =new People("Serg2");
    People Serg3 =new People("Serg3");
    People Serg4 =new People("Serg4");
    People Serg5 =new People("Serg5");
   
    staffCollection.add("dep1", Ivan1);
    staffCollection.add("dep1", Ivan2);
    staffCollection.add("dep1", Ivan3);
    staffCollection.add("dep1", Ivan4);
    staffCollection.add("dep1", Ivan5);
    
    staffCollection.add("dep2", Serg1);
    staffCollection.add("dep2", Serg2);
    staffCollection.add("dep2", Serg3);
    staffCollection.add("dep2", Serg4);
    staffCollection.add("dep2", Serg5);
    
   // Iterator it=staffCollection.iterator("dep1");
    Iterator it=staffCollection.iterator();
       /* System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());*/
      for(int i=0;i<7;i++)
            System.out.println(it.next());
        
    
    
       // test("ffff", String.class);

    }

 
}
