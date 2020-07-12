package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{SUBSTRING}')]";
//        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther[2]";
        SEARCH_EMPTY_RESULT_LABEL = "id:No results found";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION = "xpath://ancestor::*[*[@name='{TITLE}'] and *[@name='{DESCRIPTION}']]";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
