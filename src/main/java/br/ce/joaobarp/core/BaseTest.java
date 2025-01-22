package br.ce.joaobarp.core;

import static br.ce.joaobarp.core.DriverFactory.getDriver;
import static br.ce.joaobarp.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.joaobarp.pages.LoginPage;

public class BaseTest {
		
	@Rule
	public TestName testName = new TestName();
	
	private static LoginPage page = new LoginPage();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("joaobarpy@gmail.com");
		page.setSenha("senha000999");
		page.entrar();
	}
	
	@After
	public void fim() throws IOException {
	
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
	}

}
