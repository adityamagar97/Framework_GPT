package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtil {

    @DataProvider(name = "loginData")
    public static Object[][] getexcel() throws IOException {
        
        DataFormatter df = new DataFormatter();
        
        // Use the class loader to load the Excel file from resources folder
        InputStream file = new FileInputStream("/Users/adityamagar/Desktop/TNS /Store_TestCases.xlsx");
        // Open the Excel file using the input stream
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("logdet");

        int GeRow = sheet.getLastRowNum();
        int GeCol = sheet.getRow(0).getLastCellNum();

        Object obj[][] =  new Object[GeRow][GeCol];
        
        // Iterate over the rows and cells
        for(int i = 0; i < GeRow; i++) {
            XSSFRow row = sheet.getRow(i + 1);

            for(int j = 0; j < GeCol; j++) {
                XSSFCell cell = row.getCell(j);
                obj[i][j] = df.formatCellValue(cell);   
            }
        }
        
        workbook.close();  // Close the workbook to avoid memory leaks
        return obj;
    }

@DataProvider(name = "RegisterData")
public static Object[][] registerexcel() throws IOException {
    
    DataFormatter df = new DataFormatter();
    
    // Use the class loader to load the Excel file from resources folder
    InputStream file = new FileInputStream("/Users/adityamagar/Desktop/TNS /Store_TestCases.xlsx");
    // Open the Excel file using the input stream
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheet("regdet");

    int GeRow = sheet.getLastRowNum();
    int GeCol = sheet.getRow(0).getLastCellNum();

    Object obj[][] =  new Object[GeRow][GeCol];
    
    // Iterate over the rows and cells
    for(int i = 0; i < GeRow; i++) {
        XSSFRow row = sheet.getRow(i + 1);

        for(int j = 0; j < GeCol; j++) {
            XSSFCell cell = row.getCell(j);
            obj[i][j] = df.formatCellValue(cell);   
        }
    }
    
    workbook.close();  // Close the workbook to avoid memory leaks
    return obj;
}
}
