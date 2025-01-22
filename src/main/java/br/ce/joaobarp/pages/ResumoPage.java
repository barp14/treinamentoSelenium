package br.ce.joaobarp.pages;

import org.openqa.selenium.By;

import br.ce.joaobarp.core.BasePage;

public class ResumoPage extends BasePage {
	
	public void clicarApagarMovimentacao() {
		clicarBotao(By.xpath(".//*[@class='glyphicon glyphicon-remove-circle']"));
	}

	public String getMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String getMensagemFracasso() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public void selecionarAno(String ano) {
		selecionarCombo("ano", ano);
	}
	
	public void buscar() {
		clicarBotao(By.xpath("//input[@value='Buscar']"));
	}
}
