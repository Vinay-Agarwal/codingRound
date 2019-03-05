package main.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.sun.javafx.PlatformUtil;

public class BasePage {

	public WebDriver driver;
	static String projectDIR= System.getProperty("user.dir");
	public static final String CHROME_DRIVER_PATH= projectDIR + "\\resources\\chromedriver.exe";
	
	@SuppressWarnings("restriction")
	public WebDriver setDriverPath() {
		if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
        
        driver = new ChromeDriver();
		return driver;
	}
	
	public void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
	
	public boolean isElementDisplyed(WebElement elem) {
    	
    	try {
    		Wait<WebDriver> waitForelemDisplayed = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
        	waitForelemDisplayed.until(ExpectedConditions.invisibilityOf(elem));
        	return true;	
    	}
    	catch (Exception e) {
    		System.out.println("Element is not present");
    		System.out.println(e.getMessage());
    		return false;
    	}
    	
    }
	
	public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	 public void clickElement(WebElement elem) {
	    	elem.click();
	    }

	
		
}
