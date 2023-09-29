package com.featheredteam.LogIn;

import com.featheredteam.helper.ScreenShotGetter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



/**
 * Unit test for simple App.
 */
public class AppTest {

    /* there are 2 tests with the same Logic, but 
                the first is failed has @BeforeTest @AfterTest @Test annotations 
                  with org.openqa.selenium.NoSuchSessionException: invalid session id.
                  The Second is passed and has @Test annotation only.
                  */
    public static WebDriver driver;
    public static WebDriverEventListener eventListener;
@BeforeSuite
public void setUps(){
        System.out.println("Driver is started");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    System.out.println("Driver is Ready");
}

   
    @Test
    public void ValidateWebsiteHeadingText(){
            driver.get("https://www.saucedemo.com/");
            WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
            Assert.assertTrue(title.getText().equals("Swab Labs") );
            System.out.println("Title: " + title.getText());
    }

    @AfterSuite
    public void closeDrivers(){
        driver.close();
    }
    
    	// take screenshot when test case fail and add it in the Screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			ScreenShotGetter.captureScreenshot(driver, result.getName());
		}
	}

}