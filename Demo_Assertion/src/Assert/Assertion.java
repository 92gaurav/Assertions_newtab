package Assert;

import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assertion {
	
	static WebDriver driver;
	
	@Test (priority=1)
	public void test() {
		
		System.setProperty("webderiver.chrome.driver", "/usr/games/chromedriver");
		
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "/usr/games/geckodriver");
//		driver = new FirefoxDriver();
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();
		System.out.println("Chrome Working");
		String actualtitle = "Google";
		String title = driver.getTitle();
		Assert.assertEquals(actualtitle, title, "Your Title is not same as you expected");
			
		
	}
	
	
	@Test (priority=2)
	public void test1() throws InterruptedException {
		
		driver.findElement(By.name("q")).sendKeys("testing automation");
		System.out.println("1");
		driver.findElement(By.id("hplogo")).click();
		Thread.sleep(9000);
		System.out.println("2");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).click();
		System.out.println("3");
		System.out.println("Second Method");
		
	}
	
	@Test (priority=4)
	public void test2() throws InterruptedException{
		
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		System.out.println("Third Method");
		 WebElement fistname = driver.findElement(By.id("email"));
		 WebElement lastname = driver.findElement(By.id("passwd"));
		 
		 sendkeys(driver, fistname, 2, "test003@yopmail.com");
			sendkeys(driver, lastname, 2, "test123456789");
			
			driver.findElement(By.id("SubmitLogin")).click();
			
			//open blank new tab
//			JavascriptExecutor jse = (JavascriptExecutor)driver;
//			jse.executeScript("window.open()");
			
			
			//Open new tab with url and can control tabs
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			//Will control on tab as according to index:

			driver.switchTo().window(tabs.get(1));
			//Driver control on main tab:
			
			Thread.sleep(5000);
			
			driver.navigate().to("https://selenium.dev");
			System.out.println("New tab open with url");

			driver.switchTo().window(tabs.get(0));
			System.out.println("Its Done");
			

	}
	
	
	@Test (priority=3)
	public void tabs() {
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		System.out.println("New tab open");
		
	}

	
	@Test (priority=5)
	public void sendkeys(WebDriver driver, WebElement locator, int timeout, String value) {
		
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(locator));
		locator.sendKeys(value);
		
	}
	
	public static void main(String[]arg) throws InterruptedException {
		
		Assertion obj = new Assertion();
		obj.test();
		obj.test1();
		obj.tabs();
		obj.test2();
		
		
	}

}
