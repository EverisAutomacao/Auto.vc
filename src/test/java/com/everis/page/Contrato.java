package com.everis.page;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.ContratoElements;
import com.everis.utils.DriverFactory;

public class Contrato extends DslMobile {

	String message = "";
	ContratoElements contratoElements = new ContratoElements(DriverFactory.getMobileDriver());
	
	
	public String validarDeclaracaoDePrivacidade() {
		message = "";
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(contratoElements.telaContratoDeLicenca));
			screenShot();
			scrollElementIsPresent(contratoElements.linkDeclaracao, 75, 1);
			screenShot();
			tap(contratoElements.linkDeclaracao);
			Thread.sleep(1000);
			tap(contratoElements.donwloadNovamentePdf);
			Thread.sleep(4000);
		} catch (Exception e) {
			message = "Falha ao ver declaração de privacidade";
			System.err.println(e.getMessage());
		} finally {
			screenShot();
		}
		return message;
	}
	
	public String lerContratoDeLicenca() {
		message = "";
		try {
			screenShot();
			scrollElementIsPresent(contratoElements.linkDeclaracao, 75, 1);
			Thread.sleep(1000);
			tap(contratoElements.btnConcordo);
			wait.until(ExpectedConditions.visibilityOfAllElements(contratoElements.telaDeclaracaoDePrivacidade));
		} catch (Exception e) {
			message = "Falha ao ler contrato";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	
	
//	public String verEmailAutoVc() {
//// txtMinhaPrivacidadeMail
//		try {
//			scrollElementIsPresent(contratoElements.txtMinhaPrivacidadeMail, 50, 10);
//			tapByCoordinatesPlus(contratoElements.txtMinhaPrivacidadeMail, 500, 90);
//			Thread.sleep(4000);
//			wait.until(ExpectedConditions.visibilityOfAllElements(contratoElements.appGmail));
//		} catch (Exception e) {
//			message = "Falha ao validar email privacidade@allianz.com.br";
//			e.printStackTrace();
//		} finally {
//			screenShot();
//		}
//		return message;
//	}
	
	public String clicarEmailAutovc() {
		try {
			scrollElementIsPresent(contratoElements.txtMinhaPrivacidadeMail, 75, 10);
			tapByCoordinatesPlus(contratoElements.txtMinhaPrivacidadeMail, 200, 1);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfAllElements(contratoElements.appGmail));
		} catch (Exception e) {
			message = "Falha ao validar email privacidade@allianz.com.br";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	
	
	public String verRegulamento() {
		try {
			scrollElementIsPresent(contratoElements.txtLinkRegulamento, 50, 10);
			Thread.sleep(1000);
			screenShot();
			tapByCoordinatesPlus(contratoElements.txtLinkRegulamento, 500, 90);
			tap(contratoElements.donwloadNovamentePdf);
			//wait.until(ExpectedConditions.visibilityOfAllElements(contratoElements.pdfRegulamento));
			Thread.sleep(3000);
		} catch (Exception e) {
			message = "Falha ao ver regulamento";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	public void lerDeclaracaoDePrivacidade() {
		message = "";
		try {
			scrollElementIsPresent(contratoElements.ultimaAtualicazao, 75, 1);
			message = "Declaração de privacidade lida com sucesso!";
		} catch (Exception e) {
			message = "Falha ao ler declaração de privacidade";
			e.printStackTrace();
		} finally {
			screenShot();
		}
	}
	

	
	
	
}