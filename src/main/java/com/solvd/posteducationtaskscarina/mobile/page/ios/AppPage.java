package com.solvd.posteducationtaskscarina.mobile.page.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.posteducationtaskscarina.mobile.page.common.AppPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AppPageBase.class)
public class AppPage extends AppPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == 'Close'`]")
    private ExtendedWebElement closeTabButton;

    public AppPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void closeTabButton() {
        closeTabButton.click();
    }
}
