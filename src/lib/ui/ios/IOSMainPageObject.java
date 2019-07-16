package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.pageObjects.MainPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMainPageObject extends MainPageObject {

    static {
        MY_LIST_BUTTON = "xpath://XCUIElementTypeButton[@name='Saved']";
    }

    public IOSMainPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
