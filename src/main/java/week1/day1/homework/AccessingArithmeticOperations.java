package week1.day1.homework;

public class AccessingArithmeticOperations {

	public static void main(String[] args) {
		//Main method to execute arithmetic program

		//Creating Objects for Arithmetic operations class
		ArithmeticOperations arithOp = new ArithmeticOperations();
		//calling addition method
		arithOp.addition();
		//calling division with passing arguments
		int division=arithOp.divideNoTwoBy(10);
		System.out.println("Divisor value from arithmetic operation class " + division );
		//calling multiplication method
		arithOp.multiply(); 
		//calling multiplication method w.o return
		arithOp.multiplyNoOneByTwo();
		//calling subtraction method
		arithOp.subtract();


	}

}
