package com.zoomdata.demo.core;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.zoomdata.demo.helpers.Helpers.getTexts;


public class CustomConditions {

    public static ExpectedCondition<List<WebElement>> textsOf(final By locator, final String... expectedTexts) {
        return elementExceptionsCatcher(new ExpectedCondition<List<WebElement>>() {
            private List<String> actualTexts;
            private List<WebElement> elements;

            public List<WebElement> apply(WebDriver driver) {
                actualTexts = new ArrayList<String>();
                elements = driver.findElements(locator);

                actualTexts = getTexts(elements);

                for (int i = 0; i < actualTexts.size(); i++) {
                    for (int j = 0; j < expectedTexts.length; j++) {
                        if (!(actualTexts.contains(expectedTexts[j]))) {
                            return null;
                        }
                    }
                }
                return elements;
            }

            @Override
            public String toString() {
                return String.format("\n Texts mismatch \n Actual : %s \n Expected: %s \n Element located  %s", actualTexts, Arrays.toString(expectedTexts), locator);
            }
        });
    }


    public static <V> ExpectedCondition<V> elementExceptionsCatcher(final Function<? super WebDriver, V> condition) {
        return new ExpectedCondition<V>() {
            public V apply(WebDriver driver) {
                try {
                    return condition.apply(driver);
                } catch (StaleElementReferenceException | ElementNotVisibleException | IndexOutOfBoundsException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return condition.toString();
            }
        };
    }
}
