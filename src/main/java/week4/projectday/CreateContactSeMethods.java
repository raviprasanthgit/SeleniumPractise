package week4.projectday;

import org.junit.Test;
import org.openqa.selenium.Keys;

import wdMethods.SeMethods;

public class CreateContactSeMethods extends SeMethods {
	
	@Test
	public void seMthodsCreateContact()
	{
		String fName ="Ravi",lName= "Anjan"; 
		
		startApp("chrome", "http://leaftaps.com/opentaps/control/main");
		
		type(locateElement("username"), "demosalesmanager");
		
		type(locateElement("password"),"crmsfa");
		
		click(locateElement("class", "decorativeSubmit"));
		
		click(locateElement("linktext", "CRM/SFA"));
		
		click(locateElement("linktext", "Create Contact"));
		
		type(locateElement("firstNameField"), fName);
		
		type(locateElement("lastNameField"), lName);
		
		type(locateElement("createContactForm_firstNameLocal"), "project");
		
		type(locateElement("createContactForm_lastNameLocal"), "day");
		
		type(locateElement("createContactForm_personalTitle"), "Mr");
		
		type(locateElement("createContactForm_generalProfTitle"), "Project day");
		
		type(locateElement("createContactForm_departmentName"), "Luna");
		
		selectDropDownUsingText(locateElement("createContactForm_preferredCurrencyUomId"), "INR - Indian Rupee");
		
		type(locateElement("createContactForm_description"), "proj day - Luna");
		
		type(locateElement("createContactForm_importantNote"), "Project day - luna-important note");
		
		type(locateElement("createContactForm_primaryPhoneAreaCode"), "600063");
		
		type(locateElement("createContactForm_primaryPhoneExtension"), "0001");
		
		type(locateElement("createContactForm_primaryEmail"), "u.raviprasanth@gmail.com");
		
		type(locateElement("createContactForm_primaryPhoneNumber"), "8015721179");
		
		type(locateElement("createContactForm_primaryPhoneAskForName"), "Someone");
		
		
		verifyPartialAttribute(locateElement("generalToNameField"),"value", (fName+" "+lName));
		
		String toName = returnAttribute(locateElement("generalToNameField"), "value");
		
		type(locateElement("createContactForm_generalAddress1"), "h405,tvs apartment");
		
		type(locateElement("createContactForm_generalCity"), "Chennai");
		
		type(locateElement("createContactForm_generalPostalCode"), "600062");
		
		type(locateElement("createContactForm_generalPostalCodeExt"), "0001");
		
		type(locateElement("createContactForm_generalAttnName"), "Test Leaf");
		
		type(locateElement("createContactForm_generalAddress2"), "Perungalathur");
		
		selectDropDownUsingText(locateElement("createContactForm_generalCountryGeoId"), "India");
		
		type(locateElement("createContactForm_generalCountryGeoId"),"Keys.TAB");
		
		selectDropDownUsingText(locateElement("createContactForm_generalStateProvinceGeoId"), "TAMILNADU");		
		
		click(locateElement("name", "submitButton"));
		
		verifyPartialText(locateElement("viewContact_fullName_sp"), toName);
		
		click(locateElement("linktext", "Edit"));
		
		selectDropDownUsingText(locateElement("addMarketingCampaignForm_marketingCampaignId"), "Car and Driver");
		
		String mrktSegValue = retrunFirstSelectedOption(locateElement("addMarketingCampaignForm_marketingCampaignId"));
		
		click(locateElement("xpath", "//input[@value='Add']"));
		
		click(locateElement("xpath", "//input[@value='Update']"));
		
		verifyPartialText(locateElement("viewContact_marketingCampaigns_sp"), mrktSegValue);
		
		closeAllBrowsers();
		
		
		
	}

}
