package com.demo.nopcommerce.testsuite;

import com.demo.nopcommerce.pages.BuildYourComputerPage;
import com.demo.nopcommerce.pages.ComputersPage;
import com.demo.nopcommerce.pages.DesktopPage;
import com.demo.nopcommerce.pages.HomePage;
import com.demo.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ComputerTest extends TestBase {
    HomePage homePage = new HomePage();
    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourComputerPage buildYourComputerPage = new BuildYourComputerPage();

    /*
     * Testing Navigate to Computers Page
     */

    @Test (priority = 0, groups = {"smoke", "sanity"})
    public void verifyUserAbleToNavigateToComputersPage() {
        homePage.mouseOverToComputers();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(computersPage.getComputerText().contains("Computers"));
    }

    /*
     * Testing Navigate to Desktop Page via Computers Page
     */

    @Test (priority = 1, groups = {"sanity", "regression"})
    public void verifyUserIsAbleToNavigateToDesktopPageViaComputersPage() {
        homePage.mouseOverToComputers();
        computersPage.clickOnDesktopLink();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(desktopPage.getDesktopText().contains("Desktops"));
    }

    //failing a test
    @Test (priority = 2, groups = {"sanity", "regression"})
    public void verifyUserIsAbleToNavigateToDesktopPage() {
        homePage.mouseOverToComputers();
        computersPage.clickOnDesktopLink();
        Assert.assertEquals(desktopPage.getDesktopText(), "Desk");
    }
}
