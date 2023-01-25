package com.solvd.posteducationtaskscarina.mobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends AbstractPage {

    public SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterEmail(String email);

    public abstract void enterPassword(String password);

    public abstract void enterNonExistentEmail(String email);

    public abstract String getSignInText();

}
