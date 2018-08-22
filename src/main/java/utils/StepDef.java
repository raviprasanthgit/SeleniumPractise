package stepdefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import MongoDB.MongoDBConnectionManager;
import MongoDB.TestStatus;
import automationLib.Driver;
import automationLib.LaunchPega;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import extentmanager.ExtentManager;
import utils.BaseLogger;
import utils.CustomException;
import utils.ErrorLogger;
import utils.SeleniumCustomServlets;
import utils.SeleniumUtilities;
import utils.Utilities;

public class stepdefinition {

	ErrorLogger err=new ErrorLogger();
	//ErrorLogger err = new ErrorLogger();
	BaseLogger blogger = new BaseLogger();
	Date date = new Date();
	public static int executionTime;
	//TestStatus mongotest = new TestStatus();


	String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(date);
	public static String startTime, endtime;
	//MainDriverTest mdriver = new MainDriverTest();

	public  String name="";
	//public static ExtentReports reports = new ExtentReports();
	//public static ExtentReports tempreports = new ExtentReports();
	ExtentReports reports = ExtentManager.getInstance();
	TestStatus mongotest; 
	public static ExtentTest  logger;
	public static boolean isServicedown=false;	
	SeleniumUtilities utils ;
	Utilities comnutils;
	CustomException exptn;	
	WebDriver driver = Driver.getPgDriver();
	Actions action;	
	public static ArrayList<String> screenshotpath=new ArrayList<String>();
	DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	@Before
	public void before(Scenario scenario) throws Exception
	{
		System.out.println("Scenario ID " +scenario.getId());
		System.out.println("Scenario Name" +scenario.getName());

		String temp=scenario.getId().split(";")[1];


		Collection <String>  tagnames=scenario.getSourceTagNames();

		for(String iter : tagnames)
			//name= name+iter;	
			name=ExtentManager.getReportName();
		/* Commenting out mongo options till the real time report is setup
		mongotest= new TestStatus(name, "Running",System.getProperty("TEST_BUILD"));
		mongotest.updateBuild();
		mongotest.writenewBuild();
		 */
		//mongotest.setTestStatus("running");

		if (name.length()<1)
			name=temp.replaceAll("-"," ");				

		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		startTime = LocalDateTime.now().format(formatter);
		logger=reports.createTest(name,temp.replaceAll("-"," "));
		this.comnutils = new Utilities();
		String browser =  comnutils.getPropertyvalue("browser");
		String runtype = comnutils.getPropertyvalue("runtype");
		String ip = "Local";
		if (runtype.equalsIgnoreCase("Grid")){
			ip = comnutils.getPropertyvalue("ip");

		}

		Driver.setPgDriver(browser,runtype,ip);

		if (runtype.equalsIgnoreCase("Grid")){
			String scenarioID = scenario.getId(); 




			System.out.println("#SCENARIO#" + scenarioID + "#BEFORE# Scenario ID - " + scenario.getId());
			System.out.println("#SCENARIO#" + scenarioID + "#BEFORE# Scenario Name - " + scenario.getName());
			System.out.println("#SCENARIO#" + scenarioID + "#BEFORE# Scenario Status - " + scenario.getStatus());
		}

		//String ip = comnutils.getPropertyvalue("ip");


		LaunchPega lnchpega = new LaunchPega();
		//String env=comnutils.getPropertyvalue("environment");// System.getenv("env");
		String env = System.getProperty("TEST_ENVIRONMENT");
		try{ if(!env.equals(null)){
			System.out.println("From Bamboo Variable");
			lnchpega.launchPega(env);}
		else{
			System.out.println("if failed taking from property file");
			lnchpega.launchPega(comnutils.getPropertyvalue("environment"));  
		}  }catch(NullPointerException e)  {
			lnchpega.launchPega(comnutils.getPropertyvalue("environment"));
			//System.out.println("environemnet is not set in system environemnet as well as in property file");

			//lnchpega.launchPega(comnutils.getPropertyvalue("environment"));

		}   
		// Driver.openUAT();
		// this.action=new Actions(driver);

		ExtentManager.setTeststatus("Running");

		this.utils = new SeleniumUtilities();    
		this.action=new Actions(Driver.getPgDriver()); 
		//this.utils = new SeleniumUtilities();

		//finallogger=tempreports.createTest(name,temp.replaceAll("-"," "));
		isServicedown=false;
		executionTime=300;


	}


