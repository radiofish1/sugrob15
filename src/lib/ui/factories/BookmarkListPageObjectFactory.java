package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.android.AndroidBookmarkListPageObject;
import lib.ui.ios.IOSBookmarkListPageObject;
import lib.ui.mobile_web.MWArticlePageObject;
import lib.ui.mobile_web.MWBookmarkListPageObject;
import lib.ui.pageObjects.BookmarkListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BookmarkListPageObjectFactory {

    public static BookmarkListPageObject get(RemoteWebDriver driver){

        if(Platform.getInstance().isAndroid()) {
            return new AndroidBookmarkListPageObject(driver);
        } else if (Platform.getInstance().isMV()) {
            return new MWBookmarkListPageObject(driver);
        } else {
            return new IOSBookmarkListPageObject(driver);
        }
    }
}