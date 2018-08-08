package framesandwindows;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosinTheFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\\\TestLeaf\\\\drivers-20180617T030731Z-001\\\\drivers\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		
		driver.findElementByXPath("//div[@class='ui-layout-west ui-layout-pane ui-layout-pane-west']//h3/preceding::button").click();
		System.out.println("Left closed button clicked");
		
		driver.findElementByXPath("//div[@class='ui-layout-east ui-layout-pane ui-layout-pane-east']//button[1]").click();
		System.out.println("Right closed button clicked");
		
		driver.switchTo().frame("childIframe");
		System.out.println("Frame Switched");

		driver.findElementByXPath("//div[contains(text(),' Iframe West')]//button").click();
		System.out.println("Clicked close me button inside the frame on the left");
		
		driver.findElementByXPath("//div[contains(text(),' Iframe East')]//button").click();
		System.out.println("Clicked close me button inside the frame on the right");
		
		

	}

}
