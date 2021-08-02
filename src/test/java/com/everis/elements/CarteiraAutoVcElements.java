package com.everis.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CarteiraAutoVcElements {

	public CarteiraAutoVcElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")
	//@AndroidFindBy(xpath = "//android.widget.TextView[@text='Desconto Conquistado']")

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, 'DESCONTO ESTIMADO')])[32]")
	public WebElement btnDescontos;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gerar cupom de desconto']")
	@iOSXCUITFindBy(xpath = "??????")
	public WebElement btnGerarCupomDesconto;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Agenda do Carro']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='openPresent'])[2]")
	public WebElement btnBrindeCarro;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Acessar o Site']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='couponURL'])[2]")
	public WebElement btnAcessarSite;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Detalhes do Cupom']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Código do Cupom']")
	public WebElement codigoCupom;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Check Up do Carro']")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='openPresent'])[4]")
	public WebElement btnBrindeAutomotivo;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView[2]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='openPresent'])[5]")
	public WebElement btnBrindeSmiles;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cupom gerado com sucesso!']")
	@iOSXCUITFindBy(xpath = "??????")
	public WebElement txtCupomGerado;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Em Progresso']")
	@iOSXCUITFindBy(xpath = "??????")
	public WebElement brindeEmProgresso;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Desconto para Iniciantes 3 % Pendente']")
	@iOSXCUITFindBy(xpath = "??????")
	public WebElement semBrindeIniciante;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Completo']")
	@iOSXCUITFindBy(xpath = "??????")
	public WebElement brindeCompleto;
	
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView


	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='shareGift']")
	public WebElement btnEnviarCorretor;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gmail']")
	public WebElement btnGmail;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.google.android.gm:id/action_bar_root']")
	public WebElement telaEmail;
	
	public By btnCupom(String nomeDoCupom) {
		return  By.xpath("//*[@content-desc='openPresent']/android.widget.TextView[@text='" + nomeDoCupom + "']");
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Validade']/../android.widget.TextView[4]")
	public WebElement txtDataDeValidade;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Valor do Desconto']/../android.widget.TextView[5]")
	public WebElement txtValorDoDesconto;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Código do Cupom Auto.Vc']/../*/android.widget.TextView")
	public WebElement txtCodigoCupom;
	
	public By btnLogin = By.id("xpath");
	
	
}