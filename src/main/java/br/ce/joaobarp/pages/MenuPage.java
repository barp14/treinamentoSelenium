package br.ce.joaobarp.pages;

import br.ce.joaobarp.core.BasePage;

public class MenuPage extends BasePage {
		
	public void acessarInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarListaContas() {
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarMovimentacao() {
		clicarLink("Criar Movimentação");
	}
	
	public void acessarResumoMensal() {
		clicarLink("Resumo Mensal");
	}
	
	public void acessarHome() {
		clicarLink("Home");
	}
}
