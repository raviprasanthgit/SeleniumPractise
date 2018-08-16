package stringoperations;

import org.apache.poi.util.SystemOutLogger;

public class WorkingWithString {

	public static void main(String[] args) {
		//program 1 - Reverse string
		/*		String name = "Ravi";
		int length = name.length();
		System.out.println("Reverse a string without reverse func");
		for(int i=length-1;i>=0;i--)
		{
			char charAt = name.charAt(i);
			System.out.print(charAt);

		}*/


		//Program 2 - Letter in name
/*		String name1 = "Prsanth";
		int temp=0;
		String lowerCase = name1.toLowerCase();
		char[] charArray = lowerCase.toCharArray();
		for (char c : charArray) {
			if(c=='a')
			{
				temp++;
			}
		}
		System.out.println("The no of letters "+temp);
	}	*/	
		
		//Program 3
		String name3 = "Amazon India Private Limited";
		int temp=0;
		String lowerCase = name3.toLowerCase();
		int length = lowerCase.length();
		char[] charArray = lowerCase.toCharArray();
		for (char c : charArray) {
			temp=0;
			for(int i=0;i<length;i++)
			{
				if(c==lowerCase.charAt(i))
				{
					temp++;
				}
			}
			System.out.println(c+"="+temp);
			lowerCase=lowerCase.replaceAll(""+c, "");
			length=lowerCase.length();
			System.out.println(lowerCase);
		}		

}
}

