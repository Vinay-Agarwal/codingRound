import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

    

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        setDriverPath();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.manage().window().maximize();
        WebElement yourTrip = driver.findElement(By.linkText("Your trips")); 
        WebElement SignIn = driver.findElement(By.id("SignIn"));
        
        clickElement(yourTrip);
        clickElement(SignIn);

        driver.switchTo().frame("modal_window");
    	WebElement signInButton = driver.findElement(By.id("signInButton"));
        clickElement(signInButton);

        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    
    private boolean ExplicitWait(WebElement elem) {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	boolean elemExist = wait.until(ExpectedConditions.invisibilityOfElementLocated((By) elem));
		return elemExist;
    }
    
    private void clickElement(WebElement elem) {
    	elem.click();
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }


}
