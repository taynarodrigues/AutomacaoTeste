package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformacoesUsuarioTest {

	private WebDriver navegador;

	@Before
	public void setUp() {

		// Abrindo o navegador
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// navegando para a pagina do Taskit!
		navegador.get("http://www.juliodelima.com.br/taskit");
		navegador.manage().window().maximize();

		// Clicar no link que possui o texto "Sign in"
		navegador.findElement(By.linkText("Sign in")).click();

		// Identificando o formulário de Login
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

		// Digitar no campo com name "login que esta dentro do formulário de id "siginbox" o texto "julio001"
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio001");

		// Digitar no campo com name "password" que está dentro do formulário de id "sininbox" o texto "123456"
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

		// Clicar no link com o texto "SIGN IN"
		navegador.findElement(By.linkText("SIGN IN")).click();

		// Clicar em um link em que possui a class "me"
		navegador.findElement(By.className("me")).click();

		// Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

	}

	// @Test Teste comentado temporariamente!
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {

		// Clicar no botão através de seu spath //button[@data-target="addmoredata"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

		// Identificar a popup onde está o formulário de id addmoredata
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

		// Na combo de name "type" escolhe a opção "Phone"
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));

		// No campo de name "contact" digitar "+551199999999"
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+551199999999");

		// Clicar no link de text "SAVE" que está na popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();

		// Na mensagem de id "toast-container" validar que o texto é "Your contact has bee added!"
		WebElement mensagemPop = navegador.findElement(By.id("toast-caontainer"));
		String mensagem = mensagemPop.getText();
		assertEquals("Your contact has\n bee added", mensagem);
	}

	@Test
	public void removerUmContatoDeUmUsuario() {
		//Clicar no elemento pelo seu xpath //span[text()="+5592992825179"]/following-sibling::a
		navegador.findElement(By.xpath("//span[text()=\"+5592992825179\"]/following-sibling::a")).click();
		
		//Confirmaar a janela javascript
		navegador.switchTo().alert().accept();
		
		//Validar que a mensagem apresentada foi Rest in peace, dear phone!
		WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPop.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);
		
		//Aguardar até 10 segundos para que a janela desapareça
		WebDriverWait aguardar = new WebDriverWait(navegador,50);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
		
		//Clicar no link com texto "Logout"
		navegador.findElement(By.linkText("Lougout"));
	}

	@After
	public void tearDown() {
		// Fechar o navegador
		// navegador.quit();

	}

}
