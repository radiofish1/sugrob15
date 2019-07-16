package lib.tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.factories.*;
import lib.ui.pageObjects.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstTest extends CoreTestCase {

    private static final String LOGIN = "AppiumTest";
    private static final String PASS = "abc123";

    private MainPageObject mainPAgeObject;

    protected void setUp() throws Exception{
        super.setUp();
    }


    @Test
    public void testCheckSearchField(){

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Object-oriented programming language");
    }


    @Test
    public void testCheckSearchResultPresent(){

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");

        int resultCount = searchPageObject.getSearchResultCount();
        Assert.assertTrue("There is no search results on the screen", resultCount>0);

        searchPageObject.clickSearchCloseButton();
        searchPageObject.waitForSearchResultToDisappear();
    }


    @Test
    public void testCheckSearchResultContainsRequestedString(){

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        String searchString = "java";

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchString);

        List<WebElement> search_results = searchPageObject.getSearchResult();

        for (WebElement we : search_results){
            Assert.assertTrue("Result does not contains search world", we.getText().toLowerCase().contains(searchString));
        }
    }


    @Test
    public void testSaveTwoArticlesToMyList() throws InterruptedException {

        String folderName = "Learning programming";
        String firstArticleTitle = "Java";
        String firstArticleSubtitle = "Object-oriented programming language";
        String secondArticleTitle = "Kotlin";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        BookmarkListPageObject bookmarkPageObject = BookmarkListPageObjectFactory.get(driver);
        mainPAgeObject = MainPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(firstArticleTitle);
        searchPageObject.clickForSearchResult("programming language");

        if(Platform.getInstance().isMV()){
            articlePageObject.addArticleToMySaved();
            AuthorizationPageObject authPO = new AuthorizationPageObject(driver);
            authPO.clickAuthButton();
            authPO.enterLoginData(LOGIN, PASS);
            authPO.submitForm();
            articlePageObject.waitForTitleElement();
            assertTrue("we are not on the same page after login", articlePageObject.getArticleTitle().contains(firstArticleTitle));
            articlePageObject.addArticleToMySaved();
        } else if (Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToBookmarksAndCreateList(folderName);
            articlePageObject.returnToMainScreen();
        } else if (Platform.getInstance().isIOS()){
            articlePageObject.addArticleToMySaved();
            articlePageObject.closeDialog();
            articlePageObject.closeArticle();
        }

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(secondArticleTitle);
        searchPageObject.clickForSearchResult("programming language");


        if(Platform.getInstance().isMV()){
            articlePageObject.addArticleToMySaved();
            articlePageObject.openMyLists();
        } else if (Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToBookmarks(folderName);
            articlePageObject.returnToMainScreen();
            mainPAgeObject.openBookmarks();
            mainPAgeObject.openMyBookmarksList(folderName);
        } else if (Platform.getInstance().isIOS()){
            articlePageObject.addArticleToMySaved();
            articlePageObject.closeArticle();
            mainPAgeObject.openBookmarks();
        }

        bookmarkPageObject.deleteArticleFromListBySwipe(secondArticleTitle);

        if (Platform.getInstance().isAndroid()){
            bookmarkPageObject.openArticle(firstArticleTitle);
            String articleSubtitle = articlePageObject.getArticleSubtitle();
            Assert.assertEquals("Title does not match. Expected: " + firstArticleSubtitle + ", actual: " + articleSubtitle, firstArticleSubtitle, articleSubtitle);
        } else if ((Platform.getInstance().isIOS()) || (Platform.getInstance().isMV())) {
            bookmarkPageObject.checkArticlePresentInList(firstArticleTitle);
            bookmarkPageObject.checkArticleNotPresentInList(secondArticleTitle);
        }
    }


    @Test
    public void testCheckArticleTitleWithoutWaiting(){

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String search_str = "java";

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(search_str);
        searchPageObject.clickForSearchResult("programming language");
        articlePageObject.assertSubtitlePresent();
    }


    @Test
    public void testChangeScreenOrientationOnSearchResults() {

        if (Platform.getInstance().isMV()){
            return;
        }

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickForSearchResult("Object-oriented programming language");

        String articleSubtitleBeforeRotation = articlePageObject.getArticleSubtitle();

        this.rotateScreenLandscape();

        String articleSubtitleAfterRotation = articlePageObject.getArticleSubtitle();

        Assert.assertEquals("Article title have been changed after rotation", articleSubtitleAfterRotation, articleSubtitleBeforeRotation);
    }


    @Test
    public void testCheckSearchResultByTitleAndSubtitle(){

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        String expecedTitle1 = "Java";
        String expectedSubtitle1 = "Island of Indonesia";
        String expecedTitle2 = "JavaScript";
        String expectedSubtitle2 = "Programming language";
        String expecedTitle3 = "Java (programming language)";
        String expectedSubtitle3 = "Object-oriented programming language";
        String searchRequest = "Java";

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchRequest);

        searchPageObject.waitForElementByTitleAndDescription(expecedTitle1, expectedSubtitle1);
        searchPageObject.waitForElementByTitleAndDescription(expecedTitle2, expectedSubtitle2);
        searchPageObject.waitForElementByTitleAndDescription(expecedTitle3, expectedSubtitle3);
    }

    @Test
    public void testPassThroughWelcome(){

        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMV()) ){
            return;
        }

        WelcomePageObject welcomePageObject = WelcomePageObjectFactory.get(driver);

        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.clickNextButton();
        welcomePageObject.waitForNewWaysText();
        welcomePageObject.clickNextButton();
        welcomePageObject.waitForSearchInText();
        welcomePageObject.clickNextButton();
        welcomePageObject.waitForHelpMakeText();
        welcomePageObject.clickGetStartedButton();

    }
}
