package steps.implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wdMethods.Annotations;

public class ViewLead extends Annotations{
	
	public  ViewLead() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleFNameText;
	
	public ViewLead verifyFname(String expText)
	{
		verifyExactText(eleFNameText, expText);
		return this;
	}
	
}
