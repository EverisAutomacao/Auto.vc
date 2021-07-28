package com.everis.page;

import static com.everis.utils.DriverFactory.getMobileDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.CommonElements;
import com.everis.utils.DriverFactory;
import com.everis.utils.Tools;

public class Common extends DslMobile {

	String message = "";
	Tools tools = new Tools();
	CommonElements elements = new CommonElements(DriverFactory.getMobileDriver());

	public void getDeviceSize() {
		Dimension size = getMobileDriver().manage().window().getSize();
		System.out.println("Largoura: " + size.width);
		System.out.println("Altura: " + size.height);
	}

	public String acessarMenu(String menu) {
		message = "";

		try {
			tap(elements.getBtnMenu);
			Thread.sleep(1000);
			
			switch (menu) {
			case "Editar Perfil":
				tap(elements.getMenuMinhasDefinicoes());
				Thread.sleep(1000);
				tap(elements.getSubMenuEditarPerfil());
				break;
			case "Editar Configurações":
				tap(elements.getMenuMinhasDefinicoes());
				Thread.sleep(1000);
				tap(elements.getSubMenuEditarConfiguracoes());
				break;
			case "FAQ":
				tap(elements.getMenuDuvidas());
				Thread.sleep(1000);
				tap(elements.getSubMenuFAQ());
				break;
			case "Contrato":
				tap(elements.getMenuPoliticaDeUso());
				Thread.sleep(1000);
				tap(elements.getSubContratoDeUsuarioFinal());
				break;
			case "Video":
				tap(elements.getMenuComoFunciona());
				Thread.sleep(1000);
				tap(elements.getSubVideoAutoVc());
				break;

			case "Tour Inicial":
				tap(elements.getMenuComoFunciona());
				Thread.sleep(1000);
				tap(elements.getSubTourInicial());
				break;
			case "Desconto de amigos":
				tap(elements.getMenuDescontoDeAmigos());
				break;
			case "Declaração de Privacidade":
				tap(elements.getMenuPoliticaDeUso());
				Thread.sleep(1000);
				tap(elements.getSubDeclaracaoDePrivacidade());
				break;

			default:
				message = "Tela inválida";
				break;
			}
		} catch (Exception e) {
			message = "Falha ao acessar menu";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}

	public void abrirManifestacao() {
		message = "";
		try {

			scrollElementIsPresent(elements.getBtnFalarComSAS(), 75, 1);
			tap(elements.getBtnFalarComSAS());
			tap(elements.getBtnEnviarMensagem());
			screenShot();

			if (mapTestCase.get("Plataforma").equals("Android")) {

				sendKeysAnnotations(elements.getInputAssunto(), mapTestCase.get("Assunto"));
				String mensagem = mapTestCase.get("Mensagem");
				if (mensagem.equals("#mensagem"))
					mensagem = tools.getTextRandom();
				sendKeysAnnotations(elements.getInputMensagem(), tools.getTextRandom());
			} else {
				sendKeysWithPosition(163, 246, mapTestCase.get("Assunto"));
				String mensagem = mapTestCase.get("Mensagem");
				if (mensagem.equals("#mensagem"))
					mensagem = tools.getTextRandom();
				sendKeysWithPosition(208, 347, tools.getTextRandom());
			}
			message = "Campos preennchidos com sucesso";
		} catch (Exception e) {
			message = "Falha ao abrir manifestação";
		} finally {
			screenShot();
		}
	}

	public String salvarManifestacao() {
		message = "";
		try {
			tap(elements.getBtnEnviarManifestacao());
			screenShot();
			Thread.sleep(1000);
			waitLoading();
			String msg = "//android.widget.TextView[@text='Sua mensagem foi enviada com sucesso.']";
			if (isPresent(By.xpath(msg))) {
				message = "Sua mensagem foi enviada com sucesso";
				System.out.println(message);

			} else {
				message = "Falha ao abrir manifestação";
			}
		} catch (Exception e) {
			message = "Falha ao abrir manifestação";
		} finally {
			screenShot();
		}
		return message;
	}

	public String tourInicial() {
		message = "";
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements.getTelaTourInicial()));
			
