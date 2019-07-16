package lib.ui.pageObjects;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_RESULT_TITLE_ELEMENT,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_CLOSE_BUTTON,
            SEARCH_RESULT_BY_TITLE_AND_SUBTITLE;

    public SearchPageObject(RemoteWebDriver driver){
        super(driver);
    }

    private static String getResultSearchElement(String substr) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substr);
    }

    private static String getSearchResultElementByTitleAndSubtitle(String title, String subtitle){
        return SEARCH_RESULT_BY_TITLE_AND_SUBTITLE.replace("{TITLE}", title).replace("{SUBTITLE}", subtitle);
    }


    public void initSearchInput(){
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "There is no search field on the screen", 5);

    }

    public void typeSearchLine(String seach_line){
        this.waitForElementAndSendKeys(SEARCH_INPUT, seach_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring){
        String searchResultXpath = getResultSearchElement(substring);
        this.waitForElementPresent(searchResultXpath, "Cannot find search result");
    }

    public void clickForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);

        if (Platform.getInstance().isMV()){
            this.tryClickElementWithFewAttempts(search_result_xpath, "Cannot find search result", 5);
        }
        else {
            this.waitForElementAndClick(search_result_xpath, "Cannot find search result", 15);
        }
    }

    public List<WebElement> getSearchResult(){
        List<WebElement> searchResults = this.waitForListOfElementsPresentByXPath(SEARCH_RESULT_TITLE_ELEMENT,"There is no search results on the screen", 15);
        return searchResults;
    }

    public int getSearchResultCount(){
        List<WebElement> searchResults = getSearchResult();
        return searchResults.size();
    }

    public void clickSearchCloseButton(){
        this.waitForElementAndClick(SEARCH_CLOSE_BUTTON, "There is no search close button on the screen", 5);
    }

    public void waitForSearchResultToDisappear(){
        this.waitForElementNotPresent(SEARCH_RESULT_TITLE_ELEMENT, "Search results still present on the screen", 5);
    }

    public void waitForElementByTitleAndDescription(String title, String description){
        String searchResultXpath = getSearchResultElementByTitleAndSubtitle(title, description);
        this.waitForElementPresent(searchResultXpath, "Cannot find search result by title '" + title + "' and subtitle '" + description + "'");
    }

}