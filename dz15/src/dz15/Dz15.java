

package dz15;


public class Dz15 {

  
    public static void main(String[] args) {
        
        Singleton1 sg1=Singleton1.getInstance();
        Singleton1 sg11=Singleton1.getInstance();
        //Singleton1 sg111=new Singleton1();
        
        System.out.println(sg1==sg11);
        Singleton2 sg2=Singleton2.getInstance();
        Singleton2 sg22=Singleton2.getInstance();
        System.out.println(sg2==sg22);
        Singleton2 sg3=Singleton2.getInstance();
        Singleton2 sg33=Singleton2.getInstance();
        System.out.println(sg3==sg33);
        System.out.println("zadanie 2");
        //класс адаптер приводит строку к нужному формату, чтобы ее можно было умножить на 2, 
        //т.е убирает нечисловые значения из строки)) 
        Destination dd=new Destination();
        System.out.println(dd.result());
    }

}
