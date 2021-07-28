package com.everis.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PerfilElements {
	
	public PerfilElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='nameText']/../../../*[1]//android.widget.ImageView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Nome*']/../../../XCUIElementTypeOther")
	public WebElement btnAvatar;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Salvar Alterações']/..")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Salvar Alterações'])[2]")
	public WebElement btnSalvar;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Informações atualizadas com sucesso!']")
	public WebElement sucessoMsgXpath;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='nameText']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='nameText']")
	public WebElement edtNome;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='emailText']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='emailText']")
	public WebElement edtEmail;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='leaderboardAliasText']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='leaderboardAliasText']")
	public WebElement edtApelido;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='mobilePhoneText']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='mobilePhoneText']")
	public WebElement edtTelefone;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='passwordText']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='passwordText']")
	public WebElement edtSenha;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='confirmPasswordText']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='confirmPasswordText']")
	public WebElement edtConfirmarSenha;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='btnToggleMenu']/android.view.ViewGroup\n" +
	
			"")
	@iOSXCUITFindBy(xpath = "?????")
	public WebElement getBtnMenu;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Minhas Definições']")
	@iOSXCUITFindBy(xpath = "?????")
	public WebElement menuMinhasDefinicoes;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Editar Perfil']")
	@iOSXCUITFindBy(xpath = "?????")
	public WebElement subMenuEditarPerfil;;
	
	

	
	public By imgAvatar(String numeroAvatar) {
		return By.xpath("(//android.widget.TextView[@text='Meu Avatar']/../android.widget.ScrollView//android.widget.ImageView)"
				+ "["+numeroAvatar+"]");
		
		
		
		
		
	}




	public By edtApelid1o() {
		return (By) edtApelido;
	}


}