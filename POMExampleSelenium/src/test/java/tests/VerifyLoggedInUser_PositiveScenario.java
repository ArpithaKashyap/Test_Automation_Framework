package tests;

import java.util.concurrent.TimeUnit;

import javax.xml.crypto.dsig.XMLSignatureFactory;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ExcelReader.xlsReader;
import apppages.LandingHomePage;
import apppages.LoginPage;

public class VerifyLoggedInUser_PositiveScenario {
	
	WebDriver driver;
	
	// Creating object of Landing home page
    LandingHomePage objLandingHomePage; 
    
    // Creating object of Login page
    LoginPage objLoginPage;
    
    String browserDriverPath= "D:\\chromedriver.exe";
    

    @BeforeTest
    public void setup(){    	
		
		System.setProperty("webdriver.chrome.driver",browserDriverPath);	
        
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://www.advantageonlineshopping.com/#/");        
       
    }
    
    /**

     * This test case will login in advantageonlineshopping.com and verify
      
	 * its title.It Should be Advantage Shopping 

     * Login to the application
     * 
     */

    @Test(priority=1)
    public void loggedInToApplication_TC1(){

        // Initializing Landing Home Page object
    	objLandingHomePage = new LandingHomePage(driver);
	
	    // Getting Landing Page title	
	    String landingPageTitle = objLandingHomePage.getLandingHomePageTitle();
	
	    // Verifying Landing Home Page title	    
	    Assert.assertTrue(landingPageTitle.contains("Advantage Shopping"));
	    
	    objLandingHomePage.clickLogin();
	
	    // Initializing Login Page Object	    
	    objLoginPage = new LoginPage(driver);
	    
	    // Login to the Application	    
	    objLoginPage.login( "TestAccount", "Testacc@123"); 
	    
	    System.out.println("Login is Sucessfull");
	    
	    
    }
    
    /*This test case will login verify logged in user's name */

    @Test(priority=2)
    public void verifyLoggedInUser_TC2(){

        // Waiting until logged in user's name becomes visible properly on the home page
    	
    	// objLandingHomePage has already been initialized in above test.No need to initialize again    	
	    objLandingHomePage.waitForloggedInUserNameToBecomeVisible();
	
	    // Getting logged in user's name	    
	    String userName =  objLandingHomePage.getLoginUserName();
	    
	    System.out.println("Logged in user's name is:"+userName);
		
	    // Verifying Logged in User name
	    Assert.assertTrue(userName.contains("TestAccount"));
    }
    

    


}