package com.everis.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RankingElements {
	
	public RankingElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Ranking']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ranking']")
	private WebElement abaRankingXPath;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Ranking') and contains(@text,'de Amigos')]/..")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, 'Ranking') and contains(@name, 'de Amigos')])[35]")
	private WebElement btnRankingDeAmigosXPath;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Ranking') and contains(@text,'Viagens')]/..")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, 'Ranking') and contains(@name, 'Viagens')])[39]")
	private WebElement btnRankingPorNumViagensXPath;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Ranking') and contains(@text,'por KM')]/..")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, 'Ranking') and contains(@name, 'por KM')])[35]")
	private WebElement btnRankingPorKmXPath;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Ranking') and contains(@text,'Geral')]/..")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, 'Ranking') and contains(@name, 'Geral')])[35]")
	private WebElement btnRankingGeralXPath;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='emailField']")
	@iOSXCUITFindBy(xpath = "???")
	private WebElement edtEmailAmigo;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Agora não']")
	@iOSXCUITFindBy(xpath = "???")
	private WebElement btnAgoraNao;

	public WebElement getAbaRankingXPath() {
		return abaRankingXPath;
	}

	public WebElement getBtnRankingDeAmigosXPath() {
		return btnRankingDeAmigosXPath;
	}

	public WebElement getBtnRankingPorNumViagensXPath() {
		return btnRankingPorNumViagensXPath;
	}

	public WebElement getBtnRankingPorKmXPath() {
		return btnRankingPorKmXPath;
	}

	public WebElement getBtnRankingGeralXPath() {
		return btnRankingGeralXPath;
	}
	public WebElement getEdtEmailAmigo() {
		return edtEmailAmigo;
	}
	public WebElement getBtnAgoraNao() {
		return btnAgoraNao;
	}
	
	
}