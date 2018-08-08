package dataprovider;

import org.testng.annotations.Test;

import wdMethods.Annotations;

public class EditLead extends Annotations {
//	@Test(invocationCount=2)
//	@Test(dependsOnMethods= {"week2.day2.homework.CreateLead.createLead"})
	@Test(groups= {"smoke"})
	public void editLead() 
	{
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("firstName").sendKeys("Ravi");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
//		driver.findElementByXPath("//span[text()='Lead List']//following::table[2]//div//a[1]").click();
	}
}
		