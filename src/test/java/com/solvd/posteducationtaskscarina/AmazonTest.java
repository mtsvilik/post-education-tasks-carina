package com.solvd.posteducationtaskscarina;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.posteducationtaskscarina.mobile.page.common.*;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AmazonTest implements IAbstractTest {

    @Test
    public void verifySearchResultsTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.closeLocationElement();

        SearchResultPageBase searchResultPage = homePage.openResultPage("umbrella");
        String searchText = "umbrella";
        List<String> titles = searchResultPage.findResults();

        SoftAssert softAssert = new SoftAssert();
        titles.
                forEach(title -> softAssert.assertTrue(title.contains(searchText)));

        softAssert.assertAll();
    }

    @Test
    public void verifySignInTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.closeLocationElement();

        SignInPageBase signInPage = homePage.clickSignInButton();
        signInPage.enterEmail(R.TESTDATA.get("user1.email"));
        signInPage.enterPassword(R.TESTDATA.get("user1.password"));

        Assert.assertTrue(homePage.getUserName().contains(R.TESTDATA.get("userName")));
    }

    @Test
    public void checkSignInNonExistentEmailTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.closeLocationElement();

        SignInPageBase signInPage = homePage.clickSignInButton();
        signInPage.enterNonExistentEmail(R.TESTDATA.get("user2.email"));
        Assert.assertEquals(signInPage.getSignInText(),
                R.TESTDATA.get("signInTextAndroid"), "Sign In page should contains sign in text");
    }

    @Test
    public void checkAddCartButtonIsClickableTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.closeLocationElement();

        ShoppingCartPageBase shoppingCartPage = homePage.clickShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.getCartIsEmptyText(),
                R.TESTDATA.get("cartIsEmptyText"), "Shopping cart page should contains add to cart is empty text");
    }

    @Test
    public void verifyProductIsAddedToCartTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.closeLocationElement();

        SearchResultPageBase searchResultPage = homePage.openResultPage(R.TESTDATA.get("searchText"));

        ProductPageBase productPage = searchResultPage.clickSearchResult();

        ShoppingCartPageBase shoppingCartPage = productPage.addToCart();
        shoppingCartPage.clickShoppingCartButton();
        Assert.assertTrue(shoppingCartPage.getProductTitle().toLowerCase().contains(R.TESTDATA.get("productTitle")),
                "Product in shopping cart with incorrect title");
    }

    @Test
    public void checkIncreaseProductInCartTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.closeLocationElement();

        SearchResultPageBase searchResultPage = homePage.openResultPage(R.TESTDATA.get("searchText"));

        ProductPageBase productPage = searchResultPage.clickSearchResult();
        productPage.chooseQuantity();

        ShoppingCartPageBase shoppingCartPage = productPage.addToCart();
        shoppingCartPage.clickShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.getValue(), R.TESTDATA.get("quantity"), "Incorrect quantity product in shopping cart");
    }
}

