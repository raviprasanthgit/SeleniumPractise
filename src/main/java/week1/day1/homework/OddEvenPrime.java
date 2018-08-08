package week1.day1.homework;

import java.util.Scanner;

public class OddEvenPrime {

	public static void main(String[] args) {
		boolean prime = true; //assigning boolean value for prime
		boolean even = false; ////assigning boolean value for even
		int num = 923,i,temp;
		int input;
		
		//user input using scanner
		
		//System.out.println("Enter the number \n");
		//Scanner scan = new Scanner(System.in);
		//input = scan.nextInt();
		
		if (num%2==0)  // if loop for num value hardcoded
			//if (input%2==0) // if loop for user input
		{
			even=true; // setting the even value to true 
		}
		
		else
		{
			for(i=2;i<num;i++) // for loop for num value hardcoded
				//for(i=2;i<input;i++)	 // for loop for num value hardcoded
			{
				temp=num%i; // getting the remainder value
				if(temp==0)
				{
					prime=false; // prime value to false
					break;
				}
			}
		}
		if(even)
			System.out.println("is a even number");
		else if(prime)
			System.out.println("is a prime number");
		else
			System.out.println("is a odd number number");
	}

}
