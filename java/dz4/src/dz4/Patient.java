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
public class Patient {
   
	
	String imya;
	String familia;
	int vozrast;
	boolean isVetryanka;
	
	/*Patient(){
		System.out.println("Vvedite imya patienta: ");	
		
		}*/
	void vvodD(){
			Scanner scan=new Scanner(System.in);
			System.out.println("Vvedite imya patienta: ");
			imya=scan.nextLine();
			System.out.println("Vvedite familiyu patienta: ");
			familia=scan.nextLine();
			System.out.println("Vvedite vozrast patienta: ");
			vozrast=scan.nextInt();
			System.out.println("Boleet li vetryankoi (true/false): ");
			isVetryanka=scan.nextBoolean();
				
			}
	
	void vivodNaEkan(){
		
		System.out.println("Пациент "+imya+" "+familia+" - Возраст = "+vozrast+" Bolen vetryankoi: "+isVetryanka);
		
		}
		
	static void poisk(Patient[] pat,String zhelanie){
		Scanner scan=new Scanner(System.in);
	
		if(zhelanie.equals("familia")){
			System.out.println("vvedite familiyu: ");
			String fam=scan.nextLine();
		for(Patient p:pat){
			if(p.familia.equals(fam))
			p.vivodNaEkan();
			}	
		}
		else{
			System.out.println("vvedite vozrast: ");
			int age=scan.nextInt();
			for(Patient p:pat){
				if(p.vozrast==age)
				p.vivodNaEkan();
			}
		}
	}
		
	
}
