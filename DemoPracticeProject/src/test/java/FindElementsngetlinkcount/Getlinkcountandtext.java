package FindElementsngetlinkcount;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Getlinkcountandtext {
	WebDriver driver;
	
	@BeforeTest
	
	public void setup() {
		String dpath="C:\\Users\\Admin_SRV\\git\\DempPracticeProject\\DemoPracticeProject\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",dpath);
		
		driver=new ChromeDriver();
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	//	driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	@Test
	
	public void test() {
		
		driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
		//1.to getall link on the page
		//2. to get text for each link
		
	List <WebElement > list=	driver.findElements(By.tagName("a"));
	 list.size();
	System.out.println(list.size());
	
	for(int i=0;i<list.size();i++) {

		String listtext=list.get(i).getText();
		System.out.println(listtext);
		
	}
	
		
		
	}
	
	@AfterTest
	
	public void teardown() {
		
		driver.close();
	}

}
