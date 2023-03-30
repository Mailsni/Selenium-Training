import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FileHandling {
	
	public static void readExcelFile(String filepath)throws IOException {
		
	FileInputStream fis = new FileInputStream(new File(filepath));
	
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Students");
		
		for(int i=0; i<sheet.getLastRowNum();i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			for (int j =0; j<row.getLastCellNum();j++) {
				System.out.println(row.getCell(j));
			}
		}
		
		
		//System.out.println(sheet.getRow(1).getCell(1));
	

		}



		public static void writeExcelFile(String filepath)throws IOException {
		
	
	
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Students");
		sh.createRow(0).createCell(0).setCellValue("Snisha");
		sh.createRow(1).createCell(1).setCellValue("Padm");
		sh.createRow(2).createCell(0).setCellValue("Snisha");
		sh.createRow(3).createCell(0).setCellValue("Snisha");
		
		System.out.println("Data is provided");
		
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\mails\\Downloads\\OpenPages.xlsx"));
		wb.write(fos);
		fos.close();
	}
			
	
	public static void main(String[] args)throws IOException, InvalidFormatException{
		
		String filepath = "C:\\Users\\mails\\Downloads\\OpenPages-Interview-Prep-2023.xlsx";
			//FileHandling.readExcelFile(filepath);
			
		FileHandling.writeExcelFile("C:\\Users\\mails\\Downloads\\OpenPages.xlsx");
	}
}



