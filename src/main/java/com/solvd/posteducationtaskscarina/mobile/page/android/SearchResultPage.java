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

    @FindBy(xpath = "//*[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']")
    private List<ExtendedWebElement> resultProductList;

    @FindBy(xpath = "//*[@data-index='4' and @data-component-type='s-search-result']")
    private ExtendedWebElement searchResult;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> findResults() {
        return resultProductList.stream()
                .map(title -> title.toString().toLowerCase(Locale.ROOT))
                .collect(Collectors.toList());
    }

    @Override
    public ProductPageBase clickSearchResult() {
        searchResult.click();
        return initPage(getDriver(), ProductPageBase.class);
    }
}
