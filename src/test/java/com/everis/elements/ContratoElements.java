package com.everis.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ContratoElements {

	public ContratoElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Declaracao_de_Privacidade_Allianz_Auto.Vc.pdf')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@text,'privacidade.pdf')]")
	public WebElement linkDeclaracao;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTRATO DE LICENÇA DE USUÁRIO FINAL DE PRODUTO LICENCIADO']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CONTRATO DE LICENÇA DE USUÁRIO FINAL DE PRODUTO LICENCIADO']")
	public WebElement telaContratoDeLicenca;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'telematics.lexisnexis.com')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'telematics.lexisnexis.com')]")
	public WebElement pgPoliticas;
	
	@AndroidFindBy(xpath = "//*[@content-desc='agreeButton']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='agreeButton'])[2]")
	public WebElement btnConcordo;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='contentHtml']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Declaração de Privacidade']")
	public WebElement telaDeclaracaoDePrivacidade;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Programa_Allianz_Auto.Vc_Regulamento.pdf')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'regulamento_auto_vc.pdf')]")
	public WebElement txtLinkRegulamento;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'privacidade@allianz.com.br')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'regulamento_auto_vc.pdf')]")
	public WebElement txtMinhaPrivacidadeMail;
	
	//@AndroidFindBy(xpath = "//android.widget.TextView[@text='privacidade@allianz.com.br']")
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='contentHtml']/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[6]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='auto.vc@sulamericaauto.com.br']")
	public WebElement emailMinhaPrivacidade;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Última atualização')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Última atualização')]")
	public WebElement ultimaAtualicazao;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Última atualização')]")
	public WebElement donwloadNovamentePdf;
	//busca por ID
	
	//   com.android.chrome:id/infobar_message       //id abrir Declaração de prividade no crhome, botão do cel
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View")
	@iOSXCUITFindBy(xpath = "???")
	public WebElement pdfContrato;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout")
	@iOSXCUITFindBy(xpath = "???")
	public WebElement pdfRegulamento;
	

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.google.android.gm:id/subject_content']")
	@iOSXCUITFindBy(xpath = "//*[contains(@name, 'Gmail')]")
	public WebElement appGmail;
	

	
}