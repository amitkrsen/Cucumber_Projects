package StepDefinition_POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.loginPage;
import io.cucumber.java.en.*;

public class loginSteps_POM {

	WebDriver driver;
	loginPage login;
	
	@Given("Users opens the browser")
	public void users_opens_the_browser() {

		String browser = "CHROME";
		String currDir = System.getProperty("user.dir");

		//calling chrome browser...
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currDir+"\\drivers\\chromedriver.exe");

			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
			driver = new ChromeDriver(option);
		}
		//calling firefox browser...
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", currDir+"\\drivers\\geckodriver.exe");

			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("start-maximized");
			driver = new FirefoxDriver(option);
		}
	}

	@And("Navigate to the Edureka portal")
	public void navigate_to_the_edureka_portal() {

		String url = "https://www.edureka.co/";

		//get url...
		if(url != "")
			driver.get(url);
		else
			driver.get("about:blank");
	}

	@When("^User provides the (.*) and (.*)$")
	public void user_provides_the_email_and_password(String email, String password) {
		
		login = new loginPage(driver);
		login.login1();
		login.email(email);
		login.password(password);
				
//		driver.findElement(By.linkText("Log In")).click();
//		driver.findElement(By.id("si_popup_email")).sendKeys(email);
//		driver.findElement(By.id("si_popup_passwd")).sendKeys(password);	
	}

	@And("Clicks of the Login button")
	public void clicks_of_the_login_button() {
//		driver.findElement(By.xpath("//*[@id=\"new_sign_up_optim\"]/div/div/div[2]/div[3]/form/button")).click();
		
		login.login2();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id=\"footauto\"]/app-root/app-mycourse-main/section/app-header/header/nav/div/div[3]/ul/li[2]/div/button"))));
	}

	@Then("User land on the My Course page")
	public void user_land_on_the_my_course_page() {

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://learning.edureka.co/mycourses";

		Assert.assertTrue(expectedUrl.equalsIgnoreCase(actualUrl));
		System.out.println("The Actual url is: "+actualUrl);

	}

	@And("Logout from the portal successfully")
	public void logout_from_the_portal_successfully() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footauto\"]/app-root/app-mycourse-main/section/app-header/header/nav/div/div[3]/ul/li[8]/div/button/img")));
		driver.findElement(By.xpath("//*[@id=\"footauto\"]/app-root/app-mycourse-main/section/app-header/header/nav/div/div[3]/ul/li[8]/div/button/img")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
		login.logout();
		
		System.out.println("== Test has been run POM file ==");
		
		driver.close();
		driver.quit();
	}

}
