package week1.day2;

import org.apache.poi.util.SystemOutLogger;

public class LargestOfNumbers {

	public static void main(String[] args) {
		
		int[] numbers = {22,32,42,-22,-9};
		int temp=0;
		
		//Using For loop.
		for (int i=0;i<numbers.length;i++)
		{
			if (numbers[i]>temp)
			{
				temp=numbers[i];
			}
		}
		System.out.println("The largest number using for loop is : "+temp);
		
		//Using For Each
		for(int larNumbers:numbers)
		{
			if(larNumbers>temp)
			{
				temp=larNumbers;
			}
		}
		System.out.println(" The largest number using for each : "+ temp);
	}


}
