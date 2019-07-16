package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.android.AndroidMainPageObject;
import lib.ui.ios.IOSMainPageObject;
import lib.ui.mobile_web.MWBookmarkListPageObject;
import lib.ui.mobile_web.MWMainPageObject;
import lib.ui.pageObjects.MainPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainPageObjectFactory {

    public static MainPageObject get(RemoteWebDriver driver){

        if(Platform.getInstance().isAndroid()) {
            return new AndroidMainPageObject(driver);
        } else if (Platform.getInstance().isMV()) {
            return new MWMainPageObject(driver);
        } else {
            return new IOSMainPageObject(driver);
        }
    }
}