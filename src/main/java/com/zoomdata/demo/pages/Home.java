package com.zoomdata.demo.pages;

import org.openqa.selenium.By;

import static com.zoomdata.demo.core.ConciseAPI.waitVisibilityElement;


public class Home {

    public static void assertHomeIcon() {
        waitVisibilityElement(By.cssSelector("a[title='Home']"));
    }
}
