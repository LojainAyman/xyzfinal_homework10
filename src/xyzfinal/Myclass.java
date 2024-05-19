package xyzfinal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Myclass {
	WebDriver driver = new ChromeDriver();
	SoftAssert myAssertion = new SoftAssert();

	@BeforeTest
	public void mysetup () {
		
		driver.get("https://www.google.com");
		
		
	}
	

	@Test()
	public void check_the_number_searches () {
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("lojain almufleh"+Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"Rzn5id\"]/div/a[2]")).click();
		
		driver.findElement(By.id("result-stats")).getText();
		
		String search_results =  driver.findElement(By.id("result-stats")).getText();
		
		
		String splitedText [] = search_results.split(" ");
		
		
		System.out.println(splitedText[1]);
		
		String theNumberOfTheSearchResults = splitedText[1];
		
		String theNumberOfTheSearchResultsUpdated = theNumberOfTheSearchResults.replace(",", "");
		
		int actualResultsNumber = Integer.parseInt(theNumberOfTheSearchResultsUpdated);
		
		int expectedNumber = 10 ;

	    
		myAssertion.assertEquals(actualResultsNumber, expectedNumber, "wlh 3m n3ml test");
		
		myAssertion.assertAll();
	}
	
	
	@AfterTest
	public void theEnd () {
		


	}
	
}

