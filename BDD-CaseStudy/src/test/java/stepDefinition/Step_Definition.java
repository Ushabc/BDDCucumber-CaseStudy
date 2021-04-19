package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.select.Evaluator.ContainsData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Step_Definition {
	WebDriver driver;
	@Given("I am able to navigate to Homepage")
	public void i_am_able_to_navigate_to_homepage() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
//	WebDriverManager.firefoxdriver().setup();
//	driver = new FirefoxDriver();
	driver.get("http://elearningm1.upskills.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

	
	@Given("Click on SignUp button")
	public void click_on_sign_up_button() {
	 driver.findElement(By.linkText("Sign up!")).click();
		
	}
	
	@When("I Enter the First name as {string}")
	public void i_enter_the_first_name_as(String string) {
	   driver.findElement(By.name("firstname")).sendKeys(string);
	}
	
	@When("I Enter the Last name as {string}")
	public void i_enter_the_last_name_as(String string) {
		driver.findElement(By.name("lastname")).sendKeys(string);
	    
	}
	
	@When("I Enter the email {string}")
	public void i_enter_the_email(String string) {
		driver.findElement(By.name("email")).sendKeys(string);
	    
	}
	
	@When("I Enter Username as {string}")
	public void i_enter_username_as(String string) {
		driver.findElement(By.name("username")).sendKeys(string);
	   
	}
	
	@When("I Enter Pass as {string}")
	public void i_enter_pass_as(String string) {
		driver.findElement(By.name("pass1")).sendKeys(string);
	  
	}
	
	@When("I Enter Confirm password as {string}")
	public void i_enter_confirm_password_as(String string) {
		driver.findElement(By.name("pass2")).sendKeys(string);
		
	}
	@When("Click on Register button")
	public void click_on_register_button() {
		driver.findElement(By.name("submit")).click();
	}
	@Then("User should be registered successfully")
	public void user_should_be_registered_successfully() {
	    System.out.println("Login successfull");
	    WebElement regis=driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/ul/li"));
		System.out.println(regis.getText());
		String act=regis.getText();
		if(act.contains("The message has been sent to"));
		{
			System.out.println("email sent successfully");
		}

	
	   
	}
	
	//Compose email
	@Given("Able to login to the portal")
	public void able_to_login_to_the_portal() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("login")).sendKeys("ushabc");
		driver.findElement(By.id("password")).sendKeys("Admin@123");
		driver.findElement(By.name("submitAuth")).click();
	 
	}
	
	@When("Click on Compose")
	public void click_on_compose() {   
	    driver.findElement(By.linkText("Compose")).click();
	}
	
	@When("Enter SendTo")
	public void enter_send_to() throws AWTException, InterruptedException {
	WebElement ele= driver.findElement(By.className("select2-search__field"));
	   Actions action=new Actions(driver);
	   action.click(ele).perform();
	   action.sendKeys("Test").perform();
//	   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  Thread.sleep(5000);
	   WebElement eleme=driver.findElement(By.xpath("//*[@id=\"select2-compose_message_users-results\"]/li[1]"));
	   action.click(eleme).perform();
	   

	}
	
	@When("Enter Subject")
	public void enter_subject() {
	    driver.findElement(By.name("title")).sendKeys("Test");
	}
	@When("Click on Send Message")
	public void click_on_send_message() throws InterruptedException {
		 driver.findElement(By.name("compose")).click();
//		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Thread.sleep(5000);
	}
	
	@Then("Email will be sent successfully with acknowledgement")
	public void email_will_be_sent_successfully_with_acknowledgement() {
	WebElement actual=driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div[1]"));
	System.out.println(actual.getText());
	String act=actual.getText();
	if(act.contains("The message has been sent to"));
	{
		System.out.println("email sent successfully");
	}

	   
		
	}

}

