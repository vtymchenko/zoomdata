package com.zoomdata.demo;


import com.zoomdata.demo.pages.Chart;
import com.zoomdata.demo.widgets.DataSource;
import com.zoomdata.demo.widgets.*;
import org.testng.annotations.Test;
import testconfigs.BaseTest;

public class BottomTimeLineTest extends BaseTest {

    //Test4
    @Test
    public void testBottomTimeLine() {

        DataSource.given(DataSourceItems.IMPALA);
        Chart.selectByTitle("Scatter Plot");
        Chart.assertChartFromDataSource("Scatter Plot", DataSourceItems.IMPALA);

        LeftPanel.selectTimeBar();
        TimeBar.selectTimeAttribute("Saletime");
        Chart.assertChartFromDataSource("Scatter_Plot_Time_Attribute_By_Saletime", DataSourceItems.IMPALA);

        BottomPanel.dragLeftTime();
        Chart.assertChartFromDataSource("Draggable_Time_Line", DataSourceItems.IMPALA);
    }
}
