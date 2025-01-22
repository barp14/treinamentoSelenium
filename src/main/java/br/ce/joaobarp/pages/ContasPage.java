package br.ce.joaobarp.pages;

import org.openqa.selenium.By;


import br.ce.joaobarp.core.BasePage;

public class ContasPage extends BasePage {
			
	public void setNomeConta(String nome) {
		escrever("nome", nome);
	}
	
	public String getMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String getMensagemFracasso() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public void salvar() {
		clicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public void editarNomeConta(String nomeEditado) {
		apagar("nome");
		escrever("nome", nomeEditado);
	}
	
	public void editarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public void excluirConta (String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
	
}
