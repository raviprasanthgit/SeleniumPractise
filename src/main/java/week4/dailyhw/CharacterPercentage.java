package week4.dailyhw;

import java.util.Scanner;

public class CharacterPercentage {

	public static void main(String[] args) {

		String sentence;
		System.out.println("Enter the sentence : ");
		Scanner input = new Scanner(System.in);
		sentence=input.nextLine();
		input.close();
		charPercent(sentence);
	}


	public static void  charPercent(String sentence)
	{	
		int upperCase=0,lowerCase=0,digits=0,otherChar;
		float f1,f2,f3,f4;
		char c;
		int length = sentence.length();
		for(int i=0;i<length-1;i++)
		{
			c=sentence.charAt(i);
			if(Character.isUpperCase(c))
			{
				upperCase++;
			}
			else if(Character.isLowerCase(c))
			{
				lowerCase++;	
			}
			else if(Character.isDigit(c))
			{
				digits++;
			}
		}
			otherChar=length-(upperCase+lowerCase+digits);

			f1=((upperCase*100)/length);
			f2=((lowerCase*100)/length);
			f3=((digits*100)/length);
			f4=((otherChar*100)/length);

			System.out.println("upper case percent : "+f1+ "%");
			System.out.println("lower case percent : "+f2+ "%");
			System.out.println("digits percent : "+f3+ "%");
			System.out.println("other chars : "+f4+ "%");
		}
	}
