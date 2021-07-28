package com.everis.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CommonElements {

	public CommonElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='btnToggleMenu']/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='SulAmérica Auto.Vc'])[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
	private WebElement btnMenu;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Minhas Definições']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Minhas Definições'])[1]")
	private WebElement menuMinhasDefinicoes;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Editar Perfil']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Editar Perfil']")
	private WebElement subMenuEditarPerfil;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Editar Configurações']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Editar Configurações']")
	private WebElement subMenuEditarConfiguracoes;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Dúvidas']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Dúvidas'])[1]")
	private WebElement menuDuvidas;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='FAQ (Perguntas Frequentes)']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='FAQ (Perguntas Frequentes)']")
	private WebElement subMenuFAQ;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Política de Uso de Dados']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Política de Uso de Dados'])[1]")
	private WebElement menuPoliticaDeUso;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Contrato de Usuário Final']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Contrato de Usuário Final']")
	private WebElement subContratoDeUsuarioFinal;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Como Funciona']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Como Funciona'])[1]")
	private WebElement menuComoFunciona;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Vídeo Auto.Vc']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Vídeo Auto.Vc']")
	private WebElement subVideoAutoVc;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Tour Inicial']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Tour Inicial']")
	private WebElement subTourInicial;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Desconto de amigos']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Desconto de amigos'])[1]")
	private WebElement menuDescontoDeAmigos;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Declaração de Privacidade']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Declaração de Privacidade']")
	private WebElement subDeclaracaoDePrivacidade;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Dirija')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Confirme se você foi o motorista')]")
	private WebElement telaTourInicial;
	
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView

	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Falar com a SulAmérica']/..")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Falar com a SulAmérica'])[3]")
	private WebElement btnFalarComSAS;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clique aqui e envie uma mensagem para o nosso SAC.']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Clique aqui e envie uma mensagem para o nosso SAC.']")
	private WebElement btnEnviarMensagem;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='subjectText']")
	// @iOSXCUITFindBy(xpath = "")
	private WebElement inputAssunto;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='bodyTextArea']")
	// @iOSXCUITFindBy(xpath = "")
	private WebElement inputMensagem;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enviar']/..")
	// @iOSXCUITFindBy(xpath = "")
	private WebElement btnEnviarManifestacao;

	@AndroidFindBy(xpath = "//*[@content-desc='scoreGauge']//android.widget.TextView")
	// @iOSXCUITFindBy(xpath = "")
	private WebElement pontosXPath;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='BRINDES']/../android.widget.TextView[4]")
	// @iOSXCUITFindBy(xpath = "")
	private WebElement descontoXPath;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Minimo 20 viagens']/../android.widget.TextView[2]")
	// @iOSXCUITFindBy(xpath = "")
	private WebElement numeroDeViagensXPath;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Minimo 60 dias']/../android.widget.TextView[2]")
	// @iOSXCUITFindBy(xpath = "")
	private WebElement diasXPath;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Minimo 300 Kms']/../android.widget.TextView[2]")
	// @iOSXCUITFindBy(xpath = "")
	private WebElement kmXPath;

	// @AndroidFindBy(xpath = "")
	// @iOSXCUITFindBy(xpath = "")
	private WebElement msgManifestacao;


	

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Próximo'])[last()]")
	@iOSXCUITFindBy(xpath = "?????")
	private WebElement btnTourInicialProximo;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Entrar']")
	@iOSXCUITFindBy(xpath = "?????")
	private WebElement btnTourInicialEntrar;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "?????")
	private WebElement btnTourInicialPular;
	

	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView
//1129c830-6db1-4398-b9ec-2465e9c51161
	//uma barra acima, botão pular
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='aboutThisAppDetails']")
	@iOSXCUITFindBy(xpath = "?????")
	private WebElement txtVersaoApp;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='emailOnboard']")
	@iOSXCUITFindBy(xpath = "?????")
	private WebElement telaPrincipal;
	
//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='btnToggleMenu']/android.view.ViewGroup\n" + 
			"")
	@iOSXCUITFindBy(xpath = "?????")
	public WebElement getBtnMenu;
	


	public WebElement getMenuMinhasDefinicoes() {
		return menuMinhasDefinicoes;
	}

	public WebElement getSubMenuEditarPerfil() {
		return subMenuEditarPerfil;
	}
	
	public WebElement getSubMenuEditarConfiguracoes() {
		return subMenuEditarConfiguracoes;
	}

	public WebElement getMenuDuvidas() {
		return menuDuvidas;
	}

	public WebElement getSubMenuFAQ() {
		return subMenuFAQ;
	}

	public WebElement getMenuPoliticaDeUso() {
		return menuPoliticaDeUso;
	}

	public WebElement getSubContratoDeUsuarioFinal() {
		return subContratoDeUsuarioFinal;
	}

	public WebElement getMenuComoFunciona() {
		return menuComoFunciona;
	}

	public WebElement getSubVideoAutoVc() {
		return subVideoAutoVc;
	}

	public WebElement getSubTourInicial() {
		return subTourInicial;
	}

	public WebElement getMenuDescontoDeAmigos() {
		return menuDescontoDeAmigos;
	}

	public WebElement getSubDeclaracaoDePrivacidade() {
		return subDeclaracaoDePrivacidade;
	}

	public WebElement getTelaTourInicial() {
		return telaTourInicial;
	}

	public WebElement getBtnFalarComSAS() {
		return btnFalarComSAS;
	}

	public WebElement getBtnEnviarMensagem() {
		return btnEnviarMensagem;
	}

	public WebElement getInputAssunto() {
		return inputAssunto;
	}

	public WebElement getInputMensagem() {
		return inputMensagem;
	}

	public WebElement getBtnEnviarManifestacao() {
		return btnEnviarManifestacao;
	}

	public WebElement getPontosXPath() {
		return pontosXPath;
	}

	public WebElement getDescontoXPath() {
		return descontoXPath;
	}

	public WebElement getNumeroDeViagensXPath() {
		return numeroDeViagensXPath;
	}

	public WebElement getDiasXPath() {
		return diasXPath;
	}

	public WebElement getKmXPath() {
		return kmXPath;
	}

	public WebElement getMsgManifestacao() {
		return msgManifestacao;
	}

	public WebElement getBtnTourInicialProximo() {
		return btnTourInicialProximo;
	}

	public WebElement getBtnTourInicialEntrar() {
		return btnTourInicialEntrar;
	}
	public WebElement getBtnTourInicialPular() {
		return btnTourInicialPular;
	}
	public WebElement getTxtVersaoApp() {
		return txtVersaoApp;
	}
	public WebElement getTelaPrincipal() {
		return telaPrincipal;
	}
	

}