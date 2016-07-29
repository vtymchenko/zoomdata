package com.zoomdata.demo.pages;

import org.openqa.selenium.By;

import static com.zoomdata.demo.core.ConciseAPI.waitVisibilityElement;


public class Login {

    public static void loginAs(String login, String password) {

        waitVisibilityElement(By.cssSelector("#username")).sendKeys(login);

        waitVisibilityElement(By.cssSelector("#password")).sendKeys(password);

        waitVisibilityElement(By.xpath("//input[@value='Login']")).click();
    }
}


