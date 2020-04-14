package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.pages.RegisterPage;
import com.demo.nopcommerce.pages.RegistrationCompletePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.demo.nopcommerce.utility.Utility.getRandomString;

public class RegistrationTest extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    RegistrationCompletePage registrationCompletePage = new RegistrationCompletePage();

    String firstName = "Roger";
    String lastName = "Moore";
    String dateOfBirth = "1";
    String monthOfBirth = "January";
    String yearOfBirth = "1980";
    String email = null;
    String companyName = "Roger Moore International";
    String password = null;
    String wrongPassword = "Roger77777";

    @BeforeClass(groups = {"smoke", "sanity", "regression"})
    public void setUpEmail (){
        email = "Roger" + getRandomString(4) + "@gmail.com";
        password = "Roger" + getRandomString(3);
    }
    /*
     * Navigating to Registration Page
     */

      @Test (priority = 0, groups = {"smoke", "sanity"})

    public void verifyThatUserIsAbleToNavigateToRegisterPage() {
        homePage.setRegisterLink();
        registerPage.setRegisterText();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(registerPage.getRegisterText().contains("Register"));

//        String expectedText = "Register";
//        String actualText = registerPage.getRegisterText();
//        Assert.assertEquals(expectedText, actualText);

    }


    /*
     * Testing Registration with valid credentials
     */

    @Test (priority = 2, groups = {"sanity", "regression"})
    @Parameters({"firstName", "lastName"} )

        public void verifyThatNewUserIsAbleToRegisterSuccessfully() {


        homePage.setRegisterLink();
        registerPage.clickOnGenderField();
        registerPage.waitForElementIsVisible();
        registerPage.enterFirstNameField(firstName);
        registerPage.enterLastNameField(lastName);
        registerPage.setDayOfBirthField(dateOfBirth);
        registerPage.setMonthOfBirthField(monthOfBirth);
        registerPage.setYearOfBirthField(yearOfBirth);
        registerPage.setNewUserEmailField(email);
        registerPage.setCompanyField(companyName);
        registerPage.setNewUserPasswordField(password);
        registerPage.setConfirmPasswordField(password);
        registerPage.setNewUserRegisterButton();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(registrationCompletePage.getRegistrationConfirmText().contains("Your registration completed"));
    }

    ////failing a test
        @Test(priority = 2, groups = {"regression"})
        public void verifyThatNewUserIsAbleToRegister () {
            homePage.setRegisterLink();
            registerPage.clickOnGenderField();
            registerPage.waitForElementIsVisible();
            registerPage.enterFirstNameField(firstName);
            registerPage.enterLastNameField(lastName);
            registerPage.setDayOfBirthField(dateOfBirth);
            registerPage.setMonthOfBirthField(monthOfBirth);
            registerPage.setYearOfBirthField(yearOfBirth);
            registerPage.setNewUserEmailField(email);
            registerPage.setCompanyField(companyName);
            registerPage.setNewUserPasswordField(password);
            registerPage.setConfirmPasswordField(password);
            registerPage.setNewUserRegisterButton();
            Assert.assertEquals(registrationCompletePage.getRegistrationConfirmText(), "Your registration");

        }

//        /*
//         * Testing Login with invalid credentials
//         * Expected error message
//         */
    @Test (priority = 3, groups = {"sanity", "regression"})
    public void verifyUserisNotBeAbleToRegisterWithInvalidCredentials() {
        homePage.setRegisterLink();
        registerPage.clickOnGenderField();
        registerPage.waitForElementIsVisible();
        registerPage.enterFirstNameField(firstName);
        registerPage.enterLastNameField(lastName);
        registerPage.setDayOfBirthField(dateOfBirth);
        registerPage.setMonthOfBirthField(monthOfBirth);
        registerPage.setYearOfBirthField(yearOfBirth);
        registerPage.setNewUserEmailField(email);
        registerPage.setCompanyField(companyName);
        registerPage.setNewUserPasswordField(password);
        registerPage.setWrongConfirmPasswordField(wrongPassword);
        registerPage.setNewUserRegisterButton();
        registerPage.registrationErrorMessageText();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(registerPage.getRegistrationErrorMessage().contains("The password and confirmation password do not match."));

    }
}
