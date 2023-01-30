package com.solvd.posteducationtaskscarina.mobile.page.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SearchResultPageBase extends AbstractPage {

    public SearchResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> findResults();

    public abstract ProductPageBase clickSearchResult();

    public abstract AppPageBase clickTabSwitcherButton();

}
