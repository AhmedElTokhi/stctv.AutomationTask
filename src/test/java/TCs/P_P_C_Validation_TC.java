package TCs;

import java.io.IOException;

//Package_Price_Currency Validation_TC

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.Locators;
import Utils.Common_Methods;
import Utils.ReadExcel_To_DProvider;
import Utils.ReadingPropertiesFile;


public class P_P_C_Validation_TC {


	WebDriver driver;
	ReadingPropertiesFile data = Common_Methods.Call_ReadPropFile();
	Utils.LoggerFile Logger = new Utils.LoggerFile(TCs.P_P_C_Validation_TC.class);
	Locators Locator=new Locators();
	
	

	@DataProvider(name = "SheetsTestData")
	public String[][] ReadTaskDataExcel() {
		String SBuffer[][] = null;
		try {
			ReadExcel_To_DProvider ExcelToProvider = new ReadExcel_To_DProvider();

			SBuffer = ((String[][]) ExcelToProvider.ReadAllExcel(data.Get_Filepath(), data.Get_Filename(), Integer.parseInt(data.Get_Sheetindex())));
			
		} catch (IOException e) {
			e.printStackTrace();
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + ": Error", e);
		}

		return SBuffer;
	}
	
	@Test (dataProvider= "SheetsTestData")
	public void ValidatePackageDetails_TC (String Country, String PackageName, String PackagePrice, String Currency) {
		HomePage HP_P= new HomePage(driver);  
		
		HP_P.SelectDisplayLang();
		HP_P.Assert_CurrentPage();
		HP_P.Select_Cuntry(Country);
		HP_P.AssertSelectedCountry(Country);
		HP_P.Validate_PackagesName(PackageName);
		HP_P.Validate_PackagesPrice(Country, PackagePrice);
		HP_P.Validate_PakagesCurrency(Country, Currency);
		
	}

	
	@BeforeMethod(alwaysRun = true)
	public void Setup(){ 
		
	try{
		System.out.println("-------------\n:@BeforeMethod");

		driver = Utils.WebDriverFactory.Driver_Default(data.GetBrowser());
		driver.get(data.Get_URL());
		System.out.println("The config. URL is: "+data.Get_URL());
		
	}catch (Exception e){
		e.printStackTrace();
		Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+":\n",e);
	}
	}

	@AfterMethod(alwaysRun = true)
	public void Teardown(ITestResult Result) {
	try{
		System.out.println("-----------------\n:@AfterMethod");

		// Add time stamp to use it screenshot
		long TimeStamp = System.currentTimeMillis();

		if (!Result.isSuccess()) {
			Utils.ScreenCapture.getFullScreenShot(driver, ".\\Screenshot\\Fail" + TimeStamp + ".png");
		}
		driver.quit();
		System.gc();
		
	}catch (Exception e){
		e.printStackTrace();
		Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+":\n",e);
	}	
	}
}
