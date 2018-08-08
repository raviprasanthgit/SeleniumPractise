package week1.day2;

import java.util.Scanner;

public class TwoDimensionalArray {

	public static void main(String[] args) {
	
		//Creating arrays
		String[] name= {"Ravi","Ram","Akbar","Rani"};
		int[] age = {23,24,25,26};
		char[][] grades= {{'A','B','C','D'},
						  {'A','A','A','A'},
						  {'B','B','B','B'},
						  {'C','C','C','C'}};
		
		System.out.println("enter the number to get the name ");
		//Getting input from user
		Scanner scan = new Scanner(System.in);
		int inputName = scan.nextInt();
		//Printing particular student value
		System.out.println(name[inputName-1] + " who is " + age[inputName-1] +  " Years scored " + grades[inputName-1][0]+"," + grades[inputName-1][1]+ "," +grades[inputName-1][2]+"," +grades[inputName-1][3]);
		//System.out.println(grades[inputName-1]);
		
		//Printing all the student details
		for(int i=0;i<4;i++)
		{
			System.out.println("All the student details");
			int temp = i+1;
			System.out.println("Student "+temp+ " details");
			System.out.println(name[i] + " who is " + age[i] +  " Years scored " + grades[i][0]+"," + grades[i][1]+ "," +grades[i][2]+"," +grades[i][3]);
		}
	}

}
