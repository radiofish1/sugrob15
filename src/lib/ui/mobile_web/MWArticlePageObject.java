package lib.ui.mobile_web;

import lib.ui.pageObjects.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        ARTICLE_MENU_BOOKMARK = "css:#ca-watch.mw-ui-icon-mf-watch";
        ARTICLE_TITLE = "css:#content h1";
        OPTIONS_REMOVED_FROM_BOOKMARKS_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watched watched button";
        OVERFLOW_MENU_BUTTON = "css:a[title='Open main menu']";
        MY_LIST_MENU_BUTTON = "css:a[data-event-name='watchlist']";
    }

    public MWArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}