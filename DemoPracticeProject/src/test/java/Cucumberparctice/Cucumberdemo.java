package Cucumberparctice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestPages.loginpage;
import io.cucumber.java.en.*;

public class Cucumberdemo {
WebDriver driver;
loginpage lgnpage;
	
	@Given("open the browser")
	public void open_the_browser() {
	   String dpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\DemoPracticeProject\\src\\test\\resources\\drivers\\chromedriver.exe";
	   System.setProperty("webdriver.chrome.driver",dpath);
	   driver=new ChromeDriver();
	} 

	@And("enter the URL")
	public void enter_the_url() {
		
		driver.get("https://example.testproject.io/web/");

		driver.manage().window().maximize();
	
	}

	@When("^enter the (.*) and (.*)$")
	public void enter_the_username_and_password(String username,String password) throws Exception {
      lgnpage=new loginpage(driver);
      lgnpage.us_name(username);
      Thread.sleep(2000);
      lgnpage.pasw(password);
      Thread.sleep(2000);
		
	}

	@And("Click on loginbutton")
	public void click_on_loginbutton() throws Exception {
		 lgnpage=new loginpage(driver);
		 lgnpage.logbtn();
Thread.sleep(2000);
	
	}

	@Then("navigate to home page")
	public void navigate_to_home_page() {

		driver.close();
	
	}

}
