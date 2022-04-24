package com.armeniafly.dataprovider;

import com.armeniafly.utils.DataUtil;
import com.armeniafly.utils.Xls_Reader;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestDataProvider {

	
	
	@DataProvider
	public static Object[][] getData(Method m){		
		System.out.println("Getting data for "+ m.getName());
		Object[][] data= new DataUtil().getData(m.getName(), new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx"));
		System.out.println("Got data for "+ m.getName());
		return data;
	}
	

	
	
}
