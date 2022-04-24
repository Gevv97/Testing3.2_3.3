package com.armeniafly.pages;

import com.armeniafly.base.pages.ArmeniaflyPage;
import com.armeniafly.base.pages.BasePage;
import com.armeniafly.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class HomePage extends BasePage {

    @FindBy(xpath = Constants.FROM_INPUT)
    WebElement from;
    @FindBy(xpath = Constants.TO_INPUT)
    WebElement to;
    @FindBy(xpath = Constants.MONTH_DIV)
    WebElement monthEle;
    @FindBy(xpath = Constants.YEAR_DIV)
    WebElement yearEle;
    @FindBy(xpath = Constants.NAV_DIV)
    WebElement nav;
    @FindBy(xpath = Constants.PASSENGER_BUTTON)
    WebElement passengers;
    @FindBy(xpath = Constants.DATE_DIV)
    WebElement dateDiv;
    @FindBy(xpath = Constants.SEARCH_BUTTON)
    WebElement search;

    public ArmeniaflyPage searchFlight(Hashtable<String,String> data)
    {
        JavascriptExecutor js=(JavascriptExecutor) getCurrentDriver();
        js.executeScript("window.scrollBy(0,400)");
        from.sendKeys(data.get("From"));
        wait(2);
        getCurrentDriver().findElement(By.xpath("//span[text()='"+data.get("From")+"']")).click();
        Actions action=new Actions(getCurrentDriver());
        action.sendKeys(Keys.TAB).build().perform();
        to.sendKeys(data.get("To"));
        wait(5);
        getCurrentDriver().findElements(By.xpath("//span[text()='"+data.get("To")+"']")).get(1).click();
        wait(2);
        selectDate(data.get("Date"));
        wait(1);
        search.click();
        wait(1);
        return new FlightsPage();
    }
    public ArmeniaflyPage selectDate(String date)
    {
        log("Selecting Date "+date);
        dateDiv.click();
        try {
            Date currentDate = new Date();
            Date dateToSel=new SimpleDateFormat("d-MM-yyyy").parse(date);
            String day=new SimpleDateFormat("d").format(dateToSel);
            String month=new SimpleDateFormat("MMMM").format(dateToSel);
            String year=new SimpleDateFormat("yyyy").format(dateToSel);
            String monthYearToBeSelected=month+" "+year;
            String monthYearDisplayed=monthEle.getText()+" "+yearEle.getText();

            while(!monthYearToBeSelected.equals(monthYearDisplayed)) {
                nav.click();
                wait(1);
                monthYearDisplayed=monthEle.getText()+" "+yearEle.getText();
            }
            getCurrentDriver().findElement(By.xpath("//div[text()='"+day+"']")).click();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this;
    }
}
