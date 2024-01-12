package pages;

import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JobDetailsPage {

    @FindBy(css = "div.job-details-container>div:nth-of-type(1)>img")
    WebElement companyImage;

    @FindBy(css="div.job-details-container>div:first-child>div>h1")
    WebElement jobTitleName;

    @FindBy(css = "div.job-details-container>div:first-child p")
    WebElement jobRating;

    @FindBy(css = "div.job-details-container>div:nth-child(2) div>div.location-container>p")
    WebElement locationState;

    @FindBy(css = "div.job-details-container>div:nth-child(2) div>div.employment-type-container>p")
    WebElement employmentType;

    @FindBy(className = "job-detail-description")
    WebElement jobDetailDescription;

    @FindBy(css = "h1.skills-heading+ul>li")
    List<WebElement> skills;


    @FindBy(className = "life-at-company-description")
    WebElement lifeOfCompanyDescription;


    @FindBy(className = "similar-job-item")
    List<WebElement> similarJobs;


    WebDriver driver;
    WebDriverWait wait;

    public JobDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public WebElement getComapanyImage(){
        return companyImage;
    }

    public WebElement getJobTitle(){
        return jobTitleName;
    }

    public WebElement getJobRating(){
        return jobRating;
    }

    public WebElement getLocationState(){
        return locationState;
    }

    public WebElement getEmploymentType(){
        return employmentType;
    }


    public WebElement getJobDetailsDescription(){
        return jobDetailDescription;
    }

    public List<WebElement> skillsVisibility(){
        return skills;
    }

    public WebElement getLifeOfCompanyDescription(){
        return lifeOfCompanyDescription;
    }

    public List<WebElement> getSimilarJobsList(){
        return similarJobs;
    }


}
