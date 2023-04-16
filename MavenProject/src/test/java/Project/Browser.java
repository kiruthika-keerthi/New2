package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static void main(String[] args) {
String key="webdriver.chrome.driver";
String Value="./src/main/resources/chromedriver.exe";
System.setProperty(key, Value);
WebDriver driver=new ChromeDriver();
	
	
	}

}
