package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicValidation {
	
	public static WebDriver driver;
	String url = "https://www.fb.com";
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void urlValidation() {
		String expectedResult = "https://www.facebook.com/";
		String actualResult = driver.getCurrentUrl();
		
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the url");
	}
	
	@Test
	public void welcomeMessageValidation() {
		String expectedResult = "Facebook helps you connect and share with the people in your life";
		String actualResult = driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the url");
	}

}