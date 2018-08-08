package week1.day2.homework;

import java.util.Scanner;

public class LargestOfThreeNumbers {

	public static void main(String[] args) {
	
		int no1,no2,no3,result;
		
		System.out.println("Enter First Number : ");
		Scanner scan = new Scanner(System.in);
		no1=scan.nextInt();
		
		System.out.println("Enter Second Number : ");
		no2=scan.nextInt();
		
		System.out.println("Enter Thrid Number : ");
		no3=scan.nextInt();
		
		if((no1>no2)&&(no1>no3))
			System.out.println("Largest number is : "+no1);
		else if(no2>no3)
			System.out.println("Largest number is : "+no2);
		else
			System.out.println("Largest number is : "+no3);
		
		//Alternate way: 
		result = ((no1>no2)?(no1>no3)?no1:no3:(no2>no3)?no2:no3);
	}

}
