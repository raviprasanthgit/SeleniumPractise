package week1.dailyhomework;

public class StringReverseRecursive {
	public static void main(String[] args) {

		String text = "Ravi";
		long no=10;
		StringReverseRecursive obj = new StringReverseRecursive();
				
				System.out.println(obj.reverse(text));

		if(no==10)
			System.out.println("Reverse order is:01");
		else
		{
			System.out.print("reverse order : ");
		reverseNumber(no);
		}
	}

	public  String reverse(String args)
	{
		
		if(args.length() <= 1)
			return args;
		else
			return reverse(args.substring(1))+args.charAt(0);
			
	}

	public static void reverseNumber(long number)
	{

		if(number <10)
			return;
		else
		{
			System.out.print((number%10));
			reverseNumber(number/10);
		}
	}

}
