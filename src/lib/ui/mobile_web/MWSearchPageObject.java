package lib.ui.mobile_web;

import lib.ui.pageObjects.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_TITLE_ELEMENT = "css:ul.page-list>li.page-summary";
        // SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikipedia-description')][contains(text(), '{SUBSTRING}')]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://h3[contains(text(),'{SUBSTRING}')]";
        SEARCH_CLOSE_BUTTON = "css:button.cancel";
    }

    public MWSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }


}