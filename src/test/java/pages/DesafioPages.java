package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DesafioPages {

	static WebDriver driver;

	public DesafioPages(WebDriver driver) {
		this.driver = driver;
	}

	public void preencherLoginErrado1aTentativa() {

		WebElement nome = driver.findElement(By.name("username"));
		nome.sendKeys("Demouser");

		WebElement senha = driver.findElement(By.name("password"));
		senha.sendKeys("abc123");

		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();

		String validarLoginErrado = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
		Assert.assertEquals("Wrong username or password.", validarLoginErrado);
	}

	public void preencherLoginErrado2aTentativa() {

		WebElement nome = driver.findElement(By.name("username"));
		nome.sendKeys("demouser_");

		WebElement senha = driver.findElement(By.name("password"));
		senha.sendKeys("xyz");

		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();

		String validarLoginErrado = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
		Assert.assertEquals("Wrong username or password.", validarLoginErrado);
	}

	public void preencherLoginErrado3aTentativa() {

		WebElement nome = driver.findElement(By.name("username"));
		nome.sendKeys("demouser");

		WebElement senha = driver.findElement(By.name("password"));
		senha.sendKeys("nananana");

		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();

		String validarLoginErrado = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
		Assert.assertEquals("Wrong username or password.", validarLoginErrado);
	}

	public void preencherLoginErrado4aTentativa() {

		WebElement nome = driver.findElement(By.name("username"));
		nome.sendKeys("Demouser");

		WebElement senha = driver.findElement(By.name("password"));
		senha.sendKeys("abc123");

		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();

		String validarLoginErrado = driver.findElement(By.xpath("/html/body/div/div[1]")).getText();
		Assert.assertEquals("Wrong username or password.", validarLoginErrado);
	}

	public void preencherLoginCerto() {

		WebElement nome = driver.findElement(By.name("username"));
		nome.sendKeys("demouser");

		WebElement senha = driver.findElement(By.name("password"));
		senha.sendKeys("abc123");

		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();
	}

	public void clicarLinkInvoice() {

		WebElement btnInvoice = driver.findElement(By.linkText("Invoice Details"));
		btnInvoice.click();
	}

	public void validarCamposInvoice() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String validarCustomerDtls = driver.findElement(By.xpath("/h4[text()='Rendezvous Hotel']/following-sibling::div[1]")).getText();
		Assert.assertEquals("JOHNY SMITHR2, AVENUE DU MAROC123456", validarCustomerDtls);
		
		WebElement validarNomeHotel = driver.findElement(By.cssSelector(".mt-5:nth-child(2)"));
		Assert.assertEquals("Rendezvous Hotel", validarNomeHotel);
		
		String validarDataInvoice = driver.findElement(By.xpath("/html/body/section/div/ul/li")).getText();
		Assert.assertEquals("Invoice Date: 14/01/2018", validarDataInvoice);
		
		String validarDueDate = driver.findElement(By.xpath("/html/body/section/div/ul/li[2]")).getText();
		Assert.assertEquals("15/01/2018", validarDueDate);

		String validarInvoiceNumber = driver.findElement(By.xpath("/html/body/section/div/h6")).getText();
		Assert.assertEquals("Invoice #110 details", validarInvoiceNumber);

		String validarBookingCode = driver.findElement(By.xpath("/html/body/section/div/table[1]/tbody/tr[1]/td[2]"))
				.getText();
		Assert.assertEquals("0875", validarBookingCode);

		String validarRoom = driver.findElement(By.xpath("/html/body/section/div/table[1]/tbody/tr[2]/td[2]"))
				.getText();
		Assert.assertEquals("Superior Double", validarRoom);

		String validarCheckIn = driver.findElement(By.xpath("/html/body/section/div/table[1]/tbody/tr[5]/td[2]"))
				.getText();
		Assert.assertEquals("14/01/2018", validarCheckIn);

		String validarCheckOut = driver.findElement(By.xpath("/html/body/section/div/table[1]/tbody/tr[6]/td[2]"))
				.getText();
		Assert.assertEquals("15/01/2018", validarCheckOut);

		String validarStayCount = driver.findElement(By.xpath("/html/body/section/div/table[1]/tbody/tr[3]/td[2]"))
				.getText();
		Assert.assertEquals("1", validarStayCount);

		String validarStayAmount = driver.findElement(By.xpath("/html/body/section/div/table[1]/tbody/tr[4]/td[2]"))
				.getText();
		Assert.assertEquals("$150", validarStayAmount);

		String validarDepositNow = driver.findElement(By.xpath("/html/body/section/div/table[2]/tbody/tr/td[1]"))
				.getText();
		Assert.assertEquals("USD $20.90", validarDepositNow);

		String validarTaxVat = driver.findElement(By.xpath("/html/body/section/div/table[2]/tbody/tr/td[2]")).getText();
		Assert.assertEquals("USD $19", validarTaxVat);

		String validarTotalAmount = driver.findElement(By.xpath("/html/body/section/div/table[2]/tbody/tr/td[3]"))
				.getText();
		Assert.assertEquals("USD $209", validarTotalAmount);

	}

}
