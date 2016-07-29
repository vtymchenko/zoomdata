package com.zoomdata.demo;

import com.zoomdata.demo.helpers.TestData;
import com.zoomdata.demo.widgets.DataSource;
import com.zoomdata.demo.widgets.HamburgerMenu;
import org.testng.annotations.Test;
import testconfigs.BaseTest;

import static com.zoomdata.demo.pages.Home.*;
import static com.zoomdata.demo.pages.Login.loginAs;


public class LoginTest extends BaseTest {

    //Test1
    @Test
    public void testLogin() {

        loginAs(TestData.LOGIN, TestData.PASSWORD);
        assertHomeIcon();
        HamburgerMenu.followTo();
        HamburgerMenu.goToDataSources();
        DataSource.assertDataSourceSize(2);
    }
}

