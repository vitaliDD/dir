/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw7;

/**
 *
 * @author user
 */
public class Button {
    private OnclickListener listener;

    public void setListener(OnclickListener listener) {
        this.listener = listener;
    }
    
    
    
    
    public void onTouch(){

        listener.onClick();
    }   
    
}
