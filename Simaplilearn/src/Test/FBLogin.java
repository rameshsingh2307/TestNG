package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBLogin {
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException{
		FBLogin fBLogin = new FBLogin();
		fBLogin.setup();
		fBLogin.login();
		fBLogin.singup();
	}
	
	

	private void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
	}

	public void login()
	{
		WebElement userName = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@name='login']"));
		
		userName.sendKeys("xej@gmail.com");
		password.sendKeys("abc");
		loginButton.click();
	}
	
	private void singup() {
		WebElement signUp = driver.findElement(By.xpath("//*[text()='Create New Account']"));
		signUp.click();
		
		WebElement dropdown = driver.findElement(By.xpath("//*[@title='Day']"));
		
		Select day = new Select(dropdown);
		
		day.selectByVisibleText("1");
		day.selectByIndex(0);
		day.selectByValue("1");
		
		
		WebElement genderFemail = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		genderFemail.click();
		
		WebElement domText = driver.findElement(By.xpath("//*[contains(text(),'people')]"));
	}
	
	
}
