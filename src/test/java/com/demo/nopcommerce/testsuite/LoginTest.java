package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.pages.*;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {
    //Object for Home Page, Login Page, WelcomeStorePage and WelcomeErrorPage

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    WelcomeStorePage welcomeStorePage = new WelcomeStorePage();
    LoginErrorMessagePage loginErrorMessagePage = new LoginErrorMessagePage();

    String email = "Roger123@gmail.com";
    String password = "Roger1980";
    String wrongPassword = "Roger197777";

    /*
     * Navigating to Login Page
     */

    @Test(priority = 0, groups = {"smoke", "sanity"})
    public void verifyUserIsAbletoNavigatetoLoginPage() {
        homePage.setLoginLink();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(loginPage.getWelcomeText().contains("Welcome, Please Sign In!"));

    }

    /*
     * Testing Login with valid credentials
     */

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void verifyUserIsAbleToLoginSuccessfully() {
        homePage.setLoginLink();
        loginPage.enterReturningUserEmail(email);
        loginPage.enterReturningUserPassword(password);
        loginPage.clickonReturningUserLoginButton();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(welcomeStorePage.getWelcomeStoreText().contains("Welcome to our store"));

    }

    ////failing a test
    @Test(priority = 2, groups = {"regression"})
    public void verifyUserIsAbleToLoginSuccessfullywithWrongDetails() {
        homePage.setLoginLink();
        loginPage.enterReturningUserEmail(email);
        loginPage.enterReturningUserPassword(wrongPassword);
        loginPage.clickonReturningUserLoginButton();
        Assert.assertEquals(welcomeStorePage.getWelcomeStoreText(), "Wrong email");
    }


    @Test(priority = 3, groups = {"sanity", "regression"})
    public void verifyUserIsNotAbleToLoginWithInvalidCredentials() {
        homePage.setLoginLink();
        loginPage.enterReturningUserEmail(email);
        loginPage.enterReturningUserWrongPassword(wrongPassword);
        loginPage.clickonReturningUserLoginButton();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(loginErrorMessagePage.getErrorMessageText().contains("Login was unsuccessful. Please correct the errors and try again."));
    }

}
