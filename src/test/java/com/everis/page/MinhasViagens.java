package com.everis.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.ContratoElements;
import com.everis.elements.MinhasViagensElements;
import com.everis.utils.DriverFactory;

public class MinhasViagens extends DslMobile {

	String message = "";
	MinhasViagensElements viagemElements = new MinhasViagensElements(DriverFactory.getMobileDriver());
	//ContratoElements contratoElements = new ContratoElements(DriverFactory.getMobileDriver());
	String txtHistorico = "//android.widget.TextView[@text='Histórico de Viagens']";

	public String filtrarViagensComo(String filtro) {

		try {

			tap(viagemElements.getAbaViagens());
			wait.until(ExpectedConditions.visibilityOfAllElements(viagemElements.getTelaViagens()));
			screenShot();
			 
			switch (filtro) {
			case "Motorista":
				tap(viagemElements.getTgMotorista());
				screenShot();
				scrollElementIsPresent(viagemElements.getTgMotorista(), 90, 20);
				screenShot();
				break;
			case "Passageiro":
				tap(viagemElements.getTgPassageiro());
				 scrollElementIsPresent(viagemElements.getTgPassageiro(), 90, 20);
				screenShot();
				break;
			case "Ignorada":
				tap(viagemElements.getTgIgnorado());
				screenShot();
				break;
			default:
				message = "Filtro [" + filtro + "] não existe";
				break;
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			message = "Falha ao filtrar viagens";
//		} finally {
//			screenShot();
		}
		return message;
	}

	public String confirmarViagensComo(String tipo) {

		String cheboxViagem1 = "//android.widget.ScrollView[@content-desc='comp.screen.scrollView']"
				+ "/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup"
				+ "/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]"
				+ "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"
				+ "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup";

		try {

			tap(viagemElements.getAbaViagens());
			wait.until(ExpectedConditions.visibilityOfAllElements(viagemElements.getTelaViagens()));
			screenShot();
			tap(viagemElements.checkViagem);
			Thread.sleep(1000);
			screenShot();
			

			scrollElementIsPresent(viagemElements.getBtnFuiPassageiro(), 75, 1);
			Thread.sleep(1000);

			switch (tipo) {
			case "Motorista":
				tap(viagemElements.getBtnFuiMotorista());
				tap(viagemElements.btnConfirmarViagem());
				screenShot();
				break;

			case "Passageiro":
				tap(viagemElements.getBtnFuiPassageiro());
				tap(viagemElements.btnConfirmarViagem());
				screenShot();
				break;

			default:
				message = "[" + tipo + "] não existe";
				break;
			}

			// atualizando tela
			scroll(20, 90, 1);
			waitLoading();
			Thread.sleep(2000);
		} catch (Exception e) {
			message = "Falha ao confirmar viagens";
		} finally {
			screenShot();
		}
		return message;
	}

	public String validarViagensComo(String filtro) {
		message = "";

		try {

			switch (filtro) {
			case "Motorista":
				if (isPresent(viagemElements.getViagensIgnorada())) {
					message = "Foram exibidas viagens como [Passageiro ou ignorada] no filtro [Motorista]";
				}
				scroll(90, 10, 1);
				if (isPresent(viagemElements.getViagensIgnorada())) {
					message = "Foram exibidas viagens como [Passageiro ou ignorada] no filtro [Motorista]";
				}
				break;
			case "Passageiro":
				if (isPresent(viagemElements.getViagensMotorista())) {
					message = "Foram exibidas viagens como [Motorista] no filtro [Passageiro ou ignorada]";
				}
				scroll(90, 10, 1);
				if (isPresent(viagemElements.getViagensMotorista())) {
					message = "Foram exibidas viagens como [Motorista] no filtro [Passageiro ou ignorada]";
				}
				break;
			default:
				message = "Filtro " + filtro + " não existe";
				break;
			}

		} catch (Exception e) {
			message = "Falha ao filtras viagens";
		} finally {
			screenShot();
		}
		return message;
	}

	public String validarViagem() {
		message = "";
		try {
			tap(viagemElements.getAbaViagens());

			 tap(viagemElements.getTxtDetalhesUltimaViagem());
			 System.out.println("Validando viagem...");

			String inicio = getText(viagemElements.getTxtInicio());
			String chegada = getText(viagemElements.getTxtChegada());
			 String tempoViagem = getText(viagemElements.getTempoViagem());

			String inicioEsperado = mapTestCase.get("Início da viagem");
			String chegadaEsperado = mapTestCase.get("Chega da viagem");
			 String tempoViagemEsperado = mapTestCase.get("Tempo de viagem");

			if (!inicio.equals(inicioEsperado)) {
				message = "Inicio esperado[" + inicioEsperado + "] recebido[" + inicio + "]";
				return message;
			}
			if (!chegada.equals(chegadaEsperado)) {
				message = "chegada esperado[" + chegadaEsperado + "] recebido[" + chegada + "]";
				return message;
			}
			 if (!tempoViagem.equals(tempoViagemEsperado)) {
			 message = "chegada esperado[" + tempoViagemEsperado + "] recebido[" +
			 tempoViagem + "] Viagem validada com sucesso";
			 return message;
			 }

		} catch (Exception e) {
			message = "Falha ao validar viagem";
		} finally {
			screenShot();
		}
		return message;
	}

}