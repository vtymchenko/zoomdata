package com.zoomdata.demo.widgets;


import com.zoomdata.demo.core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.zoomdata.demo.core.ConciseAPI.waitVisibilityElement;

public class BottomPanel {

    public static void dragLeftTime() {

        WebElement leftDragElement = waitVisibilityElement(By.xpath("//div[contains (@class,'left ui-draggable')]"));
        WebElement rightDragElement = waitVisibilityElement(By.xpath("//div[contains (@class,'right ui-draggable')]"));

        ConciseAPI.actions().clickAndHold(leftDragElement)
                .moveToElement(rightDragElement)
                .release().build().perform();
    }

}
