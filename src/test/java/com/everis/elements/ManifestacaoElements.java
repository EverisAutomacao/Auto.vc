package com.everis.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ManifestacaoElements {
	
	public ManifestacaoElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Falar com a Allianz']/..")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Falar com a SulAmérica Auto'])[3]")
	public WebElement btnFalarComSAS;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clique aqui e envie uma mensagem para o nosso SAC.']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Clique aqui e envie uma mensagem para o nosso SAC.']")
	public WebElement btnEnviarMensagem;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='subjectText']")
	public WebElement inputAssunto;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='bodyTextArea']")
	public WebElement inputMensagem;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enviar']/..")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement btnEnviarManifestacao;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sua mensagem foi enviada com sucesso.']")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement msg;

}