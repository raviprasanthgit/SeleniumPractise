package week1.day2;

import java.util.Scanner;

public class SwitchCaseProgram {

	public static void main(String[] args) {
		String testCase;
		System.out.println("Enter the test case result : ");
		Scanner scan = new Scanner(System.in);
		testCase=scan.nextLine();
		
		switch(testCase)
		{
		case "pass":
			System.out.println("Test case is passed");
			break;
			
		case "fail":
			System.out.println("Test case is Failed");
			break;
			
		case "block":
			System.out.println("Test case is blocked");
			break;
			
		case "invalid":
			System.out.println("Test case is invlaid");
			break;
			
		default:
			System.out.println("Enter valid response");
					
		}
		
	}

}
