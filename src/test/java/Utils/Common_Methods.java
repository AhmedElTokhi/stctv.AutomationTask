package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common_Methods {
	// WebDriver driver;
	static Utils.ReadingPropertiesFile data;	

	static Utils.LoggerFile Logger = new Utils.LoggerFile(Utils.Common_Methods.class);


	public Common_Methods(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriver driver;
	
	
	public static  Utils.ReadingPropertiesFile Call_ReadPropFile() {

		try {
			data = new Utils.ReadingPropertiesFile(".\\ReadFrom\\STCTV_Configuration.properities");

		} catch (Exception e) {
			e.printStackTrace();
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "\n", e);
		}
		return data;
	}
	

	public static void AssertTablevalue(WebElement TableElement, String Validatefor) {
		
		try{

//		driver.findElement(TableLocator);
		
//		WebElement elemTable=driver.findElement(TableLocator);
		
		List<WebElement> trlist = TableElement.findElements(By.tagName("tr"));

		// create empty (strRowData) value to be used in store and print.
		String strRowData = "";
		
		for (WebElement elemTr : trlist) {

			// Fetch the columns from a particular row (for each row)
			List<WebElement> tdlist = elemTr.findElements(By.xpath("td"));
			
			//when column list have value
			if (tdlist.size() > 0) {
				
				// For each row accumulated store columns value in (strRowData) and print it in console.
				for (WebElement w : tdlist) {
					
					// "\t\t" for Tab Space
					strRowData = strRowData + w.getText() + "\t\t";	

					if (strRowData.contains(Validatefor)){
					System.out.println("The value "+Validatefor+"exists");
					break;
					}
				}
				
				System.out.println(strRowData );

				// empty (strRowData) value.
				strRowData = "";
			} 
		}
		
		System.out.println("The value "+Validatefor+" is not exist");
	}catch (Exception e) {
		e.printStackTrace();
		Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + "\n", e);
	}	
	}
}
