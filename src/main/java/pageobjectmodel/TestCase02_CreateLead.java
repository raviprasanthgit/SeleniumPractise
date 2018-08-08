package pageobjectmodel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class TestCase02_CreateLead extends Annotations {

	@BeforeTest
	public void testData() {
		excelFileName = "CreateLead_Neg";
		testName= "Create Lead Negative";
		testDesc="Create a  new lead";
		author="Naveen";
		category="sanity";
		moduleName = "Negatve leads";
	}

	@Test(dataProvider="fetchdata")

	public void createLeadTest(String cname,String fname,String lname,String flocal,String phone,String erroMsg) {
		
		new MyHome()
		.clickLeads()
		.clickCreateLead()
		.typeCName(cname)
		.typeFName(fname)
		.typeFNameLocal(flocal)
		.typeLName(lname)
		.typePhNo(phone)
		.clickCreateLeadNeg()
		.errorMessage(erroMsg);
		
	}
}