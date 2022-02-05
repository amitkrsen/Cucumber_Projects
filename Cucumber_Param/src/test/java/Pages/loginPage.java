package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

	WebDriver driver;

	By login1 = By.linkText("Log In");
	By text_email = By.id("si_popup_email");
	By text_password = By.id("si_popup_passwd");
	By login2 = By.xpath("//*[@id=\"new_sign_up_optim\"]/div/div/div[2]/div[3]/form/button");
	By logout = By.linkText("Log Out");

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login1() {
		driver.findElement(login1).click();
	}

	public void email(String email) {
		driver.findElement(text_email).sendKeys(email);
	}

	public void password(String password) {
		driver.findElement(text_password).sendKeys(password);
	}

	public void login2() {
		driver.findElement(login2).click();
	}

	public void logout() {
		driver.findElement(logout).click();
	}
	public void loginValidUser(String email, String password) {

		driver.findElement(login1).click();
		driver.findElement(text_email).sendKeys(email);
		driver.findElement(text_password).sendKeys(password);
		driver.findElement(login2).click();
		driver.findElement(logout).click();
	}

}
