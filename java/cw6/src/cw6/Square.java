/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw6;

/**
 *
 * @author user
 */
public class Square extends Figure{

    double size;
    public Square(int size) {
        this.size=size;
        
    }

    @Override
    double getArea() {

        return size*size;
    }
    
}
