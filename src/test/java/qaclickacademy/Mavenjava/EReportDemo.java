package qaclickacademy.Mavenjava;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EReportDemo {

	ExtentReports extent;

	@BeforeTest

	public void config()

	{
		// Extent Report and ExtentSparkReporter these 2 classes are very helpful in
		// generate the reports

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		// ExtentSparkReporter is a helper class which helps to create some
		// configuration and that will finally report to main class
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		// if you want to change your report name modify with the help of reporter above
		// object

		reporter.config().setReportName("Web Automation Results");

		// if you want change/modify the document tittle with the help of above reporter
		// object
		reporter.config().setDocumentTitle("Test Results");

		// reporter object is created that holds some results
		// this is our main class which is responsible to drive all ur reporting
		// execution
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahulshetty");

	}

	@Test
	public void InitaialDemo()

	{
		// creat one new test in the reporting file
		
		//once you create test and thats it automatically will keep on monitering the result status of this if it works that will go back update this results does pass or if it fail extent mark itt has fail
		//this step is mandtary for every test
		extent.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		extent.flush();
		//this will help you notified to you test is done and this step is mandatory to add at the end of your complete execution
		
	}

}
