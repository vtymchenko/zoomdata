package com.zoomdata.demo.widgets;


import com.zoomdata.demo.core.ConciseAPI;
import org.openqa.selenium.By;

import static com.zoomdata.demo.core.ConciseAPI.byCss;
import static com.zoomdata.demo.core.ConciseAPI.waitVisibilityElement;

public class ChartStyle {


    public static void switchTo(String chartStyleName) {
        waitVisibilityElement(By.xpath("//a[@title='" + chartStyleName + "']")).click();
    }

    public static void followTo () {
        waitVisibilityElement(By.id("controlStyle")).click();
    }

    public static void selectAllCharts () {
        waitVisibilityElement(byCss("li[data-type='all']")).click();
    }

}
