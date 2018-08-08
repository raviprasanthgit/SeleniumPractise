package pageobjectmodel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class TestCase_CreateLead extends Annotations {

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
		
		new MyHome()
		.clickLeads()
		.clickCreateLead()
		.typeCName(cname)
		.typeFName(fname)
		.typeLName(lname)
		.typeFNameLocal(flocal)
		.typePhNo(phone)
		.clickCreateLead()
		.verifyFname(fname);
	}
}