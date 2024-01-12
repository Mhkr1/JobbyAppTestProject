package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.JobDetailsPage;

import java.util.List;

public class JobsDetailsPageTest {

    WebDriver driver=Hooks.getDriver();
    JobDetailsPage jobDetailsPage=new JobDetailsPage(driver);


    @And("company image should be visible")
    public void companyImageVisible(){
        Assert.assertTrue(jobDetailsPage.getComapanyImage().isDisplayed());
    }

    @And("job title should be visible")
    public void jobTitleVisible(){
        Assert.assertTrue(jobDetailsPage.getJobTitle().isDisplayed());
    }

    @And("job rating should be visible")
    public void jobRatingEl(){
        Assert.assertTrue(jobDetailsPage.getJobRating().isDisplayed());
    }

    @And("location should be visible")
    public void locationStateEl(){
        Assert.assertTrue(jobDetailsPage.getLocationState().isDisplayed());
    }

    @And("employment type should be visible")
    public void employmentTypeEl(){
        Assert.assertTrue(jobDetailsPage.getEmploymentType().isDisplayed());
    }

    @And("job details description should be visible")
    public void jobDetailsDescriptionEl(){
        Assert.assertTrue(jobDetailsPage.getJobDetailsDescription().isDisplayed());
    }

    @And("check skills visible or not")
    public void checkSkillsVisibility(){
        Assert.assertTrue(jobDetailsPage.skillsVisibility().size()>0);
    }

    @And("life inside company should be visible")
    public void  insideCompanyLife(){
        Assert.assertTrue(jobDetailsPage.getLifeOfCompanyDescription().isDisplayed());
    }

    @And("Similar movie should be visible")
    public void similarJobsVisiblity(){
        Assert.assertTrue(jobDetailsPage.getSimilarJobsList().size()>0);
    }
}
