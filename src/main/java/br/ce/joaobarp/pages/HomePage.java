package br.ce.joaobarp.pages;

import br.ce.joaobarp.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldo (String string) {
		return obterCelula("Conta", string, "Saldo", "tabelaSaldo").getText();
	}
	
}
