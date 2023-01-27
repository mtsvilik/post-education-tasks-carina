package com.solvd.posteducationtaskscarina.mobile.page.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.posteducationtaskscarina.mobile.page.common.HomePageBase;
import com.solvd.posteducationtaskscarina.mobile.page.common.SearchResultPageBase;
import com.solvd.posteducationtaskscarina.mobile.page.common.ShoppingCartPageBase;
import com.solvd.posteducationtaskscarina.mobile.page.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//*[@type='text' and @placeholder='Search Amazon']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//*[@type='submit' and @class='nav-input']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//*[@data-toaster-type='AIS_INGRESS']")
    private ExtendedWebElement locationElement;

    @FindBy(xpath = "//*[@class='a-button-inner']//*[@data-action-type='DISMISS']")
    private ExtendedWebElement dismissButton;

    @FindBy(xpath = "//*[@id='nav-logobar-greeting']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//*[@id='nav-greeting-name']")
    private ExtendedWebElement userNameButton;

    @FindBy(xpath = "//*[@id='nav-button-cart']")
    private ExtendedWebElement shoppingCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void closeLocationElement() {
        ExtendedWebElement locationElement = getLocationElement();
        if (locationElement.isPresent()) {
            dismissButton.click();
        }
    }

    @Override
    public SearchResultPageBase openResultPage(String searchText) {
        searchInput.type(searchText);
        searchButton.click();
        return initPage(getDriver(), SearchResultPageBase.class);
    }

    @Override
    public SignInPageBase clickSignInButton() {
        signInButton.click();
        return initPage(getDriver(), SignInPageBase.class);
    }

    @Override
    public String getUserName() {
        return userNameButton.getText();
    }

    @Override
    public ShoppingCartPageBase clickShoppingCartButton() {
        shoppingCartButton.click();
        return initPage(getDriver(), ShoppingCartPageBase.class);
    }

    @Override
    public ExtendedWebElement getLocationElement() {
        return locationElement;
    }
}
