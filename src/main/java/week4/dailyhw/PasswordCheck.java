package week4.dailyhw;

import java.util.Scanner;

public class PasswordCheck {

	public static void main(String[] args) {
		
		String pass;
		System.out.println("Enter the password : ");
		Scanner input = new Scanner(System.in);
		pass=input.nextLine();
		input.close();
		if(passCheck(pass)) {
			System.out.println("PAssword is valid");
		}else
		{
			System.out.println("Psssword is not valid");

		}
	}


	public static boolean  passCheck(String pass)
	{	char c;int countDigits = 0,countLetters=0,countUpperCase=0;
		int length = pass.length();
		if(length < 10)
		{
			System.out.println("Password must contain atleast 10 characters");
			return false;
		}else {
		for(int i=0;i<length-1;i++)
		{
			c=pass.charAt(i);
			if(!Character.isLetterOrDigit(c))
			{
				System.out.println("The password should not contain special characters");
				return false;
			}
			if(Character.isDigit(c))
			{
			countDigits++;	
			}
			else if(Character.isLetter(c))
			{
				countLetters++;
			}
			else if(Character.isUpperCase(c))
			{
				countUpperCase++;
			}
		}
		if(countDigits<2)
		{
			System.out.println("pass must have atleast 2 digits");
			return false;
		}
		else if(countLetters<2)
		{
			System.out.println("Pass must have atleast 2 letters");
			return false;
		}
		else if(countUpperCase<2)
		{
			System.out.println("Pass must have atleast 2 upper case");
			return false;
		}
		return true;
	}
}
}