	@After
	public void afterScenario(Scenario scenario) {
		//utils.uploadResult();
		//reports.endTest(logger);
		//tempreports.flush();
		/*htmlReporter.setAppendExisting(true);
		htmlReporter = temphtmlReporter;
		reports.attachReporter(htmlReporter);*/

		/*
		if(mongotest.getTestStatus()=="Running")
			mongotest.setTestStatus("Pass");
		mongotest.updateTest();
		 */
		if(ExtentManager.getTeststatus()=="Running"){
			ExtentManager.setTeststatus("Pass");
			ExtentManager.setExecutionTime(executionTime);
		}
		reports.flush();	
		System.out.println("<BuildNumber>"+System.getProperty("TEST_BUILD")+"</BuildNumber>"
				+"<TestID>"+ExtentManager.getReportName()+"</TestID>"
				+"<TestStatus>"+ExtentManager.getTeststatus()+"</TestStatus>"+"<TestExecutionTime>"+executionTime+"</TestExecutionTime>"
				);

		String scenarioID = scenario.getId();  
		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Scenario ID - " + scenario.getId());
		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Scenario Name - " + scenario.getName());
		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Scenario Status - " + scenario.getStatus());

		Driver.getPgDriver().close();
		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Browser Closed.");

		Driver.getPgDriver().quit();
		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Driver Quit.");

		Driver.customServlet.terminatePirateProcess();
		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Process(s) terminated.");

		System.out.println("#SCENARIO# " + scenarioID + " #AFTER# Scenario execution is complete.");

		if(!(comnutils.getPropertyvalue("runtype").equals("API")))

		{

			Driver.getPgDriver().close();
			System.out.println("#SCENARIO#" + scenarioID + "#AFTER# Browser Closed.");

			Driver.getPgDriver().quit();
			System.out.println("#SCENARIO#" + scenarioID + "#AFTER# Driver Quit.");

			Driver.customServlet.terminatePirateProcess();
			System.out.println("#SCENARIO#" + scenarioID + "#AFTER# Process(s) terminated.");

			/*try{

		Runtime.getRuntime().exec("taskkill /im iexplore.exe /f");
		System.out.println("Kiiled the iexplore");
		}
		catch(Exception e){

			e.printStackTrace();
		}*/
			//MongoDBConnectionManager.closeMongoClient();


			endtime = LocalDateTime.now().format(formatter);

			System.out.println("#AFTER SCENARIO#" + scenarioID + "# Scenario execution is complete.");
		}
	}
	/*@Given("^The application is opened on the browser$")
	public void the_application_is_opened_on_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions	
//		 automationLib.Driver d=new automationLib.Driver();
//		d.setPgDriver("ie","Local","ip");
        this.utils = new SeleniumUtilities();    
        this.action=new Actions(Driver.getPgDriver());              
//               //d.openSIT();
//               d.openUAT();
//		//logger=reports.startTest(name);	
//              logger=reports.createTest(name);

	}*/


	public String takescreenshot(String methodname,String classname) {

		String loc=null;

		try{
			if(screenshotpath.size()==0) screenshotpath.add("Header");

			//int TCloop=MainDriver.loopvar;
			String currentpage,currentaction;
			//String currenttestcase="TC_"+count;
			//String currenttestcase=MainDriver.testcases.get(1),currentpage,currentaction;

			String currenttestcase = name;

			String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
			currentpage = classname;
			currentaction = methodname;

			// Screen shot taken 
			File scrFile = ((TakesScreenshot)Driver.pgDriver).getScreenshotAs(OutputType.FILE);

			String reportName = System.getProperty("TEST_EXECUTION_REPORT");
			String buildNumber = System.getProperty("TEST_BUILD");
			String reportLocation = System.getProperty("user.dir");

			try{
				if (!reportName.isEmpty() && !buildNumber.isEmpty()) {
					reportLocation = reportLocation + "//TestExecutionRecords//" + buildNumber;
					FileUtils.copyFile(scrFile, new File(reportLocation + "/Screenshots/" /*+currenttestcase+"_"*/ + currentpage + "_" + currentaction + "_" + timeStamp + ".png")); 
					loc = "../../" + buildNumber + "/Screenshots/" /*+currenttestcase+"_"*/ + currentpage + "_" + currentaction + "_" + timeStamp + ".png";
				} else {
					reportLocation = "C://SolutionCentralEngine";
					FileUtils.copyFile(scrFile, new File(reportLocation + "/Screenshots/" /*+currenttestcase+"_"*/ + currentpage + "_" + currentaction + "_" + timeStamp + ".png")); 
					loc = "../Screenshots/" /*+currenttestcase+"_"*/ + currentpage + "_" + currentaction + "_" + timeStamp + ".png";
				}
			} catch (NullPointerException e) {
				reportLocation = "C://SolutionCentralEngine";
				//reportLocation="C://SolutionCentralEngine//Screenshots";
				FileUtils.copyFile(scrFile, new File(reportLocation + "/Screenshots/" /*+currenttestcase+"_"*/ + currentpage + "_" + currentaction + "_" + timeStamp + ".png")); 
				loc = "../Screenshots/" /*+currenttestcase+"_"*/ + currentpage + "_" + currentaction + "_" + timeStamp + ".png";
			}

		} catch (Exception e) {
			System.out.println("Not able to take screen shot due to " + e);
			err.logError(e, methodname);
			Driver.customServlet.terminatePirateProcess();
			System.out.println("#takescreenshot# Process terminated.");
		}

		return loc;
	}



