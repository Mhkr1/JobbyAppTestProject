package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderSection {

    @FindBy(css = "div[class $= large-container] img.website-logo")
    WebElement appLogoElement;

    @FindBy(css = "div[class $= large-container]>a")
    WebElement appLogoLinkElement;

    @FindBy(linkText = "Home")
    WebElement navHomeLinkElement;

    @FindBy(linkText = "Jobs")
    WebElement navJobsLinkElement;

    @FindBy(className = "logout-desktop-btn")
    WebElement logoutButtonElement;

    WebDriver driver;
    WebDriverWait wait;

    public HeaderSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findAppLogo() {
        waitForVisibility(appLogoElement);
        return appLogoElement;
    }

    public void clickOnAppLogo() {
        waitForVisibility(appLogoLinkElement);
        appLogoLinkElement.click();
    }

    public WebElement navHomeLink() {
        waitForVisibility(navHomeLinkElement);
        return navHomeLinkElement;
    }

    public WebElement navJobsLink() {
        waitForVisibility(navJobsLinkElement);
        return navJobsLinkElement;
    }

    public WebElement logoutButton(){
        waitForVisibility(logoutButtonElement);
        return logoutButtonElement;
    }

    public void clickLogoutButton() {
        logoutButton().click();
        driver.switchTo().alert().accept();

    }

    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}