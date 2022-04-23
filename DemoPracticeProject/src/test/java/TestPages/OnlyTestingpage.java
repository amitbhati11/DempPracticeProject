package TestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlyTestingpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//h1[contains(text(),'Only Testing')]")
	WebElement pagetitle;
	
	@FindBy(xpath="//a[contains(text(),'Tooltip')]")
	WebElement tooltip;
	
	@FindBy(xpath="//a[contains(text(),'Hover over me')]")
	WebElement mouseover;
	
	@FindBy(xpath="//input[@id='tooltip-1']")
	WebElement entername;
	
	@FindBy(xpath="//a[contains(text(),'iframe1')]")
	WebElement iframe1;
	
	@FindBy(xpath="//h1[contains(text(),'Only Testing') and @xpath='1']")
	WebElement title;
			
	@FindBy(xpath="//a[contains(text(),'Only Testing') and @xpath='1']")
	WebElement frmtitle;
	
	public OnlyTestingpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	
	public void testpagetitiel() {
		pagetitle.isDisplayed();
		title.isDisplayed();
		frmtitle.isDisplayed();
		
	}
	
	public void overperform() {
		mouseover.isDisplayed();
		tooltip.isDisplayed();
		
		
	}
	public void framedisplayed() {
		
		iframe1.isDisplayed();
	}
	public void namefeild() {
		
		entername.sendKeys("amit");
	}

}
