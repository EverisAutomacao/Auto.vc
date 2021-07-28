package com.everis.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MinhasViagensElements {
	
	public MinhasViagensElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Viagens'])[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Minhas Viagens']")
	private WebElement abaViagens;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Minhas Viagens']")
	private WebElement telaViagens;
	
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup

	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='chipOne']")
	@iOSXCUITFindBy(xpath = "???")
	private WebElement tgMotorista;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='chipTwo']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Passageiro ou Ignorada']")
	private WebElement tgPassageiro;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='chipThree']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Passageiro ou Ignorada']")
	private WebElement tgIgnorado;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Histórico de Viagens']/../android.widget.ScrollView//android.widget.TextView[@text='Motorista']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='confirmedJourneysHeader']/../../XCUIElementTypeOther[contains(@name, 'Motorista')])[2]")
	private WebElement viagensMotorista;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Histórico de Viagens']/../android.widget.ScrollView//android.widget.TextView[@text='Ignorada']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='confirmedJourneysHeader']/../../XCUIElementTypeOther[contains(@name, 'Passageiro')])[2]")
	private WebElement viagensIgnorada;
	
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Selecionar Todos')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Fui motorista']")
	public WebElement checkViagem;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Selecionar')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'regulamento_auto_vc.pdf')]")
	public WebElement clickCheckbox;
	
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup
	

	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Fui motorista']")
	private WebElement btnFuiMotorista;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Minhas Viagens']")
	private WebElement btnFuiPassageiro;
	

	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='touchHideKeyboard']/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Minhas Viagens']")
	private WebElement btnConfirmar;
	
	
	////android.view.ViewGroup[@content-desc="touchHideKeyboard"]/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView

	
	//android.view.ViewGroup[@content-desc='touchHideKeyboard']/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Ínicio -')]")
	@iOSXCUITFindBy(xpath = "???")
	private WebElement txtInicio;
	
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Chegada -')]")
	//@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[7]")
	@iOSXCUITFindBy(xpath = "???")
	private WebElement txtChegada;
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[7]

	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Tempo de viagem']/../android.widget.TextView[3]")
	@iOSXCUITFindBy(xpath = "???")
	private WebElement txtTempo;

	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Detalhes'])[1]")
	@iOSXCUITFindBy(xpath = "???")
	private WebElement txtDetalhesUltimaViagem;
	
	public WebElement getAbaViagens() {
		return abaViagens;
	}
	public WebElement getTelaViagens() {
		return telaViagens;
	}

	public WebElement getTgMotorista() {
		return tgMotorista;
	}

	public WebElement getTgPassageiro() {
		return tgPassageiro;
	}
	public WebElement getTgIgnorado() {
		return tgIgnorado;
	}

	public WebElement getViagensMotorista() {
		return viagensMotorista;
	}

	public WebElement getViagensIgnorada() {
		return viagensIgnorada;
	}
	
	public WebElement getBtnFuiMotorista() {
		return btnFuiMotorista;
	}		
			public WebElement checkBtnViagem() {
		return checkViagem;
		
	}
		public WebElement btnConfirmarViagem() {
	return btnConfirmar;
		
	}
			
			
	public WebElement getBtnFuiPassageiro() {
		return btnFuiPassageiro;
	}
	public WebElement getTxtInicio() {
		return txtInicio;
	}
	public WebElement getTxtChegada() {
		return txtChegada;
	}
	public WebElement getTempoViagem() {
		return txtTempo;
	}
	public WebElement getTxtDetalhesUltimaViagem() {
		return txtDetalhesUltimaViagem;
	}
	
}