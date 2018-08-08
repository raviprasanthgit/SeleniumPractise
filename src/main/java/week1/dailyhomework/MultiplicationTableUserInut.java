package week1.dailyhomework;

import java.util.Scanner;

public class MultiplicationTableUserInut {

	public static void main(String[] args) {
		
		int no1,no2,result;
		
		System.out.println("enter number 1 : " );
		Scanner scan = new Scanner(System.in);
		no1=scan.nextInt();
		System.out.println("enter number 2 : " );
		no2=scan.nextInt();
		System.out.println("The multiplication table for number "+no1+" is");
		for(int i=1;i<=no2;i++)
		{
			result=i*no1;
			System.out.println(i + " * "+no1+" = "+result);
		}
		
	}

}
