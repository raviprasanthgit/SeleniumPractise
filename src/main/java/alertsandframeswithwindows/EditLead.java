package alertsandframeswithwindows;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\TestLeaf\\drivers-20180617T030731Z-001\\drivers\\chromedriver.exe");
		//		ChromeOptions op = new ChromeOptions();
		//		op.setHeadless(true);
		ChromeDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		webDriver.get("http://leaftaps.com/opentaps/control/main");
		webDriver.findElementById("username").sendKeys("demosalesmanager");;
		webDriver.findElementById("password").sendKeys("crmsfa");
		webDriver.findElementByClassName("decorativeSubmit").click();
		webDriver.findElementByLinkText("CRM/SFA").click();
		webDriver.findElementByLinkText("Create Lead").click();
		webDriver.findElementByLinkText("Find Leads").click();
		webDriver.findElementByName("firstName").sendKeys("Ravi");
		webDriver.findElementByXPath("//button[text()='Find Leads']").click();
		webDriver.findElementByXPath("//span[text()='Lead List']//following::table[2]//div//a[1]").click();
	}
}
		