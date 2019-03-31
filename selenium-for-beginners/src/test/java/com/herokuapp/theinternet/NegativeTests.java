package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

	@Test
	public void incorrectUsernameTest() {
		System.out.println("Starting incorrectusername test");

		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		sleep(3000);

		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// open the page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		sleep(2000);
		System.out.println("Page is opened.");

		// enter incorrect username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith1");

		// enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");

		// push log in button
		WebElement logInButton = driver.findElement(By.className("radius"));
		logInButton.click();

		// Error message
		WebElement errorMessage = driver.findElement(By.id("flash"));
		String expectederrorMessage = "Your username is invalid!";
		String actualerrorMessage = errorMessage.getText();
		Assert.assertTrue(actualerrorMessage.contains(expectederrorMessage),
				"actualerrorMessage does not contain expectederrorMessage\nexpectederrorMessage: "
						+ expectederrorMessage + "\nactualerrorMessage: " + actualerrorMessage);

		sleep(3000);

		// Close browser
		driver.quit();
	}

	@Test
	public void incorrectPasswordTest() {
		System.out.println("Starting incorrectpassword test");

		// Create driver
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		WebDriver driver = new FirefoxDriver();

		sleep(3000);

		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// open the page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		sleep(2000);
		System.out.println("Page is opened.");

		// enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		// enter incorrect password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword");

		// push log in button
		WebElement logInButton = driver.findElement(By.className("radius"));
		logInButton.click();

		// Error message
		WebElement errorMessage = driver.findElement(By.id("flash"));
		String expectederrorMessage = "Your password is invalid!";
		String actualerrorMessage = errorMessage.getText();
		Assert.assertTrue(actualerrorMessage.contains(expectederrorMessage),
				"actualerrorMessage does not contain expectederrorMessage\nexpectederrorMessage: "
						+ expectederrorMessage + "\nactualerrorMessage: " + actualerrorMessage);

		sleep(3000);

		// Close browser
		driver.quit();
	}

	/** Static sleep */
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
