package com.solvd.posteducationtaskscarina.mobile.page.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.posteducationtaskscarina.mobile.page.common.AppPageBase;
import com.solvd.posteducationtaskscarina.mobile.page.common.ProductPageBase;
import com.solvd.posteducationtaskscarina.mobile.page.common.SearchResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchResultPageBase.class)
public class SearchResultPage extends SearchResultPageBase {

    @FindBy(xpath = "//*[@class='sg-col-inner']")
    private List<ExtendedWebElement> resultProductList;

    @FindBy(xpath = "//*[@class='s-image' and @data-image-index='2']")
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
        searchResult.click(10);
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public AppPageBase clickTabSwitcherButton() {
        return null;
    }
}
