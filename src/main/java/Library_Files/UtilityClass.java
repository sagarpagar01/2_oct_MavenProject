package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass 
{

	@Test
	public static String getDataFromPropFile(String key) throws IOException
	{
		
		FileInputStream Propfile = new FileInputStream("C:\\Users\\sagar pagar\\eclipse-workspace\\02_Oct_JavaBasics_Mavenframework\\PropFile.properties");
		
		Properties prop = new Properties();
		
		prop.load(Propfile);
		
	   String Value1 = prop.getProperty(key);
	   
	   return Value1;
		
	}
	
	@Test
	public static String getDataFromExcelSheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\sagar pagar\\eclipse-workspace\\02_Oct_JavaBasics_Mavenframework\\TestData\\parameterisation.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet5");
		
		String ExpectedEmail = sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		
		return ExpectedEmail;
		
	}
	
	@Test
	public static void captureScreenshot(WebDriver driver, int TestCaseID) throws IOException
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		
		File Destination = new File("C:\\Users\\sagar pagar\\eclipse-workspace\\02_Oct_JavaBasics_Mavenframework\\Screenshot."+TestCaseID+".jpg");
		
		FileHandler.copy(Source, Destination);
		
	}
	
	
	
}
