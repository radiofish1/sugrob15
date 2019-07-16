package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.pageObjects.BookmarkListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSBookmarkListPageObject extends BookmarkListPageObject {

    static {
        ARTICLE_TITLE = "xpath://XCUIElementTypeLink[contains(@name, '{ARTICLE_TITLE}')]";
    }

    public IOSBookmarkListPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
