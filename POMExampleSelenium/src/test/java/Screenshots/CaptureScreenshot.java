package Screenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class CaptureScreenshot {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		
	String browserDriverPath= "D:\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver",browserDriverPath);	
    
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

    driver.get("http://www.advantageonlineshopping.com/#/");  
    takeScreenshot("Online_Shopping_LoginPage");
}
	
	public static void takeScreenshot(String fileName) throws IOException {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("/Users/arpitha.kashyap/eclipse-workspace/Sel/src/test/java/Screenshot_LoginPage/"
				+fileName+".jpg"));
		
	
	}
	
}

