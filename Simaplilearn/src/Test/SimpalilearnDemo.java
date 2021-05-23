package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestNGListnerExample.class)
public class SimpalilearnDemo {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet1;
	public static void main(String[] args) {
		
		
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://accounts.simplilearn.com/user/login?redirect_url=https%3A%2F%2Flms.simplilearn.com%2F");
		//WebElement loginElement = driver.findElement(By.linkText("Log in"));
		//loginElement.click();
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet1 = workbook.getSheetAt(0);
	}
	
	@Test
	//@Parameters({"uname","pwd"})
	public void login()
	{
		String usernameval, passwd;
		
		WebElement userName = driver.findElement(By.name("user_login"));
		
		
		
		  usernameval = sheet1.getRow(0).getCell(0).getStringCellValue();
		  
		  passwd = sheet1.getRow(0).getCell(1).getStringCellValue();
		 
		/*
		 * usernameval = "csdcdcd";
		 * 
		 * passwd = "cdcdcdc";
		 */
		
		userName.sendKeys(usernameval);
		
		WebElement password = driver.findElement(By.name("user_pwd"));
		password.sendKeys(passwd);
		
		WebElement btn_login = driver.findElement(By.name("btn_login"));
		btn_login.click();
		WebElement msg_box = driver.findElement(By.id("msg_box"));
		String errorMessage = msg_box.getText();
		String actualError="The email or password you have entered is .";
		/*
		 * if(errorMessage.equals(actualError.toString())) { System.out.println("same");
		 * }
		 */
		
		Assert.assertEquals(errorMessage, actualError);

		
	}

}
