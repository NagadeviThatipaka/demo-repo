package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SimplyhiredEPE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
				System.setProperty("webdriver.chrome.driver",
						"I:\\\\\\\\Devi\\\\\\\\ChromeDriver\\\\\\\\chromedriver-win64\\\\\\\\chromedriver.exe");

				// Initialize the Chrome driver
				ChromeOptions options = new ChromeOptions();
				// options.addArguments("--headless"); // Run in headless mode
				WebDriver driver = new ChromeDriver(options);

				try {
					// Navigate to the website
					String path = "https://www.simplyhired.co.in/search?q=java&l=";
					driver.get(path);

					String detailsPath = "/html/body/div[1]/div/main/div/div[2]/div/div/div[2]/div/div/div/aside/div/div[1]/div/div[4]/div/div";

					WebElement detailElement = driver.findElement(By.xpath(detailsPath));
					System.out.println("Detail: " + detailElement.getText());
					


				 } catch (Exception e) {
					e.printStackTrace();
				} finally {
					// Close the browser
					driver.quit();
				}
	}

}
