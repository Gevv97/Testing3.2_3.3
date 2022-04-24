package com.armeniafly.tests;

import com.armeniafly.base.TestBase;
import com.armeniafly.dataprovider.TestDataProvider;
import com.armeniafly.pages.LaunchPage;
import com.armeniafly.utils.Constants;
import com.armeniafly.utils.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class SearchFlightTest extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void searchFlightTest(Hashtable<String,String> data) {
        session.log(data.toString());
        if(!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
            // skip in extent rep
            session.skipTest("Skipping the test as Runmode was NO");
            //skip - testng
            throw new SkipException("Skipping the test as Runmode was NO");
        }
        new LaunchPage()
                .openBrowser(data.get("Browser"))
                .goToHomePage(appUrl)
                .searchFlight(data)
                .validator(true)
                .validateElementNotPresence(Constants.ERROR_SPAN_LOCATOR);
    }
}
