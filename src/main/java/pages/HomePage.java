package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.DriverFactory;

public class HomePage {

    private final AndroidDriver driver;

    private static final By NOTES_OPTION = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Notes\")"
    );
    private static final By CHECKLIST_OPTION = AppiumBy.androidUIAutomator(
            "new UiSelector().text(\"Checklist\")"
    );

    public HomePage() {
        this.driver = DriverFactory.getDriver();
    }

    public boolean isNotesVisible() {
        return driver.findElement(NOTES_OPTION).isDisplayed();
    }

    public boolean isChecklistVisible() {
        return driver.findElement(CHECKLIST_OPTION).isDisplayed();
    }
}
