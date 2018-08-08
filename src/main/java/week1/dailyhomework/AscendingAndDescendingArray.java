package week1.dailyhomework;

public class AscendingAndDescendingArray {

	public static void main(String[] args) {
		int no[]= {13,25,9,56,54,89,17};
		int tmp;
		for(int i=0;i<no.length;i++)
		{
			if(i==0) {
				System.out.print("Descending:");
			}
			for (int j=i+1;j<no.length;j++)
			{
				if(no[i]<no[j])
				{
					tmp=no[i];
					no[i]=no[j];
					no[j]=tmp;
				}
			}
			if(no.length!=i+1)
			System.out.print(no[i]+",");
			else
				System.out.print(no[i]);
		}
	

	for(int i=0;i<no.length;i++)
	{
		if(i==0) {
			System.out.println();
			System.out.print("Ascending:");
		}
		for (int j=i+1;j<no.length;j++)
		{
			if(no[i]>no[j])
			{
				tmp=no[i];
				no[i]=no[j];
				no[j]=tmp;
			}
		}
		if(no.length!=i+1)
		System.out.print(no[i]+",");
		else
			System.out.print(no[i]);
	}

}

}
