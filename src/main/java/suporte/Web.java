package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Web {
	
	  public static final String USERNAME = "taynarodrigues1";
	  public static final String AUTOMATE_KEY = "KkKCmt5YqAwpV4cyc7Cx";
	  public static final String URL = "https://" + "taynarodrigues1" + ":" + "KkKCmt5YqAwpV4cyc7Cx" + "@hub-cloud.browserstack.com/wd/hub";
	
	public static WebDriver createChrome() {
		
		// Abrindo o navegador
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
				WebDriver navegador = new ChromeDriver();
				navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				// navegando para a pagina do Taskit!
				navegador.get("http://www.juliodelima.com.br/taskit");
				
				return navegador;
	}
	
	public static WebDriver createBrowserStack() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "62.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1024x768");

		 WebDriver navegador = null;
		 
		try {
			navegador = new RemoteWebDriver(new java.net.URL(URL), caps);
			navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			// navegando para a pagina do Taskit!
			navegador.get("http://www.juliodelima.com.br/taskit");
		}catch (MalformedURLException e) {
			System.out.println("Houveram problemas com a URL: " + e.getMessage());
		}
		return navegador;
	}

}
