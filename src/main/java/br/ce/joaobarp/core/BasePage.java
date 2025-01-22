package br.ce.joaobarp.core;

import static br.ce.joaobarp.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	/**************** Text Field e Text Area ****************/

	public void apagar(String id_campo) {
		getDriver().findElement(By.id(id_campo)).clear();
	}
	
	public void escrever(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public void escreverInt(String id_campo, int valor) {
		getDriver().findElement(By.id(id_campo)).sendKeys(String.valueOf(valor));
	}
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public String obterTexto(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getText();
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	/**************** Radio, Link e Check ****************/
		
	public void clicarBotao(String id_campo) {
		getDriver().findElement(By.id(id_campo)).click();
	}
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarLink(String linkText_campo) {
		getDriver().findElement(By.linkText(linkText_campo)).click();
	}
	
	public boolean obterSelecao(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).isSelected();
	}
	
	/**************** Combo ****************/
	
	public void selecionarCombo(String id_campo, String valor) {
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void selecionarCombo(By by, String valor) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id_campo, String valor) {
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	
	public String obterValorCombo(String id_campo) {
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String id_campo) {
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		
		return valores;
	}
	
	public int obterQuantidadeCombo(String id_campo) {
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		
		return options.size();
	}
	
	public int obterSelecaoCombo(String id_campo) {
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		
		return options.size();
	}
	
	public int obterSelecionadosCombo(String id_campo) {
	    WebElement element = getDriver().findElement(By.id(id_campo));
	    Select combo = new Select(element);
	    List<WebElement> selectedOptions = combo.getAllSelectedOptions(); // Apenas opções selecionadas
	    return selectedOptions.size();
	}

	
	public boolean obterOpcaoCombo(String id_campo, String opcao) {
		WebElement element = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		
		for(WebElement option: options) {
			if(option.getText().equals(opcao)) {
				return true;
			}
		}
		return false;
	}
	
	public void selecionarComboPrime(String radical, String valor) {
		clicarBotao(By.xpath(".//*[@id='"+ radical +"_input']/../../div[2]//span"));
		clicarBotao(By.xpath(".//*[@id='"+ radical + "_panel']//li[.='"+ valor +"']")); // sempre deixar o mais generico possivel
	}
	
	
	/**************** Alerts ****************/
	
	public String alertaObterTexto() {
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoAceitar() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}
	
	public String alertaObterTextoRecusar() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}
	
	/**************** Javascript ****************/

	public Object executarJS (String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}
	
	/**************** Tabela ****************/		
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
	}
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}


}
