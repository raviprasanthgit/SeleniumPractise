package auiandexceptions;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import wdMethods.SeMethods;

public class AdvancedUserInterface extends SeMethods {
	//WebDriver driver;
	
//		@Test
		public void dragAndDrop() {
		
		startApp("chrome", "http://jqueryui.com/");
		
		click(locateElement("linktext", "Droppable"));
		
		WebElement frame = locateElement("class", "demo-frame");
		
		switchToFrame(frame);
		
		WebElement draggable = locateElement("draggable");
		
		WebElement droppable = locateElement("droppable");
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggable, droppable).perform();
		
	}
//	@Test
	public void sortable()
	{
		startApp("chrome", "http://jqueryui.com/");
		
		click(locateElement("linktext", "Sortable"));
		
		WebElement frame = locateElement("class", "demo-frame");
		
		switchToFrame(frame);
		
		WebElement item1 = locateElement("xpath", "//ul[@id='sortable']/li[1]");
		
		WebElement item4 = locateElement("xpath", "//ul[@id='sortable']/li[4]");
		
		int x = item4.getLocation().getX();
		
		int y = item4.getLocation().getY();
	
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(item1, x, y).perform();
		
		System.out.println("Item sorted");
		
	}

	@Test
	public void moveToElement() {
		
		startApp("chrome", "https://www.flipkart.com/");
		
		click(locateElement("xpath", "//button[text()='✕']"));
		
		Actions builder = new Actions(driver);
		builder.contextClick().perform();
		
		builder.sendKeys(Keys.ARROW_DOWN).perform();;
		
		
//		WebElement eleElectronics = locateElement("xpath", "//span[text()='Electronics']");
//		
//		WebElement elePowerBanks = locateElement("xpath", "//span[text()='Power Banks']");
//		
//		
//		builder.moveToElement(eleElectronics).pause(2000).click(elePowerBanks).perform();
//		
//		builder.
//		
	}
	
}
