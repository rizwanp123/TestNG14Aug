package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	//This is a base class
	
	public static WebDriver driver;
	
	static {
		String baseDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", baseDir + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

}
