package framesandwindows;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFrames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\\\TestLeaf\\\\drivers-20180617T030731Z-001\\\\drivers\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com/");
		String parentWind = driver.getWindowHandle();
		driver.findElementByLinkText("Multi-PopUp Test #2").click();
		Set<String> childWind = driver.getWindowHandles();
		int i=0;
		for (String closeChild : childWind) {

			if(closeChild.equals(parentWind))
			{
				continue;
			}
			else
			{
				driver.switchTo().window(closeChild);
				driver.close();
				System.out.println("Child window "+(i=i+1)+" Closed" );
			}

		}			
		System.out.println("Closed all child windows");
		driver.switchTo().window(parentWind);
		System.out.println("Parent window : "+driver.getCurrentUrl());
		System.out.println("Prent Window title : "+driver.getTitle());
		
		driver.quit();
	}

}
