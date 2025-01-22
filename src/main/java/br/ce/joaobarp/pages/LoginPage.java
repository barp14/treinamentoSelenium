package br.ce.joaobarp.pages;

import static br.ce.joaobarp.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.joaobarp.core.BasePage;

public class LoginPage extends BasePage {		
	
	public void acessarTelaInicial() {
		getDriver().get("https://seubarriga.wcaquino.me/");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}

	public void entrar() {
		clicarBotao(By.xpath("//button[.='Entrar']"));
	}
	
	public void reset() {
		clicarLink("reset");
	}
}
