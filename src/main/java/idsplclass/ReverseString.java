package idsplclass;

public class ReverseString {

	public static void main(String[] args) {
		StringBuffer txt = new StringBuffer( "I am the Winner");

		System.out.println("Reverse using predefined : "+txt.reverse());

		String newText = "I am the Winner";
		char[] charArray = newText.toCharArray();
		int length = charArray.length;
		for(int i=length-1;i>=0;i--)
		{
			System.out.print("without predefined " +charArray[i]);
		}
		

	}

}
