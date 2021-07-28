package com.everis.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.everis.excel.Dados;
import com.everis.runners.Automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static URL url;
	private static AndroidDriver<MobileElement> androidDriver;
	private static IOSDriver<MobileElement> iosDriver;
	private static WebDriver webDriver;
	private static DesiredCapabilities desiredCapabilities;

	private static String permissoes;
	private static String resetarApp;
	
public String message = "Saurabh";
	
	
	public static AppiumDriver<?> getMobileDriver() {
		String platform = Dados.mapTestCase.get("Plataforma");

		if (platform.equals("iOS")) {
			return iosDriver;
		} else {
			return androidDriver;
		}
	}

	public static void createDriveMobile(String platform) {

		try {
			if (platform.equals("Android")) {
				resetarApp = Dados.mapTestCase.get("Resetar App?");
				permissoes = Dados.mapTestCase.get("Permissões?");
				androidDriver();
			} else {
				iosDriver();
			}
		} catch (Exception e) {
			Automation.resultadoRecebido = "Falha ao instanciar driver\n" 
			 		+ "Verifique se o servidor do Appium foi iniciado corretamente.";
		}
	}
	
	
		
	public static WebDriver getWebDriver() {
		return webDriver;
	}

	/**
	 * inicia o navegador
	 * 
	 * @param clearData = Limpar dados da aplicação antes de iniciar
	 */
	public static void createWebDriver() {

		System.setProperty("webdriver.chrome.driver", Global.chromedriverFolder);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");// tela maximizada
		options.addArguments("--disable-notifications");// desativar notificacoes do navegador
		options.addArguments("--incognito");// navegar em janela anonima
		webDriver = new ChromeDriver(options);
	}

	/**
	 * Instancia o driver do Android e inicia a aplicação
	 * 
	 * @param clearData = Limpar dados da aplicação antes de iniciar
	 * @throws MalformedURLException 
	 */
	private static void androidDriver() throws MalformedURLException {

		if (androidDriver == null) {
			desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", "emulator-2019");
			desiredCapabilities.setCapability("automationName", "uiautomator2");

			desiredCapabilities.setCapability("appPackage", "br.com.allianz.mobile.autovc");
			//desiredCapabilities.setCapability("appPackage", "br.com.sulamerica.autovc");
			desiredCapabilities.setCapability("appActivity",
					"com.lexisnexis.risk.mobile.telematics.driver.MainActivity");

			if (resetarApp.equalsIgnoreCase("Não")) {
				desiredCapabilities.setCapability("noReset", "true");
				desiredCapabilities.setCapability("fullReset", "false");
			}
			if (permissoes.equalsIgnoreCase("Sim")) {
				desiredCapabilities.setCapability("autoGrantPermissions", "true");
			}

				url = new URL("http://127.0.0.1:4723/wd/hub");
				androidDriver = new AndroidDriver<MobileElement>(url, desiredCapabilities);

		}
	}

	/**
	 * Instancia o driver do IOs e inicia a aplicação
	 */
	private static void iosDriver() {

		desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.2");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

		desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "spykerug@gmail.com");
		desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "iPhone Developer");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "120c060ea9872c78e137b9f52b8ee9ac1919a0eb");
		desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,
				"br.com.lexisnexis.risk.mobile.sulamerica.driver");
		// desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,
		// "safari");
		desiredCapabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
		desiredCapabilities.setCapability("useNewWDA", true);

		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			iosDriver = new IOSDriver<MobileElement>(url, desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finaliza a instancia do driver e finaliza a aplicação
	 */
	public static void killMobileDriver() {
		System.out.println("Finalizando Aplicação!");

		if (getMobileDriver() != null) {
			getMobileDriver().quit();
			androidDriver = null;
			iosDriver = null;
		}
	}

	/**
	 * Finaliza o navegador
	 */
	public static void killWebDriver() {
		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}

	public static void changeContext() {
		try {
			Set<String> contextHandles = getMobileDriver().getContextHandles();
			for (String value : contextHandles) {
				System.out.println("Context: " + value);
			}
			try {
				getMobileDriver().context((String) contextHandles.toArray()[1]);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}