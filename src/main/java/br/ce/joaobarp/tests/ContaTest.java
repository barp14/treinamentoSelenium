package br.ce.joaobarp.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.joaobarp.core.BaseTest;
import br.ce.joaobarp.pages.ContasPage;
import br.ce.joaobarp.pages.MenuPage;

public class ContaTest extends BaseTest {

	ContasPage contas = new ContasPage();	
	MenuPage menu = new MenuPage();
	
	@Test
	public void inserirConta() {
		menu.acessarInserirConta();
		contas.setNomeConta("Conta do teste");
		contas.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contas.getMensagemSucesso());
	}
	
	@Test
	public void editarConta() {
		menu.acessarListaContas();
		contas.editarConta("Conta para alterar");
		contas.editarNomeConta("Conta alterada");
		contas.salvar();

		Assert.assertEquals("Conta alterada com sucesso!", contas.getMensagemSucesso());
	}
	
	@Test
	public void inserirContaRepetida() {
		menu.acessarInserirConta();
		contas.setNomeConta("Conta mesmo nome");
		contas.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contas.getMensagemFracasso());
	}
}
