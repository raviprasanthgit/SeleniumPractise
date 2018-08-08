package week1.day2;

import java.util.Scanner;

public class AllStudentsAllDetails {

	public static void main(String[] args) {
	
		//Creating arrays
		String[] name= {"Ravi","Ram","Akbar","Rani"};
		int[] age = {23,24,25,26};
		char[][] grades= {{'A','B','C','D'},
						  {'A','A','A','A'},
						  {'B','B','B','B'},
						  {'C','C','C','C'}};
		
		for(String stuName:name)
		{
			System.out.println("Students names :"+stuName);
		}
		for(int stuAge:age)
		{
			System.out.println("Students Age :"+ stuAge);
		}

		//length of the name
		int length;
		length = name.length;
		
		System.out.println("Total names in the array : "+length);
	}

}
