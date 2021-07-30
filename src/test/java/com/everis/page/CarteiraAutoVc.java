package com.everis.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.CarteiraAutoVcElements;
import com.everis.utils.DriverFactory;
import com.everis.utils.Tools;

public class CarteiraAutoVc extends DslMobile {

	String message = "";
	Tools tools = new Tools();
	CarteiraAutoVcElements elements = new CarteiraAutoVcElements(DriverFactory.getMobileDriver());

	public String minhaCarteiraAutoVc() {
		message = "";
		try {
			tap(elements.btnDescontos);
		} catch (Exception e) {
			message = "Falha ao acessar tela minha carteira AutoVc";
			e.printStackTrace();
		} finally {

			screenShot();
		}
		return message;
	}
	
	public String capturaTelaBrindes() {
		message = "";
		try {
			Thread.sleep(500);
			screenShot();
			waitLoading();
			scroll(90, 35, 1);
			Thread.sleep(500);
			screenShot();
			//scroll(90, 25, 1);
//			Thread.sleep(500);
//			screenShot();
				
		} catch (Exception e) {
			message = "Falha ao capturar tela de Brindes";
			e.printStackTrace();
		} finally {

			screenShot();
		}
		return message;
	}
	
	public String capturaTelaCupons() {
		message = "";
		try {
			Thread.sleep(500);
			waitLoading();
			screenShot();
			scroll(90, 35, 1);
			scroll(90, 25, 1);
			Thread.sleep(500);
			screenShot();
				
		} catch (Exception e) {
			message = "Falha ao capturar tela de Cupons";
			e.printStackTrace();
		} 
		return message;
	}
	
	
	
	

	public String gerarCupomLargada() {
		message = "";

		try {

			Thread.sleep(5000);
			waitLoading();
			tap(elements.btnGerarCupomDesconto);
			screenShot();
			waitLoading();
			wait.until(ExpectedConditions.visibilityOfAllElements(elements.txtCupomGerado));
			String msg = getText(elements.txtCupomGerado);
			if (msg.isEmpty()) {
				message = "Falha ao gerar cupom";
			} else {
				System.out.println(msg);
			}
		} catch (Exception e) {
			message = "Falha ao gerar cupom";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}

	public String validarBrindeCheckUpAutomotivo() {
		message = "";

		try {
			Thread.sleep(5000);
			waitLoading();
			scroll(90, 20, 1);
			screenShot();
			wait.until(ExpectedConditions.visibilityOfAllElements(elements.btnBrindeAutomotivo));
			tap(elements.btnBrindeAutomotivo);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements.codigoCupom));
			screenShot();
			tap(elements.btnAcessarSite);
			Thread.sleep(7000);

		} catch (Exception e) {
			message = "Falha ao validar brinde";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	
	public String telaInicialCapturaCards() {
		message = "";

		try {
			Thread.sleep(500);
			waitLoading();
			scroll(90, 35, 1);
			Thread.sleep(500);
			screenShot();
			scroll(90, 25, 1);
			Thread.sleep(500);
			screenShot();
			scroll(90, 25, 1);
			screenShot();
		} catch (Exception e) {
			message = "Falha ao capturar cards";
			e.printStackTrace();
		} finally {
			//screenShot();
		}
		return message;
	}
	

	public String validarBrindeAgendaDoCarro() {
		message = "";

		try {
			Thread.sleep(5000);
			waitLoading();
			scroll(90, 20, 1);
			screenShot();
			tap(elements.btnBrindeCarro);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements.codigoCupom));
			screenShot();
			tap(elements.btnAcessarSite);
			Thread.sleep(7000);
		} catch (Exception e) {
			message = "Falha ao validar brinde";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}

	public String validarSmiles() {
		message = "";

		try {
			Thread.sleep(5000);
			waitLoading();
			scroll(90, 20, 1);
			screenShot();
			tap(elements.btnBrindeSmiles);
			Thread.sleep(5000);
			screenShot();
			scroll(90, 20, 1);
			screenShot();
		} catch (Exception e) {
			message = "Falha ao validar brinde";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}

	public String validarCupom(String nomeDoCupom) {
		message = "";
		try {

			waitLoading();
			Thread.sleep(1000);
			waitLoading();
			scroll(90, 20, 1);
			Thread.sleep(1000);
			tap(elements.btnCupom(nomeDoCupom));

			String codigo = getText(elements.txtCodigoCupom);
			String validade = getText(elements.txtDataDeValidade);
			String valorDoDesconto = getText(elements.txtValorDoDesconto);

			System.out.println("Código do cupom [" + codigo + "]");
			System.out.println("Validade [" + validade + "]");
			System.out.println("Valor do desconto [" + valorDoDesconto + "]");


		} catch (Exception e) {
			message = "Falha ao validar Cupom " + nomeDoCupom;
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;

	}

	public String compartilharCupom() {
		message = "";

		String btnCupom = "//*[@content-desc='openPresent']/android.widget.TextView[@text='Desconto Seguro']";
		try {

			waitLoading();
			Thread.sleep(1000);
			waitLoading();
			scroll(90, 20, 1);
			screenShot();
			Thread.sleep(1000);
			tap(By.xpath(btnCupom));
			Thread.sleep(3000);
			scroll(90, 10, 1);
			screenShot();
			tap(elements.btnEnviarCorretor);
			screenShot();
			tap(elements.btnGmail);
			wait.until(ExpectedConditions.invisibilityOf(elements.telaEmail));
			Thread.sleep(3000);
		} catch (Exception e) {
			message = "Falha ao compartilhar cupom";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;

	}
	public String compartilharBrinde(String brinde) {
		message = "";
		try {

			waitLoading();
			Thread.sleep(1000);
			waitLoading();
			scroll(90, 20, 1);
			screenShot();
			Thread.sleep(1000);
			switch (brinde) {
			case "Agenda do Carro":
				tap(elements.btnBrindeCarro);
				break;
			case "Check Up Automotivo":
				
				break;
			case "Smiles":
				
				break;
			default:
				message = "Brinde não existe";
				return message;
			}
			
			Thread.sleep(3000);
			scroll(90, 10, 1);
			screenShot();
			tap(elements.btnEnviarCorretor);
			screenShot();
			tap(elements.btnGmail);
			wait.until(ExpectedConditions.invisibilityOf(elements.telaEmail));
			Thread.sleep(3000);
		} catch (Exception e) {
			message = "Falha ao compartilhar brinde["+brinde+"]";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;

	}

	public String semCupom() {
		message = "";

		try {
			Thread.sleep(1000);
			scroll(90, 20, 1);
			Thread.sleep(1000);
			if (isPresent(elements.brindeEmProgresso)) {
				message = "Falha na validação de usuário novo, brinde em progresso";
			}
			if (isPresent(elements.brindeCompleto)) {
				message = "Falha na validação de usuário novo, brinde disponível";
			}

		} catch (Exception e) {
			message = "Falha ao validar brinde";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	
	public String semBrindeIniciante() {
		message = "";

		try {
			Thread.sleep(1000);
			scroll(90, 20, 1);
			Thread.sleep(1000);
			if (isPresent(elements.semBrindeIniciante)) {
				message = "Falha na validação de usuário novo, brinde em progresso";
			}
			
		} catch (Exception e) {
			message = "Falha ao validar brinde";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	

}