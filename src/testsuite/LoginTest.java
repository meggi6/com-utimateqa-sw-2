package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Create the package ‘testsuite’ and create the following class inside
 * * the ‘testsuite’ package. 1. LoginTest 3. Write down the following test into ‘LoginTest’ class
 * * 1. userShouldNavigateToLoginPageSuccessfully
 * * * click on the ‘Sign In’ link * Verify the text ‘Welcome Back!’
 * * 2. verifyTheErrorMessage * click on the ‘Sign In’ link * Enter invalid username
 * * * Enter invalid password * Click on Login button * Verify the error message ‘Invalid email or password.
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    //Before annotation run in the beginning of all tests
    @Before
    //Browser set-up method
    public void setUp() {
        openBrowser(baseUrl);
    }

    //After annotation method run at the end of all tests
    @After
    //Browser closing method
    public void tearDown() {
        closeBrowser();
    }

    //Test annotation for executing the method
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find sign-in link element and click on it
        driver.findElement(By.xpath("//a[@href = '/users/sign_in']")).click();
        //Expected text according to requirement
        String expectedWelcomeText = "Welcome Back!";
        //Find Products text element and get it's text
        String actualWelcomeText = driver.findElement(By.xpath("//article[@class = 'sign-in__form']//h2[@class='page__heading']")).getText();
        //String actualWelcomeText = driver.findElement(By.linkText("Welcome Back!")).getText();
        //Verify expected and actual text
        Assert.assertEquals("Text is not matching", expectedWelcomeText, actualWelcomeText);
    }

    //Test annotation for executing the method
    @Test
    public void verifyTheErrorMessage(){
        //Find sign-in link element and click on it
        driver.findElement(By.xpath("//a[@href = '/users/sign_in']")).click();
        //Find username field element and enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("megha123");
        //Find password field element and enter invalid password
        driver.findElement(By.name("user[password]")).sendKeys("megha123");
        //Find sign-in button element and click on it
        driver.findElement(By.className("g-recaptcha")).click();
        //Expected text according to requirement
        String expectedErrorMessageText = "Invalid email or password";
        //Find Error Message element and get it's text
        String actualErrorMessageText = driver.findElement(By.xpath("//li[@class = 'form-error__list-item']")).getText();
        //Verify expected and actual text
        Assert.assertEquals("Text is not matching", expectedErrorMessageText, actualErrorMessageText);
    }
}
