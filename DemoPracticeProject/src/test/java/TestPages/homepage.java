package TestPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class homepage {
	WebDriver driver;
	
	@FindBy(id="logout")
	WebElement logut;
	
	//Constructor
	
	public homepage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void logoutbtn() {
		
	//fluentwait
		
		logut.isDisplayed();
	}
	

}
