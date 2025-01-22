package br.ce.joaobarp.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.joaobarp.core.BaseTest;
import br.ce.joaobarp.pages.ContasPage;
import br.ce.joaobarp.pages.MenuPage;
import br.ce.joaobarp.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {

	MenuPage menu = new MenuPage();
	MovimentacaoPage movi = new MovimentacaoPage();
	ContasPage contas = new ContasPage();	

	
	@Test
	public void criarMovimentacao() {
		menu.acessarMovimentacao();
		movi.setTipoMovimentacao("REC"); // REC ou DESP
		movi.setDataMovimentacao("14/01/2025");
		movi.setDataPagamento("14/01/2025");
		movi.setDescricao("Descrição teste");
		movi.setInteressado("João");
		movi.setValor(100);
		movi.setConta("Conta para movimentacoes");
		movi.setSituacao("status_pago");
		movi.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movi.getMensagemSucesso());
	}
	
	@Test
	public void movimentacaoRegrasDataMovimentacao() {
		menu.acessarMovimentacao();
		movi.setDataPagamento("14/01/2025");
		movi.setDescricao("Descrição teste");
		movi.setInteressado("João");
		movi.setValor(100);
		movi.salvar();
		
		Assert.assertEquals("Data da Movimentação é obrigatório", movi.getMensagemFracasso());
	}
	
	@Test
	public void movimentacaoRegrasDataPagamento() {
		menu.acessarMovimentacao();
		movi.setDataMovimentacao("14/01/2025");
		movi.setDescricao("Descrição teste");
		movi.setInteressado("João");
		movi.setValor(100);
		movi.salvar();
		
		Assert.assertEquals("Data do pagamento é obrigatório", movi.getMensagemFracasso());
	}
	
	@Test
	public void movimentacaoRegrasDescricao() {
		menu.acessarMovimentacao();
		movi.setDataMovimentacao("14/01/2025");
		movi.setDataPagamento("14/01/2025");
		movi.setInteressado("João");
		movi.setValor(100);
		movi.salvar();
		
		Assert.assertEquals("Descrição é obrigatório", movi.getMensagemFracasso());
	}
	
	@Test
	public void movimentacaoRegrasInteressado() {
		menu.acessarMovimentacao();
		movi.setDataMovimentacao("14/01/2025");
		movi.setDataPagamento("14/01/2025");
		movi.setDescricao("Descrição teste");
		movi.setValor(100);
		movi.salvar();
		
		Assert.assertEquals("Interessado é obrigatório", movi.getMensagemFracasso());
	}
	
	@Test
	public void movimentacaoRegrasValor() {
		menu.acessarMovimentacao();
		movi.setDataMovimentacao("14/01/2025");
		movi.setDataPagamento("14/01/2025");
		movi.setDescricao("Descrição teste");
		movi.setInteressado("João");
		movi.salvar();
		Assert.assertEquals("Valor é obrigatório\nValor deve ser um número", movi.getMensagemFracasso());
	}
	
	@Test
	public void movimentacaoRegrasFutura() {
		menu.acessarMovimentacao();
		movi.setDataMovimentacao("25/01/2030");
		movi.setDataPagamento("14/01/2025");
		movi.setDescricao("Descrição teste");
		movi.setInteressado("João");
		movi.setValor(100);
		movi.setConta("Conta para movimentacoes");
		movi.salvar();
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movi.getMensagemFracasso());
	}
}