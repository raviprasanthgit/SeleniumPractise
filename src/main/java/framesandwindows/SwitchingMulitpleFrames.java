package framesandwindows;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingMulitpleFrames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\\\TestLeaf\\\\drivers-20180617T030731Z-001\\\\drivers\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/");
		
		driver.findElementByLinkText("Draggable").click();
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		System.out.println("Frame Switched");
		String textInsideDraggable = driver.findElementByXPath("//div[@id='draggable']//p").getText();
		System.out.println("TExt inside draggable : "+textInsideDraggable);
		driver.switchTo().defaultContent();
		
		driver.findElementByLinkText("Droppable").click();
		Thread.sleep(1000);
		driver.quit();

	}

}
