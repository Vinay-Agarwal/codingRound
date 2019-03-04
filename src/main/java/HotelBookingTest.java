package main.java;

import com.sun.javafx.PlatformUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {
	WebDriver driver;

    @FindBy(xpath= "//*[@class='hotelApp ']")
    public WebElement hotelLink;
    
    @FindBy(xpath = "//*[@id='Tags']")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBy(xpath= "//*[@class='ui-state-default ui-state-highlight ']")
    public WebElement CheckInDateSelector;

    @FindBy(xpath = "//*[@class='ui-state-default ']")
    public List<WebElement> CheckoutDateSelctor;
    
    public void HotelBookingTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();
        driver = new ChromeDriver();
        HotelBookingTest(driver);
        driver.get("https://www.cleartrip.com/");
        hotelLink.click();
       	localityTextBox.sendKeys("Indiranagar, Bangalore");	
       	waitFor(4000);
       	boolean LocationListDisplayed = driver.findElement(By.xpath("//*[@class='list']")).isDisplayed();
       	System.out.println("Location list displayed: " + LocationListDisplayed);
       	List<WebElement> LocationList = driver.findElements(By.xpath("//*[@class='list']"));
       	if(LocationListDisplayed) {
       		LocationList.get(0).click();
       	}
       	
       	//Selecting current date as start date and +1 for End Date
       	CheckInDateSelector.click();
       	CheckoutDateSelctor.get(0).click();
       	
       	
        new Select(travellerSelection).selectByVisibleText("2 rooms, 4 adults");
        searchButton.click();
      //  driver.quit();
        
    }
    
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    

	private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinay.kumar.agarwal\\Downloads\\chromedriver_win32_Latest\\chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
