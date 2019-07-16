package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.pageObjects.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        ARTICLE_MENU_BOOKMARK = "xpath://XCUIElementTypeButton[@name='Save for later']";
        ARTICLE_SUBTITLE = "xpath://XCUIElementTypeStaticText[@name='{SUBTITLE}']";
        GO_BACK_BUTTON = "xpath://XCUIElementTypeButton[@name='Back']";
        CLOSE_DIALOG_BUTTON = "xpath://XCUIElementTypeButton[@name='places auth close']";
    }

    public IOSArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}
