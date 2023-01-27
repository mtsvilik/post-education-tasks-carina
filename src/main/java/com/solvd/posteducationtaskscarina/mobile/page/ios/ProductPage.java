package com.solvd.posteducationtaskscarina.mobile.page.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.posteducationtaskscarina.mobile.page.common.ProductPageBase;
import com.solvd.posteducationtaskscarina.mobile.page.common.ShoppingCartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//*[@id='a-autoid-1']/../../..//*[@id='add-to-cart-button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id='a-autoid-0-announce']")
    private ExtendedWebElement chooseQuantityButton;

    @FindBy(xpath = "//*[@id='a-popover-1']")
    private ExtendedWebElement quantityList;

    @FindBy(xpath = "//*[@data-action='a-popover-scroll']//*[@id='mobileQuantityDropDown_1']")
    private ExtendedWebElement quantity;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ShoppingCartPageBase addToCart() {
        addToCartButton.click();
        return initPage(getDriver(), ShoppingCartPageBase.class);
    }

    @Override
    public void chooseQuantity() {
        chooseQuantityButton.click();
        quantityList.isElementPresent();
        quantity.click();
    }
}
