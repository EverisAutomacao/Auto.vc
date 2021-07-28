package com.everis.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TermosElements {
	
	public TermosElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='agreeButton']")
	//@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='agreeButton'])[1]")
	public WebElement btnConcordo;
	


	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Declaracao_de_Privacidade_Allianz_Auto.Vc.pdf')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@text,'privacidade.pdf')]")
	public WebElement linkDeclaracao;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Última atualização')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Última atualização')]")
	public WebElement ultimaAtualicazao;

	
}