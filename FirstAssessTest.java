//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
package assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstAssessTest extends LoginCredential {

	@DataProvider(name = "useData")
	public String[][] testData() {
		String[][] data = new String[1][2];
		data[0][0] = "cypress@testleaf.com";
		data[0][1] = "Bootcamp@123";

		return data;
	}

	@Test(dataProvider = "useData")
	public void assessFirst(String uName, String uPasswd) throws InterruptedException {

		try {

			driver.findElement(By.id("username")).sendKeys(uName);
			driver.findElement(By.id("password")).sendKeys(uPasswd);
			driver.findElement(By.name("Login")).click();

			// AppLauncher
			driver.findElement(By.xpath("//*[contains(@class,'slds-icon-waffle_container')]")).click();
			System.out.println("App Launcher clicked successfully");

			// Clicking on ViewAll
			driver.findElement(By.xpath("//div/lightning-button//*[contains(@class,'slds-button')]")).click();
			System.out.println("View All clicked successfully");

			// Clicking on Service Console
			driver.findElement(By.xpath("//p[text()='Service Console']")).click();
			System.out.println("Service Console clicked successfully");

			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//div[@class='slds-context-bar__icon-action']//button[@type='button']")));

			// Select Home from the DropDown
			driver.findElement(By.xpath("//div[@class='slds-context-bar__icon-action']//button[@type='button']"))
					.click();

			WebElement ele1 = driver.findElement(By.xpath("//section/div//ul//li/div/a[@title='Home']"));
			Actions builder1 = new Actions(driver);
			builder1.moveToElement(ele1).click().perform();
			System.out.println("Home option clicked successfully from the drop down");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/button[@title='Edit Goal']")));
			// Add CLOSED + OPEN values and result should set as the GOAL (If the result is
			// less than 10000 then set the goal as 10000)
			driver.findElement(By.xpath("//li/button[@title='Edit Goal']")).click();

			driver.findElement(By.xpath("//div[@class='inputContainer']/div/input[@type='text']")).clear();

			driver.findElement(By.xpath("//div[@class='inputContainer']/div/input[@type='text']")).sendKeys("10000");

			driver.findElement(By.xpath("(//div/button/span[@class=' label bBody'])[3]")).click();
			System.out.println("Value of Goal field is set as 10000");

			// Select Dashboards from DropDown
			driver.findElement(By.xpath("//div[@class='slds-context-bar__icon-action']//button[@type='button']"))
					.click();

			WebElement ele2 = driver.findElement(By.xpath("//section/div//ul//li/div/a[@title='Dashboards']"));
			Actions builder2 = new Actions(driver);
			builder2.moveToElement(ele2).click().perform();
			System.out.println("Dashboards option clicked successfully from the drop down");

			// Click on New Dashboard
			driver.findElement(By.xpath("//span/ul//li/a[@title='New Dashboard']")).click();
			System.out.println("New Dashboard is clicked successfully");

			Thread.sleep(3000);
			// Enter the Dashboard name as "YourName_Workout"

			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[last()]")));

			driver.findElement(By.xpath("//div/input[@id='dashboardNameInput']")).sendKeys(name);
			System.out.println(name + " name is updated as Dashboard name");

			// Enter Description as Testing and Click on Create
			driver.findElement(By.xpath("//div/input[@id='dashboardDescriptionInput']")).sendKeys("TEST");

			driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand submitBtn']")).click();
			System.out.println("Description field is updated as 'Testing' and 'Create' button is clicked successfully");

			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[last()]")));

			// Click on Done
			driver.findElement(By.xpath("//button[@class='slds-button doneEditing']")).click();

			// Verify the Dashboard is Created
			driver.findElement(By.xpath("//div/h1/span[@title='Nirmal']"));
			// need to think of some logic
			System.out.println("Dashboard is created with the required name");

			// Click on Subscribe
			driver.findElement(By.xpath("//div/button[@class='slds-button slds-button_neutral']")).click();
			System.out.println("Subscribe button clicked successfully");

			driver.switchTo().defaultContent();

			// Select Frequency as "Daily"
			driver.findElement(By.xpath(
					"//div[@class='frequency-button-group']//div[@class='slds-form-element__control']//label[1]"))
					.click();
			System.out.println("Frequency is set as 'Daily'");

			// Time as 10:00 AM
			driver.findElement(By.xpath("//div/select[@class=' select']")).click();

			Thread.sleep(3000);

			/*
			 * WebElement ele3 = driver.findElement(By.
			 * xpath("//div/select[@class=' select']/option[@value='10']")); Actions
			 * builder3 = new Actions(driver);
			 * builder3.moveToElement(ele3).click().perform();
			 */
			WebElement dum = driver.findElement(By.xpath("//select[@id='time']"));
			Select time = new Select(dum);
			time.selectByVisibleText("10:00 AM");
			System.out.println("Time is set as 10:00 AM");

			// Click on Save
			driver.findElement(By.xpath("//div/button[@title='Save']")).click();
			System.out.println("Save button is clicked successfully");

			// Thread.sleep(2000);
			// driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title='dashboard'])[last()]")));

			Thread.sleep(3000);
			// Verify "You started Dashboard Subscription" message displayed or not
			/*
			 * boolean disp = driver.findElement(By.
			 * xpath("//div/span/[@class='toastMessage slds-text-heading--small forceActionsText']"
			 * )).isDisplayed(); System.out.println(disp);
			 */

			Thread.sleep(3000);
			// Close the "YourName_Workout" tab
			String closeTab = "Close " + name;
			driver.findElement(By.xpath("//div/button[@title='" + closeTab + "']")).click();
			System.out.println("Created name is successfully closed");

			// Click on Private Dashboards
			driver.findElement(By.xpath("//div/a[@title='Dashboards']")).click();

			driver.findElement(By.xpath("//div/ul//li/a[@title='Private Dashboards']")).click();

			// Verify the newly created Dashboard available

			WebElement ele4 = driver
					.findElement(By.xpath("//*[contains(@placeholder, 'Search private dashboards...')]"));
			ele4.sendKeys(name);
			ele4.click();
			Thread.sleep(3000);
			System.out.println("Newly created dashboard is now available");

			// to filter the result, trying to click on the page as we don't have an enter
			// button
			driver.findElement(By.xpath("//li//span[text()='Private Dashboards']")).click();

			// Click on dropdown for the item
			driver.findElement(
					By.xpath("//tr//td//span[@class='slds-grid slds-align_absolute-center slds-grid_align-spread']"))
					.click();

			// Select Delete
			WebElement ele5 = driver
					.findElement(By.xpath("(//div[@class='slds-dropdown slds-dropdown_left']//following::a)[3]"));
			Actions builder4 = new Actions(driver);
			builder4.moveToElement(ele5).click().perform();
			System.out.println("Delete option is choosed succcesfully from the drop down");

			// Confirm the Delete
			driver.findElement(By.xpath("//div/button[@title='Delete']")).click();
			System.out.println("Delete option clicked successfully from the drop down");

			// Verify the item is not available under Private Dashboard folder

			WebElement ele6 = driver
					.findElement(By.xpath("//*[contains(@placeholder, 'Search private dashboards...')]"));
			ele6.sendKeys(name);
			ele6.click();
			Thread.sleep(3000);
			System.out.println("No new dashboard values are available now !! ");

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}

	}

}
