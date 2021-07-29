package com.everis.page;

import org.openqa.selenium.By;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.RankingElements;
import com.everis.utils.DriverFactory;

public class Ranking extends DslMobile {

	String message = "";
	RankingElements rankingElements = new RankingElements(DriverFactory.getMobileDriver());

	public String convidarAmigo() {
		message = "";
		String abaRankingXPath = "//android.widget.TextView[@text='Ranking']";
		String competir = "//android.widget.TextView[contains(@text,'Competir') and contains(@text,'com meus amigos')]";
		// String edtEmail = "//android.widget.EditText[@text='email do seu amigo']";
		String btnConvidar = "//android.view.ViewGroup[@content-desc='inviteFriendButton']";

		String msgError = "//android.widget.TextView[@text='Você já convidou esse amigo.']";
		String msgConviteEnviado = "//android.widget.TextView[@text='Estamos quase lá!']";

		try {
			screenShot();
			tap(By.xpath(abaRankingXPath));

			if (isPresent(rankingElements.getBtnAgoraNao())) {
				screenShot();
				tap(rankingElements.getBtnAgoraNao());
			}

			screenShot();
			tap(By.xpath(competir));
			screenShot();
			// sendKeys(By.xpath(edtEmail), mapTestCase.get("Amigo"));
			sendKeysAnnotations(rankingElements.getEdtEmailAmigo(), mapTestCase.get("Amigo"));
			tap(By.xpath(btnConvidar));
			screenShot();
			waitLoading();
			Thread.sleep(1000);
			if (isPresent(By.xpath(msgError))) {
				message = "Você já convidou esse amigo!";
				System.out.println(message);
			} else if (isPresent(By.xpath(msgConviteEnviado))) {
			} else {
				message = "Falha ao enviar convite";
			}

		} catch (Exception e) {
			message = "Falha ao enviar convite";
			e.printStackTrace();
		} finally {
			screenShot();

		}
		return message;

	}

