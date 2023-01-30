package com.solvd.posteducationtaskscarina.mobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ShoppingCartPageBase extends AbstractPage {

    public ShoppingCartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getCartIsEmptyText();

    public abstract void clickShoppingCartButton();

    public abstract String getProductTitle();

    public abstract String getValue();

    public abstract AppPageBase clickTabsButton();

}
