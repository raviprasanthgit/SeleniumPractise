package week1.dailyhomework;

public class SumOfArray {

	public static void main(String[] args) {
		int no1[] = {13,25,9,56,54,89,17};
		int add=0;
		for(int i=0;i<no1.length;i++)
		{
			add=add+no1[i];
		}
		System.out.println("Sum of the array : " + add);
	}

}
