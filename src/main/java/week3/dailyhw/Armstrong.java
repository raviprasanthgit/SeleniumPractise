package week3.dailyhw;

public class Armstrong {

	public static void main(String[] args) {
		int num1,i,temp1,temp2,temp3,temp4,sum;
		
		for(num1=100;num1<1000;num1++)
		{
			temp1=num1%10;
			//System.out.println("temp1 :"+temp1);
			temp2=num1/10;
			temp3=temp2%10;
			//System.out.println("temp3 :"+temp3);
			temp4=temp2/10;
			//System.out.println("tmep4 :"+temp4);
			
			sum=(temp1*temp1*temp1)+(temp3*temp3*temp3)+(temp4*temp4*temp4);
			
			if(sum==num1)
			{
				System.out.println("Armstrong nunber "+num1);
			}
		}
		
	}

}
