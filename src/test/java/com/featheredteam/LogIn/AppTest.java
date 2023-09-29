package com.featheredteam.LogIn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.*;
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
//              Assert.assertEquals(title.getText(), "Swag Labs");
              System.out.println("Title: "+ title.getText());
     
    }

    @AfterSuite
    public void closeDrivers(){
        driver.close();
    }

//    @Test
//    public void shouldAnswerWithTrueTest(){
//    WebDriverManager.chromedriver().setup();
//    driver = new ChromeDriver();
//    driver.manage().window().maximize();
//    driver.manage().deleteAllCookies();
//    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//    driver.get("https://www.saucedemo.com/");
//            WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
//            //   Assert.AssertTr(title.getText(), "Swag Labs");
//              System.out.println("Title: "+title.getText());
//      driver.close();
//    }

    // @Test
    // public void shouldAnswerWithTrueEventFiringTest(){
    // WebDriverManager.chromedriver().setup();
    // driver = new ChromeDriver();
    // driver.manage().window().maximize();
    // driver.manage().deleteAllCookies();
    // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    // EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
    // eventListener = new WebDriverEventListener() ;
    // eventHandler.register(eventListener);
    // eventHandler.get("https://www.saucedemo.com/");
    //         WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
    //           Assert.assertEquals(title.getText(), "Swag Labs");
    //           System.out.println("Title: "+title.getText());
    //   eventHandler.close();
    // }
//   @Test
//    public void robotTest() throws AWTException{
//    WebDriverManager.chromedriver().setup();
//    driver = new ChromeDriver();
//    driver.manage().window().maximize();
//    driver.manage().deleteAllCookies();
//    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//    driver.get("https://iteamsoft.github.io/");
//            //   Assert.AssertTr(title.getText(), "Swag Labs");
//            Robot robot = new Robot();
//            robot.mouseMove(100, 4);
//            
//      driver.close();
//    }
}
