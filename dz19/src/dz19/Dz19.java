

package dz19;

/**
 *
 * @author ya
 */
public class Dz19 {

    public static void main(String[] args) {
//типизация методов и классов
       
    StaffCollection<People> staffCollection=new StaffCollection<>();
    
    People Director =new People();
    staffCollection.addDirector(Director);
     //   System.out.println("director: "+ staffCollection.getDirector());
    
    People Ivan1 =new People();
    People Ivan2 =new People();
    People Ivan3 =new People();
    People Ivan4 =new People();
    People Ivan5 =new People();
    
    People Serg1 =new People();
    People Serg2 =new People();
    People Serg3 =new People();
    People Serg4 =new People();
    People Serg5 =new People();
   
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
    
    
    
       // test("ffff", String.class);

    }

 
}
