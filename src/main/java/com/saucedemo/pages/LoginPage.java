package com.saucedemo.pages;
import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;




public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement emailField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;


    public String getWelcomeText() {
        String message = getTextFromElement(welcomeText);
        return message;
    }

    public void enterEmailId(String email) {
        Reporter.log("Enter email " + email + " to email field" + emailField.toString());
        CustomListeners.test.log(Status.PASS, "Enter EmailId " + emailField);
        sendTextToElement(emailField, email);

    }

    public void enterPassword(String password) throws InterruptedException {
        Reporter.log("Enter Password " + password + " to password field" + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter Password " + passwordField);
        sendTextToElement(passwordField, password);

    }

    public void clickOnLoginButton() {
        Reporter.log("Click on Login Button " + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on loginButton" + loginButton);
        clickOnElement(loginButton);

    }

    public String getErrorMessage() {
        String message = getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS, "Get errorMessage");
        return message;
    }
}
