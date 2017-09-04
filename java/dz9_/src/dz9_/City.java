/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz9_;

/**
 *
 * @author ya
 */
public class City {
    private String nameObj;
    private Name nameProspect;
    private Name nameUlica;
    private Name namePloschad;

    
    public Name getNameProspect() {
        return nameProspect;
    }

    public void setNameProspect(Name nameProspect) {
        this.nameProspect = nameProspect;
    }

    public Name getNameUlica() {
        return nameUlica;
    }

    public void setNameUlica(Name nameUlica) {
        this.nameUlica = nameUlica;
    }

    public Name getNamePloschad() {
        return namePloschad;
    }

    public void setNamePloschad(Name namePloschad) {
        this.namePloschad = namePloschad;
    }
    
   

    @Override
    public String toString() {
        return "City: " +getNameObj()+ "\nnameProspect: " + getNameProspect().getName() 
                + "\nnameUlica: " + getNameUlica().getName() + " \nnamePloschad: "
                + getNamePloschad().getName();
    }

    
    

  

    public City(String pr,String ul, String pl, String nameObj ) {
        this.nameProspect = new Name(pr);
        this.nameUlica = new Name(ul);
        this.namePloschad = new Name(pl);
        this.nameObj=nameObj;
    }

    public City(String nameObj, Name nameProspect, Name nameUlica, Name namePloschad) {
        this.nameObj = nameObj;
        this.nameProspect = nameProspect;
        this.nameUlica = nameUlica;
        this.namePloschad = namePloschad;
    }

    public City() {
    }

    
    
    public City( String nameObj) {
         this.nameObj=nameObj;
    }

    public String getNameObj() {
        return nameObj;
    }

    public void setNameObj(String nameObj) {
        this.nameObj = nameObj;
    }

    
    
   
    class Name{
    
    private String name;
    

        public Name(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    
            
    }
    
}
