package com.armeniafly.base.pages;

import com.armeniafly.session.ArmeniaflySession;
import com.armeniafly.web.WebConnector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.Hashtable;

public class BasePage implements ArmeniaflyPage{

    public BasePage() {// page class object is created
        System.out.println("----------Base Page Consructor-------");
        PageFactory.initElements(getCurrentDriver(), this);
        // set the page in the session
        getSession().setCurrentPage(this);
    }
    @Override
    public ArmeniaflyPage openBrowser(String browser) {
        return null;
    }

    @Override
    public ArmeniaflyPage goToHomePage(String url) {
        return null;
    }

    @Override
    public ArmeniaflyPage searchFlight(Hashtable<String, String> data) {
        return null;
    }

    @Override
    public ArmeniaflyPage selectFlight() {
        return null;
    }

    @Override
    public ArmeniaflyPage clickOnFlight() {
        return null;
    }

    @Override
    public ArmeniaflyPage clickContinueOnFlightsPage() {
        return null;
    }

    @Override
    public ArmeniaflyPage clickContinueOnBaggagePage() {
        return null;
    }

    @Override
    public ArmeniaflyPage enterPassengerDetails(Hashtable<String, String> data) {
        return null;
    }

    public WebConnector validator(boolean stopExecution) {
        // update the flag in web layer
        getSession().getCon().setStopExecution(stopExecution);
        return getSession().getCon();
    }
    public ArmeniaflySession getSession() {
        return (ArmeniaflySession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
    }

    public WebConnector getDriver() {
        return getSession().getCon();
    }

    public RemoteWebDriver getCurrentDriver() {
        return getSession().getCon().getCurrentDriver();
    }

    public void log(String message) {
        getSession().log(message);
    }
    public void waitForPageToLoad(){
        JavascriptExecutor js = (JavascriptExecutor)getCurrentDriver();
        int i=1;
        // check for pageload 100% - 20 secs
        while(i!=10){
            String state = (String)js.executeScript("return document.readyState;");
            System.out.println(state);

            if(state.equals("complete"))
                break;
            else
                wait(2);

            i++;
        }
        // check for jquery/ajax status - 20 secs
        i=1;
        while(i!=10){

            Long d= (Long) js.executeScript("return jQuery.active;");
            System.out.println(d);
            if(d.longValue() == 0 )
                break;
            else
                wait(2);
            i++;

        }

    }

    public void wait(int time) {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
