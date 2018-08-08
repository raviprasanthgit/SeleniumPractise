package reportsandexcel;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import wdMethods.SeMethods;

public class CreateLeadIWithReports extends SeMethods{
	
	@Test
	public void createLeadTest() {
		
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("username");
		type(eleUserName, "demosalesmanager");
		WebElement elePass = locateElement("password");
		type(elePass, "crmsfa");
		//WebElement clickLogin = locateElement("class", "decorativeSubmit");
		click(locateElement("class", "decorativeSubmit"));
		
		click(locateElement("linktext", "CRM/SFA"));
		
		click(locateElement("linktext", "Create Lead"));
		
		type(locateElement("createLeadForm_companyName"), "Test Leaf");
		
		type(locateElement("createLeadForm_firstName"), "Test Leaf");
		
		type(locateElement("createLeadForm_lastName"), "Test Leaf");
		
		
		
		click(locateElement("class", "smallSubmit"));
	}
	

}
