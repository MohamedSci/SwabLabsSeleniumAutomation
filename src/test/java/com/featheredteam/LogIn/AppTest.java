package com.featheredteam.LogIn;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static ChromeDriver driver;
    
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
    driver.navigate().to("https://www.saucedemo.com/");
        // try {
            WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
              Assert.assertEquals(title.getText(), "Swag Labs");
              System.out.println("Title: "+title.getText());
        // } catch (Exception e) {
        //    System.out.println("shouldAnswerWithTrue Exception :  "+e.getMessage());
        // }
      driver.close();
    }



}
