package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.JobsPage;

public class JobsPageTest {


    WebDriver driver=Hooks.getDriver();
    JobsPage jobsPage=new JobsPage(driver);
    String expected="";
    String actual="";

    @Then("The profile image should be displayed")
    public void profileImageVisibility(){
        Assert.assertTrue(jobsPage.findProfileImage().isDisplayed(),"profile image not visible");
    }

    @And("The profile name text should be displayed")
    public void profileNameTextVisibility(){
        Assert.assertEquals(jobsPage.getProfileName(),"Rahul Attluri","profile name not visible");
    }

    @And("The short bio text should be displayed")
    public void shortBioVisibility(){
        Assert.assertEquals(jobsPage.getShortBio(),"Lead Software Developer and AI-ML expert","profile short bio not visible");
    }

    int moviesCount=0;
    int actualCount=0;

    String[] movieNames= {"Devops Engineer",
            "Backend Engineer",
            "Frontend Engineer",
            "Fullstack Developer",
            "Data Scientist","ML Engineer"};

    int[] movieVisibility ={9,11,13,6,11,10};

    @When("I search with multiple job names in search bar")
    public void searchWithDifferentMovies(){

        for(int i=0;i<movieNames.length;i++){
                jobsPage.search(movieNames[i]);

                actualCount=jobsPage.getJobsCount();
                Assert.assertEquals(actualCount,movieVisibility[i],"Jobs count does not match");
                moviesCount=moviesCount+1;
                jobsPage.clearInputField();
        }
    }

    @Then("I should get the count of jobs visibled")
    public void totalMovieCount(){
        Assert.assertEquals(moviesCount,6,"total jobs count mismatch");
    }

    @When("Search for the job with the text Netflix")
    public void searchWithInvalidJobName(){
        jobsPage.search("Netflix");
    }

    @Then("The No Jobs Found image should be visible")
    public void noJobsFoundImageVisible(){
        Assert.assertTrue(jobsPage.findJobsNotFoundImage().isDisplayed());
    }

    @And("The No Jobs Found heading text should be visible")
    public void noJobsFoundHeading(){
        Assert.assertEquals(jobsPage.getJobsNotFoundHeading(),"No Jobs Found");
    }

    @And("The No Jobs Found description text should be visible")
    public void noJobsFoundDescription(){
        Assert.assertEquals(jobsPage.getJobsNotFoundDescription(),"We could not find any jobs. Try other filters.");
    }

    @When("I search for \"Devops Engineer\" job")
    public void searchWithJobRole(){
        jobsPage.search("Devops Engineer");
    }

    @And("I click on one job in the page")
    public void clickFirstJobRole(){
        jobsPage.getFirstJob(0).click();
    }

    @Then("I should be redirected to that job details page")
    public void navigateToJobDetailsPage(){
        Assert.assertTrue(jobsPage.getPackageEl().isDisplayed());
    }

}
