package Organization;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganization {

	public static void main(String[] args) throws InterruptedException, Throwable {
		String key="webdriver.chrome.driver";
		String Value="./src/main/resources/chromedriver.exe";
		System.setProperty(key, Value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties.txt");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		driver.get(URL);



		//driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Random r=new Random();
		int rnum = r.nextInt(1000);
		
		
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelDataSheet.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String exceldata = cell.getStringCellValue()+rnum;

		
		driver.findElement(By.name("accountname")).sendKeys(exceldata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actualdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actualdata.contains(exceldata))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();


	}

}
