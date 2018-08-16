package stringoperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionsWorking {

	public static void main(String[] args) {
		

		//Program 1 : MAx itme in the list
		
		List<Integer> bagPrice = new LinkedList<Integer>();
		bagPrice.add(999);
		bagPrice.add(666);
		bagPrice.add(545);
		bagPrice.add(545);
		bagPrice.add(545);
		bagPrice.add(654);
		bagPrice.add(666);
		bagPrice.add(999);
		bagPrice.add(666);
	/*	Collections.sort(bagPrice);
		int size = bagPrice.size();
		System.out.println(bagPrice.get(size-1));*/
		
		
		//Program 2 : maximum repeated
		List<Integer> bagPrices = new ArrayList<Integer>();
		/*bagPrices.add(999);
		bagPrices.add(666);
		bagPrices.add(545);
		bagPrices.add(545);
		bagPrices.add(545);
		bagPrices.add(654);
		bagPrices.add(666);
		bagPrices.add(999);
		bagPrices.add(666);*/
		int count=0;
		int size = bagPrice.size();
		int max=0;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(bagPrice.get(i)==bagPrice.get(j))
				{
					count = count+1;
				}
				if(count>=max)
				{
					max=count;
				}
		}
			bagPrices.add(max);
			
			count=0;
	}
		System.out.println(bagPrices);
	}
}
