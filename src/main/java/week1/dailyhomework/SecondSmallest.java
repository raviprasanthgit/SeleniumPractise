package week1.dailyhomework;

import java.util.Scanner;

public class SecondSmallest {

	public static void main(String[] args) {
		int no1[]= {10,15,12};
		int i,j,temp=0;
		for(i=0;i<no1.length;i++)
		{
			for(j=i+1;j<no1.length;j++)
			{
				if(no1[i]>no1[j])
				{
					temp=no1[i];
					no1[i]=no1[j];
					no1[j]=temp;
					
				}
			}
			
		}
		System.out.println("The second smallest : " + no1[1]);

	}

}
