package com.everis.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class UsuarioElements {

	public UsuarioElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='goToSignInButton']/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc='goToSignInButton']/android.widget.TextView")
	public WebElement btnEntrar;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView")
	//@iOSXCUITFindBy(xpath = "//android.view.ViewGroup[@content-desc='goToSignInButton']/android.widget.TextView")
	public WebElement btnEntreAqui;
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cadastrar']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='goToSignInButton']")
	public WebElement btnCadastrar;
	
//	/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView



	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='btnGoogle']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='googleOnboard']")
	public WebElement btnGoogle;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='btnFacebook']/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='facebookOnboard']")
	public WebElement btnFacebook;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='com.google.android.gms:id/account_display_name'])[1]")
	@iOSXCUITFindBy(xpath = "??????????????")
	public WebElement primeiraContaGmailLogada;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='emailText']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='emailText']")
	public WebElement edtEmail;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"externalReferenceIdText\"]")
	@iOSXCUITFindBy(xpath = "?????????")
	public WebElement edtCPFRecuperacao;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='passwordText']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='passwordText']")
	public WebElement edtSenha;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='confirmPasswordText']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='confirmPasswordText']")
	public WebElement edtConfirmarSenha;
	

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='bntForm']/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Entrar']")
	public WebElement btnEntrar2;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Email e/ou senha incorreta(s)']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Email e/ou senha incorreta(s)')]")
	public WebElement errorMsg;

	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Email e/ou senha incorreta(s)')]")
	public WebElement otmBateria;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Email e/ou senha incorreta(s)')]")
	public WebElement permitirAndroidbat;
	
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Meu Painel']")
	public WebElement telaInicial;
	
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup


	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='comp.screen']/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Meu Painel']")
	public WebElement telaPermissoes;
	

	@AndroidFindBy(xpath = "//input[1]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='principal']/XCUIElementTypeTextField")
	public WebElement inputFbEmailWebView;

	@AndroidFindBy(xpath = "//input[2]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='principal']/XCUIElementTypeSecureTextField")
	public WebElement inputFbSenhaWebView;

	@AndroidFindBy(xpath = "//*[text()='Entrar']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Entrar']")
	public WebElement btnFbEntrarWebView;

	@iOSXCUITFindBy(xpath = "(//*[contains(@name, 'Cancelar')])[2]")
	public WebElement btnCancelarFacebook;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@name='Entrar com telefone ou email']")
	public WebElement btnLogarFacebook;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Esqueci minha senha']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Entrar']")
	public WebElement btnEsqueciMinhaSenha;

	//android.view.ViewGroup[@content-desc='bntFormAbsolute']
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirmar']/..")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement btnRecuperarSenha;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Seu código de acesso foi enviado.')]")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement txtEmailRecuperacaoEnviado;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='nameText']")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement edtNome;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='externalReferenceIdText']")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement edtCpf;

	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='mobilePhoneText']")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement edtTelefone;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sou maior de 18 anos']")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement chkMaiorIdade;
	
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='bntForm']")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement btnConcluir;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Email existente.']")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement msgEmailExistente;
	
	//mensagem esperada não encontrada, possível problema na quebra de linha
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CPF informado já está registrado no sistema.']")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement msgCPFJaRegistrado;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sobrenome é obrigatório.']")
	@iOSXCUITFindBy(xpath = "?????????????")
	public WebElement msgSobrenomeObrigatorio;


	
}