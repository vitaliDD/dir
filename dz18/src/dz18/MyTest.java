/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz18;

/**
 *
 * @author user
 */
public class MyTest {
    
    private int a = 5;
    private float b=6.4f;
    private String text = "text";

    public void testPublic() {

        System.out.println("testPublic");

    }

    private void testPrivate() {
        System.out.println("testPrivate");

    }

    public int getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public String getText() {
        return text;
    }
    

    @Override
    public String toString() {
        return "MyTest{" + "a=" + a + ", b=" + b + ", text=" + text + '}';
    }

}
