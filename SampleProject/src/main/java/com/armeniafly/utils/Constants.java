package com.armeniafly.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.support.How;


public class Constants {
	public static final String GRIDRUN = "Y";

	public static final String ID="id";
	public static final String NAME="name";
	public static final String XPATH="XPATH";
	public static final String CSS="CSS";

	public static final String BOOKING_LINK="//a[@href='/booking-en'][contains(text(),'Booking')]";

	public static final String FROM_INPUT="//input[@placeholder='From']";
	public static final By FROM_INPUT_LOCATOR=By.xpath(FROM_INPUT);

	public static final String TO_INPUT="//input[@placeholder='To']";
	public static final By TO_INPUT_LOCATOR=By.xpath(TO_INPUT);

	public static final String DATE_DIV="//div[@id='websky']/div/div[2]/div/div/form/div/div[1]/div/div/div[3]";
	public static final By DATE_DIV_LOCATOR=By.xpath(DATE_DIV);

	public static final String PASSENGER_BUTTON="//div[@id='websky']/div/div[2]/div/div/form/div/div[2]/div";
	public static final By PASSENGER_BUTTON_LOCATOR=By.xpath(PASSENGER_BUTTON);

	public static final String CURRENCY_BUTTON="//div[@id='websky']/div/div[2]/div/div/form/div/div[2]/div[2]";
	public static final By CURRENCY_BUTTON_LOCATOR=By.xpath(CURRENCY_BUTTON);

	public static final String SEARCH_BUTTON="//div[@id='websky']/div/div[2]/div/div/form/div/div[2]/div[3]/button";
	public static final By SEARCH_BUTTON_LOCATOR=By.xpath(SEARCH_BUTTON);

	public static final String MONTH_DIV="//div[@class='OrqAs OrqAs _2eawm']/div[1]/div[1]/div/div[1]";
	public static final By MONTHS_DIV_LOCATOR=By.xpath(MONTH_DIV);

	public static final String YEAR_DIV="//div[@class='OrqAs OrqAs _2eawm']/div[1]/div[1]/div/div[2]";
	public static final By YEAR_DIV_LOCATOR=By.xpath(YEAR_DIV);

	public static final String NAV_DIV="//div[@class='_19DEu _19DEu _2ArH5']";
	public static final By NAV_DIV_LOCATOR=By.xpath(NAV_DIV);

	public static final String ERROR_SPAN="//span[text()=\"We couldn't find any flights for given dates\"]";
	public static final By ERROR_SPAN_LOCATOR=By.xpath(ERROR_SPAN);

	public static final String SELECT_FLIGHT_DIV="div.UgjDn";
	public static final By SELECT_FLIGHT_DIV_LOCATOR=By.xpath(SELECT_FLIGHT_DIV);

	public static final String CONTINUE_BUTTON="//button[text()='Continue']";
	public static final By CONTINUE_BUTTON_LOCATOR=By.xpath(CONTINUE_BUTTON);

	public static final String SELECT_BUTTON="//button[contains(text(),'Select')]";
	public static final By SELECT_BUTTON_LOCATOR=By.xpath(CONTINUE_BUTTON);

	public static final String EMAIL_INPUT="customer.email";
	public  static final String PHONE_INPUT="customer.phone";
	public static final String PASSENGER_0_LASTNAME="passengers[0].lastName";
	public static final String PASSENGER_0_FIRSTNAME="passengers[0].firstName";
	public static final String PASSENGER_0_BIRTH_DATE="passengers[0].birthDate";
	public static final String PASSENGER_0_GENDER_MALE="//input[@name='passengers[0].gender'][@value='M']/parent::label";
	public static final String PASSENGER_0_GENDER_FEMALE="//input[@name='passengers[0].gender'][@value='F']/parent::label";
	public static final String PASSENGER_0_DOCUMENT_NUMBER="passengers[0].docNumber";
	public static final String PASSENGER_0_EXPIRY_DATE="passengers[0].docExpiryDate";
	public static final String ACCEPT_TERMS_CHK="span.MuiIconButton-label input";



	
	// titles
	public static final String HOME_PAGE_TITLE = "Zoho - Cloud Software Suite and SaaS Applications for Businesses";
	
	// report path
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"//reports//";
	public static final How CSS_SEL = How.CSS;
	
	/// data
	public static final String[] intermediatePageOptions= {"Books","Connect","Mail","WorkDrive","Calendar","CRM","Meeting","Writer","Campaigns","Desk","Sheet","Cliq","Invoice","Show"};
	
	// sheet names
	public static final String TEST_STATUS_SHEET = "Test Status";
	
	//col names
	public static final Object COL_SUBJECT = "Subject";
	public static final Object COL_DATE = "Date";
	public static final String TCID = "TCID";
	public static final String RUNMODE = "Runmode";
	
	
	
	
	
	
		
}
