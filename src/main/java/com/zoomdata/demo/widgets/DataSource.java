package com.zoomdata.demo.widgets;

import com.zoomdata.demo.DataSourceItems;
import com.zoomdata.demo.core.CustomConditions;
import com.zoomdata.demo.helpers.TestData;
import org.openqa.selenium.By;

import static com.zoomdata.demo.core.ConciseAPI.byCss;
import static com.zoomdata.demo.core.ConciseAPI.waitVisibilityElement;
import static com.zoomdata.demo.core.CustomConditions.textsOf;
import static com.zoomdata.demo.pages.Base.wait;
import static com.zoomdata.demo.pages.Home.assertHomeIcon;
import static com.zoomdata.demo.pages.Login.loginAs;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;


public class DataSource {

    public static void selectAndFollowByTitle(DataSourceItems dataSourceType) {
        waitVisibilityElement(By.xpath("//a[contains(@title,'" + dataSourceType.getDataSourceItem() + "')]")).click();
    }

    public static void assertDataSourceSize(int count) {
        wait.until(numberOfElementsToBe(byCss("li .sourceItem"), count));
    }


    public static void given (DataSourceItems dataSourceItems) {
        loginAs(TestData.LOGIN, TestData.PASSWORD);
        assertHomeIcon();
        HamburgerMenu.followTo();
        HamburgerMenu.goToDataSources();
        DataSource.selectAndFollowByTitle(dataSourceItems);
    }

}

