package com.armeniafly.pages;

import com.armeniafly.base.pages.ArmeniaflyPage;
import com.armeniafly.base.pages.BasePage;
import com.armeniafly.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Hashtable;
import java.util.List;

public class PassengersPage extends BasePage {

    @FindBy(name= Constants.EMAIL_INPUT)
    WebElement emailTxt;
    @FindBy(name= Constants.PHONE_INPUT)
    WebElement phoneTxt;
    @FindBy(name= Constants.PASSENGER_0_LASTNAME)
    WebElement lastNameTxt;
    @FindBy(name= Constants.PASSENGER_0_FIRSTNAME)
    WebElement firstNameTxt;
    @FindBy(name= Constants.PASSENGER_0_BIRTH_DATE)
    WebElement dobTxt;
    @FindBy(xpath= Constants.PASSENGER_0_GENDER_MALE)
    WebElement genderRadioMale;
    @FindBy(xpath= Constants.PASSENGER_0_GENDER_FEMALE)
    WebElement genderRadioFemale;
    @FindBy(name= Constants.PASSENGER_0_DOCUMENT_NUMBER)
    WebElement documentTxt;
    @FindBy(name= Constants.PASSENGER_0_EXPIRY_DATE)
    WebElement expiryTxt;
    @FindBy(css= Constants.ACCEPT_TERMS_CHK)
    WebElement acceptTermsChkBox;
    @FindBy(xpath=Constants.CONTINUE_BUTTON)
    WebElement continueBtn;

    public ArmeniaflyPage enterPassengerDetails(Hashtable<String,String> data)
    {
        emailTxt.sendKeys(data.get("Email"));
        phoneTxt.sendKeys(data.get("Phone"));
        lastNameTxt.sendKeys(data.get("LastName"));
        firstNameTxt.sendKeys(data.get("FirstName"));
        dobTxt.sendKeys(data.get("DOB"));
        JavascriptExecutor js=(JavascriptExecutor) getCurrentDriver();
        js.executeScript("window.scrollBy(0,600)");
        wait(2);
        if(data.get("Gender").equalsIgnoreCase("Male")) {
            genderRadioMale.click();
        }
        else {
            genderRadioFemale.click();
        }
        documentTxt.sendKeys(data.get("DocumentNumber"));
        expiryTxt.sendKeys(data.get("ExpiryDate"));
        wait(2);
        acceptTermsChkBox.click();
        continueBtn.click();
        return this;
    }


}
