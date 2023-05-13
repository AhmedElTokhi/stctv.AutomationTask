package Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import Utils.Common_Methods;
import Utils.ReadingPropertiesFile;

public class HomePage 
{

	WebDriver driver;
	ReadingPropertiesFile data = Common_Methods.Call_ReadPropFile();
	Utils.LoggerFile Logger = new Utils.LoggerFile(Pages.HomePage.class);
	Locators Locator=new Locators();
	String CheckPakagename="";
	String CheckPakagePrice="";
	String CheckPakageCurrency="";
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void SelectDisplayLang() {
		try{
			System.out.println("-------------\n:@SelectDisplayLang_Method");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"-------------\n:@SelectDisplayLang_Method");
		String URL= driver.getCurrentUrl();
		System.out.println("The current URL is: "+URL);  //for testing
		Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"The current URL is: "+URL);
		
		if(URL.contains("ar")) {
			driver.findElement(Locator.But_Lang).click();
		}
		URL= driver.getCurrentUrl();
		assertTrue(URL.contains("en"));
		System.out.println("page language is 'English'");
		Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"page language is 'English'");
		
		} catch (Exception e) {
			e.printStackTrace();
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + ":\n", e);
		}

	}
	
	public void Assert_CurrentPage() {
		try {
			System.out.println("-------------\n:@assert_CurrentPage_Method");
			
			
			Utils.Wait.Presence(driver, Locator.Txt_ChooseYourPlan);
			System.out.println("Home page displayed in successfully");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"Home page displayed in successfully");

		} catch (Exception e) {
			e.printStackTrace();
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + ":\n", e);
		}
	}
	
	public void Select_Cuntry (String Cuntry) {
		try{
			System.out.println("-------------\n:@Select_Cuntry_Method");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"-------------\n:@Select_Cuntry_Method");

			Utils.Wait.Presence(driver, Locator.But_SelectCuntry);
			driver.findElement(Locator.But_SelectCuntry).click();
			Utils.Wait.Presence(driver,Locator.Txt_CuntryList_label);
		
			if(Cuntry.contains("Bahrain")) {
				driver.findElement(Locator.Icon_Bahren).click();
				System.out.println("The Country 'Bahrain' is selected");  //For tester
				Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"The Country 'Bahrain' is selected");
				
			}else if(Cuntry.contains("KSA")) {
				driver.findElement(Locator.Icon_SAR).click();
				System.out.println("The Country 'KSA' is selected");  //For tester
				Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"The Country 'KSA' is selected");
			}else if(Cuntry.contains("Kuwait")) {
				driver.findElement(Locator.Icon_KWait).click();
				System.out.println("The Country 'Kuwait' is selected");  //For tester
				Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"The Country 'Kuwait' is selected");
			}
		
		}catch (Exception e){
			e.printStackTrace();
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+":\n",e);
		}
	}
		
	public void AssertSelectedCountry(String Cuntry) {
		try{
			System.out.println("-------------\n:@AssertSelectedCountry_Method");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"-------------\n:@AssertSelectedCountry_Method");
					
		Utils.Wait.Presence(driver, Locator.Txt_SelectedCuntry);
		String ActauLSelCuntry=driver.findElement(Locator.Txt_SelectedCuntry).getText();
		
		assertTrue(ActauLSelCuntry.contains(Cuntry));
		System.out.println("the Country "+Cuntry+" is slected successfully");
		Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"the Country "+Cuntry+" is slected successfully");
		
		}catch (Exception e){
			e.printStackTrace();
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+":\n",e);
		}
	}	
		
		
	//@Test
	public void Validate_PackagesName(String PackagesName) {
		try{
			System.out.println("-------------\n:@Validate_PackagesName_Method");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"-------------\n:@Validate_PagePackages_Method");
			
			Utils.Wait.Presence(driver, Locator.Txt_LITEPkg);

			if(PackagesName.contains("LITE")) {
				CheckPakagename=driver.findElement(Locator.Txt_LITEPkg).getText();
				
			}else if(PackagesName.contains("CLASSIC")) {
				CheckPakagename=driver.findElement(Locator.Txt_CLASSICPkg).getText();
						
			}else if(PackagesName.contains("PREMIUM")) {
				CheckPakagename=driver.findElement(Locator.Txt_PREMIUMPkg).getText();		
			}
//			System.out.println("The Package adat meet expected");  //For tester
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"The Package adat meet expected");
			
			
			assertTrue(CheckPakagename.contains(PackagesName));
			System.out.println("the page display correct Package Name successfully");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"the page diplay PackagesName as expected");
			
		}catch (Exception e){
			e.printStackTrace();
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+":\n",e);
		}
	}
