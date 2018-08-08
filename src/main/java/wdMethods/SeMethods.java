package wdMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods extends Reporter implements WdMethods {
	public static RemoteWebDriver driver;
	Actions builder;

	int i = 1;

	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckoriver.exe");
				driver = new FirefoxDriver();
			}
			builder = new Actions(driver);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// System.out.println("The Browser "+browser+" is Launched Successfully");
			reportStep("The Browser " + browser + " is Launched Successfully", "Pass");

		} catch (WebDriverException e) {
			System.out.println("webdriver exception is handled");
			reportStep("webdriver exception is handled", "fail");
		} catch (Exception e) {
			System.out.println("Exception is executed");
		} finally {
			takeSnap("Browser opened");
		}
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case "id":
				return driver.findElementById(locValue);
			case "class":
				return driver.findElementByClassName(locValue);
			case "xpath":
				return driver.findElementByXPath(locValue);
			case "linktext":
				return driver.findElementByLinkText(locValue);
			case "name":
				return driver.findElementByName(locValue);
			}

		} catch (NoSuchElementException e) {
			System.out.println("No such element catch is executed");
			throw new NoSuchElementException(locValue + "Not found");
		} catch (NullPointerException e) {

			System.out.println("Null pointer exception");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Exception is executed");
			throw new NoSuchElementException(locValue + "Not found");
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			// System.out.println("The Data "+data+" is Entered Successfully");
			reportStep("The Data " + data + " is Entered Successfully", "Pass");
		} catch (NullPointerException e) {
			// System.out.println("Null pointer exception is executed");
			reportStep("Null pointer exception is executed", "Fail");
		} catch (Exception e) {
			System.out.println("Exception is executed");
		} finally {
			takeSnap("Input to the text box");
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			System.out.println("The Element " + ele + " is clicked Successfully");
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			takeSnap("clicked");
		}
	}

	public void clickNoSnap(WebElement ele) {

		try {
			ele.click();
			System.out.println("The Element " + ele + " is clicked Successfully");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public String getText(WebElement ele) {
		try {
			String text = ele.getText();
			// System.out.println("The text present : "+text);
			return text;
		} catch (Exception e) {
			System.out.println("Exception");
			throw new RuntimeException();
		}

	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			Select se = new Select(ele);
			se.selectByVisibleText(value);
//			WebElement firstSelectedOption = se.getFirstSelectedOption();
//			System.out.println("The selected option using value : "+firstSelectedOption.getText());
		} catch (NullPointerException e) {
			System.out.println("null pointer exception");
		} catch (Exception e) {
			System.out.println("Excpetion");
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select se = new Select(ele);
			se.selectByIndex(index);
//			WebElement firstSelectedOption = se.getFirstSelectedOption();
//			System.out.println("The selected option using index : "+firstSelectedOption.getText());
		} catch (NullPointerException e) {
			System.out.println("null pointer exception");
		} catch (Exception e) {
			System.out.println("Excpetion");
		}
	}

	public String retrunFirstSelectedOption(WebElement ele) {
		Select se = new Select(ele);
		WebElement firstSelectedOption = se.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}

	public boolean verifyTitle(String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			System.out.println("null pointer exception");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Excpetion");
			throw new RuntimeException();
		}
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if (getText(ele).equals(expectedText)) {
				System.out.println("Text matched");
			} else {
				System.out.println("Text is not matched");
			}
		} catch (NullPointerException e) {
			System.out.println("null pointer exception");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Excpetion");
			throw new RuntimeException();
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		System.out.println(expectedText + ": expectedText");
		try {
			if (getText(ele).contains(expectedText)) {
				System.out.println(
						"The text is partially matched. Please use verfiyExactText method to verify the exact text");
			} else {
				System.out.println("The text is not even matched partially " + ele.getText());
			}
		} catch (NullPointerException e) {
			System.out.println("null pointer exception");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Excpetion");
			throw new RuntimeException();
		}
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String expectedValue) {
		try {
			String actualAttributeValue = ele.getAttribute(attribute);
			if (actualAttributeValue.equals(expectedValue)) {
				System.out.println("Attributes matched");
			} else {
				System.out.println("Attributes is not matched");
			}
		} catch (NullPointerException e) {
			System.out.println("null pointer exception");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Excpetion");
			throw new RuntimeException();
		}

	}

	public String returnAttribute(WebElement ele, String attribute) {
		String text = ele.getAttribute(attribute);
		return text;
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {

		try {
			String actualAttributeValue = ele.getAttribute(attribute);
			if (actualAttributeValue.contains(value)) {
				System.out.println("Attributes partially matched");
			} else {
				System.out.println("Attributes is not matched");
			}
		} catch (NullPointerException e) {
			System.out.println("null pointer exception");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Excpetion");
			throw new RuntimeException();
		}

	}

	public void verifySelected(WebElement ele) {
		try {
			if (ele.isEnabled()) {
				System.out.println("Element is selected");
			} else {
				System.out.println("Element is not selected");
			}
		} catch (Exception e) {
			System.out.println("Excpetion");
		}
	}

	public void verifyDisplayed(WebElement ele) {

		try {
			if (ele.isDisplayed()) {
				System.out.println("Element is displayed");
			} else {
				System.out.println("Elelment is not displayed");
			}
		} catch (Exception e) {
			System.out.println("Exception is occured");
		}
	}

	public void switchToWindow(int index) {

		try {
			Set<String> allWindow = driver.getWindowHandles();
			List<String> cnvertedWindows = new ArrayList<String>();
			cnvertedWindows.addAll(allWindow);
			driver.switchTo().window(cnvertedWindows.get(index));
			System.out.println("window switched");
		} catch (NoSuchWindowException e) {
			System.out.println("No such window exceprion occured");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void switchToWindow(String window) {
		try {
			driver.switchTo().window(window);
			System.out.println("window switched");
		} catch (NoSuchWindowException e) {
			System.out.println("No such window exceprion occured");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("Frame switched");
		} catch (NoSuchFrameException e) {
			System.out.println("No such window exceprion occured");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void acceptAlert() throws NullPointerException {
		try {
			driver.switchTo().alert().accept();
			System.out.println("Alert accepted");
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is handled");
		} catch (UnhandledAlertException e) {
			System.out.println("Alert is not handled");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert is dismissed");
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is handled");
		} catch (UnhandledAlertException e) {
			System.out.println("Alert is not handled");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public String getAlertText() {
		try {
			String text = driver.switchTo().alert().getText();
			return text;
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is handled");
			return null;
		} catch (UnhandledAlertException e) {
			System.out.println("Alert is not handled");
			return null;
		} catch (Exception e) {
			System.out.println("Exception");
			return null;
		}
	}

	public void takeSnap(String args) {
		File src = driver.getScreenshotAs(OutputType.FILE);
		// File desc = new File("./snaps/img"+i+".png");
		File desc = new File("./snaps/" + args + i + ".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		driver.close();

	}

	public void closeAllBrowsers() {
		driver.quit();

	}

	@Override
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File desc = new File("./snaps/img" + i + ".png");
		// File desc = new File("./snaps/"+args+i+".png");
		try {
			FileUtils.copyFile(src, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	public String parentWindow() {
		try {
			String windowHandle = driver.getWindowHandle();
			return windowHandle;
		} catch (NoSuchWindowException e) {
			System.out.println("No such window exceprion occured");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("Exception");
			throw new RuntimeException();
		}
	}

	public void actionsMouseOver(WebElement ele) {
		builder.moveToElement(ele).perform();

	}

}