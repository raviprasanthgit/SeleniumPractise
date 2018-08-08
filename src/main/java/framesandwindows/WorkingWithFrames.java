package framesandwindows;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\\\TestLeaf\\\\drivers-20180617T030731Z-001\\\\drivers\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://layout.jquery-dev.com/demos/iframes_many.html");
		
		List<WebElement> totalFrames = driver.findElementsByTagName("iFrame");
		int size = totalFrames.size();
		System.out.println("Total Frames"+size);
		
//		for (WebElement switchFrames : totalFrames) {
//			driver.switchTo().frame(switchFrames);
//			List<WebElement> childFrames = driver.findElementsByTagName("iFrame");
//			if(childFrames.size()>0)
//			{
//				
//			}
//			
//		}
	}

}
