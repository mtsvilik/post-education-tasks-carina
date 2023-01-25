package com.solvd.posteducationtaskscarina.mobile.page.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.posteducationtaskscarina.mobile.page.common.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(xpath = "//*[@id='ap_email_login']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//*[@id='continue' and @aria-labelledby='continue-announce']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//*[@id='ap_password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@id='signInSubmit']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//*[@class='a-alert-heading' and contains(text(), 'No account found')]")
    private ExtendedWebElement signInText;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterEmail(String email) {
        emailField.type(email);
        continueButton.click();
    }

    @Override
    public void enterPassword(String password) {
        passwordField.type(password);
        signInButton.click();
    }

    @Override
    public void enterNonExistentEmail(String email) {
        emailField.type(email);
        continueButton.click();
    }

    @Override
    public String getSignInText() {
        return signInText.getText();
    }
}
