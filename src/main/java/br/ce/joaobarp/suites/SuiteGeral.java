package br.ce.joaobarp.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.joaobarp.core.DriverFactory;
import br.ce.joaobarp.pages.LoginPage;
import br.ce.joaobarp.tests.ContaTest;
import br.ce.joaobarp.tests.MovimentacaoTest;
import br.ce.joaobarp.tests.RemoverMovimentacaoTest;
import br.ce.joaobarp.tests.ResumoTest;
import br.ce.joaobarp.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoTest.class,
	SaldoTest.class,
	ResumoTest.class
	
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		page.setEmail("joaobarpy@gmail.com");
		page.setSenha("senha000999");
		page.entrar();
		page.reset();
		DriverFactory.killDriver();
	}
}
