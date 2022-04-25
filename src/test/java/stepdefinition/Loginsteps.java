package stepdefinition;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginsteps {

	WebDriver driver=Baseclass.driver;
	@Given("User is on SauceDemo login page")
	public void user_is_on_saucedemo_login_page() throws InterruptedException{
	     
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(3000);  
	}
	@When("User enters Username {string} and Password {string}")
public void user_enters_something_and_something(String username, String password){
    	
    	WebElement Username=driver.findElement(By.id("user-name"));
    	WebElement Password=driver.findElement(By.id("password"));
    	Username.sendKeys(username);
    	Password.sendKeys(password);
	}
	@When("User clicks on Login button")
	 public void user_clicks_on_login_button(){
	       
    	WebElement LoginBtn=driver.findElement(By.id("login-button"));
    	LoginBtn.click();
    }
    @Then("User lands on the Product Page")
public void user_lands_on_the_product_page(){
        
    	String ExpTitle="PRODUCTS";
    	WebElement product=driver.findElement(By.xpath("//span[@class='title']"));
    	String actual=product.getText();
    	Assert.assertEquals(ExpTitle, actual);
    	System.out.println("User is on Products Page");
    }
    @Then("User gets the error message as {string}")
public void user_gets_the_error_message_as_something(String ExpMsg){
        
    	WebElement ErrorMsg = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface')]"));
		String ActualMsg = ErrorMsg.getText();
		Assert.assertEquals(ActualMsg, ExpMsg);
    }

}