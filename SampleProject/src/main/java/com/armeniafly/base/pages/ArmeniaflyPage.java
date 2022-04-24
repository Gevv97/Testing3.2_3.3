package com.armeniafly.base.pages;

import com.armeniafly.web.WebConnector;

import java.util.Hashtable;

public interface ArmeniaflyPage {
    ArmeniaflyPage openBrowser(String browser);
    WebConnector validator(boolean stopExecution);
    ArmeniaflyPage goToHomePage(String url);
    ArmeniaflyPage searchFlight(Hashtable<String,String> data);
    ArmeniaflyPage selectFlight();
    ArmeniaflyPage clickOnFlight();
    ArmeniaflyPage clickContinueOnFlightsPage();
    ArmeniaflyPage clickContinueOnBaggagePage();
    ArmeniaflyPage enterPassengerDetails(Hashtable<String,String> data);
}
