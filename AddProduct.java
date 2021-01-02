package week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProduct {

	public static void main(String[] args) throws InterruptedException {
		// Test case# S20-64

		WebDriverManager.chromedriver().setup();

		WebDriver driver;

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		Thread.sleep(3000);

		driver.findElement(By.id("username")).sendKeys("cypress@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.name("Login")).click();

		Thread.sleep(7000);
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

		Thread.sleep(4000);
		// Clicking on View All Key Deals
		driver.findElement(By.xpath("//div[@class='slds-card__footer']/a/span[text()='View All Key Deals']")).click();
		System.out.println("View All Key Deals link is clicked successfully");

		Thread.sleep(3000);
		// To click All Opportunities from the drop down
		driver.findElement(By.xpath("//div/a[@title='Select List View']")).click();

		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//div[@class='listContent']//ul/li/a[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click().perform();
		System.out.println("All Opportunities option is clicked successfully from the drop down");

		Thread.sleep(3000);
		WebElement Post;
		Post = driver.findElement(By.xpath("//*[contains(@placeholder, 'Search this list...')]"));
		Post.sendKeys("SRM Steel");
		Post.click();
		Thread.sleep(4000);
		System.out.println("Clicked on search button and searched for the required account name successfully");

		// to filter the result, trying to click on the page as we don't have an enter button
		driver.findElement(By.xpath("//li//span[text()='Opportunities']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//table//tbody//span//a[@title='SRM Steel'][1]")).click();
		System.out.println("SRM Steel is clicked successfully");
		
		Thread.sleep(4000);
		// To click on New Case button
		driver.findElement(By.xpath("//div//ul//lightning-button/button[1]")).click();
		System.out.println("New Case button is clicked successfully");
		
		Thread.sleep(4000);
		// To click on Contact Name drop down
		driver.findElement(By.xpath("//div[@class='contentWrapper slds-box--border']")).click();
		
		Thread.sleep(2000);
		// To click on the first element in drop down
		WebElement element1 = driver.findElement(By.xpath("//div/ul/li[@role='presentation']/a/div[@data-aura-class='forceEntityIcon'][1]"));
		Actions builder1 = new Actions(driver);
        builder1.moveToElement(element1).click().perform();
        System.out.println("First name is clicked from the drop down");
        
        Thread.sleep(3000);
        //To fill on the Subject field
        driver.findElement(By.xpath("//div/input[@class=' input']")).sendKeys("New Case");
        System.out.println("Subject field is filled successfully");
        
        Thread.sleep(2000);
        // To click on the save button
        driver.findElement(By.xpath("(//div/button/span[text()='Save'])[2]")).click();
        System.out.println("Save button is clicked successfully");
        
	}

}
