package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    @FindBy(className = "home-heading")
    WebElement headingTextElement;

    @FindBy(className = "home-description")
    WebElement descriptionTextElement;

    @FindBy(className = "find-jobs-button")
    WebElement findJobsButtonElement;

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeadingText() {
        waitForVisibility(headingTextElement);
        return headingTextElement.getText();
    }

    public String getDescriptionText() {
        waitForVisibility(descriptionTextElement);
        return descriptionTextElement.getText();
    }

    public WebElement findindJobsButton(){
        waitForVisibility(findJobsButtonElement);
        return findJobsButtonElement;
    }

    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}