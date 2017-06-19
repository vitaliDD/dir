
package cw13;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;




public class Cw13 {

    
    public static void main(String[] args) {
        
        Root root =  parseGson("test.json");
        System.out.println(root.toString());
        
        
        
    }
    
    public static Root parseJson(String path){
    
      JSONParser parser = new JSONParser();
      Root root=null;
        
        try{
                       
            JSONObject rootObj=(JSONObject)parser.parse(new FileReader(path));//ob'ekt vsego documenta
            root=new Root();
            String name = (String) rootObj.get("name");
            System.out.println("name = "+name);
            root.setName(name);
            ArrayList<People> peopleList= new ArrayList();
            JSONArray peopleArray=(JSONArray)rootObj.get("people");
            for(Object item: peopleArray){
            
                JSONObject itmIbj=(JSONObject)item;
                People people=new People(); 
                long id=(long) itmIbj.get("id");
                String namePeople=(String) itmIbj.get("name");
                String surname=(String) itmIbj.get("surname");
                long age=(long) itmIbj.get("age");
                boolean isDegree=(boolean) itmIbj.get("isDegree");   
                
                people.setAge((int)age);
                people.setId((int)id);
                people.setIsDegree(isDegree);
                people.setName(namePeople);
                people.setSurname(surname);
                peopleList.add(people);
            
            }
             root.setPeople(peopleList);
            

        }catch(Exception e){
            System.out.println("pi"+e.toString());
        
        }
    return root;
    
    }
    
    
    public static Root parseGson(String path){
        
        Root root = null;
        try{
            BufferedReader reader= new BufferedReader(new FileReader(path));
            Gson gson = new Gson();
            root=gson.fromJson(reader,Root.class);
        
        
        
        }catch(Exception e){
        
            System.out.println("oshibka"+e.toString());
        
        }
        return root;
        
        
    }
}
