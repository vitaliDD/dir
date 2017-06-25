/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collect;

/**
 *
 * @author user
 */
public class Controller {

    private static Controller  controller=new Controller();

    private Controller() {

    }

    public static Controller getInstance() {
        return controller;
    }
}