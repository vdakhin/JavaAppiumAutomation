package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
            STEP_LEARN_MORE_TEXT = "xpath://XCUIElementTypeStaticText[@name='Learn more about Wikipedia']",
            STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
            STEP_ADD_OR_EDIT_PREFERRED_LANG_TEXT = "xpath://XCUIElementTypeStaticText[@name='Add or edit preferred languages']",
            STEP_HELP_MAKE_THE_APP_BETTER_TEXT = "id:Help make the app better",
            NEXT_BUTTON = "xpath://XCUIElementTypeButton[@name='Next']",
            GET_STARTED_BUTTON = "xpath://XCUIElementTypeButton[@name='Get started']",
            SKIP_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_TEXT, "Cannot find 'Learn more about Wikipedia' link", 10);
    }

    public void waitForNewWaysToExploreText()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'New ways to explore' link", 10);
    }

    public void waitForAddOrEditPreferredLangText()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_TEXT, "Cannot find 'Help make the app better' link", 10);
    }

    public void waitForHelpMakeTheAppBetterText()
    {
        this.waitForElementPresent(STEP_HELP_MAKE_THE_APP_BETTER_TEXT, "Cannot find 'New ways to explore' link", 10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_BUTTON, "Cannot find and click 'Next' button", 10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find and click 'Get started' button", 10);
    }

    public void clickSkip()
    {
        waitForElementAndClick(SKIP_BUTTON, "Cannot find and click skip button", 5);
    }
}
