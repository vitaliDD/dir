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
public class Triangle extends Figure{
    private double storona_a;
    private double storona_b;

    public Triangle(int storona_a, int storona_b) {
        this.storona_a = storona_a;
        this.storona_b = storona_b;
    }

    @Override
    double getArea() {
        
        return storona_a*storona_b/2;
    }
    
}
