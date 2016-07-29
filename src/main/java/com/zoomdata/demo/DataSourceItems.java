package com.zoomdata.demo;


public enum DataSourceItems {

    IMPALA("impala_automation"), MYSQL("mysql_automation");

    private final String dataSourceItem;

    DataSourceItems(String dataSourceItem) {
        this.dataSourceItem = dataSourceItem;
    }

    public String getDataSourceItem() {
        return dataSourceItem;
    }
}
