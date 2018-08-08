package dailyprogram;

public class UniqueCharInString {

	public static void main(String[] args) {
		/*Write a simple Java program to identify and form a string with unique characters. 
		Ex. Input=Good Looking. 
			Output should be = godlkin.*/
		String input="Good looking";
		String output="";
		char b[]=input.toLowerCase().replace(" ", "").toCharArray();
		System.out.println("Input:"+input);
		/*for (int i=0;i<b.length;i++) {
			if(!output.contains(b[i]+"")) {
				output = output + b[i];
			}
		}*/
		for (int i=0;i<b.length;i++) {
			if(output.indexOf(b[i]) == -1) {
				output = output + b[i];
			}
		}
		System.out.println("Output:"+output);
	}

}
