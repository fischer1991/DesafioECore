package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.DesafioPages;

public class DesafioTest {
	
static WebDriver driver;
static DesafioPages loginPages;
	
	@BeforeTest
	public static void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\707922\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://automation-sandbox.herokuapp.com/");
		driver.manage().window().maximize();
		loginPages = new DesafioPages(driver);
	}
	
	@Test
	public static void test() {
		loginPages.preencherLoginErrado1aTentativa();
		loginPages.preencherLoginErrado2aTentativa();
		loginPages.preencherLoginErrado3aTentativa();
		loginPages.preencherLoginErrado4aTentativa();
		loginPages.preencherLoginCerto();
		loginPages.clicarLinkInvoice();
		loginPages.validarCamposInvoice();
		
	}
	
	@AfterTest
	public static void afterTest() {
		driver.close();
	}

}


