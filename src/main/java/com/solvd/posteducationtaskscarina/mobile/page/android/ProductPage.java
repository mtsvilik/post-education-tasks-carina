package com.solvd.posteducationtaskscarina.mobile.page.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.posteducationtaskscarina.mobile.page.common.ProductPageBase;
import com.solvd.posteducationtaskscarina.mobile.page.common.ShoppingCartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//*[@id='a-autoid-1']/../../..//*[@id='add-to-cart-button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id='a-autoid-0']")
    private ExtendedWebElement chooseQuantityButton;

    @FindBy(xpath = "//*[@id='mobileQuantityDropDown_1']")
    private ExtendedWebElement quantity;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ShoppingCartPageBase addToCart() {
        addToCartButton.click(10);
        return initPage(getDriver(), ShoppingCartPageBase.class);
    }

    @Override
    public void chooseQuantity() {
        chooseQuantityButton.click();
        quantity.click();
    }
}
