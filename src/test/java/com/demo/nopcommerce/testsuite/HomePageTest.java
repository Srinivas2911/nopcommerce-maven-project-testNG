package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HomePageTest extends TestBase {


    //Object for Homepage
    HomePage homePage = new HomePage();

    @Test(priority = 0, groups = {"smoke"})
    public void verifyThatListofAllElementsDisplayedOnHomePage() {
        homePage.listofWebElementsDisplayed();
    }

    @Test(priority = 1, groups = {"sanity"})
    public void verifyThatComputerLinkisDisplayed() {
        homePage.setComputerLink();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(homePage.getComputerText().contains("Computers"));

    }

    //failing a test
    @Test(priority = 2, groups = {"sanity"})
    public void verifyComputerLinkisDisplayed() {
        homePage.setComputerLink();
        Assert.assertEquals(homePage.getComputerText(), "Compute");
    }
}