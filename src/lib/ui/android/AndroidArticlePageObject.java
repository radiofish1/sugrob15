package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.pageObjects.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        ARTICLE_MENU_BOOKMARK = "xpath://*[@resource-id='org.wikipedia:id/article_menu_bookmark']";
        GOT_IT_BUTTON = "xpath://*[@text='GOT IT']";
        CREATE_NEW_LIST_BUTTON = "xpath://*[@text='Create new']";
        LIST_TITLE_INPUT = "xpath://*[@resource-id='org.wikipedia:id/text_input']";
        CREATE_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        OVERFLOW_MENU_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/page_toolbar_button_show_overflow_menu']";
        OVERFLOW_FEED_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/page_action_overflow_feed']";
        NO_THANKS_BUTTON = "xpath://*[@resource-id='android:id/button2']";
        ARTICLE_SUBTITLE = "xpath://*[@resource-id='pagelib_edit_section_title_description']";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}