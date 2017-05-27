package dz2;
import java.util.*;


public class Dz2 {
   
  
    public static void main(String[] args) {
     
        //zadanie 1
        System.out.println("zadanie 1");
        
        
        //заполняем и выводим исходнй массив
        int[] mass1=new int[10];
        Random rand=new Random();
        System.out.print("ishodnii massiv: ");
        for(int i=0;i<mass1.length;i++){
            mass1[i]=rand.nextInt(10);
            System.out.print(mass1[i]+" ");
        }
        System.out.println();
        
        int min_value=mass1[0];
        int max_value=mass1[0];
        
		// находим мин и макс
        for(int i=1;i<mass1.length;i++){ 
			if (mass1[i]<min_value)
				min_value=mass1[i];
			if (mass1[i]>max_value)
				max_value=mass1[i];	
           
        }
        
        System.out.println("minimalnoe znachenie: " + min_value);
        System.out.println("maksimalnoe znachenie: " + max_value);
        
        //заменяем мин на 0, макс на 99
        
        for(int i=0;i<mass1.length;i++){
			if(mass1[i]==min_value)
			mass1[i]=0;
			if(mass1[i]==max_value)
			mass1[i]=99;
			}
		//выводим финальный массив
        System.out.print("finalnii massiv: ");
        for(int i=0;i<mass1.length;i++){
            System.out.print(mass1[i]+" ");
        }
        System.out.println();
        
        
         //zadanie 2
        System.out.println("===========================");
        System.out.println("zadanie 2");
        
        float[] mass2={1,8,8,3,8,3,4,1,9,8};
        System.out.print("ishodni massiv: ");
         for(int i=0;i<mass2.length;i++){
			System.out.print(mass2[i]+" ");
		}
        System.out.println();
        //сортируем массив по возрастанию
        Arrays.sort(mass2);
        
        System.out.print("otsortirovanii massiv: ");
        for(int i=0;i<mass2.length;i++){
            System.out.print(mass2[i]+" ");
            
        }
        
        System.out.println();
        int flag=1;
        for (int i=0;i<mass2.length-1;i++){
            for(int j=i+1;j<mass2.length;j++){
                if(mass2[i]==mass2[j]){
                flag++;
                i=j;
                }
            }
            if(flag!=1){
                System.out.println("["+mass2[i]+"] - povtorenii "+flag);
                flag=1;
            }
        }
        
         //zadanie 3
        System.out.println("===========================");
        System.out.println("zadanie 3");
        
        //заполняем и выводим исходный массив
        int[] mass3=new int[10];
        
        System.out.print("ishodnii massiv: ");
        for(int i=0;i<mass3.length;i++){
            mass3[i]=rand.nextInt(20);
            System.out.print(mass3[i]+" ");
        }
        System.out.println();
        int temp=0;
        for(int i=0;i<mass3.length/2;i++){
		temp=mass3[i];
                mass3[i]=mass3[mass3.length-i-1];
                mass3[mass3.length-i-1]=temp;
		}
        System.out.print("konechni massiv: ");
        for(int i=0;i<mass3.length;i++){
            System.out.print(mass3[i]+" ");
		}
        System.out.println();
        
        //zadanie 4
        System.out.println("===========================");
        System.out.println("zadanie 4");
        
         int[] mass4=new int[10];
        
        System.out.print("ishodnii massiv: ");
        for(int i=0;i<mass1.length;i++){
            mass4[i]=rand.nextInt(10);
            System.out.print(mass4[i]+" ");
        }
        System.out.println();
        Arrays.sort(mass4);
        System.out.print("konechni massiv: ");
        for(int i=0;i<mass4.length;i++){
            System.out.print(mass4[i]+" ");
		}
        
        
    }
    
}
