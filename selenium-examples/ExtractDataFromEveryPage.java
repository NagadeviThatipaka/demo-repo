package home;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Strings;

public class ExtractDataFromEveryPage {

	public static void main(String[] args) throws Throwable {
		int NO_PAGES_TO_PRINT = 3;
		System.setProperty("webdriver.chrome.driver", "I:\\Devi\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

		// Initialize the Chrome driver
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless"); // Run in headless mode
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			// Navigate to the website
			driver.get("https://www.simplyhired.co.in/search?q=java&l=hyderabad%2C+telangana");

			int nextPageNo = 2;

			// Loop through all the pages
			boolean hasNextPage = true;
			while (hasNextPage) {
				
				if ((nextPageNo-1) > NO_PAGES_TO_PRINT) {
					break;
				}

				System.out.println("Page No: " + (nextPageNo - 1));

				// Extract data from the current page
				extractDataFromPage(driver);

				String pageXPath = "//a[@aria-label='page " + nextPageNo + "']";

				// Check if the "Next" button exists and is enabled
				try {

					WebElement div = driver.findElement(By.className("css-ukpd8g")); 
					// Use the correct locator for the "Next" button
					
					WebElement nav = div.findElement(By.tagName("nav"));

					System.out.println("nav: " + nav.getText());

					WebElement pageElement = nav.findElement(By.xpath(pageXPath));

					if (pageElement != null) {
						// Click the "Next" button
						pageElement.click();

						// Wait for the next page to load (you might need to wait for a specific element
						// to be visible)
						// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pageNumberBlockNext")));
					} else {
						hasNextPage = false; // No more pages
					}
				} catch (Exception e) {
					hasNextPage = false; // No "Next" button found, end of pagination
					e.printStackTrace();
				}
				Thread.sleep(2000);
				nextPageNo++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
		// Open the webpage

	}

	private static void extractDataFromPage(WebDriver driver) {
		try {

			List<WebElement> items = driver.findElement(By.id("job-list")).findElements(By.tagName("li"));

			System.out.println("Total Jobs : " + items.size());

			for (int i = 0; i < items.size(); i++) {
				WebElement item = items.get(i);
				item.click();
				Thread.sleep(2000);

				WebElement parentElement = driver.findElement(By.className("css-k008qs"));

				System.out.println("Job No : " + i);

				// Get all child elements of the parent element
				List<WebElement> childElements = parentElement.findElements(By.className("css-1ebprri"));

				// Loop through the child elements and extract the required data
				for (WebElement child : childElements) {
					// Get text, attribute, or any other relevant data
					String childText = child.getText();
					String childAttribute = child.getAttribute("");

					// Print the child data
				//	System.out.println("Child Element Text: " + childText);
					// System.out.println("Child Element Attribute: " + childAttribute);
				}

				System.out.println("===================================================");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
