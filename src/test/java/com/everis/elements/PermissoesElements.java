package com.everis.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PermissoesElements {
	
	public PermissoesElements(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Minhas Permissões']")
	public WebElement telaInicioPermissoesLocalização;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement btnPermitirApp;

	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement btnPermitirApp2;
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup


	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement btnPermitirAndroid;


	//  XPATH /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]
	//   ID     com.android.permissioncontroller:id/permission_allow_foreground_only_button
	//
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='comp.screen']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement btnOkVamosEmFrente;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement btnConfigGravarViagens;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement permissoesAndroid;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.RelativeLayout")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement permissaoLocalizaçãoAndroid;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RadioGroup/android.widget.RadioButton[1]")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement permitirOTempoTodoAndroid;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Voltar']")
	//@iOSXCUITFindBy(xpath = "")
	public WebElement voltarAndroid;
	
	
	//permissoesAndroid
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.RelativeLayout
	
	//permissaoLocalização
	//hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.RelativeLayout
	
	//permitirOTempoTodo
	//hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RadioGroup/android.widget.RadioButton[1]
	
	//voltarAndroid (2 voltar)
	///android.widget.ImageButton[@content-desc="Voltar"]
    //ID Voltar
	//click permitir app
	//click permitir android
	//screenshot
	//permitir app
	//permitir android
	// tela inicial


	


	
	
	
	
	
	
	
	
		

	
	
	//codigo app anterior abaixo
		
//	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name='Localização')]")
//	public WebElement switchLocalizacao;
	
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup
	//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView

	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Otimização de Bateria']/..//android.widget.Switch[@checked]")
//	public WebElement switchOtimizacaoBateria;
//	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Armazenamento']/..//android.widget.Switch[@checked]")
//	//@iOSXCUITFindBy(xpath = "")
//	public WebElement switchArmazenamento;
//
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Celular']/..//android.widget.Switch[@checked]")
//	//@iOSXCUITFindBy(xpath = "")
//	public WebElement switchCelular;


	
	//android.view.ViewGroup[@content-desc='comp.screen']/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView
	//tela inicial	
	//android.widget.ScrollView[@content-desc="comp.screen.scrollView"]/android.view.ViewGroup
	
	//menu
	//android.view.ViewGroup[@content-desc="btnOpenDrawer"]/android.view.ViewGroup

	


	
	
}