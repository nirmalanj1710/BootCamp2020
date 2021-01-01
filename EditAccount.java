package week1;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EditAccount {

	public static void main(String[] args) throws InterruptedException {

		// Initializing the Chrome browser
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cseni\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		Thread.sleep(3000);

		((RemoteWebDriver) driver).findElementById("username").sendKeys("cypress@testleaf.com");
		((RemoteWebDriver) driver).findElementById("password").sendKeys("Bootcamp@123");
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
		//To click on the Edit option
		WebElement element = driver.findElement(By.xpath("//div[@class='branding-actions actionMenu']//following::a/div[@title='Edit']"));
		Actions builder = new Actions(driver);
        builder.moveToElement(element).click().perform();
		System.out.println("Edit option clicked succcssfully from the drop down");
								
		Thread.sleep(5000);
		// Selecting the value for Type as Technology Partner
		driver.findElement(By.xpath("(//div[@class='slds-form-element slds-hint-parent']/following::div[@class='uiMenu']//a[text()='--None--'])[1]")).click();
		Thread.sleep(4000);
		
		WebElement ele1 = driver.findElement(By.xpath("//div[@class='select-options']//ul//li//a[text()='Technology Partner']"));
		Actions builder1 = new Actions(driver);
		Actions hover1 = builder1.moveToElement(ele1);
		System.out.println("Mouse hoover succeed to Technology Partner option"); 
		hover1.build().perform();
		Thread.sleep(4000); 
		ele1.click();
		System.out.println("Type value is selected successfully as Technology Partner");
		
		Thread.sleep(4000);
		// Selecting the value for Industry as Healthcare
		driver.findElement(By.xpath("//div[@class='slds-form-element slds-hint-parent']//span[text()='Industry']/following::a[text()='--None--'][1]")).click();
		Thread.sleep(3000);
		
		WebElement ele2 = driver.findElement(By.xpath("//div[@class='select-options']//ul//li//a[text()='Healthcare']"));
		Actions builder2 = new Actions(driver);
		Actions hover2 = builder2.moveToElement(ele2);
		System.out.println("Mouse hoover succeed to Healthcare option");
		hover2.build().perform();
		Thread.sleep(3000);
		ele2.click();
		System.out.println("Industry value is selected successfully as Healthcare");
		
		Thread.sleep(4000);
		// Entering the details for Billing Street
		driver.findElement(By.xpath("//*[contains(@placeholder,'Billing Street')]")).sendKeys("TEST");
		System.out.println("Details are successfully entered in Billing Street");
				
		Thread.sleep(4000);
		// Entering the details for Shipping Street
		driver.findElement(By.xpath("//*[contains(@placeholder,'Shipping Street')]")).sendKeys("TEST");
		System.out.println("Details are successfully entered in Shipping Street");
		
		Thread.sleep(4000);
		// Selecting the value for Customer Priority as Low
		driver.findElement(By.xpath("//div[@class='slds-form-element slds-hint-parent']//span[text()='Customer Priority']/following::a[text()='--None--'][1]")).click();
        Thread.sleep(3000);		
        
        WebElement ele3 = driver.findElement(By.xpath("//div[@class='select-options']//ul//li//a[text()='Low']"));
        Actions builder3 = new Actions(driver);
        Actions hover3 = builder3.moveToElement(ele3);
        System.out.println("Mouse hoover succeed to Low option");
        Thread.sleep(3000);
        ele3.click();		
		System.out.println("Customer Priority value is selected successfully as Low");
		
		Thread.sleep(4000);
		// Selecting the value for SLA as Silver
		driver.findElement(By.xpath("//div[@class='slds-form-element slds-hint-parent']//span[text()='SLA']/following::a[text()='--None--'][1]")).click();
		Thread.sleep(3000);
		
		WebElement ele4 = driver.findElement(By.xpath("//div[@class='select-options']//ul//li//a[text()='Silver']"));
		Actions builder4 = new Actions(driver);
		Actions hover4 = builder4.moveToElement(ele4);
		hover4.build().perform();
		System.out.println("Mouse hoover succeed to Silver option");
		ele4.click();
		System.out.println("SLA value is selected successfully as Silver");
		
		Thread.sleep(4000);
		// Selecting the value for Active as NO
		driver.findElement(By.xpath("//div[@class='slds-form-element slds-hint-parent']//span[text()='Active']/following::a[text()='--None--'][1]")).click();
		Thread.sleep(3000);
		
		WebElement ele5 = driver.findElement(By.xpath("//div[@class='select-options']//ul//li//a[text()='No']"));
		Actions builder5 = new Actions(driver);
		Actions hover5 = builder5.moveToElement(ele5);
		System.out.println("Mouse hoover succeed to No option ");
		Thread.sleep(3000);
		hover5.build().perform();
		ele5.click();
		System.out.println("Active value is selected successfully as NO");
		
		Thread.sleep(4000);
		// Entering the details for Unique Number in Phone Field				
		driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']//span[text()='Phone']/following::input[1]")).sendKeys("7894563690");
		System.out.println("Details are successfully entered in Unique Number field");
		
		Thread.sleep(4000);
		// Selecting the value for Upsell Opportunity as No
		driver.findElement(By.xpath("//div[@class='slds-form-element slds-hint-parent']//span[text()='Upsell Opportunity']/following::a[text()='--None--'][1]")).click();
		Thread.sleep(3000);
		
        WebElement ele6 = driver.findElement(By.xpath("(//div[@class='select-options']//ul[@class='scrollable']//a[text()='No'])[2]"));
        Actions builder6 = new Actions (driver);
        Actions hover6 = builder6.moveToElement(ele6);
        System.out.println("Mouse hoover succeed to No option");
        hover6.build().perform();
        Thread.sleep(3000);
        ele6.click();
		System.out.println("Upsell Opportunity is selected successfully as No");
		
		Thread.sleep(5000);
		//Clicking on the save button
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']//following::span[text()='Save']")).click();
		System.out.println("Save button is clicked successfully !!!");
		
	}
}
