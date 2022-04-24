package com.armeniafly.pages;

import com.armeniafly.base.pages.ArmeniaflyPage;
import com.armeniafly.base.pages.BasePage;
import com.armeniafly.utils.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaggagePage extends BasePage {

    @FindBy(xpath= Constants.CONTINUE_BUTTON)
    WebElement continueBtn;

    public ArmeniaflyPage clickContinueOnBaggagePage()
    {
        continueBtn.click();
        return new PassengersPage();
    }
}
