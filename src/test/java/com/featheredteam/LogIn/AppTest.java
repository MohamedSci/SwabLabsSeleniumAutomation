package com.featheredteam.LogIn;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

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
    
@BeforeTest
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
    public void shouldAnswerWithTrue(){
            driver.get("https://www.saucedemo.com/");
            WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
              Assert.assertEquals(title.getText(), "Swag Labs");
              System.out.println("Title: "+ title.getText());
     
    }

    @AfterTest
    public void closeDrivers(){
        driver.close();
    }

    @Test
    public void shouldAnswerWithTrueTest(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.get("https://www.saucedemo.com/");
            WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
              Assert.assertEquals(title.getText(), "Swag Labs");
              System.out.println("Title: "+title.getText());
      driver.close();
    }



}
