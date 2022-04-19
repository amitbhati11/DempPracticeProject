package TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	
	@FindBy(id="name")
	WebElement  usr_name;
	
	@FindBy(id="password")
	WebElement  us_pass;
	
	@FindBy(id="login")
	WebElement log_btn;
	
	
	
	//conublistructor
	
	public loginpage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void us_name(String username) {
		usr_name.sendKeys(username);
		
		}
	
	public void pasw(String pass) {
		
		us_pass.sendKeys(pass);
	}
	
	public void logbtn() {
		
		log_btn.click();
	}

}
