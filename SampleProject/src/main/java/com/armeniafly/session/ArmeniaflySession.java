package com.armeniafly.session;

import com.armeniafly.base.pages.ArmeniaflyPage;
import com.armeniafly.reports.ExtentManager;
import com.armeniafly.utils.Constants;
import com.armeniafly.web.ArmeniaflyDriver;
import com.armeniafly.web.WebConnector;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ArmeniaflySession {
    WebConnector con;
    ArmeniaflyPage currentPage; // current page
    ExtentReports reports;
    ExtentTest test ;
    boolean executeListener;

    public ArmeniaflySession() {
        con = new ArmeniaflyDriver();
    }

    public void init(String testName) {
        setExecuteListener(true);
        if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null)
            Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);

        // init reports
        reports = ExtentManager.getReport(Constants.REPORTS_PATH);
        test = reports.createTest(testName);
        //ZohoPage page = new LaunchPage();

    }

    public WebConnector getCon() {
        return con;
    }

    public ArmeniaflyPage getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(ArmeniaflyPage currentPage) {
        this.currentPage = currentPage;
    }

    public void end() {
        getCon().assertAll();
    }
    /*********************Reporting functions*****************************/
    public void log(String message) {
        System.out.println(message);
        test.log(Status.INFO, message);
    }

    public void generateReport() {
        if(reports !=null)
            reports.flush();
        // quit the browser
        if(getCon() !=null)
            getCon().quit();

    }

    public void failTest(String failureMessage) {
        //fail in extent
        System.out.println("Failing "+failureMessage);
        takeScreenShot();
        test.log(Status.FAIL, failureMessage);
        // take screenshot of failure
    }
    // first take screenshot and then add it to reports
    public void takeScreenShot() {
        // fileName of the screenshot
        Date d=new Date();
        String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
        // take screenshot
        File srcFile = ((TakesScreenshot) getCon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
        try {
            // get the dynamic folder name
            FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
            //put screenshot file in reports
            test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // first take screenshot and then add it to reports
    public void takeScreenShotOnTestFailure(String testName) {
        // fileName of the screenshot
        System.out.println("screenshot method -> "+testName);
        Date d=new Date();
        String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
        // take screenshot
        File srcFile = ((TakesScreenshot) getCon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
        try {
            // get the dynamic folder name
            FileUtils.copyFile(srcFile, new File(".//Screenshots//"+testName+"_"+screenshotFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void skipTest(String message) {
        test.log(Status.SKIP, message);
    }

    public boolean isExecuteListener() {
        return executeListener;
    }

    public void setExecuteListener(boolean executeListener) {
        this.executeListener = executeListener;
    }

}
