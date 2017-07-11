

package controllers.adapter;

/**
 *
 * @author ya
 *Самый лучший адаптер в мире*/
public class SuperAdapter {
    private String line;

    public SuperAdapter setLine(String line) {
        this.line = line;
        return this;
    }

    public String getLine() {
        return line;
    }

    
    
    public Integer convertStr(){
    
        return Integer.valueOf(line);
    
    } 

}
