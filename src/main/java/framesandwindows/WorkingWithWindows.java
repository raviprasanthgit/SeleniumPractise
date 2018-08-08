package framesandwindows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithWindows {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","E:\\\\TestLeaf\\\\drivers-20180617T030731Z-001\\\\drivers\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		String parentWindow = driver.getWindowHandle();
		
		driver.findElementByLinkText("Contact Us").click();
		driver.findElementByLinkText("Compatible Browser").click();
		
		Set<String> allWindowsCnt = driver.getWindowHandles();
		List<String> cnvrtedWindowsCnt = new ArrayList<String>();
		cnvrtedWindowsCnt.addAll(allWindowsCnt);
		
		driver.switchTo().window(cnvrtedWindowsCnt.get(3));
		System.out.println("contact us window title :"+ driver.getTitle());
		System.out.println("contact us window URL :"+ driver.getCurrentUrl());
		
		driver.switchTo().window(cnvrtedWindowsCnt.get(2));
		System.out.println("compatible browser window title :"+ driver.getTitle());
		System.out.println("compatible browser window URL :"+ driver.getCurrentUrl());
		
		driver.switchTo().window(cnvrtedWindowsCnt.get(3));
		driver.close();
		System.out.println("Contact us is closed");
		
		driver.switchTo().window(parentWindow);
		driver.close();
		System.out.println("parent window is closed");
		
		driver.switchTo().window(cnvrtedWindowsCnt.get(2));
		WebElement cmptBrowser = driver.findElementByClassName("normaltxt");
		System.out.println("All compatible browser"+cmptBrowser.getText());
	}

}
