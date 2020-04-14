package com.demo.nopcommerce.pages;

import com.demo.nopcommerce.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    By loginWelcomeText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
    By loginEmailField = By.id("Email");
    By loginPasswordField = By.xpath("//input[@name='Password']");
    By rememberMeCheckBox = By.xpath("//label[contains(text(),'Remember me?')]");
    By forgotPasswordLink = By.xpath("//a[contains(text(),'Forgot password?')]");
    By loginUserButton = By.xpath("//input[@class='button-1 login-button']");

    public void welcomeSignInPage() {
        verifyThatTextIsDisplayed(loginWelcomeText, "Welcome, Please Sign In!");
    }
    public String getWelcomeText() {
        return getTextFromElement(loginWelcomeText);
    }

//    public void waitForVisibilityofElement(){
//        waitUntilVisibilityOfElementLocated(loginEmailField, 90);
//    }

    public void enterReturningUserEmail(String email) {
        waitUntilVisibilityOfElementLocated(loginEmailField, 90);
        sendTextToElement(loginEmailField, email);
    }

    public void enterReturningUserPassword(String password) {
        sendTextToElement(loginPasswordField,password );
    }

    public void enterReturningUserWrongPassword(String wrongPassword) {
        sendTextToElement(loginPasswordField, wrongPassword);
    }

    public void clickonReturningUserLoginButton() {
        clickOnElement(loginUserButton);
    }
    public void setRememberMeCheckBox() {
        clickOnElement(rememberMeCheckBox);
    }

    public void setForgotPasswordLink() {
        clickOnElement(forgotPasswordLink);
    }
}
