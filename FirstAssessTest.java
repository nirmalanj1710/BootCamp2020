package assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstAssessTest extends LoginCredential{

	@Test
	public void assessFirst () throws InterruptedException {
		
		try {
			
			
			// AppLauncher
			driver.findElement(By.xpath("//*[contains(@class,'slds-icon-waffle_container')]")).click();
			System.out.println("App Launcher clicked successfully");

			
			// Clicking on ViewAll
			driver.findElement(By.xpath("//div/lightning-button//*[contains(@class,'slds-button')]")).click();
			System.out.println("View All clicked successfully");

			
			// Clicking on Service Console
			driver.findElement(By.xpath("//p[text()='Service Console']")).click();
			System.out.println("Service Console clicked successfully");

			
			Thread.sleep(3000);
			// Select Home from the DropDown
			driver.findElement(By.xpath("//div[@class='slds-context-bar__icon-action']//button[@type='button']"))
					.click();

			Thread.sleep(3000);
			
			WebElement ele1 = driver.findElement(By.xpath("//section/div//ul//li/div/a[@title='Home']"));
			Actions builder1 = new Actions(driver);
			builder1.moveToElement(ele1).click().perform();
			System.out.println("Home option clicked successfully from the drop down");

			
			// Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
			driver.findElement(By.xpath("//li/button[@title='Edit Goal']")).click();
			
			
			driver.findElement(By.xpath("//div[@class='inputContainer']/div/input[@type='text']")).clear();
			
			driver.findElement(By.xpath("//div[@class='inputContainer']/div/input[@type='text']")).sendKeys("10000");
		
			
			driver.findElement(By.xpath("(//div/button/span[@class=' label bBody'])[3]")).click();
            System.out.println("Value of Goal field is set as 10000");
			
		
			//Select Dashboards from DropDown
			driver.findElement(By.xpath("//div[@class='slds-context-bar__icon-action']//button[@type='button']"))
			.click();
			
			
			WebElement ele2 = driver.findElement(By.xpath("//section/div//ul//li/div/a[@title='Dashboards']"));
			Actions builder2 = new Actions(driver);
			builder2.moveToElement(ele2).click().perform();
			System.out.println("Dashboards option clicked successfully from the drop down");
			
			Thread.sleep(3000);
			//Click on New Dashboard
			driver.findElement(By.xpath("//span/ul//li/a[@title='New Dashboard']")).click();
			System.out.println("New Dashboard is clicked successfully");
			
			
			Thread.sleep(3000);
			//Enter the Dashboard name as "YourName_Workout"
			
						
			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[last()]")));
		
			
			driver.findElement(By.xpath("//div/input[@id='dashboardNameInput']")).sendKeys("Dummy11");
			System.out.println("Dummy11 is updated as Dashboard name");
			
			
			//Enter Description as Testing and Click on Create
			driver.findElement(By.xpath("//div/input[@id='dashboardDescriptionInput']")).sendKeys("TEST");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand submitBtn']")).click();
			System.out.println("Description field is updated as 'Testing' and 'Create' button is clicked successfully");
			
			
			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[last()]")));
			
			
			//Click on Done
			driver.findElement(By.xpath("//button[@class='slds-button doneEditing']")).click();
			
			
			//Verify the Dashboard is Created
			driver.findElement(By.xpath("//div/h1/span[@title='Dummy11']"));
			//need to think of some logic
			System.out.println("Dashboard is created with the required name");
			
			Thread.sleep(2000);
			//Click on Subscribe
			driver.findElement(By.xpath("//div/button[@class='slds-button slds-button_neutral']")).click();
			System.out.println("Subscribe button clicked successfully");
			
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			
			Thread.sleep(3000);
			
			//Select Frequency as "Daily"
            driver.findElement(By.xpath("//div[@class='frequency-button-group']//div[@class='slds-form-element__control']//label[1]")).click();
			System.out.println("Frequency is set as 'Daily'");
			
			Thread.sleep(2000);
			//Time as 10:00 AM
			driver.findElement(By.xpath("//div/select[@class=' select']")).click();
			
			Thread.sleep(3000);
			
			
			/*
			 * WebElement ele3 = driver.findElement(By.
			 * xpath("//div/select[@class=' select']/option[@value='10']")); Actions
			 * builder3 = new Actions(driver);
			 * builder3.moveToElement(ele3).click().perform();
			 */
			WebElement dum = driver.findElement(By.xpath("//select[@id='time']"));
			Select time = new Select (dum);
			time.selectByVisibleText("10:00 AM");
			System.out.println("Time is set as 10:00 AM");
			
			
			Thread.sleep(3000);
		    //Click on Save
			driver.findElement(By.xpath("//div/button[@title='Save']")).click();
			System.out.println("Save button is clicked successfully");
			
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[last()]")));
			
			Thread.sleep(3000);
			//Verify "You started Dashboard Subscription" message displayed or not
			/*
			 * boolean disp = driver.findElement(By.
			 * xpath("//div/span/[@class='toastMessage slds-text-heading--small forceActionsText']"
			 * )).isDisplayed(); System.out.println(disp);
			 */
            
            Thread.sleep(3000);
            //Close the "YourName_Workout" tab
            //driver.findElement(By.xpath("//div/ul/li/a[@title='Dummy11']"));
            
            
            driver.findElement(By.xpath("//div/button[@title='Close Dummy11']")).click();
            System.out.println("Created name is successfully closed");
            
            Thread.sleep(3000);
            //Click on Private Dashboards
            driver.findElement(By.xpath("//div/a[@title='Dashboards']")).click();
            
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div/ul//li/a[@title='Private Dashboards']")).click();
            
            Thread.sleep(3000);
            //Verify the newly created Dashboard available
            
            WebElement ele4 = driver.findElement(By.xpath("//*[contains(@placeholder, 'Search private dashboards...')]"));
            ele4.sendKeys("Dummy11");
   		    ele4.click();
   		    Thread.sleep(3000);
            System.out.println("Newly created dashboard is now available");
            

            //to filter the result, trying to click on the page as we don't have an enter button
   		    driver.findElement(By.xpath("//li//span[text()='Private Dashboards']")).click();
   		
            Thread.sleep(2000);
   		    //Click on dropdown for the item
            driver.findElement(By.xpath("//tr//td//span[@class='slds-grid slds-align_absolute-center slds-grid_align-spread']")).click();
            
            Thread.sleep(2000);
            //Select Delete
    		WebElement ele5 = driver.findElement(By.xpath("(//div[@class='slds-dropdown slds-dropdown_left']//following::a)[3]"));
    		Actions builder4 = new Actions(driver);
            builder4.moveToElement(ele5).click().perform();
    		System.out.println("Delete option is choosed succcesfully from the drop down");
    		
    		Thread.sleep(3000);
    		//Confirm the Delete
    		driver.findElement(By.xpath("//div/button[@title='Delete']")).click();
    		System.out.println("Delete option clicked successfully from the drop down");
    		
    		Thread.sleep(2000);
    		//Verify the item is not available under Private Dashboard folder
    		
    		WebElement ele6 = driver.findElement(By.xpath("//*[contains(@placeholder, 'Search private dashboards...')]"));
            ele6.sendKeys("Dummy11");
   		    ele6.click();
   		    Thread.sleep(3000);
            System.out.println("Now new dashboard values are available now !! ");
    					
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}
