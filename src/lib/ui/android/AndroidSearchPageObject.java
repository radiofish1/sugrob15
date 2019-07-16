package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.pageObjects.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[@resource-id='org.wikipedia:id/search_src_text']";
        SEARCH_RESULT_TITLE_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/fragment_search_results']//*[contains(@text, '{SUBSTRING}')]";
        SEARCH_CLOSE_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/search_close_btn']";
        SEARCH_RESULT_BY_TITLE_AND_SUBTITLE = "xpath://*[contains(@text, '{TITLE}')]/following-sibling::*[contains(@text, '{SUBTITLE}')]/parent::*";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }
}