			for (int vezes = 1; vezes <= 4; vezes++) {
				screenShot();
				tap(elements.getBtnTourInicialProximo());
				Thread.sleep(1000);
			}
			//tap(elements.getBtnTourInicialEntrar());
			wait.until(ExpectedConditions.visibilityOfAllElements(elements.getTelaPrincipal()));
		} catch (Exception e) {
			message = "Falha ao validar Tour Inicial";
		} finally {
			screenShot();
		}
		return message;
	}

	public void verificarSeEstaNaTelaTourInicial() {
		message = "";
		try {
			elements = new CommonElements(DriverFactory.getMobileDriver());

			wait.until(ExpectedConditions.visibilityOfAllElements(elements.getTelaTourInicial()));
			message = "Tela Tour Inicial validada com sucesso!";
		} catch (Exception e) {
			message = "Falha ao visualizar tour Inicial";
			e.printStackTrace();
		} finally {
			screenShot();
		}
	}

	public void validarPontuacaoZerada() {
		message = "";
		String pontosXPath = "//*[@content-desc='scoreGauge']//android.widget.TextView";
		String descontoXPath = "//android.widget.TextView[@text='BRINDES']/../android.widget.TextView[4]";
		String brindeXPath = "//android.widget.TextView[@text='BRINDES']/../android.widget.TextView[3]";
		String numeroDeViagensXPath = "//android.widget.TextView[@text='Minimo 20 viagens']/../android.widget.TextView[2]";
		String diasXPath = "//android.widget.TextView[@text='Minimo 60 dias']/../android.widget.TextView[2]";

		String kmXPath = "//android.widget.TextView[@text='Minimo 300 Kms']/../android.widget.TextView[2]";

		try {
			String pontos = getText(By.xpath(pontosXPath));
			String desconto = getText(By.xpath(descontoXPath));
			String brinde = getText(By.xpath(brindeXPath));

			scroll(90, 10, 1);

			String numeroDeViagens = getText(By.xpath(numeroDeViagensXPath));
			String dias = getText(By.xpath(diasXPath));
			String km = getText(By.xpath(kmXPath));

			if (!pontos.equalsIgnoreCase("Dirija e veja amanhã sua pontuação")) {
				message = "Pontos [" + pontos + "]";
			}

			if (!desconto.equalsIgnoreCase("R$ 0,00")) {
				message = "Desconto [" + desconto + "]";
			}

			if (!brinde.equalsIgnoreCase("0")) {
				message = "brinde [" + brinde + "]";
			}
			if (!numeroDeViagens.equalsIgnoreCase("0")) {
				message = " Numero de viagens [" + numeroDeViagens + "]";
			}
			if (!dias.equalsIgnoreCase("0")) {
				message = "Dias [" + dias + "]";
			}
			if (!km.equalsIgnoreCase("0")) {
				message = "Km [" + km + "]";
			}

			if (message.isEmpty()) {
				message = "Pontuação zerada para o usuário, validada com sucesso!";
			}
		} catch (Exception e) {
			message = "Falha ao validar pontuação zerada";
			e.printStackTrace();
		} finally {
			screenShot();
		}
	}

	public void validarPontuacaoRecuperada() {
		message = "";

		try {
			waitLoading();
			screenShot();

			String pontos = getText(elements.getPontosXPath());
			String desconto = getText(elements.getDescontoXPath());

			scroll(90, 10, 1);
			screenShot();
			String numeroDeViagens = getText(elements.getNumeroDeViagensXPath());
			String dias = getText(elements.getDiasXPath());
			String km = getText(elements.getKmXPath());

			if (pontos.equalsIgnoreCase("Dirija e veja amanhã sua pontuação")) {
				message = "Pontos [" + pontos + "]";
			}
			if (desconto.equalsIgnoreCase("R$ 0,00")) {
				message = "Desconto [" + desconto + "]";
			}
			/*
			 * if (brinde.equalsIgnoreCase("0")) { message = "brinde [" + brinde + "]"; }
			 */
			if (numeroDeViagens.equalsIgnoreCase("0")) {
				message = " Numero de viagens [" + numeroDeViagens + "]";
			}
			if (dias.equalsIgnoreCase("0")) {
				message = "Dias [" + dias + "]";
			}
			if (km.equalsIgnoreCase("0")) {
				message = "Km [" + km + "]";
			}

			if (message.isEmpty()) {
				message = "Pontuação do usuário recuperada com sucesso!";
			}

		} catch (Exception e) {
			message = "Falha ao validar pontuação zerada";
			e.printStackTrace();
		} finally {
			screenShot();
		}
	}

//	public String verNotificacoes() {
//		message = "";
//		String btnNotificacoes = "//android.view.ViewGroup[@content-desc='btnNotifications']/android.view.ViewGroup";
//		String lblNotificacoes = "//android.view.View[@text='Notícias']";
//
//		try {
//			tap(By.xpath(btnNotificacoes));
//			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(lblNotificacoes)));
//		} catch (Exception e) {
//			message = "falha ao visualizar tela de notificações";
//			e.printStackTrace();
//		} finally {
//			screenShot();
//		}
//		return message;
//	}

	

	public String verificaLogin() {
		message = "";
		try {
			Usuario user = new Usuario();
			Termos termos = new Termos();
			if (!user.verificarSeEstaLogado()) {
				message = termos.concordar();
				if(!message.isEmpty())
					return message;
				message = pularTourInicial();
				if(!message.isEmpty())
					return message;
				message = user.loginEmail();
			}

		} catch (Exception e) {
			message = "Falha ao verificar login";
		}
		
		return message;
	}
	public String pularTourInicial() {
		message = "";
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements.getTelaTourInicial()));
			screenShot();
			tap(elements.getBtnTourInicialPular());
		} catch (Exception e) {
			message = "falha ao pular tour inicial";
		}
		return message;
	}

}





