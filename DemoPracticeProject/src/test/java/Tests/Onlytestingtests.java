package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestPages.OnlyTestingpage;

public class Onlytestingtests {
	WebDriver driver;
	OnlyTestingpage onp;
	@BeforeTest
	
	public void setup() {
		String cpath="C:\\Users\\Admin_SRV\\git\\DempPracticeProject\\DemoPracticeProject\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", cpath);
		driver=new ChromeDriver();
	}
	@Test
	
	public void testexecution() {
		driver.get("http://only-testing-blog.blogspot.com/");
		onp=new OnlyTestingpage(driver);
		onp.testpagetitiel();
		onp.framedisplayed();
		onp.namefeild();
		onp.overperform();
		
		
	}
	
	@AfterTest
	
	public void teardown() {
		System.out.println("Completed");
		driver.close();
		
	}

}
