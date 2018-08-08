package week1.day1.homework;

public class ArithmeticOperations {

	int int1,int2; // declare variables

	//Addition 

	public void addition()
	{
		int1=10;
		int2=20;
		int add = int1+int2;
		System.out.println("Addition " + add);
	}

	//Subtraction with return

	public int subtract()
	{
		int1=10;
		int2=20;

		int sub = int2-int1;

		System.out.println("Subtraction "+ sub);
		return sub;

	}

	//Mulitplicatin with return

	public int multiply()
	{

		int1=10;
		int2=20;

		int mult = int1*int2;
		System.out.println("Multiplication " + mult);
		return mult;	
	}

	//Multiplication with no return

	public void multiplyNoOneByTwo()
	{
		int1=1;
		int2=2;
		int multiply = int1*int2;
		System.out.println("Number one by two " + multiply);

	}

	//Division with arguments and returning value

	public int divideNoTwoBy(int divident)
	{
		int1=2;
		int divide = divident/int1;
		return divide;
	}
}
