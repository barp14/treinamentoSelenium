package br.ce.joaobarp.tests;

import br.ce.joaobarp.core.BaseTest;
import br.ce.joaobarp.pages.HomePage;
import br.ce.joaobarp.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {

	MenuPage menu = new MenuPage();
	HomePage home = new HomePage();
	
	@Test
	public void verificarSaldo() {
		menu.acessarHome();
		Assert.assertEquals("534.00", home.obterSaldo("Conta para saldo"));
	}
	
}
