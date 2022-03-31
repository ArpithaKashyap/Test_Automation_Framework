package apppages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
 
public class LoginPage {
 
 WebDriver driver;
 
 By userName = By.name("username");    
 By userPassword = By.name("password");    
   

	public By getUserName() {
	return userName;
}


public By getUserPassword() {
	return userPassword;
}


	// This Constructor will be automatically called when the object of the class is created
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }
    
        
    // Set the value of user name in user name TextBox
    public void setUserName(String strUserName){
    	
        driver.findElement(userName).sendKeys(strUserName);
 
    }
 
    // Set the value of password in password TextBox
    public void setPassword(String strPassword){
 
         driver.findElement(userPassword).sendKeys(strPassword+Keys.ENTER);
 
    }
        
    /**This POM method will be used in actual test case to login to the application
   @param strUserName @param strPasword @return */
    
    public void login(String strUserName,String strPasword){
    	
    	// Switching to Login Popup window
    	driver.switchTo().activeElement();
        
    	//Enter user name
        this.setUserName(strUserName);
 
        //Enter password
        this.setPassword(strPasword);       
        
        driver.switchTo().defaultContent();
    }    
 
}