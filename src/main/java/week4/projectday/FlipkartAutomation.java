package week4.projectday;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import wdMethods.SeMethods;

public class FlipkartAutomation extends SeMethods {

	@Test
	public void comparisonFlipkart() throws InterruptedException {
		
		startApp("chrome", "https://www.flipkart.com/");
		
		click(locateElement("xpath", "//button[text()='✕']"));
			
		actionsMouseOver(locateElement("xpath", "//span[text()='TVs & Appliances']"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(locateElement("xpath", "//a[@title='Samsung']/following::span[text()='Samsung']")));
		
		click(locateElement("xpath", "//a[@title='Samsung']/following::span[text()='Samsung']"));

		Thread.sleep(1000);
		
		selectDropDownUsingText(locateElement("xpath", "//div[@class='_1qKb_B']/select[@class='fPjUPw']"), "₹25000");
		
		Thread.sleep(2000);
		
		selectDropDownUsingText(locateElement("xpath", "//div[@class='_1YoBfV']/select[@class='fPjUPw']"), "₹60000");
		
		Thread.sleep(2000);
		
		click(locateElement("xpath", "//div[text()='Screen Size']"));
		
		Thread.sleep(1000);
		
		click(locateElement("xpath", "//div[@class='_1GEhLw'][text()='48 - 55']"));
		
		String parentWindow = parentWindow();
		
		click(locateElement("xpath", "//div[@data-id='TVSEVHPAAKQDSXRK']//div[@class='_3wU53n']"));
		
		switchToWindow(2);
		
		click(locateElement("xpath", "//input[@type='checkbox']/following::div[@class='_1p7h2j']"));
		
		closeBrowser();
		
		switchToWindow(parentWindow);
		
		
		click(locateElement("xpath", "//div[@data-id='TVSEVHPAMR4T3ZZY']//div[@class='_3wU53n']"));
		
		switchToWindow(2);
		
		click(locateElement("xpath", "//input[@type='checkbox']/following::div[@class='_1p7h2j']"));
		
		Thread.sleep(3000);
		
		click(locateElement("xpath", "//span[text()='COMPARE']"));
		
		String firstValue = getText(locateElement("xpath", "//div[@class='aqcZRL']/div/div[1]"));
		String f1=firstValue.replaceAll("₹", "");
		String f2=f1.replaceAll(",", "");
		//String firstValueSplit = firstValue.substring(1, 3);
		System.out.println("First value price"+f2);
		double firstValueInt = Double.parseDouble(f2);
		
		String secondValue = getText(locateElement("xpath", "//div[@class='aqcZRL']//following::div[@class='aqcZRL']//div[@class='_1vC4OE']"));
		String s1=secondValue.replaceAll("₹", "");
		String s2=s1.replaceAll(",", "");
		//String secondValueSplit = secondValue.substring(1, 3);
		System.out.println("second value price"+s2);
		double secondValueInt = Double.parseDouble(s2);
		
		if(firstValueInt < secondValueInt)	
		{
			System.out.println("Clicking first value");
			click(locateElement("xpath", "//span[@class='_279WdV']"));
		}else
		{
			System.out.println("Clicking Second value");
			click(locateElement("xpath", "//span[@class='_279WdV']//following::span[@class='_279WdV']"));
		}
		
		closeBrowser();
	}
	
}
