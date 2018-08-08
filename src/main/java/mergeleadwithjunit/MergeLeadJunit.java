package mergeleadwithjunit;



import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wdMethods.Annotations;

public class MergeLeadJunit extends Annotations{

	@Test(groups= {"sanity"})
	public void mergeLead() throws InterruptedException {

		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUserName = locateElement("username");
		type(eleUserName, "demosalesmanager");
		WebElement elePass = locateElement("password");
		type(elePass, "crmsfa");
		//WebElement clickLogin = locateElement("class", "decorativeSubmit");
		click(locateElement("class", "decorativeSubmit"));

		click(locateElement("linktext", "CRM/SFA"));
		 	
		click(locateElement("linktext", "Create Lead"));

		click(locateElement("linktext", "Merge Leads"));

		String parentWindow = parentWindow();

		click(locateElement("xpath", "//input[@id='partyIdFrom']//following::img[1]"));

		switchToWindow(2);

		type(locateElement("name", "id"), "1035");

		click(locateElement("xpath", "//button[text()='Find Leads']"));

		clickNoSnap(locateElement("xpath", "//table[@class='x-grid3-row-table']//a"));

		switchToWindow(parentWindow);

		click(locateElement("xpath", "//input[@id='partyIdFrom']//following::img[2]"));

		switchToWindow(2);

		type(locateElement("name", "id"), "1045");

		click(locateElement("xpath", "//button[text()='Find Leads']"));

		clickNoSnap(locateElement("xpath", "//table[@class='x-grid3-row-table']//a"));

		switchToWindow(parentWindow);

		clickNoSnap(locateElement("linktext", "Merge"));

		acceptAlert();

//		closeAllBrowsers();
	}


}
