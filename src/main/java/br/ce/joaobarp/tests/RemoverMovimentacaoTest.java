package br.ce.joaobarp.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.joaobarp.core.BaseTest;
import br.ce.joaobarp.pages.ContasPage;
import br.ce.joaobarp.pages.MenuPage;

public class RemoverMovimentacaoTest extends BaseTest {
	
	ContasPage contas = new ContasPage();	
	MenuPage menu = new MenuPage();
	
	// está em classe separada pois o teste na ContasTest não estaria na ordem correta
	@Test
	public void testExcluirContaComMovimentacao(){
		menu.acessarListaContas();
		contas.excluirConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", contas.getMensagemFracasso());
	}

}
