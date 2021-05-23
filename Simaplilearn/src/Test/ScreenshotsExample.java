package Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotsExample {
	WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		ScreenshotsExample screenshots = new ScreenshotsExample();
		screenshots.setup();
		//
		//fBDemo.login();
	}
	
	void setup() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		
		File image = screenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(image, new File("test.png"));
		
		
	}
	
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
