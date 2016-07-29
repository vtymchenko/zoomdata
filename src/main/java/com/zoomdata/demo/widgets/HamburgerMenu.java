package com.zoomdata.demo.widgets;


import org.openqa.selenium.By;

import static com.zoomdata.demo.core.ConciseAPI.waitVisibilityElement;

public class HamburgerMenu {

    public static void followTo () {
        waitVisibilityElement(By.xpath("//a[@value='showSidePane']")).click();
    }

    public static void goToDataSources() {
        waitVisibilityElement(By.xpath("//*[@class='zd-modal sidepane'][starts-with(@style, 'display: block')]//*[contains(text(),'Data Sources')]")).click();
    }
}
