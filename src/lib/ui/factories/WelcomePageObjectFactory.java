package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.android.AndroidWelcomePageObject;
import lib.ui.ios.IOSWelcomePageObject;
import lib.ui.pageObjects.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObjectFactory {

    public static WelcomePageObject get(RemoteWebDriver driver){

        if(Platform.getInstance().isAndroid()) {
            return new AndroidWelcomePageObject(driver);
        } else {
            return new IOSWelcomePageObject(driver);
        }
    }
}