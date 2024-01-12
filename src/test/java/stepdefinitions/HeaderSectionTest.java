package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HeaderSection;

import java.time.Duration;

public class HeaderSectionTest {


    WebDriver driver=Hooks.getDriver();
    HeaderSection headerSection=new HeaderSection(driver);
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    String expected="";
    String actual="";

    @Then("the app logo image should be visible")
    public void appLogoVisibility(){
        Assert.assertTrue(headerSection.findAppLogo().isDisplayed(),"app logo not visible");
    }

    @And("the home route should be visible")
    public void homeRouteVisible(){
        Assert.assertTrue(headerSection.navHomeLink().isDisplayed(),"Home link not visible");
    }

    @And("the jobs route should be visible")
    public void jobsLinkVisible(){
        Assert.assertTrue(headerSection.navJobsLink().isDisplayed(),"Jobs link not visible");
    }

    @And("logout button should be visible")
    public void logoutButtonvisible(){
        Assert.assertTrue(headerSection.logoutButton().isDisplayed(),"logout button not visible");
    }

    @When("I click jobs link on navbar")
    public void clickNavbarJobsLink(){
        headerSection.navJobsLink().click();
    }

    @Then("I should be redirected to the jobs page")
    public void redirectToJobsPage(){
        expected="https://qajobbyapp.ccbp.tech/jobs";
        wait.until(ExpectedConditions.urlToBe(expected));
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,expected,"Jobs link Not visible");
    }

    @When("I click on the app logo")
    public void clickAppLogo(){
        headerSection.clickOnAppLogo();
    }

    @When("I click home route")
    public void clickHomeRoute(){
        headerSection.navHomeLink().click();
    }

    @When("I click logout button")
    public void clickLogoutButton(){
        headerSection.clickLogoutButton();
    }

    @Then("I should be redirected to the login page")
    public void navigateToLoginPage(){
        expected="https://qajobbyapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expected));
        actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,expected,"login page url mismatch");
    }
}
