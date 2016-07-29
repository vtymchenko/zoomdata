package com.zoomdata.demo.pages;

import com.zoomdata.demo.core.ConciseAPI;
import com.zoomdata.demo.core.Configuration;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Base {
    public static WebDriverWait wait = new WebDriverWait(ConciseAPI.getWebDriver(), Configuration.timeout);
}
