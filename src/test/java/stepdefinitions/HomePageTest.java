package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;

import java.time.Duration;

public class HomePageTest {

    WebDriver driver = Hooks.getDriver();
    HomePage homePage=new HomePage(driver);
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    String expected="";
    String actual="";

    @When("I am on home page home heading should be visible")
    public void homeHeadingText(){
        Assert.assertEquals(homePage.getHeadingText(), "Find The Job That Fits Your Life","home heading mismatch");
    }

    @Then("the home description should be visible")
    public void homeDescription(){
        Assert.assertEquals(homePage.getDescriptionText(),"Millions of people are searching for jobs, salary information, company reviews. Find the job that fits your abilities and potential.","home description mismatch");
    }

    @And("Find jobs button should be visible")
    public void findJobsButtonVisibility(){
        Assert.assertTrue(homePage.findindJobsButton().isDisplayed(),"find jobs button not visible");
    }

    @When("Click the find jobs button")
    public void clickFindJobsButtonEl(){
        homePage.findindJobsButton().click();
    }

    @Then("I should be navigated to that find jobs page")
    public void navigateToFindJobsPage(){
        expected="https://qajobbyapp.ccbp.tech/jobs";
        wait.until(ExpectedConditions.urlToBe(expected));
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,expected,"Urls Mismatch");
    }
}

