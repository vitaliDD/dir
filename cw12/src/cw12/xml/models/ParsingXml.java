/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw12.xml.models;

import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author user
 */
public class ParsingXml {


    public static void main(String[] args){
        
        Document dom=null;
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("test.xml");
            
        
        }catch(Exception e){
            System.out.println("Osibka otkritiya faila "+e.toString());
            return;
        }
        
        org.w3c.dom.Element  root =  dom.getDocumentElement();
        System.out.println("tag 1 = "+root.getTagName());
        NodeList nameNodeList = root.getElementsByTagName("name");
        Node nameNode = nameNodeList.item(0);
        System.out.println("tag 2 = "+nameNode.getNodeName());
        String name=nameNode.getFirstChild().getNodeValue();
        System.out.println("name = "+name);
    }
}
