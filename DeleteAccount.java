package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteAccount {

	public static void main(String[] args) throws InterruptedException {
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

		Thread.sleep(5000);
		// Clicking on Accounts
		WebElement accdpdwm = driver.findElement(By.xpath("//a[@title='Accounts']"));
		System.out.println("Accounts clicked successfully");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", accdpdwm);

		Thread.sleep(3000);
        
		 WebElement Post; 
		 Post = driver.findElement(By.xpath("//*[contains(@placeholder, 'Search this list...')]"));
		 Post.sendKeys("Bootcamp"); 
		 Post.click(); 
		 Thread.sleep(4000);
         System.out.println("Clicked on search button and searched for the required account name successfully");

        //to filter the result, trying to click on the page as we don't have an enter button
		 driver.findElement(By.xpath("//li//span[text()='Accounts']")).click();
		
		Thread.sleep(4000);
		// To click on the drop down arrow				
		driver.findElement(By.xpath("//tr//td[@class='slds-cell-edit cellContainer']/following::a[@role='button']")).click();
		
		Thread.sleep(6000);
		//To click on the Delete option
		WebElement element = driver.findElement(By.xpath("//div[@class='branding-actions actionMenu']//following::a/div[@title='Delete']"));
		Actions builder = new Actions(driver);
        builder.moveToElement(element).click().perform();
		System.out.println("Delete option clicked succcssfully from the drop down");
		
		Thread.sleep(5000);
		//Clicking on the save button
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']//following::span[text()='Delete']")).click();
		System.out.println("Delete button is clicked successfully !!!");	

	}

}
