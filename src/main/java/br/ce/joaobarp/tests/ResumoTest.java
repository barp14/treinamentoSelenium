package br.ce.joaobarp.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.joaobarp.core.BaseTest;
import br.ce.joaobarp.core.DriverFactory;
import br.ce.joaobarp.pages.MenuPage;
import br.ce.joaobarp.pages.ResumoPage;

public class ResumoTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();	
	private ResumoPage resumo = new ResumoPage();
	
	@Test
	public void excluirMovimentacao() {
		menu.acessarResumoMensal();
		resumo.clicarApagarMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resumo.getMensagemSucesso());
	}
	
	@Test // poderia ser (expected = NoSuchElementException.class) mas pode gerar falso positivo em alguns casos
	public void resumoMensal() {
		menu.acessarResumoMensal();
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
		
		resumo.selecionarAno("2016");
		resumo.buscar();
		
		List<WebElement> elementosEncontrados = 
		DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));

		Assert.assertEquals(0, elementosEncontrados.size());
	}
}
