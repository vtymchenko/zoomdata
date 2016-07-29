package com.zoomdata.demo.widgets;


import org.openqa.selenium.By;

import static com.zoomdata.demo.core.ConciseAPI.byCss;
import static com.zoomdata.demo.core.ConciseAPI.waitVisibilityElement;

public class TimeBar {

    public static void selectTimeAttribute(String timeAttribute) {

        waitVisibilityElement(By.xpath("//*[text()='" + timeAttribute + "']")).click();
        waitVisibilityElement(byCss("button[value='applyTime']")).click();
    }
}
