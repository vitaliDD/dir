/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw17.newpackage;

/**
 *
 * @author user
 */
public class Main {
    
    public static void main(String[] args){
    
        DownoaderThread  downloaderT=new DownoaderThread();
        ParserrThread parserT=new ParserrThread();
        
        
        downloaderT.setParserrThread(parserT);
        
    
        parserT.setDownoaderThread(downloaderT);
        parserT.start();
        downloaderT.start();
    
    }
    
}
