package lib.ui.mobile_web;

import lib.ui.pageObjects.MainPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class  MWMainPageObject extends MainPageObject {

    static {
        MY_LIST_BUTTON = "xpath://*[contains(@text, '{TITLE}')]/following-sibling::*[contains(@text, '{SUBTITLE}')]/parent::*";
    }

    public MWMainPageObject(RemoteWebDriver driver){
        super(driver);
    }
}