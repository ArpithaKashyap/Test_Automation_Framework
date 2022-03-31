package apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
 
public class LandingHomePage {
 
 WebDriver driver;
 
    By userLoginMenuIcon = By.id("menuUser");    
    
    By loggedInUserName = By.xpath("//*[@id=\"menuUserLink\"]/span");    
   
    // This Constructor will be automatically called when the object of the class is created
    public LandingHomePage(WebDriver driver)
    {
        this.driver = driver;        
    }
 
    // Get the title of Landing Home Page
    public String getLandingHomePageTitle()
    {
 
    	return driver.getTitle();
 
    }
    
    // Click on User login Menu Button
    public void clickLogin()
    {
         driver.findElement(userLoginMenuIcon).click();
    }
    
    // Get Login User Name
    public String getLoginUserName()
    {
 
    	return driver.findElement(loggedInUserName).getText();
 
    }
    
    public void waitForloggedInUserNameToBecomeVisible()
    {
    	// Defining Explicit Wait 
      WebDriverWait wait = new WebDriverWait(driver,5); 
 
      // Waiting until the logged in user's name becomes visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUserName));
    }
    
    
}