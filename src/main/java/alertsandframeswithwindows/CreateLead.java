package alertsandframeswithwindows;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
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
		webDriver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		webDriver.findElementById("createLeadForm_firstName").sendKeys("Ravi");
		webDriver.findElementById("createLeadForm_lastName").sendKeys("Gopi");
		webDriver.findElementByName("firstNameLocal").sendKeys("day2");
		webDriver.findElementByName("lastNameLocal").sendKeys("homework");
		webDriver.findElementById("createLeadForm_personalTitle").sendKeys("salutation");
		Select dropDown = new Select(webDriver.findElementById("createLeadForm_dataSourceId"));
		dropDown.selectByValue("LEAD_COLDCALL");
		Select dd = new Select(webDriver.findElementById("createLeadForm_industryEnumId"));
		dd.selectByVisibleText("Insurance");
		webDriver.findElementById("createLeadForm_generalProfTitle").sendKeys("ravi");
		webDriver.findElementById("createLeadForm_annualRevenue").sendKeys("200");
		Select ownerShip = new Select(webDriver.findElementById("createLeadForm_ownershipEnumId"));
		ownerShip.selectByIndex(1);
		webDriver.findElementById("createLeadForm_sicCode").sendKeys("sic code");
		webDriver.findElementById("createLeadForm_description").sendKeys("desc test");
		webDriver.findElementById("createLeadForm_importantNote").sendKeys("importantNote");
		webDriver.findElementById("createLeadForm_primaryPhoneCountryCode").clear();
		webDriver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("2");
		webDriver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("91");
		webDriver.findElementById("createLeadForm_departmentName").sendKeys("department");
		Select country = new Select(webDriver.findElementById("createLeadForm_generalCountryGeoId"));
		country.selectByValue("IND");
		webDriver.findElementById("createLeadForm_numberEmployees").sendKeys("10");
		webDriver.findElementById("createLeadForm_tickerSymbol").sendKeys("yes");
		webDriver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("ravi");
		webDriver.findElementById("createLeadForm_primaryWebUrl").sendKeys("https://www.google.com");
		webDriver.findElementById("createLeadForm_generalToName").sendKeys("toravi");
		webDriver.findElementById("createLeadForm_generalAddress1").sendKeys("h405");
		webDriver.findElementById("createLeadForm_generalAddress2").sendKeys("tvs");
		webDriver.findElementById("createLeadForm_generalCity").sendKeys("chennai");
		webDriver.findElementById("createLeadForm_generalPostalCode").sendKeys("600063");
		webDriver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("12");
		webDriver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("8015721179");
		webDriver.findElementById("createLeadForm_primaryEmail").sendKeys("abc@gmail.com");
		webDriver.findElementByClassName("smallSubmit").click();
		
		WebElement verifyFname = webDriver.findElementById("viewLead_firstName_sp");
		String fNameText = verifyFname.getText();
		if(fNameText.contains("Ravi"))
		{
			System.out.println("First name matched");
		}
		else
		{
			System.out.println("not matched");
		}
		//		webDriver.quit();
		//		webDriver.close();
				
	}

}
