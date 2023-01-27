package com.solvd.posteducationtaskscarina.mobile.page.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.posteducationtaskscarina.mobile.page.common.ShoppingCartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ShoppingCartPageBase.class)
public class ShoppingCartPage extends ShoppingCartPageBase {

    @FindBy(xpath = "//*[@class='a-spacing-top-base a-text-center sc-your-amazon-cart-is-empty']")
    private ExtendedWebElement cartIsEmptyText;

    @FindBy(xpath = "//*[@id='nav-button-cart']")
    private ExtendedWebElement shoppingCartButton;

    @FindBy(xpath = "//*[@class='a-truncate-cut' and contains(text(), 'iPhone')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@class='a-declarative']//*[@aria-label='2']")
    private ExtendedWebElement value;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getCartIsEmptyText() {
        return cartIsEmptyText.getText();
    }

    @Override
    public void clickShoppingCartButton() {
        shoppingCartButton.click();
    }

    @Override
    public String getProductTitle() {
        return title.getText();
    }

    @Override
    public String getValue() {
        return value.getText();
    }
}
