package week2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LoginLeaftaps {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\TestLeaf\\drivers-20180617T030731Z-001\\drivers\\chromedriver.exe");
		//		ChromeOptions op = new ChromeOptions();
		//		op.setHeadless(true);
		ChromeDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get("http://leaftaps.com/opentaps/control/main");
		webDriver.findElementById("username").sendKeys("demosalesmanager");;
		webDriver.findElementById("password").sendKeys("crmsfa");
		webDriver.findElementByClassName("decorativeSubmit").click();
		webDriver.findElementByLinkText("CRM/SFA").click();
		webDriver.findElementByLinkText("Create Lead").click();
		webDriver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		webDriver.findElementById("createLeadForm_firstName").sendKeys("Ravi");
		webDriver.findElementById("createLeadForm_lastName").sendKeys("Gopi");
		Select dropDown = new Select(webDriver.findElementById("createLeadForm_dataSourceId"));
		dropDown.selectByValue("LEAD_COLDCALL");
		dropDown.selectByIndex(2);
		dropDown.selectByVisibleText("Existing Customer");
		Select dd = new Select(webDriver.findElementById("createLeadForm_industryEnumId"));
		dd.selectByVisibleText("Insurance");
		
		//Printing the defaulted selected value in dropdown
		
		WebElement firstSelectedOption = dd.getFirstSelectedOption();
		System.out.println("Selected value " + firstSelectedOption.getText());
		
		//Printing the value selected by the user
		
		Select pc = new Select(webDriver.findElementById("createLeadForm_currencyUomId"));
		WebElement firstSelectedOption2 = pc.getFirstSelectedOption();
		System.out.println("Selected Value " + firstSelectedOption2.getText());
		
		//Selecting the index based on the size
		
		List<WebElement> options = pc.getOptions();
		int size = options.size();
		System.out.println(size);
		pc.selectByIndex(size-5);
		
		//Printing all the options in the dropdown
		
		for (WebElement allOptions : options) 
		{
			System.out.println("options " + allOptions.getText());

		}
		
		webDriver.findElementByClassName("smallSubmit").click();
		//		webDriver.quit();
		//		webDriver.close();
				
	}

}
