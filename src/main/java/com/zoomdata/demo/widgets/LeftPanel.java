package com.zoomdata.demo.widgets;

import org.openqa.selenium.By;

import static com.zoomdata.demo.core.ConciseAPI.waitVisibilityElement;


public class LeftPanel {


    public static void selectTimeBar() {
        waitVisibilityElement(By.id("controlTimePlayer")).click();
    }

}
