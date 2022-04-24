package com.armeniafly.web;

import com.armeniafly.base.pages.ArmeniaflyPage;
import com.armeniafly.session.ArmeniaflySession;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

public interface WebConnector{

    void openBrowser(String bName);
    void navigate(String url);
    void quit();
    //EventFiringWebDriver getCurrentDriver();
    ArmeniaflySession getSession();
    boolean isStopExecution();
    void setStopExecution(boolean stopExecution);
    void assertAll();
    SoftAssert getSoftAssert();
    void setSoftAssert(SoftAssert softAssert);
    void log(String message);
    void fail(String message);
    RemoteWebDriver getCurrentDriver();


    //validation methods
    ArmeniaflyPage validateTitle(String expectedTitle);
    ArmeniaflyPage validateText(By locator, String expectedText);
    boolean isElementPresent(By locator);
    ArmeniaflyPage validateElementPresence(By locator);
    ArmeniaflyPage validateElementNotPresence(By locator);
}
