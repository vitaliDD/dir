

package dz15;


public class Adapter extends Initial{

    public Adapter(String a) {
        super(a);
    }
    
    @Override
    public String getA(){
        
    return super.getA().replaceAll("\\D","");
    }

}
