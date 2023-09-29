/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.featheredteam.LogInTest;

import static com.featheredteam.LogInTest.AppTest.driver;
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
LoginPageLoad();

   System.out.println("Valid User name is ***************** "+ getAllUserList()[1]);
      System.out.println("Password is ***************** "+ getValidPassword());
    getUserTextField().sendKeys(getAllUserList()[1]);
    getPasswordTextField().sendKeys(getValidPassword());
    getLogInBtn().click();
    
    Thread.sleep(3);
    String followingPageUrl = driver.getCurrentUrl();
       System.out.println("followingPageUrl ***************** "+ followingPageUrl);

    Assert.assertTrue(followingPageUrl.contains("inventory"));
    }


    
    
public void LoginPageLoad(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()=\"Accepted usernames are:\"]/following::br")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()=\"Password for all users:\"]/parent::div")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"user-name\"]")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"password\"]")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"login-button\"]")));
    }

public  String[] getAllUserList(){
    String[] allUserList = driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']/parent::div")).getText().split("\n");
return allUserList;
}

public String getValidPassword(){
    String[] passwordList = driver.findElement(By.xpath("//h4[text()='Password for all users:']/parent::div")).getText().split("\n");
return passwordList[1];
}
    
    public WebElement getUserTextField() {
        return driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
    }
    public WebElement getPasswordTextField() {
        return driver.findElement(By.xpath("//input[@id=\"password\"]"));
    }
        public WebElement getLogInBtn() {
        return driver.findElement(By.xpath("//input[@id=\"login-button\"]"));
    }
        

    

}
