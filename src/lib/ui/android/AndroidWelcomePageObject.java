package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.pageObjects.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidWelcomePageObject extends WelcomePageObject {

    static {
        LEARN_MORE_LINK = "xpath://*[@name ='Learn more about Wikipedia']";
        NEW_WAYS_TO_EXPLORE_TEXT = "xpath://*[@name ='New ways to explore']";
        SEARCH_IN_TEXT = "xpath://*[@name ='Search in nearly 300 languages']";
        HELP_TO_MAKE_APP_BETTER_TEXT = "xpath://*[@name ='Help make the app better']";
        GET_STARTED_BUTTON = "xpath://*[@name ='Get started']";
        NEXT_BUTTON = "xpath://*[@name ='Next']";
        SKIP = "xpath://*[@name ='Skip']";
    }

    public AndroidWelcomePageObject(RemoteWebDriver driver){
        super(driver);
    }
}