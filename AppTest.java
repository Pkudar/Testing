package DriverFactory;

import org.testng.annotations.Test;

public class AppTest {

	@Test
	public void startTest()
	{
		try{
		DriverScript ds= new DriverScript();
		ds.ERP_Test();
		
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
