package auiandexceptions;

import org.openqa.selenium.NoSuchElementException;

public class CustomException extends NoSuchElementException {
	
	public CustomException(String reason) {
		super(reason);
	
	}

	public void myException() {
		
	System.out.println("My custom exception");
		
	}

}
