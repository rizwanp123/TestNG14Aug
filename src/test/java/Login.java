import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.BaseClass;

public class Login extends BaseClass {

	// Priority
	
	@BeforeMethod (alwaysRun = true)
	public void before() {
		 driver.get("https://demoqa.com/login");
	}
	
  @Test (priority = 3, groups= {"Login"})
  @Parameters({"Username","Password"})
  public void PositiveLogin(String username, String password) {
	  driver.findElement(By.id("userName")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,350)", "");
	  
	  driver.findElement(By.id("login")).click();
	  new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\"Profile\"]")));
	  String homePage = driver.findElement(By.xpath("//div[text()=\"Profile\"]")).getText();
	  System.out.println("home page text is: " + homePage);
	  Assert.assertEquals(homePage,"Profile", "Home page assertion failed" );
	  
	  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id("submit")));
	  driver.findElement(By.id("submit")).click();
  }
  
  
  // TestNG methods are run in alphabetical order
  @Test (priority = 4,groups= {"Login","ignore"})
  public void NegativeLogin() {
	  driver.findElement(By.id("userName")).sendKeys("Rizwan@14aug");
	  driver.findElement(By.id("password")).sendKeys("Rizwan");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,350)", "");
	  
	  driver.findElement(By.id("login")).click();
	  
	  
	  new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
	  String errorMessage = driver.findElement(By.id("name")).getText();
	  System.out.println("Error text is: " + errorMessage);
	  Assert.assertEquals(errorMessage,"Invalid username or password!", "Negative login assertion failed" );

  }
  
  @AfterSuite(alwaysRun = true)
  public void closeBrowser() {
	  driver.quit();
  }
}
