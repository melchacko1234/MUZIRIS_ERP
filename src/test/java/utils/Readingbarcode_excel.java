package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Readingbarcode_excel
{
	
	
	public FileInputStream input_document;
	public XSSFWorkbook xlsx_workbook;
	public XSSFSheet xlsx_worksheet;
	
	
	public   Object[][] xlsx() throws IOException
	{
	
                                                                            
	    input_document = new FileInputStream(new File("C:\\Users\\Administrator\\git\\Muziris\\Muziris_ERP\\src\\test\\java\\datafiles\\Barcodescan.xlsx"));
		 xlsx_workbook = new XSSFWorkbook(input_document);// connect the excel using InputStream
		xlsx_worksheet = xlsx_workbook.getSheet("Sheet1");
        int rownum = xlsx_worksheet.getLastRowNum();
        int colnum = xlsx_worksheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rownum][colnum];
        for (int i = 0; i < rownum; i++) 
        {
            Row row = xlsx_worksheet.getRow(i);
            if (row != null)
            
            {
                for (int j = 0; j < colnum; j++) 
                
                {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        try
                        {
                            data[i][j] = cell.getStringCellValue();
                            
                        } 
                        
                        catch (IllegalStateException e)
                        {
                            data[i][j] = new BigDecimal(cell.getNumericCellValue()).toPlainString().toString().trim();
                        }
                    }
                }
            }
        }
        
         return data; 
        
        }
       
        }
        
	
	




	/*public static void main(String[] args) throws IOException {

		String excelFilePath="C:\\Users\\Administrator\\git\\Muziris\\Muziris_ERP\\src\\test\\java\\datafiles\\Barcodescan.xlsx";
		FileInputStream inputstream=new FileInputStream(excelFilePath);

		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.getSheetAt(0);	//XSSFSheet sheet=workbook.getSheet("Sheet1");

		////  USING FOR LOOP

		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();

		for(int r=0;r<=rows;r++)
		{
			XSSFRow row=sheet.getRow(r); //0

			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.getCell(c);

				switch(cell.getCellType())
				{
				case NUMERIC: System.out.print(cell.getNumericCellValue().);break;
                
				case STRING: System.out.print(cell.getRichStringCellValue());break;
				case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		} */
	
