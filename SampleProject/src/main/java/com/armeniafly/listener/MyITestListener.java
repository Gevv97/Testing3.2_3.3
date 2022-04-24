package com.armeniafly.listener;

import com.armeniafly.session.ArmeniaflySession;
import com.armeniafly.web.WebConnector;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyITestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        getSession().takeScreenShotOnTestFailure(result.getMethod().getMethodName());
    }

    public ArmeniaflySession getSession() {
        return (ArmeniaflySession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
    }
}
