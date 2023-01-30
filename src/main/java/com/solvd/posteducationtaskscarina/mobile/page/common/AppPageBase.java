package com.solvd.posteducationtaskscarina.mobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AppPageBase extends AbstractPage {

    public AppPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAppButtons();

}
