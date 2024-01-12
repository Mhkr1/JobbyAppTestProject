package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    String expected;
    String actual;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage(){
        driver.get("https://qajobbyapp.ccbp.tech/login");
    }

    @When("I enter valid username as 'rahul'")
    public void enterValidUsername(){
        loginPage.enterUsername("rahul");
    }

    @And("I enter valid password as 'rahul@2021'")
    public void enterValidPassword(){
        loginPage.enterPassword("rahul@2021");
    }

    @And("I click the login button")
    public void clickTheLoginButton(){
        loginPage.appLoginButton().click();
    }

    @Then("I should be redirected to the home page")
    public void navigatingToHomePage(){
        expected="https://qajobbyapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expected));
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,expected,"Login failed");
    }

    @When("The website is opened perfectly")
    public void websiteOpenPerfectly(){
        expected="https://qajobbyapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expected));
    }

    @Then("the app logo image should be displayed")
    public void appLogoDisplay(){
        Assert.assertTrue(loginPage.findLoginAppLogo().isDisplayed(),"App logo image is not displayed");
    }


    @And("the username label text should be \"USERNAME\"")
    public void checkUserNameText(){
        Assert.assertEquals(loginPage.getLabelTextAt(0).getText(),"USERNAME","username text Mismatch");
    }

    @And("the password label text should be \"PASSWORD\"")
    public void checkPasswordText(){
        Assert.assertEquals(loginPage.getLabelTextAt(1).getText(),"PASSWORD","Password Text Mismatch");
    }

    @And("the login button should be displayed")
    public void checkLoginbuttonDisplay(){
        Assert.assertTrue(loginPage.appLoginButton().isDisplayed(),"App logo image is not displayed");
    }

    @Then("an error message '*Username or password is invalid' should be visible")
    public void errorMessage(){
        String actualErrorMessage=loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage,"*Username or password is invalid","error message Mismatch");
    }


    @And("I enter invalid password as 'rahul2021'")
    public void enteringInvalidPassword(){
        loginPage.enterPassword("rahul2021");
    }

    @Then("an error message '*username and password didn't match' should be visible")
    public void getErrorForInvalidCredentials(){
        String actualErrorMsg=loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMsg,"*username and password didn't match","error Mismatch");
    }
}