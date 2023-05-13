package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel_To_DProvider {

	// String FilePath= "./ReadFrom/CalcInput.xls";
	private File src;
	private FileInputStream fis;
	private Workbook wb;
	Utils.LoggerFile Logger = new Utils.LoggerFile(ReadExcel_To_DProvider.class);
	
	public Object[][] ReadAllExcel(String filePath, String fileName, int sheetindex) throws IOException {

		src = new File(filePath + "\\" + fileName);
	
		try {
			fis = new FileInputStream(src);

			// Find the file extension by splitting file name in substring and
			// getting only extension name
			String fileExtensionName = fileName.substring(fileName.indexOf("."));

			if (fileExtensionName.equals(".xlsx")) {
				wb = new XSSFWorkbook(fis);
			} else if (fileExtensionName.equals(".xls")) {
				wb = new HSSFWorkbook(fis);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Logger.WriteLog(" Line " + Thread.currentThread().getStackTrace()[1].getLineNumber() + ":\n", e);
		}
		Sheet mySheet = wb.getSheetAt(sheetindex);
			int numRows = mySheet.getLastRowNum()+1;
			//System.err.println("Rows Number = "+numRows);
		
			int numCols = mySheet.getRow(0).getLastCellNum();
			//System.err.println("Columns Number = "+numCols);
		
		String[][] excelData = new String[numRows-1][numCols];

		 System.out.println("=================\nPopulating Array\n=================");
		for (int i = 1; i < numRows; i++) {
			wb.getSheetAt(sheetindex).getRow(i);

			// System.err.println("Next Row value"); //for test only
			for (int j = 0; j < numCols; j++) {
				Cell cell = wb.getSheetAt(sheetindex).getRow(i).getCell(j);
				//String value = cell.getStringCellValue();
				// OR
				String value = String.valueOf(cell);
				excelData[i-1][j] = value;
				System.out.println("The value is: " + excelData[i-1][j]); // for test only
				Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"The value is: " + excelData[i-1][j]);
			}
			System.out.println("-------------------------------\n");
			Logger.WriteLog(" Line "+Thread.currentThread().getStackTrace()[1].getLineNumber()+"-------------------------------\n");
		}
		return excelData;


	}
}
