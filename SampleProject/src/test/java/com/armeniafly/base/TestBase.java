package com.armeniafly.base;

import com.armeniafly.session.ArmeniaflySession;
import com.armeniafly.utils.Xls_Reader;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
	
	public ArmeniaflySession session;
	public String testName=null;
	public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	public String appUrl;
	@Parameters({"appUrl"})
	@BeforeClass
	public void getUrl(String url)
	{
		appUrl=url;
	}
	@BeforeMethod()
	public void init(ITestResult result) {
		System.out.println("@BeforeMethod");
		testName = result.getMethod().getMethodName().toUpperCase();
		System.out.println(testName);
		session= new ArmeniaflySession();
		session.init(testName);
	}
	
	@AfterMethod
	public void quit() {
		session.generateReport();
	}
	
}
