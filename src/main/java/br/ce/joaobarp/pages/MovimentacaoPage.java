package br.ce.joaobarp.pages;

import org.openqa.selenium.By;

import br.ce.joaobarp.core.BasePage;

public class MovimentacaoPage extends BasePage {

	public void setTipoMovimentacao(String valor) {
		clicarBotao(By.id("tipo"));
		clicarBotao(By.xpath("//*[@value='"+ valor +"']"));
	}
	
	public void setDataMovimentacao(String dataMovimentacao) {
		escrever("data_transacao", dataMovimentacao);
	}
	
	public void setDataPagamento(String dataPagamento) {
		escrever("data_pagamento", dataPagamento);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(int valor) {
		escreverInt("valor", valor);
	}
	
	public void setConta(String valor) {
		clicarBotao(By.id("conta"));
		clicarBotao(By.xpath("//*[.='"+ valor +"']"));
	}
	
	public void setSituacao(String valor) {
		clicarBotao(By.xpath("//*[@id='"+ valor +"']"));
	}
	
	public void salvar() {
		clicarBotao(By.xpath("//button[.='Salvar']"));
	}
	
	public String getMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String getMensagemFracasso() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
}
