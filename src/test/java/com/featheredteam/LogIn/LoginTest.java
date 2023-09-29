/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.featheredteam.LogIn;

import static com.featheredteam.LogIn.AppTest.driver;
import java.awt.List;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
/**
 *
 * @author muham
 */
public class LoginTest {
    
        @Test
    public void ValidateWebsiteHeadingText(){
            WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
            Assert.assertTrue(title.getText().equals("Swag Labs") );
            System.out.println("Title: " + title.getText());
    }
    
    @Test
    public void AccessWithInValidUsername() throws InterruptedException{
        
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()=\"Accepted usernames are:\"]/following::br")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()=\"Password for all users:\"]/parent::div")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"user-name\"]")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"password\"]")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"login-button\"]")));
//        List<WebElement> userNames = driver.findElements(By.xpath("//h4[text()=\"Accepted usernames are:\"]/following::br"));
String[] allUserList = driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']/parent::div")).getText().toString().split("\n");
String[] passwordList = driver.findElement(By.xpath("//h4[text()='Password for all users:']/parent::div")).getText().toString().split("\n");
   System.out.println("User name is ***************** "+ allUserList[1]);
      System.out.println("Password is ***************** "+ passwordList[1]);

    WebElement userTextField = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
    WebElement passwordTextField = driver.findElement(By.xpath("//input[@id=\"password\"]"));
    WebElement logInBtn = driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
    
    userTextField.sendKeys(allUserList[1]);
    passwordTextField.sendKeys(passwordList[1]);
    logInBtn.click();
    
    Thread.sleep(3);
    String followingPageUrl = driver.getCurrentUrl();
       System.out.println("followingPageUrl ***************** "+ followingPageUrl);

    Assert.assertTrue(followingPageUrl.contains("inventory"));
    }
    
}
