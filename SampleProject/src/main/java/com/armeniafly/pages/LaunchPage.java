package com.armeniafly.pages;

import com.armeniafly.base.pages.ArmeniaflyPage;
import com.armeniafly.base.pages.BasePage;

public class LaunchPage extends BasePage {

    public ArmeniaflyPage openBrowser(String browser) {
        getDriver().openBrowser(browser);
        return this;
    }

    public ArmeniaflyPage goToHomePage(String url) {
        log("Navigaing to "+url);
        getDriver().navigate(url);
        return new HomePage();
    }
}
