package com.zoomdata.demo.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.currentThread;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class ConciseAPI {

    private static Map<Thread, WebDriver> webDriversContainer = new HashMap<>();

    public static WebDriver getWebDriver() {
        return webDriversContainer.get(currentThread());
    }

    public static void setWebDriver(WebDriver driver) {
        webDriversContainer.put(currentThread(), driver);
    }

    public static Actions actions() {
        return new Actions(getWebDriver());
    }

    public static void executeJavaScript(String jsScript) {
        ((JavascriptExecutor) getWebDriver()).executeScript(jsScript);
    }

    public static void open(String url) {
        getWebDriver().get(url);
    }

    public static <T> T waitVisibilityElement(ExpectedCondition<T> condition) {
        return waitVisibilityElement(condition, Configuration.timeout);
    }

    public static <T> WebElement waitVisibilityElement(By locator) {
        return waitVisibilityElement(visibilityOfElementLocated(locator), Configuration.timeout);
    }

    public static <T> T waitVisibilityElement(ExpectedCondition<T> condition, long timeout) {
        return new WebDriverWait(getWebDriver(), timeout).until(condition);
    }

    public static By byCss(String selector) {
        return By.cssSelector(selector);
    }

    public static  By byText(String elementText) {
        return By.xpath(".//*/text()[normalize-space(.) = " + Quotes.escape(elementText) + "]/parent::*");
    }

}
