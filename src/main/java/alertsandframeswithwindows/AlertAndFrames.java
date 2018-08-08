package alertsandframeswithwindows;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAndFrames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\\\TestLeaf\\\\drivers-20180617T030731Z-001\\\\drivers\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		WebElement frame = driver.findElementById("iframeResult");
		driver.switchTo().frame(frame);
		WebElement tryIT = driver.findElementByXPath("//button[text()='Try it']");
		tryIT.click();
		
		driver.switchTo().alert().sendKeys("Testing alerts andd frames");
		Thread.sleep(2000);
		System.out.println("Text present in alert : "+(driver.switchTo().alert().getText()));
		driver.switchTo().alert().accept();
		
		WebElement textAlert = driver.findElementByXPath("//p[@id='demo']");
		System.out.println("Text from alert : "+textAlert.getText());
		driver.switchTo().defaultContent();
		
		driver.findElementById("tryhome").click();
		Thread.sleep(1000);
		driver.quit();
		//driver.close();
		
	}

}
