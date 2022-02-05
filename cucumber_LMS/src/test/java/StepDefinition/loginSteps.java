package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	
	WebDriver driver;
	
	@Given ("User opnes the browser")
	public void open_borwser() {
		
		String currDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currDir+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@And ("Navigate to Edureka LMS Portal")
	public void loadUrl() {
		
		driver.get("https://www.edureka.co/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@When ("^User provides the (.*) and (.*)$")
	public void provideDetails(String email, String password) {
		
		driver.findElement(By.xpath("//span[@data-button-name='Login']")).click();
		driver.findElement(By.id("si_popup_email")).sendKeys(email);
		driver.findElement(By.id("si_popup_passwd")).sendKeys(password);
	}
	
	@And ("Clicks on the Login button")
	public void login() {
		
		driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@Then ("User lands on the home page")
	public void homePage() {
		
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"footauto\"]/app-root/app-mycourse-main/section/app-header/header/nav/div/div[3]/ul/li[8]/div/button/span"));
		String actualUsername = userName.getText();
		String expectedUsername = "Amit";
		AssertJUnit.assertEquals(expectedUsername, actualUsername);
	}
	
	@And ("Logout from the portal successfully")
	public void logout() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//span[@class='user_name']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Log Out"))));
		driver.findElement(By.linkText("Log Out")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@data-button-name='Login']"))));
		
	}

}
