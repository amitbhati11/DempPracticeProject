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
		
		Wait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(  wait.until(ExpectedConditions.visibilityOf(logut)));
	}
	

}
