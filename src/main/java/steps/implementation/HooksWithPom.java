package steps.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.Result.Type;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import wdMethods.Annotations;
import wdMethods.SeMethods;

public class HooksWithPom extends Annotations {
	
	@Before
	public void before(Scenario sc)
	{
		beginResult();
		startTest(sc.getName(), sc.getId());
		startTestIteration("Create Lead", "Ravi", "Smoke");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
	}
	
	@After
	public void after(Scenario sc)
	{
		driver.quit();
		endResult();
	}
		
	

}
