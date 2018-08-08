package createleadusingjunit;


import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import wdMethods.Annotations;
import wdMethods.SeMethods;

public class CreateLeadUsingJunit extends Annotations{
	@BeforeTest
	public void testData() {
		excelFileName = "CreateLead";
		testName= "Create Lead";
		testDesc="Createa  new lead";
		author="Ravi";
		category="smoke";
		moduleName = "Leads";
	}

	@Test(dataProvider="fetchdata")
	
	public void createLeadTest(String cname,String fname,String lname,String flocal,String phone) {
		
		click(locateElement("linktext", "Create Lead"));
		
		type(locateElement("createLeadForm_companyName"), cname);
		
		type(locateElement("createLeadForm_firstName"), fname);
		
		type(locateElement("createLeadForm_lastName"), lname);
		
		type(locateElement("name", "firstNameLocal"), flocal);
		
		type(locateElement("createLeadForm_primaryPhoneNumber"), phone);
			
		click(locateElement("class", "smallSubmit"));
	}
	

}
