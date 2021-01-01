package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortAccount {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");

		driver.findElement(By.id("username")).sendKeys("cypress@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.name("Login")).click();

		Thread.sleep(5000);
		// AppLauncher
		driver.findElement(By.xpath("//*[contains(@class,'slds-icon-waffle_container')]")).click();
		System.out.println("App Launcher clicked successfully");

		Thread.sleep(3000);
		// Clicking on ViewAll
		driver.findElement(By.xpath("//div/lightning-button//*[contains(@class,'slds-button')]")).click();
		System.out.println("View All clicked successfully");

		Thread.sleep(3000);
		// Clicking on Sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		System.out.println("Sales clicked successfully");

		Thread.sleep(5000);
		// Clicking on Accounts
		WebElement accdpdwm = driver.findElement(By.xpath("//a[@title='Accounts']"));
		System.out.println("Accounts clicked successfully");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", accdpdwm);

		Thread.sleep(3000);
		// Clicking on the Account Name to sort
		WebElement ele = driver.findElement(By.xpath("//a//span[text()='Account Name']"));
		
		Actions act =  new Actions (driver);
		act.moveToElement(ele).click().perform();	
		System.out.println("Account Name is sorted in Ascending Order");
	}

}
