/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw12.xml.models;

import java.util.ArrayList;
//import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

/**
 *
 * @author user
 */
public class ParsingXml {

    public static void main(String[] args) {

        /*  Document dom=null;
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
        System.out.println("tag 2 = " + nameNode.getNodeName());
        String name = nameNode.getFirstChild().getNodeValue();
        // NodeList nan=nameNode.getChildNodes();
        //  System.out.println(nan.toString());
        System.out.println("name = " + name);

        NodeList peopleNodeList = root.getElementsByTagName("people");
        Node peopleNode = peopleNodeList.item(0);
        System.out.println("tag 3 = " + peopleNode.getNodeName());

        NodeList ageNodeList = root.getElementsByTagName("age");
        Node ageNode = ageNodeList.item(1);
        System.out.println("ag " + ageNode.getNodeName());
        NodeList ageList = ageNode.getChildNodes();
        System.out.println("ageList " + ageList.item(0));
        System.out.println("ageNode " + ageNode.);
        String age = ageNode.getFirstChild().getNodeValue();
        System.out.println("age " + age);
         */
        Document dom;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("test.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        Root r = new Root();

        org.w3c.dom.Element root = dom.getDocumentElement();
        System.out.println("tag 1 = " + root.getTagName());

        NodeList nameNodeList = root.getElementsByTagName("name");
        Node nameNode = nameNodeList.item(0);
        System.out.println("tag 2 = " + nameNode.getNodeName());

        String name = nameNode.getFirstChild().getNodeValue();
        System.out.println("name = " + name);

        NodeList peopleNodeList = root.getElementsByTagName("people");
        Node peopleNode = peopleNodeList.item(0);
        System.out.println("tag 3 = " + peopleNode.getNodeName());

        NodeList elementsNodeList = peopleNode.getChildNodes();
       // System.out.println(elementsNodeList.getLength());
        ArrayList<People> list = new ArrayList<>();

        for (int i = 0; i < elementsNodeList.getLength(); i++) {

            Node node = elementsNodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            People el = new People();

            System.out.println("======================================");

            org.w3c.dom.Element element = (org.w3c.dom.Element) node;
            System.out.println("tag = " + node.getNodeName());

            // name
            NodeList nameElemlist = element.getElementsByTagName("name");
            Element nameElement = (Element) nameElemlist.item(0);
            String namePeople = nameElement.getFirstChild().getNodeValue();
            System.out.println("name : " + namePeople);

            el.setName(namePeople);

            // surname
            String surnamePeople = element.getElementsByTagName("surname").item(0).getTextContent();
            System.out.println("surname : " + surnamePeople);

            el.setSurname(surnamePeople);

            // age
            String agePeople = element.getElementsByTagName("age").item(0).getTextContent();
            System.out.println("age : " + agePeople);

            el.setAge(Integer.valueOf(agePeople));

            // isDegree
            String isDegree = element.getElementsByTagName("isDegree").item(0).getTextContent();
            System.out.println("isDegree : " + isDegree);

            el.setIsDegree(Boolean.valueOf(isDegree));

            list.add(el);
        }

        for (People e : list) {

            System.out.println(e.toString());

        }

    }
}
