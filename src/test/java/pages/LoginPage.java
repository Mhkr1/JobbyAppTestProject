package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginPage {

    @FindBy(className = "login-website-logo")
    WebElement loginAppLogoElement;

    @FindBy(className = "input-label")
    List<WebElement> labelElements;

    @FindBy(id = "userNameInput")
    WebElement usernameInputElement;

    @FindBy(id = "passwordInput")
    WebElement passwordInputElement;

    @FindBy(className = "login-button")
    WebElement loginButtonElement;

    @FindBy(className = "error-message")
    WebElement errorMessageElement;

    WebDriver driver;
    WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findLoginAppLogo() {
        return loginAppLogoElement;
    }

    public WebElement getLabelTextAt(int index) {
        waitForVisibility(labelElements.get(index));
        return labelElements.get(index);
    }

    public void enterUsername(String username){
        usernameInputElement.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInputElement.sendKeys(password);
    }

    public WebElement appLoginButton(){
        return loginButtonElement;
    }

    public void loginToApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        appLoginButton().click();
    }

    public String getErrorMessage() {
        waitForVisibility(errorMessageElement);
        return errorMessageElement.getText();
    }

    private void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}