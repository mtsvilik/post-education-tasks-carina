package com.solvd.posteducationtaskscarina.mobile.page.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.posteducationtaskscarina.mobile.page.common.AppPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AppPageBase.class)
public class AppPage extends AppPageBase {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='New tab']")
    private ExtendedWebElement addPageButton;

    @FindBy(id = "com.android.chrome:id/tab_switcher_button")
    private ExtendedWebElement tabSwitcherButton;

    @FindBy(id = "com.android.chrome:id/menu_button")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Close all tabs']")
    private ExtendedWebElement closeAllTabsButton;

    @FindBy(id = "com.android.chrome:id/tab_list_view")
    private ExtendedWebElement tabListView;

    public AppPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickAppButtons() {
        addPageButton.click();
        tabSwitcherButton.click();
        menuButton.click();
        closeAllTabsButton.click();
    }
}
