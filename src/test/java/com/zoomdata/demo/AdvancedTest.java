package com.zoomdata.demo;


import com.zoomdata.demo.pages.Chart;
import com.zoomdata.demo.widgets.DataSource;
import org.testng.annotations.Test;
import testconfigs.BaseTest;

public class AdvancedTest extends BaseTest {

    //Test5
    @Test
    public void testCharts() {

        DataSource.given(DataSourceItems.MYSQL);
        Chart.selectByTitle("Heat Map");
        Chart.assertChartFromDataSource("Heat Map", DataSourceItems.MYSQL);

        Chart.clickOn();
        Chart.zoom();
        Chart.selectZoomAttributeName("City");
        Chart.assertChartFromDataSource("Heat Map Attr By City", DataSourceItems.MYSQL);

    }
}
