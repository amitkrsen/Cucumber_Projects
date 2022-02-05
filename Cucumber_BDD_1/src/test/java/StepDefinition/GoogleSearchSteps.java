package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	WebDriver driver;

	@Given("Browser is open")
	public void browser_is_open() {
		String browser = "CHROME";
		String currDir = System.getProperty("user.dir");

		//calling chrome browser...
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currDir+"\\drivers\\chromedriver.exe");

			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
			driver = new ChromeDriver(option);
			System.out.println("Chrome browser has opened.");
		}
		//calling firefox browser...
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", currDir+"\\drivers\\geckodriver.exe");

			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("start-maximized");
			driver = new FirefoxDriver(option);
		}
	}

	@And("User is on the Google search page")
	public void user_is_on_the_google_search_page() {
		String url = "https://google.com";

		//get url...
		if(url != "")
			driver.get(url);
		else
			driver.get("about:blank");
		
		System.out.println("Google search page opened.");
	}

	@When("User provides the text in the search box")
	public void user_provides_the_text_in_the_search_box() {
		
		driver.findElement(By.name("q")).sendKeys("UEFA CHampions League");
		System.out.println("User provided search criteria.");
	}

	@And("Press the enter button")
	public void press_the_enter_button() {

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		System.out.println("User preesed Enter button.");
	}

	@Then("Page displays the search results")
	public void page_displays_the_search_results() {

		String actualText = driver.findElement(By.xpath("//*[@id=\"sports-app\"]/div/div[3]/div/div/div/div/div[1]/div[2]/div[1]/div/div[3]/div[2]/div")).getText();
		String expectedText = "Chelsea";
		
		Assert.assertTrue(expectedText.equalsIgnoreCase(actualText));
		
		//if(expectedText.equalsIgnoreCase(actualText))
			//System.out.println("The expected text is same as actual text - "+actualText);
		//else
			//System.out.println("The expected text doesn't match the actual text - "+ "ActualText: "+actualText+" ExpectedText: "+expectedText);
		
		driver.close();
		driver.quit();
	}

}
