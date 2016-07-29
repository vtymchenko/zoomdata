package com.zoomdata.demo.pages;


import com.zoomdata.demo.DataSourceItems;
import com.zoomdata.demo.core.ConciseAPI;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;


import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

import static com.zoomdata.demo.core.ConciseAPI.byCss;
import static com.zoomdata.demo.core.ConciseAPI.getWebDriver;
import static com.zoomdata.demo.core.ConciseAPI.waitVisibilityElement;
import static com.zoomdata.demo.core.CustomConditions.textsOf;
import static com.zoomdata.demo.pages.Base.wait;
import static org.testng.Assert.assertTrue;


public class Chart {


    public static void setGroupAttribute(String attribute) {
        waitVisibilityElement(By.xpath("//div[@class='attrLabel label-button']/span['Group:']")).click();
        waitVisibilityElement(By.cssSelector(".attributeItem[title='" + attribute + "']")).click();
    }


    public static void assertTitles(String... dataSourceNames) {
        wait.until(textsOf(By.xpath("//div[@class='zd nav nav-tabs nav-stacked'][starts-with(@style, 'display: block')]//a"), dataSourceNames));
    }

    public static void selectByTitle(String chartName) {
        waitVisibilityElement(By.xpath("//div[@class='zd nav nav-tabs nav-stacked'][starts-with(@style, 'display: block')]//a[@title='" + chartName + "']")).click();
    }

    public static void clickOn() {
        waitVisibilityElement(By.cssSelector(".widgetContent canvas")).click();
    }

    public static void zoom() {
        waitVisibilityElement(By.cssSelector("span[data-name='zoom']")).click();
    }

    public static void selectZoomAttributeName(String attributeName) {
        waitVisibilityElement(By.cssSelector(".attributeItem[title='" + attributeName + "']")).click();
    }


    public static void assertChartFromDataSource(String chartName, DataSourceItems dataSourceName) {

        String pathToActualScreenShot = "ActualCharts/" + dataSourceName.getDataSourceItem() + "/" + chartName + ".png";
        String pathToExpectedScreenShot = "ExpectedCharts/" + dataSourceName.getDataSourceItem() + "/" + chartName + ".png";
        String pathToDiffScreenShot = "DiffCharts/" + dataSourceName.getDataSourceItem() + "/DIFF_" + chartName + ".png";

        waitVisibilityElement(By.cssSelector(".screenshot_status_ready"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Screenshot actualScreenshot = new AShot().takeScreenshot(getWebDriver(), waitVisibilityElement(byCss(".dashboard")));
        try {
            ImageIO.write(actualScreenshot.getImage(), "PNG", new File(pathToActualScreenShot));

            ImageDiff diff =
                    new ImageDiffer().makeDiff(ImageIO.read(new File(pathToExpectedScreenShot)),
                            ImageIO.read(new File(pathToActualScreenShot)));

            if (diff.hasDiff()) {
                ImageIO.write(diff.getMarkedImage(), "PNG", new File(pathToDiffScreenShot));
                assertTrue(false, String.format("Actual Chart : %s differ from original ", chartName));
            }
            assertTrue(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
