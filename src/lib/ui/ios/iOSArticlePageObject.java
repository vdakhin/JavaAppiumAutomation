package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        NAVBAR_ADD_TO_MY_LIST_BUTTON = "xpath://XCUIElementTypeButton[@name='Save for later']";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        CLOSE_BUTTON_FOR_SYNC_YOUR_SAVED_ARTICLES_POP_UP = "id:places auth close";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
