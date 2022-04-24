package com.armeniafly.pages;

import com.armeniafly.base.pages.ArmeniaflyPage;
import com.armeniafly.base.pages.BasePage;
import com.armeniafly.utils.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsPage extends BasePage {

    @FindBy(css= Constants.SELECT_FLIGHT_DIV)
    WebElement firstFlight;
    @FindBy(xpath= Constants.SELECT_BUTTON)
    WebElement selectBtn;
    @FindBy(xpath= Constants.CONTINUE_BUTTON)
    WebElement continueBtn;

    public ArmeniaflyPage clickOnFlight()
    {
        firstFlight.click();
        return this;
    }
    public ArmeniaflyPage selectFlight()
    {
        selectBtn.click();
        return this;
    }
    public ArmeniaflyPage clickContinueOnFlightsPage()
    {
        continueBtn.click();
        return new BaggagePage();
    }

}
