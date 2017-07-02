package dz18;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewMain {

    static MyTest myTest;

    static Class clas;

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        myTest = new MyTest();

        clas = myTest.getClass();

        System.out.println(clas.getSimpleName());
        System.out.println(clas.getName());

        int mode = clas.getModifiers();

        if (Modifier.isPublic(mode)) {
            System.out.println("class publichnii");

        }
        if (Modifier.isAbstract(mode)) {

            System.out.println("astractnii");
        }
        Field[] fields = clas.getDeclaredFields();
        // fields[0].setAccessible(true);

        for (Field f : fields) {
            System.out.println("peremennaya " + f);
            f.setAccessible(true);

            Object obj = f.get(myTest);

            if (obj instanceof String) {
                System.out.println("value = " + (String) obj);
                f.set(myTest, "afagadga");
                System.out.println("value = " + (String) f.get(myTest));

            }
            if (obj instanceof Integer) {
                System.out.println("value = " + (int) obj);
                f.set(myTest, 65);
                System.out.println("value = " + (int) f.get(myTest));

            }
            if (obj instanceof Float) {
                System.out.println("value = " + (float) obj);
                f.set(myTest, 5.5f);
                System.out.println("value = " + (float) f.get(myTest));

            }

        }
       /* Method[] methods = clas.getMethods();
        for (Method method : methods) {
            System.out.println("Имя: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());

            
        }*/
        //Class[] paramTypes = new Class[] { String.class, int.class,float.class }; 
        Method refGetA=clas.getMethod("getA"); 
        Method refGetB=clas.getMethod("getB"); 
        Method refGetText=clas.getMethod("getText"); 
        System.out.println("getA "+refGetA.invoke(myTest));
        System.out.println("getB "+refGetB.invoke(myTest));
        System.out.println("getText "+refGetText.invoke(myTest));

    }

}
