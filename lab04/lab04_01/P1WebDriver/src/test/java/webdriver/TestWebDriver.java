package webdriver;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.invoke.MethodHandles.lookup;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.slf4j.Logger;

class TestWebDriver {

	static final Logger log = org.slf4j.LoggerFactory.getLogger(lookup().lookupClass());
	
	WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		//FirefoxOptions options = new FirefoxOptions().addPreference("browser.startup.homepage","https://www.google.com").setHeadless(true);
		//this.driver = new FirefoxDriver(options);
		this.driver = new ChromeDriver();
	}
	
	@AfterEach
	public void tearDown() {
		//this.driver.close();
		this.driver.quit();
	}

	@Test
	void test() {
		// Exercise
		String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
		driver.get(sutUrl);
		String title = driver.getTitle();
		log.debug("The title of {} is {}", sutUrl, title);

		assertTrue(title.equals("Hands-On Selenium WebDriver with Java"));
	}

}
