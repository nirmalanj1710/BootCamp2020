package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {

		// WebDriverManager.chromedriver().setup();

		//Initializing the Chrome browser		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cseni\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		Thread.sleep(3000);

		((RemoteWebDriver) driver).findElementById("username").sendKeys("hari.radhakrishnan@testleaf.com");
		((RemoteWebDriver) driver).findElementById("password").sendKeys("India$123");
		driver.findElement(By.name("Login")).click();
		
		Thread.sleep(7000);
		//AppLauncher
		driver.findElement(By.xpath("//*[contains(@class,'slds-icon-waffle_container')]")).click();
        System.out.println("App Launcher clicked successfully");
        
		Thread.sleep(3000);
		//Clicking on ViewAll
		driver.findElement(By.xpath("//div/lightning-button//*[contains(@class,'slds-button')]")).click();
		System.out.println("View All clicked successfully");
		
		Thread.sleep(3000);
		//Clicking on Sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		System.out.println("Sales clicked successfully");

		
		Thread.sleep(5000);
		//Clicking on Accounts
		WebElement accdpdwm = driver.findElement(By.xpath("//a[@title='Accounts']"));
		System.out.println("Accounts clicked successfully");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", accdpdwm);
        
		
		Thread.sleep(5000);
		//Clicking on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();
		System.out.println("New button clicked successfully");


		Thread.sleep(5000);
		//Entering the Account Name
		driver.findElement(By.xpath("//label//span[text()='Account Name']/following::input[1]"))
				.sendKeys("DUMMY");
		System.out.println("Name is entered successfully as DUMMY");

		Thread.sleep(5000);
		//Entering the Ownership
		driver.findElement(By.xpath("//div//span[text()='Ownership']/following::a[1]")).click();

		Thread.sleep(3000);
		//Selecting the value for Ownership as Public
		driver.findElement(By.xpath("//div//a[text()='Public']")).click();
		System.out.println("Ownership is entered successfully as Public");
				
		Thread.sleep(3000);	
		//Click on Save button
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
        System.out.println("SAVE button clicked successfully");
		
	}

}