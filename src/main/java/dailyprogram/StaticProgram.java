package dailyprogram;

public class StaticProgram {
	public static String test1 = "Hello";
	String test2 = "World";
	public static void main(String[] args) {
		/* declare 2 String variables (1 static- hello and 1 non static-world.
		 * create two methods 1 static and 1 non static to print both variables.
		 * create a main method to call both the methods.
		 * Expected o/p: Hello World should print twice*/
		method1();
		StaticProgram obj1=new StaticProgram();
		obj1.method2();
	}
	public static void method1(){
		StaticProgram obj=new StaticProgram();
		System.out.println(test1+" "+obj.test2);
	}
	public void method2(){
		System.out.println(test1+" "+test2);
	}
}
