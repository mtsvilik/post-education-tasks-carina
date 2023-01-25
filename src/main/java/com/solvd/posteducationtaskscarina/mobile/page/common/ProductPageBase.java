package com.solvd.posteducationtaskscarina.mobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ShoppingCartPageBase addToCart();

    public abstract void chooseQuantity();

}
