package DriverFactory;

import org.openqa.selenium.WebDriver;


import CommonFunLibrary.FunctionLibrary;
import Utilities.ExcelFileUtil;

public class DriverScript {

	public static WebDriver driver;
	
	public void ERP_Test() throws Throwable
	{
		//creating obj of ExcelfileUtil for accessing method;
		ExcelFileUtil xl= new ExcelFileUtil();
		//iterating all row in mastertestcase
		for(int i=1;i<xl.rowCount("MasterTestCases");i++)
		{
			if(xl.getCellData("MasterTestCases", i, 1).equalsIgnoreCase("Y"))
			{
				//store module name(Tc) in String obj
				String TCModule=xl.getCellData("MasterTestCases", i, 1);
				//Read all data from TCModule
				for(int j=1;j<=xl.rowCount(TCModule);j++)
				{
					String Description= xl.getCellData(TCModule,j, 0);
					String Function_Name=xl.getCellData(TCModule, j, 1);
					String Locator_Type=xl.getCellData(TCModule, j, 2);
					String Locator_Value=xl.getCellData(TCModule,j, 3);
					String Test_Data=xl.getCellData(TCModule, j, 4);
					
					//Calling the function from excel sheet
					try
						{
							if(Function_Name.equalsIgnoreCase("startBrowser"))
							{
								driver=FunctionLibrary.startBrowser();
								System.out.println("Executing start browser");
							}
							else if(Function_Name.equalsIgnoreCase("openApplication"))
							{ 
								FunctionLibrary.openApplication(driver);
								
							}
							else if(Function_Name.equalsIgnoreCase("waitForElement"))
							{
								FunctionLibrary.waitForElement(driver, Locator_Type, Locator_Value, Test_Data);
							}
							else if(Function_Name.equalsIgnoreCase("typeAction"))
							{
								FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
							}
							else if(Function_Name.equalsIgnoreCase("clickAction"))
							{
								FunctionLibrary.clickAction(driver, Locator_Type, Locator_Value);
							}
							else if(Function_Name.equalsIgnoreCase("closeBrowser"))
							{
								FunctionLibrary.closeBrowser(driver);
							}
							//Write as pass into status column
							xl.setCellData(TCModule, j, 5, "Pass");
							xl.setCellData("MasterTestCases", i, 3, "Pass");
						}
					catch(Exception e)
						{
							System.out.println("Exception handle");
							//Write as fail into column ,when function not exe successfully
							xl.setCellData(TCModule, j, 5, "Fail");
							xl.setCellData("MasterTestCases", i, 3,"Fail");
						}
					
				}
			}
			else
			{
				xl.setCellData("", i, 3, "Not Exe");
			}
		}
		
	}
	
}
