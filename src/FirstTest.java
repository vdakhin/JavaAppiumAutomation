import lib.CoreTestCase;
import lib.ui.*;Te
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FirstTest extends CoreTestCase {



    @Test
    public void testCheckEverySearchResultTitle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");

        List<WebElement> article_titles_list = driver.findElements(By.id("org.wikipedia:id/page_list_item_title"));

        for (int i = 0; i < article_titles_list.size(); i++)
        {
            assertEquals(
                    "Some elements title does not contain 'Java'",
                    true,
                    article_titles_list.get(i).getText().toLowerCase().contains("java")
            );
        }
    }



    @Test
    public void testSaveTwoArticlesToMylist()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "List with two articles";
        ArticlePageObject.addArticleToNewList(name_of_folder);
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("JavaScript");

        ArticlePageObject.waitForTitleElement();
        String second_article_title = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addArticleToExistingList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(first_article_title);

        String article_title_on_preview = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/page_list_item_title"),
                "text",
                "Cannot find title of article",
                15
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='JavaScript']"),
                "Cannot find 'JavaScript' article",
                5
        );

        String article_title_on_the_article_page = MainPageObject.waitForElementAndGetAttribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "Cannot find title of article",
                15
        );

        assertEquals(
                "Unexpected title",
                article_title_on_preview,
                article_title_on_the_article_page
        );
    }



    @Test
    public void testArticleTitlePresent()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        String search_line = "java";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' article searching by " + search_line,
                15
        );

        assertTrue(
                "Cannot find article title",
                MainPageObject.assertElementPresent(By.id("org.wikipedia:id/view_page_title_text"))
        );
    }
}