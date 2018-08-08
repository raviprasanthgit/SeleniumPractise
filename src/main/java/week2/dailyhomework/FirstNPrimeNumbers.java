package week2.dailyhomework;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstNPrimeNumbers {

	public static void main(String[] args) {
		int number;
		ArrayList<Integer> output= new ArrayList<Integer>();
		System.out.println("Enter the number :");
		Scanner scan = new Scanner(System.in);
		number = scan.nextInt();
		boolean prime = true;
		System.out.println("The prime numbers :");
		for(int i=2;i<=number;i++)
		{
			for(int j=2;j<i;j++)
			{
			if(i%j==0)
				prime=false;
			}
			if(prime)
				output.add(i);
			prime=true;
		}
		//print the output
		
		int size = output.size();
		for(Integer i: output) {
			if(size ==1)
				System.out.print(i);
			else {
			size--;
			System.out.print(i+" , ");
			}
		}

	}

}
