package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class CertificationsSort {

	public static void main(String[] args) throws InterruptedException {

		// Test case# S20-15

		WebDriverManager.chromedriver().setup();

		WebDriver driver;

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		Thread.sleep(3000);

		// String parent = driver.getWindowHandle();
		// System.out.println(driver.getTitle());

		String parentHandle = driver.getWindowHandle();
		// driver.getTitle();
		System.out.println(parentHandle);

		driver.findElement(By.id("username")).sendKeys("cypress@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		driver.findElement(By.name("Login")).click();

		Thread.sleep(7000);
		// Clicking on the sliding button
		driver.findElement(By.xpath("//div//button[@data-aura-class='uiButton'][1]")).click();
		System.out.println("'Sliding button' clicked successfully");

		Thread.sleep(3000);
		// Clicking on the Get Started button
		driver.findElement(By.xpath("(//div//article//div//button[@title='Get Started'])[6]")).click();
		System.out.println("'Get Started' button is clicked successfully");

		java.util.Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);

		for (String handle1 : driver.getWindowHandles()) {
			// driver.getTitle();
			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}

		// Navigating to the newly opened window
		System.out.println("'Salesforce Trust' window is opened successfully");

		Thread.sleep(3000);
		// Clicking on the drop down icon
		driver.findElement(By.xpath("//div//div[@id='dropdown-list']")).click();
		System.out.println("Clicking on the drop down successfully");

		Thread.sleep(2000);
		// Clicking on the Trust Compliance option from the drop down
		WebElement ele = driver.findElement(By.xpath("//div/ul//li/a/span[@title='Menu Item Three']"));
		Actions build = new Actions(driver);
		build.moveToElement(ele).click().perform();
		System.out.println("'Trust | Compliance' option is clicked successfully from the drop down");

		Thread.sleep(3000);
		// Clicking on the option to 'Sort alphabetically'
		driver.findElement(By.xpath("//div//button[text()=' Sort by popularity ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//button[text()=' Sort alphabetically ']")).click();

		System.out.println("'Sort alphabetically' button is clicked successfully");

		Thread.sleep(2000);
		// To verify if the tiles are arranged alphabetically or not

		List<WebElement> tiles = driver.findElements(By.xpath("//h2[contains(@class,'f5 mb2 lh-title')]/a"));
		// Select se = new Select (tile);

		List<String> originalList = new ArrayList<String>();

		for (WebElement e : tiles) {
			originalList.add(e.getText());
		}
		System.out.println("Original List of tiles are:" +"\n"+ originalList);

		List<String> tempList = originalList;
		Collections.sort(tempList);
		System.out.println("After sorting the tiles alphabetically are:" +"\n"+ tempList);
		// Assert.assertEquals(tempList, originalList);

		if (originalList == tempList) {
			System.out.println("Tiles are sorted alphabetically as expected");
		} else {
			System.out.println("Tiles are not sorted alphabetically as expected");
		}
	}
}
