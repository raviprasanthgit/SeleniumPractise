package coding;

import org.testng.annotations.Test;

public class ReverseString extends BaseTestNg{
	//String txt = "I'm the Winner";
	String txt ="Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? Hello, How are you? ";
	// Using StringBuilder class
	@Test(priority=1)
	public void reverseUsingStringBuilder() {		
		System.out.println(new StringBuilder(txt).reverse());
	}

	// Using character position
	@Test(priority=2)
	public void reverseUsingCharAt() {		 
		for (int i = txt.length()-1; i>=0; i--)
			System.out.print(txt.charAt(i));		
		System.out.println();
	}	
	
	// Using character array
	@Test(priority=3)
	public void reverseUsingCharacter() {		 
		char[] chr = txt.toCharArray();
		for (int i = chr.length-1; i>=0; i--)
			System.out.print(chr[i]);
		System.out.println();
	}


}
