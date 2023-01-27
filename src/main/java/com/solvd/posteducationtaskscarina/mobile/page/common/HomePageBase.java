package com.solvd.posteducationtaskscarina.mobile.page.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void closeLocationElement();

    public abstract SearchResultPageBase openResultPage(String searchText);

    public abstract SignInPageBase clickSignInButton();

    public abstract String getUserName();

    public abstract ShoppingCartPageBase clickShoppingCartButton();

    public abstract ExtendedWebElement getLocationElement();

}
