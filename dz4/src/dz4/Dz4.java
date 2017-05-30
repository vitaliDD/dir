/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz4;

import java.util.Scanner;

/**
 *
 * @author ya
 */
public class Dz4 {
    
public static void main (String args[]) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Vvedite kolichestvo patientov: ");
	int razm=scan.nextInt();	
	Patient[] patient=new Patient[razm];
	for(int i=0;i<patient.length;i++){
		
		patient[i]=new Patient();
		
		}
	for(int i=0;i<patient.length;i++){
		System.out.println("Vvod patienta nomer "+(i+1)+":\n");
		
		patient[i].vvodD();
	}
		

		
	for(Patient pat:patient){
		pat.vivodNaEkan();
		
		}
	zapros_poiska(patient);
	}
	
	static void zapros_poiska(Patient[] pat){
		Scanner scan=new Scanner(System.in);
		String otvet="";
                String vibor="";
		for(;;){
                        do{
			System.out.println("Hotite naiti patienta v baze (yes/no)?: ");
		
			otvet=scan.nextLine();
                        }while (!(otvet.equals("yes"))&&!(otvet.equals("no")));                      
                        
                    
			if(otvet.equals("no"))
			break;
                        do{
			System.out.println("Hotite naiti patienta po familii ili vozrasty(familia/vozrast)?: ");
			vibor=scan.nextLine();
                        }while(!(vibor.equals("familia"))&&!(vibor.equals("vozrast")));
			Patient.poisk(pat, vibor);
		
		}
		
		//System.exit(0);
	}
}
