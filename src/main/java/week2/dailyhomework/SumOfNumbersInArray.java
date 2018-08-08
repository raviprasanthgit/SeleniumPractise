package week2.dailyhomework;

public class SumOfNumbersInArray {

	public static void main(String[] args) {
		int array[]= {25,26,9,18,3,12};
		int temp=0;
		for(int i:array)
		{
			temp=temp+i;
		}
		System.out.println("Sum :"+temp);
	}

}
