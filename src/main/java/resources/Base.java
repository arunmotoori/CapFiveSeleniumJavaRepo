package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public Properties prop;
	
	public WebDriver initializeBrowser() throws IOException {
		
		WebDriver driver = null;
		
		prop = new Properties();
		
		File file = new File(".\\src\\main\\java\\resources\\data.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}
	
	public String generateTimeStamp() {
		
		Date date = new Date();
		
		return date.toString().replace(" ","_").replace(":","_");
		
		
	}
	
	public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File srceenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srceenshotFile,new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png"));
		return System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
	}
	

}
