package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FBDemo {
	WebDriver driver;
	/*
	 * public static void main(String[] args) throws InterruptedException { FBDemo
	 * fBDemo = new FBDemo(); fBDemo.setup(); Thread.sleep(3000); fBDemo.login(); }
	 */
	
	@BeforeMethod
	void setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");		
	}
	
	@Test
	void login()
	{
		WebElement user=driver.findElement(By.xpath("//input[@name='email']"));
		WebElement pass=driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement loginBtn=driver.findElement(By.xpath("//*[@name='login']"));
		user.sendKeys("csdcdc");
		pass.sendKeys("csdcdc");
		loginBtn.click();
			
	}
	
	
}
