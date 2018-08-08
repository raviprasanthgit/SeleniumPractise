package tablelearning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableLearning {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\TestLeaf\\drivers-20180617T030731Z-001\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement table = driver.findElementByXPath("//div[@id='contentblock']//table");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int sizeRows = rows.size();
		System.out.println("Rows : "+sizeRows);
		WebElement tableCol = driver.findElementByXPath("//div[@id='contentblock']//table//tr[2]");
		List<WebElement> cols = tableCol.findElements(By.tagName("td"));
		System.out.println("Cols : "+cols.size());
		WebElement progress = driver.findElementByXPath("//div[@id='contentblock']//table//tr[3]/td[2]");
		System.out.println("progress of learn to interact : "+progress.getText());
	}

}
