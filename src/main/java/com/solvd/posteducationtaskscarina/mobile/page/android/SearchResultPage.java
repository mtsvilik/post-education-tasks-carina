package com.solvd.posteducationtaskscarina.mobile.page.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.posteducationtaskscarina.mobile.page.common.ProductPageBase;
import com.solvd.posteducationtaskscarina.mobile.page.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase {

    @FindBy(xpath = "//div//h2//*[@class='a-size-small a-color-base a-text-normal']")
    private List<ExtendedWebElement> resultProductList;

    @FindBy(xpath = "//*[@class='s-image' and @data-image-index='2']")
    private ExtendedWebElement searchResult;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> findResults() {
        return resultProductList.stream()
                .map(title -> title.getText().toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
    }

    @Override
    public ProductPageBase clickSearchResult() {
        searchResult.click(10);
        return initPage(getDriver(), ProductPageBase.class);
    }
}
