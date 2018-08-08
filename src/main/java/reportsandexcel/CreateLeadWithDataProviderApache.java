package reportsandexcel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class CreateLeadWithDataProviderApache extends Annotations {

	@Test(dataProvider="fetchdata")
	//	@Test(timeOut=2000)
	//@Test(groups= {"smoke"})
	public void createLead(String cname,String fname,String lname,String flocal,String phone) throws InterruptedException
	{	
		//Thread.sleep(5000);
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(cname);
		driver.findElementById("createLeadForm_firstName").sendKeys(fname);
		driver.findElementById("createLeadForm_lastName").sendKeys(lname);
		driver.findElementByName("firstNameLocal").sendKeys(flocal);
		driver.findElementByName("lastNameLocal").sendKeys("homework");
		driver.findElementById("createLeadForm_personalTitle").sendKeys("salutation");
		Select dropDown = new Select(driver.findElementById("createLeadForm_dataSourceId"));
		dropDown.selectByValue("LEAD_COLDCALL");
		Select dd = new Select(driver.findElementById("createLeadForm_industryEnumId"));
		dd.selectByVisibleText("Insurance");
		driver.findElementById("createLeadForm_generalProfTitle").sendKeys("ravi");
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("200");
		Select ownerShip = new Select(driver.findElementById("createLeadForm_ownershipEnumId"));
		ownerShip.selectByIndex(1);
		driver.findElementById("createLeadForm_sicCode").sendKeys("sic code");
		driver.findElementById("createLeadForm_description").sendKeys("desc test");
		driver.findElementById("createLeadForm_importantNote").sendKeys("importantNote");
		driver.findElementById("createLeadForm_primaryPhoneCountryCode").clear();
		driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("2");
		driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("91");
		driver.findElementById("createLeadForm_departmentName").sendKeys("department");
		Select country = new Select(driver.findElementById("createLeadForm_generalCountryGeoId"));
		country.selectByValue("IND");
		driver.findElementById("createLeadForm_numberEmployees").sendKeys("10");
		driver.findElementById("createLeadForm_tickerSymbol").sendKeys("yes");
		driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("ravi");
		driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("https://www.google.com");
		driver.findElementById("createLeadForm_generalToName").sendKeys("toravi");
		driver.findElementById("createLeadForm_generalAddress1").sendKeys("h405");
		driver.findElementById("createLeadForm_generalAddress2").sendKeys("tvs");
		driver.findElementById("createLeadForm_generalCity").sendKeys("chennai");
		driver.findElementById("createLeadForm_generalPostalCode").sendKeys("600063");
		driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("12");
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys(""+phone);
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("abc@gmail.com");
		driver.findElementByClassName("smallSubmit").click();

		WebElement verifyFname = driver.findElementById("viewLead_firstName_sp");
		String fNameText = verifyFname.getText();
		if(fNameText.contains("Ravi"))
		{
			System.out.println("First name matched");
		}
		else
		{
			System.out.println("not matched");
		}

	}
	
@DataProvider(name="fetchdata")
	
	public Object[][] getData() throws IOException
	
	{
		ReadExcelDataProvider excelData = new ReadExcelDataProvider();
		return excelData.readExcel("CreateLead");
			
	}

}