	public String aceitarConvite() {
		message = "";
		String btnAceitar = "//android.widget.TextView[contains(@text,'Aceitar')]";
		String btnReturn = "//android.view.ViewGroup[@content-desc='btnGoBack']/android.view.ViewGroup";

		try {
			tap(By.xpath(btnAceitar));
			screenShot();
			System.out.println("Convite aceito");
			waitLoading();
			tap(By.xpath(btnReturn));
			waitLoading();
		} catch (Exception e) {
			message = "Falha ao aceitar convite";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;

	}

	public String rejeitarConvite() {
		message = "";
		String btnRejeitar = "//android.widget.TextView[contains(@text,'Rejeitar')]";
		String btnReturn = "//android.widget.TextView[@text='Notícias']/../..//android.widget.ImageView";

		try {
			tap(By.xpath(btnRejeitar));
			screenShot();
			waitLoading();
			tap(By.xpath(btnReturn));
			waitLoading();
		} catch (Exception e) {
			message = "Falha ao rejeitar convite";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;

	}

	public String verConvite() {
		message = "";
		String abaRankingXPath = "//android.widget.TextView[@text='Ranking']";
		String conviteRecebido = "//android.widget.ScrollView[@content-desc='comp.screen.scrollView']/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]";
		try {
		

			tap(By.xpath(abaRankingXPath));
			screenShot();
			Thread.sleep(3000);
			
			if (isPresent(rankingElements.getBtnAgoraNao())) 
				tap(rankingElements.getBtnAgoraNao());

			if (isPresent(By.xpath(conviteRecebido))) {
				tap(By.xpath(conviteRecebido));
				screenShot();
				Thread.sleep(3000);
			} else {
				message = "Falha ao visualizar convite";
			}

		} catch (Exception e) {
			message = "Falha ao validar convite";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;

	}

	public void convideSeusAmigos() {
		message = "";
		try {
			String btnConvideSeusAmigos = "//android.widget.TextView[@text='Convide seus amigos']/..";
			String btnWhatsapp = "//android.widget.TextView[@text='WhatsApp']";
			String primeiroContato = "//android.widget.TextView[@text='Contatos frequentes']/../..//android.widget.RelativeLayout[2]";
			scroll(90, 20, 1);

			waitLoading();
			tap(By.xpath(btnConvideSeusAmigos));
			screenShot();
			Thread.sleep(1000);
			scroll(90, 30, 1);
			screenShot();
			tap(By.xpath(btnWhatsapp));
			Thread.sleep(5000);
			screenShot();
			tap(By.xpath(primeiroContato));
			screenShot();
			Thread.sleep(99999);
		} catch (Exception e) {
			message = "Falhou";
			e.printStackTrace();
		} finally {
			screenShot();
		}

	}

	public String validarAmigoNoRanking(String amigo) {
		String abaRankingXPath = "//android.widget.TextView[@text='Ranking']";
		String btnRankingDeAmigosXPath = "//android.widget.TextView[contains(@text,'Ranking') and contains(@text,'de Amigos')]/..";

		try {
			tap(By.xpath(abaRankingXPath));
			screenShot();
			tap(By.xpath(btnRankingDeAmigosXPath));
			screenShot();
			scroll(80, 10, 1);

			String amigoXpath = "//android.widget.TextView[@text='" + amigo + "']";

			if (isPresent(By.xpath(amigoXpath))) {
				message = "O amigo esta no ranking";
				System.out.println(message);
			} else {
				message = "O amigo [" + amigo + "] não está no ranking";
			}

		} catch (Exception e) {
			message = "Falha ao verificar se o amigo esta no ranking";
		} finally {
			screenShot();
		}
		return message;
	}

	public String validarForaDoRanking(String amigo) {

		try {
			tap(rankingElements.getAbaRankingXPath());
			screenShot();
			tap(rankingElements.getBtnRankingDeAmigosXPath());
			screenShot();
			scroll(80, 10, 1);

			String amigoXpath = "//android.widget.TextView[@text='" + amigo + "']";

			if (isPresent(By.xpath(amigoXpath))) {
				message = "O amigo [" + amigo + "] está no ranking";
				System.out.println(message);
			} else {
				message = "O amigo não está no ranking";
			}

		} catch (Exception e) {
			message = "Falha ao verificar se o amigo esta no ranking";
		} finally {
			screenShot();
		}
		return message;
	}

	public String acessarTelaRanking() {
		message = "";
		try {
			tap(rankingElements.getAbaRankingXPath());
			screenShot();

			// android.widget.TextView[@text='Agora não']

		} catch (Exception e) {
			message = "Falha ao acessar tela de ranking";
		} finally {
			screenShot();
		}
		return message;
	}

	public String popupAlterarApelido(boolean alterar) {
		message = "";
		try {
			

			if (alterar) {
				// Não mapeamos teste para alteração de apelido
			} else if (isPresent(rankingElements.getBtnAgoraNao())) {
				screenShot();
				tap(rankingElements.getBtnAgoraNao());
			}

		} catch (Exception e) {
			message = "Falha ao alterar apelido";
		} finally {
			screenShot();
		}
		return message;
	}

	public String verRankingGeral() {

		try {
			tap(rankingElements.getBtnRankingGeralXPath());
			screenShot();
		} catch (Exception e) {
			message = "Falha ao visualizar ranking de geral";
		} finally {
			screenShot();
		}
		return message;
	}

	public String verRankingDeAmigos() {

		try {
			tap(rankingElements.getBtnRankingDeAmigosXPath());
			screenShot();
			scroll(90, 20, 1);
			Thread.sleep(1000);
			screenShot();
		} catch (Exception e) {
			message = "Falha ao visualizar ranking de amigos";
		} finally {
			screenShot();
		}
		return message;
	}

	public String verRankingPorNumViagens() {
		try {
			tap(rankingElements.getBtnRankingPorNumViagensXPath());
			screenShot();
			scroll(90, 20, 1);
			Thread.sleep(1000);
			screenShot();
		} catch (Exception e) {
			message = "Falha ao visualizar ranking de amigos";
		} finally {
			screenShot();
		}
		return message;
	}

	public String verRankingPorKm() {
		try {
			
			Thread.sleep(5000);
			int positionY = getPositionY(rankingElements.getBtnRankingGeralXPath());
			System.out.println("Y="+positionY);
			scrollHorizontal(positionY+50);
			
			tap(rankingElements.getBtnRankingPorKmXPath());
			screenShot();
			Thread.sleep(1000);
			scroll(90, 20, 1);
			Thread.sleep(1000);
			screenShot();
		} catch (Exception e) {
			message = "Falha ao visualizar ranking de amigos";
		} finally {
			screenShot();
		}
		return message;
	}
}