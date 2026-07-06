package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HomePage;
import utils.ExtentManager;

public class AppLaunchTest extends BaseTest {

    // Use ExtentManager singleton method, not createInstance()
    static ExtentReports extent = ExtentManager.getExtent();
    ExtentTest test;

    @Test
    public void verifyAppLaunchAndHomeOptions() {

        test = extent.createTest("Verify App Launch & Home Screen");

        HomePage home = new HomePage();

        Assert.assertTrue(home.isNotesVisible(),
                "Notes option not visible");
        test.pass("Notes option displayed");

        Assert.assertTrue(home.isChecklistVisible(),
                "Checklist option not visible");
        test.pass("Checklist option displayed");
    }

    @AfterClass
    public void flushReport() {
        extent.flush();
    }
}
