package main.java;

import com.sun.javafx.PlatformUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {
	WebDriver driver;

  //  WebDriver driver = new ChromeDriver(); // Moved this line from line 12 to Line 18 after setting up Driver Path

    @SuppressWarnings("deprecation")
	@Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
    	BasePage basePageObj = new BasePage();
    	driver=basePageObj.setDriverPath();        
        driver.get("https://www.cleartrip.com/");
        basePageObj.waitFor(2000);
        driver.manage().window().maximize();
        WebElement yourTrip = driver.findElement(By.linkText("Your trips")); 
        WebElement SignIn = driver.findElement(By.id("SignIn"));
        basePageObj.clickElement(yourTrip);
        basePageObj.clickElement(SignIn);
        driver.switchTo().frame("modal_window");
    	WebElement signInButton = driver.findElement(By.id("signInButton"));
    	// WebElement SignInButton = driver.findElement(By.id("signInButton"));
    	basePageObj.clickElement(signInButton);


        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }
    
}
