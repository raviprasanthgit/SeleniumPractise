package week2.day1.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IrctcAutomation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\TestLeaf\\drivers-20180617T030731Z-001\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement uName = driver.findElementById("userRegistrationForm:userName");
		WebElement password = driver.findElementById("userRegistrationForm:password");
		WebElement cPassword = driver.findElementById("userRegistrationForm:confpasword");
		WebElement secQues = driver.findElementById("userRegistrationForm:securityQ");
		WebElement secAns = driver.findElementById("userRegistrationForm:securityAnswer");
		WebElement fName = driver.findElementById("userRegistrationForm:firstName");
		WebElement gender = driver.findElementByName("userRegistrationForm:gender");
		WebElement mStatus = driver.findElementByName("userRegistrationForm:maritalStatus");
		WebElement day = driver.findElementById("userRegistrationForm:dobDay");
		WebElement month = driver.findElementById("userRegistrationForm:dobMonth");
		WebElement year = driver.findElementById("userRegistrationForm:dateOfBirth");
		WebElement occ = driver.findElementById("userRegistrationForm:occupation");
		WebElement country = driver.findElementById("userRegistrationForm:countries");
		WebElement eMail = driver.findElementById("userRegistrationForm:email");
		WebElement extn = driver.findElementById("userRegistrationForm:isdCode");
		WebElement mobNo = driver.findElementById("userRegistrationForm:mobile");
		WebElement nationality = driver.findElementById("userRegistrationForm:nationalityId");
		WebElement addr = driver.findElementById("userRegistrationForm:address");
		WebElement pinCode = driver.findElementById("userRegistrationForm:pincode");
		WebElement city = driver.findElementById("userRegistrationForm:cityName");
		WebElement postOffice = driver.findElementById("userRegistrationForm:postofficeName");
		WebElement phone = driver.findElementById("userRegistrationForm:landline");
		
		/*uName.sendKeys("raviprasanth94");
		password.sendKeys("test");
		cPassword.sendKeys("test");
		Select secDrp = new Select(secQues);
		secDrp.selectByIndex(1);
		secAns.sendKeys("Test");
		fName.sendKeys("Ravi");
		gender.click();
		mStatus.click();
		Select dayDrp = new Select(day);
		dayDrp.selectByValue("21");
		Select monthDrp = new Select(month);
		monthDrp.selectByValue("01");
		Select yrDrp = new Select(year);
		yrDrp.selectByValue("1994");
		Select occDrp=new Select(occ);
		occDrp.selectByValue("2");*/
//		Select coutryDrp=new Select(country);
//		coutryDrp.selectByValue("94");
	/*	eMail.sendKeys("Test@gmail.com");
		//extn.sendKeys("91");
		mobNo.sendKeys("8015721179");
		Select natDrp=new Select(nationality);
		natDrp.selectByValue("94");
		addr.sendKeys("test1");
		Thread.sleep(3000);
		pinCode.sendKeys("600063",Keys.TAB);
		Thread.sleep(10000);
		Select citytDrp=new Select(city);
		List<WebElement> options = citytDrp.getOptions();
		int size = options.size();
		citytDrp.selectByValue("Kanchipuram");
		Thread.sleep(5000);
		Select postDrp=new Select(postOffice);
		List<WebElement> options1 = postDrp.getOptions();
		int size1 = options1.size();
		postDrp.selectByValue("Old Perungalathur B.O");
		phone.sendKeys("0446485213");*/
		
		//Selecting second E
		Select coutryDrp=new Select(country);
		ArrayList<String> name = new ArrayList<String>();
		List<WebElement> optionsCountry = coutryDrp.getOptions();
		
		for (WebElement letter : optionsCountry)
		{
			if(letter.getText().charAt(0)=='E')
			{
				System.out.println(letter.getText());
				name.add(letter.getText());
			}
		}	
		String countryNmae = name.get(1);
		coutryDrp.selectByVisibleText(countryNmae);
	}
}