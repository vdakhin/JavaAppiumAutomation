package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static String
            name_of_folder_for_testSaveArticleToMyList = "Learning programming",
            name_of_folder_for_testSaveTwoArticlesToMyList = "List with two articles";

    @Test
    public void testSaveArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToNewList(name_of_folder_for_testSaveArticleToMyList);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        if(Platform.getInstance().isIOS()) {
        ArticlePageObject.closeSyncYourSavedArticlesPopUp();
        }

        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder_for_testSaveArticleToMyList);
        }

        MyListPageObject.swipeByArticleToDelete(first_article_title);
    }

    @Test
    public void testSaveTwoArticlesToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToNewList(name_of_folder_for_testSaveTwoArticlesToMyList);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        if(Platform.getInstance().isIOS()) {
            ArticlePageObject.closeSyncYourSavedArticlesPopUp();
        }

        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();

        if(Platform.getInstance().isAndroid()) {
            SearchPageObject.typeSearchLine("Java");
        }

        SearchPageObject.clickByArticleWithSubstring("JavaScript");

        ArticlePageObject.waitForTitleElement();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToNewList(name_of_folder_for_testSaveTwoArticlesToMyList);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolderByName(name_of_folder_for_testSaveArticleToMyList);
        }

        MyListPageObject.swipeByArticleToDelete(first_article_title);
        String second_article_title_on_preview = MyListPageObject.getArticleTitle();
        MyListPageObject.clickArticleByTitle("JavaScript");
        String second_article_title_on_the_article_page = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Unexpected title",
                second_article_title_on_preview,
                second_article_title_on_the_article_page
        );
    }
}