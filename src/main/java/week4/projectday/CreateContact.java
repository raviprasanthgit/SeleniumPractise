package week4.projectday;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.cache.WebappTemplateLoader;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\TestLeaf\\drivers-20180617T030731Z-001\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("demosalesmanager");;
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Contact").click();
		
		WebElement fName = driver.findElementById("firstNameField");
		fName.sendKeys("Ravi");
		String fNameValue = fName.getAttribute("value");
		
		WebElement lName = driver.findElementById("lastNameField");
		lName.sendKeys("Anjan");
		String lnameValue = lName.getAttribute("value");
		
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("project");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("day");
		driver.findElementById("createContactForm_personalTitle").sendKeys("Mr");
		driver.findElementById("createContactForm_generalProfTitle").sendKeys("Project day");
		driver.findElementById("createContactForm_departmentName").sendKeys("Luna");
		Select prefrdCurr = new Select(driver.findElementById("createContactForm_preferredCurrencyUomId"));
		List<WebElement> allOptions = prefrdCurr.getOptions();
		prefrdCurr.selectByValue("INR");
		driver.findElementById("createContactForm_description").sendKeys("Project day - luna");
		driver.findElementById("createContactForm_importantNote").sendKeys("Project day - luna-important note");
		driver.findElementById("createContactForm_primaryPhoneAreaCode").sendKeys("600063");
		driver.findElementById("createContactForm_primaryPhoneExtension").sendKeys("0001");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("u.raviprasanth@gmail.com");
		driver.findElementById("createContactForm_primaryPhoneNumber").sendKeys("8015721179");
		driver.findElementById("createContactForm_primaryPhoneAskForName").sendKeys("Someone");
		WebElement toName = driver.findElementById("generalToNameField");
		String toNameValue = toName.getAttribute("value");
		String fAndLname = fNameValue+" "+lnameValue;
		if(toNameValue.equals(fAndLname))
		{
			System.out.println("To name matches");
		}else
		{
			System.out.println("Text is not matched");
		}
		driver.findElementById("createContactForm_generalAddress1").sendKeys("h405,tvs apartment");
		driver.findElementById("createContactForm_generalCity").sendKeys("Chennai");
		driver.findElementById("createContactForm_generalPostalCode").sendKeys("600062");
		driver.findElementById("createContactForm_generalPostalCodeExt").sendKeys("001");
		driver.findElementById("createContactForm_generalAttnName").sendKeys("Test Leaf");
		driver.findElementById("createContactForm_generalAddress2").sendKeys("perungalathur");
		WebElement eleCountry = driver.findElementById("createContactForm_generalCountryGeoId");
		Select country = new Select(eleCountry);
		List<WebElement> allOptionsCountry  = country.getOptions();
		country.selectByVisibleText("India");
		eleCountry.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
		Select state = new Select(driver.findElementById("createContactForm_generalStateProvinceGeoId"));
		List<WebElement> allOptionsState  = state.getOptions();
		state.selectByVisibleText("TAMILNADU");
		
		System.out.println("Form fill done");
		driver.findElementByName("submitButton").click();
		
		WebElement fullName = driver.findElementById("viewContact_fullName_sp");
		String nameText = fullName.getText();
		
		if(nameText.contains(toNameValue))
		{
			System.out.println("Value matches");
		}else
		{
			System.out.println("value is not matching");
		}
		
		driver.findElementByLinkText("Edit").click();
		
		Select mrktCampngn = new Select(driver.findElementById("addMarketingCampaignForm_marketingCampaignId"));
		mrktCampngn.selectByVisibleText("Car and Driver");
		WebElement firstSelectedOption = mrktCampngn.getFirstSelectedOption();
		String mrktSegtext = firstSelectedOption.getText();
		
		
		driver.findElementByXPath("//input[@value='Add']").click();
		
		driver.findElementByXPath("//input[@value='Update']").click();
		
		WebElement mrktSegment = driver.findElementById("viewContact_marketingCampaigns_sp");
		String mrktSegmentTextExpt = mrktSegment.getText();
		
		if(mrktSegmentTextExpt.contains(mrktSegtext))
		{
			System.out.println("Market segemtns are matched");
		}else
		{
			System.out.println("Market segments are not matched");
		}
		
		driver.quit();
	}
}
