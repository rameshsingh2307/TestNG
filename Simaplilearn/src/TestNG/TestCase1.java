package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("inside before test..");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("inside before Method..");
	}
	@Test(groups = {"Regression"})
	public void test1()
	{
		System.out.println("inside test 1..");
	}
	
	@Test(groups = {"Regression"})
	public void test2()
	{
		System.out.println("inside test 2..");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("inside after Method..");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("inside after test ..");
	}
}
