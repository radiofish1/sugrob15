package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.pageObjects.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField";
        SEARCH_RESULT_TITLE_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{SUBSTRING}')]";
        SEARCH_CLOSE_BUTTON = "xpath://XCUIElementTypeButton[@name='Close']";
    }

    public IOSSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }


}