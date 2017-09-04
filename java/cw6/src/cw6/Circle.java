/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw6;

import static java.lang.Math.PI;

/**
 *
 * @author user
 */
public class Circle extends Figure{

    private double r;
    public Circle(int r) {
        this.r=r;
        
    }
    
    double  getArea(){
    
    return PI*(r*r)/2;
    
    }
    
    
}
