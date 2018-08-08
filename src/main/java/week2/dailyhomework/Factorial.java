package week2.dailyhomework;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int number,temp=1;
		Scanner scan = new Scanner(System.in);
		number=scan.nextInt();
		
		for(int i=1;i<=number;i++)
		{
			temp=temp*i;
		}
		
		System.out.println("Factorial : "+temp);

	}

}
