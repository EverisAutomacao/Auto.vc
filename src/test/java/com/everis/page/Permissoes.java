package com.everis.page;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.PermissoesElements;
import com.everis.utils.DriverFactory;

public class Permissoes extends DslMobile {

	String message = "";
	PermissoesElements elements = new PermissoesElements(DriverFactory.getMobileDriver());

	public String verificarPermissoes() {
		message = "";
		try {
			if (mapTestCase.get("Plataforma").equals("Android")) {
				waitLoading();
			}
			if (!isPresent(elements.telaInicioPermissoesLocalização)) {
				message = "Tela de permissões não foi apresentada!";
				System.out.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Tela de permissões não foi apresentada!";
		} finally {
			screenShot();
		}
		return message;
	}

//	public String fornecerPermissoes() {
//		message = "";
//
//		try {
//			wait.until(ExpectedConditions.visibilityOfAllElements(elements.telaInicioPermissoes));
//
//			boolean checkLocalizacao = Boolean
//					.valueOf(getAtrributeAnnotation(elements.switchLocalizacao, "checked"));
//			boolean checkArmazenamento = Boolean
//					.valueOf(getAtrributeAnnotation(elements.switchArmazenamento, "checked"));
//			boolean checkCelular = Boolean.valueOf(getAtrributeAnnotation(elements.switchCelular, "checked"));
//
//			screenShot();
//
//			if (!checkLocalizacao) {
//				tap(elements.switchLocalizacao);
//				Thread.sleep(1000);
//				screenShot();
//				tap(elements.btnPermitir);
//			} else {
//				System.out.println("Localização (Permitida)");
//			}
//			if (!checkArmazenamento) {
//				tap(elements.switchArmazenamento);
//				Thread.sleep(1000);
//				screenShot();
//				tap(elements.btnPermitir);
//			} else {
//				System.out.println("Amazenamento (Permitido)");
//			}
//			if (!checkCelular) {
//				tap(elements.switchCelular);
//				Thread.sleep(1000);
//				screenShot();
//				tap(elements.btnPermitir);
//			} else {
//				System.out.println("Dados do Celular (Permitido)");
//			}
//			Thread.sleep(500);
//			tap(elements.btnOkVamosEmFrente);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			message = "Falha ao ativar permissoes";
//		}
//		return message;
//	}
	
	
	public String fornecerPermissoesIndividual() {
		message = "";

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements.telaInicioPermissoesLocalização));
			tap(elements.btnPermitirApp);
			Thread.sleep(500);
			tap(elements.btnPermitirAndroid);
			Thread.sleep(500);
			screenShot();
			tap(elements.btnPermitirAndroid);
			Thread.sleep(1000);
			tap(elements.btnConfigGravarViagens);			
			screenShot();
			tap(elements.permissoesAndroid);
			Thread.sleep(500);
			tap(elements.permissaoLocalizaçãoAndroid);
			Thread.sleep(500);
			tap(elements.permitirOTempoTodoAndroid);
			Thread.sleep(500);
			tap(elements.voltarAndroid);
			Thread.sleep(500);
			tap(elements.voltarAndroid);
			Thread.sleep(1000);
			screenShot();
			tap(elements.btnPermitirApp);
			Thread.sleep(500);
			tap(elements.btnPermitirAndroid);
			Thread.sleep(1000);
			screenShot();
			tap(elements.btnPermitirApp2);
			Thread.sleep(500);
			tap(elements.btnPermitirAndroid);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Falha ao ativar permissoes";
		}
		return message;
	}
}