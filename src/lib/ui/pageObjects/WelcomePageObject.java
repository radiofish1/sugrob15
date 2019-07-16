package lib.ui.pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class WelcomePageObject extends MainPageObject{

    protected static String
            LEARN_MORE_LINK,
            NEW_WAYS_TO_EXPLORE_TEXT,
            SEARCH_IN_TEXT,
            HELP_TO_MAKE_APP_BETTER_TEXT,
            GET_STARTED_BUTTON,
            NEXT_BUTTON,
            SKIP;

    public WelcomePageObject(RemoteWebDriver driver){
        super(driver);
    }

    public void waitForLearnMoreLink(){
        this.waitForElementPresent(LEARN_MORE_LINK, "Cannot find 'Learn more about Wikipedia' link", 10);
    }

    public void waitForNewWaysText(){
        this.waitForElementPresent(NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'New ways to explore' text", 10);
    }

    public void waitForSearchInText(){
        this.waitForElementPresent(SEARCH_IN_TEXT, "Cannot find 'Search in nearly 300 languages' text", 10);
    }

    public void waitForHelpMakeText(){
        this.waitForElementPresent(HELP_TO_MAKE_APP_BETTER_TEXT, "Cannot find 'Help make the app better' text", 10);
    }

    public void clickNextButton(){
        this.waitForElementAndClick(NEXT_BUTTON, "Cannot find and click 'Next' link", 10);
    }

    public void clickGetStartedButton(){
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find and click 'Get started' button", 10);
    }

    public void skipTutorial(){
        this.waitForElementAndClick(SKIP, "Cannot find and click 'Skip' button", 10);
    }
}