package Pages;

import org.openqa.selenium.By;

public class Locators {
	
	// Locators
	// ==========
	
	By But_Lang= By.xpath("//*[@id='translation-btn']");
	
	By Txt_ChooseYourPlan=By.xpath("//*[@id='main']//div[1]/div[1]/div/h2/b");
	By But_SelectCuntry=By.xpath("//*[@id='header']/div/div[2]/div[1]");
	
	By Txt_CuntryList_label=By.xpath("//*[@id='country-title']");
	
	By Txt_SelectedCuntry=By.xpath("//*[@id='country-name']");
	
	//By List_Cuntry=By.xpath("//*[@id='country-select']");
	By Icon_Bahren=By.xpath("//*[@id='bh']");
	By Icon_SAR=By.xpath("//*[@id='sa']");
	By Icon_KWait=By.xpath("//*[@id='kw']");
	
	By Txt_LITEPkg=By.xpath("//div[1]/div[2]//div[1]/strong");
	By Txt_CLASSICPkg=By.xpath("//div[1]/div[2]//div[2]/strong");
	By Txt_PREMIUMPkg=By.xpath("//div[1]/div[2]//div[3]/strong");

	By Txt_LITEPrice=By.xpath("//div[1]/div[3]/div[2]/div[1]//b");
	By Txt_CLASSICPrice=By.xpath("//div[1]/div[3]/div[2]/div[2]//b");
	By Txt_PREMIUMPrice=By.xpath("//div[1]/div[3]/div[2]/div[3]//b");
	
	By Txt_LITECurrency=By.xpath("//div[1]/div[3]/div[2]/div[1]//i");
	By Txt_CLASSICCurrency=By.xpath("//div[1]/div[3]/div[2]/div[2]//i");
	By Txt_PREMIUMCurrency=By.xpath("//div[1]/div[3]/div[2]/div[3]//i");
	
}


