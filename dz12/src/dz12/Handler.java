package dz12;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    ArrayList<People> array = new ArrayList<>();
    Root root;
    
    People p;
    private String thisElement;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing");

    }

    @Override
    public void endDocument() {
        System.out.println("End parsing");

    }

    @Override
    public void startElement(String namespace, String localName, String qName, Attributes attr) {
        thisElement = qName;

    }

    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException {

        thisElement = "";

    }

    @Override
    public void characters(char[] ch, int start, int end) {
        
        if (thisElement.equals("root")) {
            root = new Root();
            //root.people=new ArrayList<>();
        }
            if(thisElement.equals("name")&&root.getName()==null){
                root.setName(new String(ch, start, end));
               System.out.println("name file = "+root.getName());
            }

        if (thisElement.equals("element")) {
            p = new People();
            System.out.println("=========================");
            System.out.println("tag = element");

        }

        if (thisElement.equals("age")) {
            p.setAge(new Integer(new String(ch, start, end)));
            System.out.println("age = "+p.getAge());
        }

        if (thisElement.equals("id")) {
            p.setId(new Integer(new String(ch, start, end)));
            System.out.println("id = "+p.getId());
        }
        if (thisElement.equals("isDegree")) {
            p.setIsDegree(Boolean.valueOf(new String(ch, start, end)));
            System.out.println("isDegree = "+p.isIsDegree());
        }
        if (thisElement.equals("name")) {

            if (p == null) {
            } else {
                p.setName(new String(ch, start, end));
                System.out.println("name = "+p.getName());
            }

        }
        if (thisElement.equals("surname")) {
            
            p.setSurname(new String(ch, start, end));
            System.out.println("surname = "+p.getSurname());
            //root.people.add(p);
            array.add(p);
        }

    }

    public ArrayList<People> getResult() {
        return array;
    }

}