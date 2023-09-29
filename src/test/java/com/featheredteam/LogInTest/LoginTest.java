/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.featheredteam.LogInTest;

import static com.featheredteam.LogInTest.AppTest.driver;
import java.time.Duration;
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



        @Test(priority=1)
    public void ValidateWebsiteHeadingText(){
            WebElement title = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
            Assert.assertTrue(title.getText().equals("Swag Labs") );
            System.out.println("Title: " + title.getText());
    }
    
    
    @Test(priority = 2)
    public void AccessWithStandard_user() throws InterruptedException{
LoginPageLoad();

   System.out.println("Valid User name is ***************** "+ getAllUserList()[1]);
      System.out.println("Password is ***************** "+ getValidPassword());
    getUserTextField().sendKeys(getAllUserList()[1]);
    getPasswordTextField().sendKeys(getValidPassword());
    getLogInBtn().click();
    
    Thread.sleep(3);
    Assert.assertTrue(getCurrentPageUrl().contains("inventory"));
           System.out.println("followingPageUrl ***************** "+ getCurrentPageUrl());
           CanLogOut();
    }

    
            @Test(priority = 3)
    public void AccessWithPerformance_glitch_user() throws InterruptedException{
LoginPageLoad();

   System.out.println("Valid User name is ***************** "+ getAllUserList()[4]);
      System.out.println("Password is ***************** "+ getValidPassword());
    getUserTextField().sendKeys(getAllUserList()[4]);
    getPasswordTextField().sendKeys(getValidPassword());
    getLogInBtn().click();
    
    Thread.sleep(3);
    Assert.assertTrue(getCurrentPageUrl().contains("inventory"));
           System.out.println("followingPageUrl ***************** "+ getCurrentPageUrl());
           CanLogOut();
    }
    
    
        @Test(priority = 4)
    public void AccessWithLocked_out_user() throws InterruptedException{
LoginPageLoad();
       System.out.println("Valid User name is ***************** "+ getAllUserList()[2]);
        getUserTextField().sendKeys(getAllUserList()[2]);
             System.out.println("Password is ***************** "+ getValidPassword());
    getPasswordTextField().sendKeys(getValidPassword());
    getLogInBtn().click();
    
        Thread.sleep(3);
       System.out.println("followingPageUrl ***************** "+ getCurrentPageUrl());

     String errorMsg =  driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
       
    Assert.assertTrue(getCurrentPageUrl().equals("https://www.saucedemo.com/"));
    Assert.assertTrue(errorMsg.equals("Epic sadface: Sorry, this user has been locked out."));
               System.out.println("errorMsg ***************** "+ errorMsg);
               driver.navigate().refresh();
    }
   
    

    public void CanLogOut(){
        getMenuDrawer().click();
        getlogOutDrawer().click();
            Assert.assertTrue(getCurrentPageUrl().equals("https://www.saucedemo.com/"));

    }
    
public void LoginPageLoad(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()=\"Accepted usernames are:\"]/following::br")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[text()=\"Password for all users:\"]/parent::div")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"user-name\"]")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"password\"]")));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"login-button\"]")));
    }

public String getCurrentPageUrl(){
return driver.getCurrentUrl();
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
     
       public WebElement getMenuDrawer() {
        return driver.findElement(By.xpath("//button[@id=\"react-burger-menu-btn\"]"));
    }
          public WebElement getlogOutDrawer() {
        return driver.findElement(By.xpath("//a[@id=\"logout_sidebar_link\"]"));
    }    

    

}
