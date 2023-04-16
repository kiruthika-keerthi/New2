package Campaigns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCampaign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 String key = "webdriver.chrome.driver()";
	 String Value = "src/main/resources/chromedriver.exe";
	 System.setProperty(key, Value);
	 WebDriver driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	}

}
