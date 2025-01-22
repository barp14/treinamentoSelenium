package br.ce.joaobarp.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = true;
	
	public static Browsers browser = Browsers.CHROME; // Chrome por padrão para meus testes
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}
	
}
