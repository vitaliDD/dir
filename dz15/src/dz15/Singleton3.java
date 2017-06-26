

package dz15;


public class Singleton3 {
 
  private static Singleton3 instance;
   
  private Singleton3(){}
   
  //блок статической инициализации с возможностью обработки исключительных ситуаций
  static{
    try{
      instance = new Singleton3();
    }catch(Exception e){
      throw new RuntimeException("При создании объекта «Singleton» произошла ошибка");
    }
  }
   
  public static Singleton3 getInstance(){
    return instance;
  }
}


