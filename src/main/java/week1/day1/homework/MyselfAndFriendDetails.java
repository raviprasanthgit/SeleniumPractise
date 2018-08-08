package week1.day1.homework;

public class MyselfAndFriendDetails {

	int age;
	String name;
	String favColor;

	public void myDetails()
	{
		age=24;
		name="Ravi";
		favColor = "Red";
		System.out.println("Myself :");
		System.out.println("Name " + name);
		System.out.println("Age " + age);
		System.out.println("favourite color " + favColor);
	}

	public void friend1()
	{
		age=23;
		name="Dhana";
		favColor = "Blue";
		System.out.println("Friend 1 :" );
		System.out.println("Name " + name);
		System.out.println("Age " + age);
		System.out.println("favourite color " + favColor);
	}

	public void friend2()
	{
		age=25;
		name="Shathru";
		favColor = "Blsck";
		System.out.println("Friend 2 : ");
		System.out.println("Name " + name);
		System.out.println("Age " + age);
		System.out.println("favourite color " + favColor);
	}

	public static void main(String[] args) {
		// calling the method

		MyselfAndFriendDetails details = new MyselfAndFriendDetails();
		details.myDetails();
		details.friend1();
		details.friend2();

	}

}
