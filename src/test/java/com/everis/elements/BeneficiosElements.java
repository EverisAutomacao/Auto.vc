package com.everis.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BeneficiosElements {
	
	public BeneficiosElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Saldo disponível']/..//android.widget.TextView[2]")
	@iOSXCUITFindBy(xpath = "???")
	public WebElement txtSaldoDisponivel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gerar cupom']")
	@iOSXCUITFindBy(xpath = "???")
	public WebElement btnGerarCupom;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Agenda do Carro']/../../android.view.ViewGroup[2]")
	@iOSXCUITFindBy(xpath = "???")
	public WebElement btnVerCupomAgendaCarro;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Check Up do Carro']/../../android.view.ViewGroup[2]")
	@iOSXCUITFindBy(xpath = "???")
	public WebElement btnVerCupomCheckUpCarro;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Smiles']/../../android.view.ViewGroup[2]")
	@iOSXCUITFindBy(xpath = "???")
	public WebElement btnVerCupomSmiles;

}