//	@Test
	public void Validate_PackagesPrice (String Cuntry, String Price) {
		try{
			System.out.println("-------------\n:@Validate_PackagesPrice_Method");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"-------------\n:@Validate_PackagesPrice_Method");
			
//			Utils.Wait.attributeNotEmpty(driver, Locator.Txt_LITEPrice,"b");
			
			String check_Price=driver.findElement(Locator.Txt_LITEPrice).getText();
//			System.out.println("The Page price is: "+ check_Price);  //For tester
			assertFalse(check_Price.isEmpty());
			
			switch (Cuntry) {
				case "Bahrain":
					if(Price.contains("2")) {
						CheckPakagePrice=driver.findElement(Locator.Txt_LITEPrice).getText();
					
					}else if(Price.contains("3")) {
						CheckPakagePrice=driver.findElement(Locator.Txt_CLASSICPrice).getText();

					}else if(Price.contains("6")) {
						CheckPakagePrice=driver.findElement(Locator.Txt_PREMIUMPrice).getText();

					}
					break;

				case "KSA":  
					if(Price.contains("15")) {
						CheckPakagePrice=driver.findElement(Locator.Txt_LITEPrice).getText();
								
					}else if(Price.contains("25")) {
						CheckPakagePrice=driver.findElement(Locator.Txt_CLASSICPrice).getText();
								
					}else if(Price.contains("60")) {
						CheckPakagePrice=driver.findElement(Locator.Txt_PREMIUMPrice).getText();

					}
					break;

				case "Kuwait":
					if(Price.contains("1.2")) {
						CheckPakagePrice=driver.findElement(Locator.Txt_LITEPrice).getText();
								
					}else if(Price.contains("2.5")) {
						CheckPakagePrice=driver.findElement(Locator.Txt_CLASSICPrice).getText();
						
					}else if(Price.contains("4.8")) {
						CheckPakagePrice=driver.findElement(Locator.Txt_PREMIUMPrice).getText();
						
					}
					break;
			}
//			System.out.println("The CheckPakagePrice current value is: "+CheckPakagePrice);  //For tester
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"The CheckPakagePrice current value is: "+CheckPakagePrice);
			
			assertTrue(CheckPakagePrice.contains(Price));
			System.out.println("the page display correct Package price successfully");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"the page display Package price as expected");
			
			
		}catch (Exception e){
			e.printStackTrace();
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+":\n",e);
		}
	}
		
	
	//@Test
	public void Validate_PakagesCurrency(String Cuntry, String Currency) {
		try{
			System.out.println("-------------\n:@Validate_PakagesCurrency_Method");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"-------------\n:@Validate_PakagesCurrency_Method");
			
			Utils.Wait.Presence(driver, Locator.Txt_LITECurrency);

			switch (Cuntry) {
			case "Bahrain":
				if(Currency.contains("BHD"))
					CheckPakageCurrency=driver.findElement(Locator.Txt_LITECurrency).getText();
				break;

			case "KSA":  
				if(Currency.contains("SAR"))
					CheckPakageCurrency=driver.findElement(Locator.Txt_LITECurrency).getText();
			
				break;
				
			case "Kuwait":
				if(Currency.contains("KWD"))
					CheckPakageCurrency=driver.findElement(Locator.Txt_LITECurrency).getText();
							
				break;
				}
			
//			System.out.println("The CheckPakageCurrency current value is: "+CheckPakageCurrency);  //For tester
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"The CheckPakageCurrency current value is: "+CheckPakageCurrency);
		
		
			assertTrue(CheckPakageCurrency.contains(Currency));
			System.out.println("the page display correct Packages Currency successfully");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"the page diplay Packages Currency as expected");
			
		}catch (Exception e){
			e.printStackTrace();
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+":\n",e);
		}
	}
}


	
