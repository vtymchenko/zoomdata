package com.zoomdata.demo;

import com.zoomdata.demo.pages.Chart;
import com.zoomdata.demo.widgets.ChartStyle;
import com.zoomdata.demo.widgets.DataSource;
import org.testng.annotations.Test;
import testconfigs.BaseTest;


public class InheriteAttributeTest extends BaseTest {

    //Test3
    @Test
    public void testInheriteAttribute() {

        DataSource.given(DataSourceItems.MYSQL);

        Chart.selectByTitle("Bars");
        Chart.assertChartFromDataSource("Bars", DataSourceItems.MYSQL);

        Chart.setGroupAttribute("City");
        ChartStyle.followTo();
        ChartStyle.selectAllCharts();
        ChartStyle.switchTo("Table");
        Chart.assertChartFromDataSource("Table_Chart_Group_By_City", DataSourceItems.MYSQL);
    }
}