	@When("^(.*) \"([^\"]*)\" ((?!data).)* \"([^\"]*)\"(.*)$")
	//And I call the "createNewInteractionResearchmember" method on the "Header" page
	public void executeMethod(String whatever,String methodname,String Whtever,String classname,String whtever)  throws Throwable{
		String imagepath;
		//logger.log(LogStatus.INFO, "Executing the "+methodname+" method on the "+classname+" page");
		System.out.println(" without data");
		if( !utils.executeMethod("automationLib."+classname, methodname))
		{

			imagepath=takescreenshot(methodname,classname);
			//logger.log(LogStatus.INFO, methodname, logger.addScreenCapture(imagepath));
			if (imagepath!=null)
				logger.info(whatever+methodname.substring(0),MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
			//throw new CustomException(err.getErrormessage(),reports,logger,mongotest);
			if(!isServicedown)
				utils.isServiceDown();
			if(!isServicedown)	
				throw new CustomException(err.getErrormessage(),reports,logger,mongotest);
			else{
				logger.warning(extentmanager.ExtentManager.getTeststatus());
				throw new PendingException();
			}



		}
		else
		{
			imagepath=takescreenshot(methodname,classname);
			//logger.log(LogStatus.INFO, methodname, logger.addScreenCapture(imagepath));
			//logger.addScreenCapture(imagepath);
			//logger.log(LogStatus.PASS, classname,classname+" step passed on the page "+classname);
			if (imagepath!=null)
				logger.pass(whatever+methodname.substring(0),MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
			//logger.log(LogStatus.PASS, classname,classname+" step passed on the page "+classname);
			else
				logger.pass(whatever+methodname.substring(0, methodname.indexOf("..."))+"passed");
		}	

	}

	@When("^(.*) \"([^\"]*)\" (.*data) \\(([^\"]*)\\) (.*) \"([^\"]*)\"(.*)$")
	public void executeMethod(String whatever, String methodname,String wteverbeforedata,String  arlistconvert,String wtverbeforepage,String classname,String whatevaftrpage) throws IOException,Throwable  {
		String imagepath;
		//logger.log(LogStatus.INFO, "Started with"+methodname);
		System.out.println("Data");
		String[] arlist=arlistconvert.split(",");
		//String[] arlist=arlistconvert.split(",");
		if(methodname.toLowerCase().equalsIgnoreCase("LaunchSolutionCentral"))
		{
			System.out.println("Skipping Launch Solution Central");
		}
		// }
		else

		{

			if( !utils.executeMethod("automationLib."+classname, methodname, arlist))
			{
				imagepath=takescreenshot(methodname,classname);
				//logger.log(LogStatus.INFO, methodname, logger.addScreenCapture(imagepath));
				if (imagepath!=null)
					logger.info(whatever+arlistconvert+methodname.substring(0),MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
				if(!isServicedown)
					utils.isServiceDown();
				if(!isServicedown)	
					throw new CustomException(err.getErrormessage(),reports,logger,mongotest);
				else{
					logger.warning(extentmanager.ExtentManager.getTeststatus());
					throw new PendingException();
				}

			}
			else
			{
				imagepath=takescreenshot(methodname,classname);
				//logger.log(LogStatus.INFO, methodname, logger.addScreenCapture(imagepath));
				//logger.log(LogStatus.PASS, classname,classname+" step passed on the page "+classname);
				if (imagepath!=null)
					logger.pass(whatever+arlistconvert+methodname.substring(0),MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
				//logger.log(LogStatus.PASS, classname,classname+" step passed on the page "+classname);
				else
					logger.pass(whatever+arlistconvert+methodname.substring(0, methodname.indexOf("..."))+"passed");
			}


		}
	}




	//Phase 2 work in progress
	@When("(.*data) \\(([^\"]*)\\)([^.*:)\"]*)([^\"]*)$")
	//@When("^([^\"]*)(.*data) \\(([^\"]*)\\)([^.*:)\"]*)([^\"]*)$")
	//(username,password,key1:value1;key2:value2,dropdown)
	public void execute(String wtver,String arlistconvert, String wat,String methodname) throws Exception{

		System.out.println("Entry");
		//Driver.setPgDriver("ie");
		//Driver.openSIT();
		String imagepath;		
		String[] arlist=arlistconvert.split(",");
		//String[] arlist=arlistconvert.split(",");
		//String page = methodname.substring(0, methodname.indexOf(":"));
		String page = methodname.substring(methodname.indexOf("...")+3, methodname.indexOf(":"));
		String method = methodname.substring(methodname.indexOf(":")+1);
		System.out.println("Page: " + page + "method: " + method);
		this.utils = new SeleniumUtilities();
		this.action=new Actions(Driver.getPgDriver());
		if( !utils.executeMethod("automationLib."+page, method, arlist))
		{
			imagepath=takescreenshot(method,page);

			//logger.log(LogStatus.FAIL, wtver+arlistconvert+methodname.substring(0, methodname.indexOf("...")), logger.addScreenCapture(imagepath));
			if (imagepath!=null)
				logger.info(wtver+arlistconvert+methodname.substring(0, methodname.indexOf("...")),MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
			//throw new CustomException(err.getErrormessage(),reports,logger,mongotest);
			if(!isServicedown)
				utils.isServiceDown();
			if(!isServicedown)	
				throw new CustomException(err.getErrormessage(),reports,logger,mongotest);
			else{
				logger.warning(extentmanager.ExtentManager.getTeststatus());
				throw new PendingException();
			}

		}
		else
		{
			imagepath=takescreenshot(method,page);
			if (imagepath!=null)
				logger.pass(wtver+arlistconvert+methodname.substring(0, methodname.indexOf("...")),MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
			//logger.log(LogStatus.PASS, classname,classname+" step passed on the page "+classname);
			else
				logger.pass(wtver+arlistconvert+methodname.substring(0, methodname.indexOf("..."))+"passed");
		}

		/*try{
		utils.executeMethod("automationLib."+page, method, arlist);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		 */
	}

	//@When("^([^\"]*) ([:]*)$")
	//@When("^([^\"]*) ([:]*)([^\"]*)$")
	//@When("(.*data)([^.*:)\"]*)([^\"]*)$")
	//@When("/^((?!data).)*$/ ([^.*:)\"]*)([^\"]*)$")
	@When("^([^\"\\(]*)$")
	//@When("^([^\"\\(]*) ([^.*:)\"]*)([^\"]*)$")
	//@When("(.*:)([^\"]*)$")
	public void execute(String methodname) throws Exception{

		if(methodname.contains("application is opened"))
		{
			System.out.println("Skipping application is opened on the browser"); 
		}else if(methodname.contains("testcase is passed"))
		{
			System.out.println("Testcase passed");
		}
		else{
			System.out.println("Entry new");
			String page = methodname.substring(methodname.indexOf("...")+3, methodname.indexOf(":"));
			String method = methodname.substring(methodname.indexOf(":")+1);
			String imagepath;
			System.out.println("Page " + page + "method  " + method);
			this.utils = new SeleniumUtilities();
			this.action=new Actions(Driver.getPgDriver());
			if( !utils.executeMethod("automationLib."+page, method))
			{

				imagepath=takescreenshot(method,page);

				if (imagepath!=null)
					//logger.log(LogStatus.FAIL, methodname.substring(0, methodname.indexOf("...")), logger.addScreenCapture(imagepath));
					logger.info(methodname.substring(0, methodname.indexOf("...")),MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());

				//throw new CustomException(err.getErrormessage(),reports,logger,mongotest);
				if(!isServicedown)
					utils.isServiceDown();
				if(!isServicedown)	
					throw new CustomException(err.getErrormessage(),reports,logger,mongotest);
				else{
					logger.warning(extentmanager.ExtentManager.getTeststatus());
					throw new PendingException();
				}

			}
			else
			{
				imagepath=takescreenshot(method,page);
				//logger.log(LogStatus.INFO, methodname.substring(0, methodname.indexOf("...")), logger.addScreenCapture(imagepath));
				if (imagepath!=null)
					logger.pass(methodname.substring(0, methodname.indexOf("...")),MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
				//logger.log(LogStatus.PASS, classname,classname+" step passed on the page "+classname);
				else
					logger.pass(methodname.substring(0, methodname.indexOf("..."))+"passed");
			}
		}


		/*try{
		utils.executeMethod("automationLib."+page, method);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		 */
	}

	@Then("^I navigate to home page$")
	public void i_navigate_to_home_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}


	/*@Then("^the testcase is passed$")
	public void TestCase_Is_Passed() throws Throwable {
//		logger.pass("Test Case passed");
//		//reports.endTest(logger);
//		reports.flush();
//		Driver.getPgDriver().close();
//		Driver.getPgDriver().quit();
//	    System.out.println("TestCase successfully passed");
//	    endtime = LocalDateTime.now().format(formatter);
	    //SeleniumUtilities.setResultInJira(startTime, endtime, "CCTSUSTAIN-9392", true);
	    //utils.uploadResult();
	}*/

	@When("I click the element \"([^\"]*)\" on the \"([^\"]*)\" page")
	public void clickAnelemnt(String elename,String pgname) throws Exception
	{
		System.out.println("Entered the when click");
		if(!utils.clickAnelemnt(utils.returnWebelement(pgname, elename), pgname, elename))
			throw new CustomException(err.getErrormessage(),reports,logger);

		takescreenshot(pgname,elename);
	}

	@When("^I enter text \"([^\"]*)\" in \"([^\"]*)\" on the \"([^\"]*)\" page$")
	public void entertextinAnelemnt(String input,String elename,String pgname) throws Exception
	{

		if(! utils.enterTextinAnelemnt(utils.returnWebelement(pgname, elename), input,pgname, elename))
			throw new CustomException(err.getErrormessage(),reports,logger);
		takescreenshot(pgname,elename);
	}


	@When("^I validate the data \"([^\"]*)\" matches with value on the Element \"([^\"]*)\" on the \"([^\"]*)\" page$")
	public void validateDatainAelement(String value,String elename,String pgname) throws Exception
	{

		if(!utils.validateValueinelement(utils.returnWebelement(pgname, elename), value,pgname, elename))
			throw new CustomException(err.getErrormessage(),reports,logger);
		takescreenshot(pgname,elename);
	}
	public boolean isProxyWebelement(WebElement element) {
		if(element.toString().contains("Proxy")){
			return true;
		}

		else{
			return false;
		}
	}

	@When("^I select the value \"([^\"]*)\" on the Element \"([^\"]*)\" on the \"([^\"]*)\" page$")
	public void SelectDatainAelement(String value,String elename,String pgname) throws Exception
	{

		if(!utils.selectDropDownbyVisibleString(utils.returnWebelement(pgname, elename), value,pgname, elename))
			throw new CustomException(err.getErrormessage(),reports,logger);
		takescreenshot(pgname,elename);
	}

	@When("^I press the \"([^\"]*)\" key on the Element \"([^\"]*)\" on the \"([^\"]*)\" page$")
	public void PressKeyonAelement(String value,String elename,String pgname) throws Exception
	{

		if(!utils.pressEnter(utils.returnWebelement(pgname, elename),pgname, elename))
			throw new CustomException(err.getErrormessage(),reports,logger);
		takescreenshot(pgname,elename);
	}

	@When("^I click on the table \"([^\"]*)\" on the position \"([^\"]*)\" on the \"([^\"]*)\" page$")
	public void ClickonTableposition(String elename,String position,String pgname) throws Exception
	{
		String[] positionsplit=position.split(",");	
		if(!utils.clickontablebasedonrowandcolumn(utils.returnWebelement(pgname, elename),Integer.parseInt(positionsplit[0]),Integer.parseInt( positionsplit[1])))
			throw new CustomException(err.getErrormessage(),reports,logger);
		takescreenshot(pgname,elename);
	}
	@When("^I click on the row with value \"([^\"]*)\" on the table \"([^\"]*)\" on the \"([^\"]*)\" page$")	
	public void Clickonrowbasedonvalue(String value,String elename,String pgname) throws Exception
	{
		if(!utils.clickontablerowbasedonvalues(utils.returnWebelement(pgname, elename), value))
			throw new CustomException(err.getErrormessage(),reports,logger);
		takescreenshot(pgname,elename);
	}

	@Then("^just for test$")
	public void justfortest()	{
		System.out.println("Testing");
	}

}
