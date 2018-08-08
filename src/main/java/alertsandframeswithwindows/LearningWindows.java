package alertsandframeswithwindows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningWindows {

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
		
		String parentWindow = driver.getWindowHandle();
		
		driver.switchTo().alert().sendKeys("Testing alerts andd frames");
		Thread.sleep(2000);
		System.out.println("Text present in alert : "+(driver.switchTo().alert().getText()));
		driver.switchTo().alert().accept();
		
		WebElement textAlert = driver.findElementByXPath("//p[@id='demo']");
		System.out.println("Text from alert : "+textAlert.getText());
		driver.switchTo().defaultContent();
		
		driver.findElementById("tryhome").click();
		Set<String> allWindows=driver.getWindowHandles();
		List<String> setToList= new ArrayList<String>();
		setToList.addAll(allWindows);
		
		driver.switchTo().window(setToList.get(2));
		Thread.sleep(1000);
		System.out.println("switched to second window title : "+driver.getTitle());
		System.out.println("switched to second window URl : "+driver.getCurrentUrl());
		
		driver.switchTo().window(parentWindow);
		System.out.println("switched to first window title : "+driver.getTitle());
		System.out.println("switched to first window URl : "+driver.getCurrentUrl());

		driver.quit();
		//driver.close();
		
	}

}
