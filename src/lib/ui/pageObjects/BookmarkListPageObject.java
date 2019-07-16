package lib.ui.pageObjects;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class BookmarkListPageObject extends MainPageObject {

    protected static String
            ARTICLE_TITLE,
            REMOVE_FROM_SAVE_BUTTON;

    public BookmarkListPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getListItemElement(String substr) {
        return ARTICLE_TITLE.replace("{ARTICLE_TITLE}", substr);
    }

    private static String getRemovedButtonByTitle(String substr) {
        return REMOVE_FROM_SAVE_BUTTON.replace("{ARTICLE_TITLE}", substr);
    }

    /* TEMPLATES METHODS */

    public void deleteArticleFromListBySwipe(String articleTitle) throws InterruptedException {

        if (Platform.getInstance().isMV()){
            String remove_locator = getRemovedButtonByTitle(articleTitle);
            this.waitForElementAndClick(remove_locator, "Cannot find saved article to removed", 5);

            driver.get(driver.getCurrentUrl());
        }

        else if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            this.swipeElementToLeft(getListItemElement(articleTitle), "Cannot find '" + articleTitle + "'");
            if (Platform.getInstance().isIOS()){
                this.clickElementToTheRightUpperCorner(getListItemElement(articleTitle), "Cannot find saved article");
            }
        }
    }

    public void openArticle(String articleTitle){
        this.waitForElementAndClick(getListItemElement(articleTitle), "There is no article with title '" + articleTitle + "' on the screen", 5);
    }

    public void checkArticlePresentInList(String atricleTitle){
        this.waitForElementPresent(getListItemElement(atricleTitle), "Atricle with name ' " + atricleTitle + " not present in list'");
    }

    public void checkArticleNotPresentInList(String atricleTitle){
        this.waitForElementNotPresent(getListItemElement(atricleTitle), "Atricle with name ' " + atricleTitle + " is present in list'", 5);
    }
}