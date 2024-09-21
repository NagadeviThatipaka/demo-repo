package home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverTest {

	public static void main(String[] args) {
	
		//set the path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "I:\\Devi\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		

        try {
            // Open a webpage
            driver.get("https://www.simplyhired.co.in/search?q=java&l=");

            // Get the title of the webpage
            String title = driver.getTitle();

            // Print the title
            System.out.println("The title of the webpage is: " + title);
            
            // Find an element by tag name
            WebElement divs = driver.findElement(By.tagName("div"));
            System.out.println("div text: " + divs.getText());

            // Find all links on the page
            java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
            for (WebElement link : links) {
                System.out.println("Link: " + link.getAttribute("href"));
            }
        

        } finally {
            // Close the browser session
            driver.quit();
        }

	}

}
