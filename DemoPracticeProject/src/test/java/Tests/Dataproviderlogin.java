package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Excelutils.Exceldatademo;
import TestPages.homepage;
import TestPages.loginpage;


public class Dataproviderlogin {
	
	WebDriver driver;
	loginpage lgp;
	homepage  hpg;
	
	@Parameters("browser")
	@BeforeTest
	
	public void setup(String browser) {
		System.out.println("browser is:"+browser);
		
		if(browser.contains("Chrome")){
		String dpath="C:\\Users\\Admin_SRV\\git\\DempPracticeProject\\DemoPracticeProject\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",dpath);
		driver=new ChromeDriver();
		
	}	else if(browser.contains("Firefox")) {
		String gpath="C:\\Users\\Admin_SRV\\git\\DempPracticeProject\\DemoPracticeProject\\src\\test\\resources\\drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", gpath);
		driver=new FirefoxDriver();
		
	}
		
		
	}
	
	@DataProvider(name="datap")
	
	public Object [][] providedata() throws Exception{
		String xlpath="C:\\Users\\Admin_SRV\\git\\DempPracticeProject\\DemoPracticeProject\\src\\test\\resources\\datautils\\loginDataprovider.xlsx";
		String sheetname="Sheet1";
		
		Object data [][]=getdata(xlpath, sheetname);
		
		return data;
	}
	
	@Test(dataProvider="datap")
	
	public void finaldata(String username,String password,String id) throws InterruptedException {
		driver.get("https://example.testproject.io/web/");
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		lgp=new loginpage(driver);
		lgp.us_name(username);
		lgp.pasw(password);
		Thread.sleep(3000);
		lgp.logbtn();
		hpg=new homepage(driver);
		hpg.logoutbtn();
		Thread.sleep(2000);
		
		System.out.println(username+" | "+password+" | "+id);
		
		
	}
	
	
	public Object [][] getdata(String xlpath,String sheetname) throws Exception {
		Exceldatademo ed=new Exceldatademo(xlpath, sheetname);
		
	int Rownum=	ed.getrowcount();
	int Colnum=ed.getcellcount();
	
	  Object data [][]=new Object [Rownum-1][Colnum];
	  
	  for(int i=1;  i<Rownum;i++) {
		  
		  for(int j=0;j<Colnum;j++) {
			  
			data [i-1][j]=     ed.getcellstringdata(i, j);
			  
		  }
	  }return data;
	  
		
		
	}
	
	@AfterTest
	
	public void teardown() throws Exception {
	
		System.out.println("completed");
		driver.close();
		
		
	}

}
