package models.parse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import models.entity.Doctors;
import models.entity.Root;
import controllers.adapter.SuperAdapter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParse implements ParseFile {
    private SuperAdapter adapter=new SuperAdapter();

    @Override
    public ArrayList<Doctors> parse() {

        Document dom=null;
        try {
            System.out.println("XML parsing START!");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("hospital.xml");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println("Oshibka: "+e.toString());
            return null;
        }

        Root r = new Root();

        Element root = dom.getDocumentElement();
        /*
        System.out.println("tag 1 = " + root.getTagName());

        NodeList nameNodeList = root.getElementsByTagName("name");
        Node nameNode = nameNodeList.item(0);
        System.out.println("tag 2 = " + nameNode.getNodeName());
        String name = nameNode.getFirstChild().getNodeValue();
        System.out.println("name = " + name);

        NodeList locationNodeList = root.getElementsByTagName("location");
        Node locationNode = locationNodeList.item(0);
        System.out.println("tag 3 = " + locationNode.getNodeName());
        String location = locationNode.getFirstChild().getNodeValue();
        System.out.println("location = " + name);
         */

        NodeList doctorsNodeList = root.getElementsByTagName("doctors");
        //Node doctorsNode = doctorsNodeList.item(0);
        // System.out.println("tag 4 = " + doctorsNode.getNodeName());
        ArrayList<Doctors> list = new ArrayList<>();

        for (int i = 0; i < doctorsNodeList.getLength(); i++) {

            Node node = doctorsNodeList.item(i);

            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Doctors el = new Doctors();

            // System.out.println("======================================");
            Element element = (Element) node;
            //  System.out.println("tag = " + node.getNodeName());

            // id
            NodeList idElemlist = element.getElementsByTagName("id");
            Element idElement = (Element) idElemlist.item(0);
            String idDoctors = idElement.getFirstChild().getNodeValue();
            // System.out.println("id : " + idDoctors);
            el.setId(adapter.setLine(idDoctors).convertStr());

            // name
            NodeList nameElemlist = element.getElementsByTagName("name");
            Element nameElement = (Element) nameElemlist.item(0);
            String nameDoctors = nameElement.getFirstChild().getNodeValue();
            // System.out.println("name : " + nameDoctors);
            el.setName(nameDoctors);

            // degree
            String degreeDoctors = element.getElementsByTagName("degree").item(0).getTextContent();
            //  System.out.println("degree : " + degreeDoctors);
            el.setDegree(degreeDoctors);

            // age
            String dateOfBirthDoctors = element.getElementsByTagName("dateOfBirth").item(0).getTextContent();
            //System.out.println("dateOfBirth : " + dateOfBirthDoctors);
            try {
                el.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirthDoctors));
            } catch (ParseException ex) {
                ex.toString();
            }

            // yearEperience
            String yearEperience = element.getElementsByTagName("yearEperience").item(0).getTextContent();
            //  System.out.println("yearEperience : " + yearEperience);
            el.setYearEperience(adapter.setLine(yearEperience).convertStr());

            // type
            NodeList nodeListType = element.getElementsByTagName("type");
            ArrayList<String> typeDoctors = new ArrayList<>();
            for (int j = 0; j < nodeListType.getLength(); j++) {

                typeDoctors.add(nodeListType.item(j).getTextContent());

            }

            //System.out.println("type : " + typeDoctors.toString());
            el.setType(typeDoctors);

            //visible
            String visibleDoctors = element.getElementsByTagName("visible").item(0).getTextContent();
            // System.out.println("visible : " + visibleDoctors);
            el.setVisible(Boolean.valueOf(visibleDoctors));

            list.add(el);
        }

       /* for (Doctors e : list) {

            System.out.println(e.toString());

        }*/
       if(list!=null)
            System.out.println("XML parsing proshel uspeshno!");
       else 
            System.err.println("Oshibka XML parsinga");
       
        return list;
    }

}
