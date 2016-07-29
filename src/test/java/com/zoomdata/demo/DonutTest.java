package com.zoomdata.demo;

import com.zoomdata.demo.pages.Chart;
import com.zoomdata.demo.widgets.DataSource;
import org.testng.annotations.Test;
import testconfigs.BaseTest;


public class DonutTest extends BaseTest {

    //Test2
    @Test
    public void testDonut() {

        DataSource.given(DataSourceItems.IMPALA);
        Chart.assertTitles("Scatter Plot", "Donut");
        Chart.selectByTitle("Donut");
        Chart.assertChartFromDataSource("Donut", DataSourceItems.IMPALA);
    }
}
