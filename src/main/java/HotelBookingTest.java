package main.java;

import com.sun.javafx.PlatformUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    
    @FindBy(xpath= "//*[@id='ui-datepicker-div']")
    public WebElement CalendarDiv;
    
    
    public void HotelBookingTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Test
    public void shouldBeAbleToSearchForHotels() {
    	BasePage basePageObj = new BasePage();
    	driver =basePageObj.setDriverPath();
        HotelBookingTest(driver);
        driver.get("https://www.cleartrip.com/");
        hotelLink.click();
       	localityTextBox.sendKeys("Indiranagar, Bangalore");	
       	basePageObj.waitFor(6000);
       //boolean LocationListDisplayed = driver.findElement(By.xpath("//*[@class='list']")).isDisplayed();
       
       	List<WebElement> LocationList = driver.findElements(By.xpath("//*[@class='list']"));
       	LocationList.get(0).click();
       	
       	/*boolean CalendarVisible = CalendarDiv.isDisplayed();
       	System.out.println("Calendar is present : "+CalendarVisible);
       	//Selecting current date as start date and +1 for End Date
       	
       	
       	CheckInDateSelector.click();
       	CheckoutDateSelctor.get(0).click();*/
       	new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();
      //  driver.quit();
        
    }

}
