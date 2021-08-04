package com.everis.page;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.ManifestacaoElements;
import com.everis.utils.DriverFactory;
import com.everis.utils.Tools;

public class Manifestacao extends DslMobile {

	String message = "";
	Tools tools = new Tools();
	ManifestacaoElements elements = new ManifestacaoElements(DriverFactory.getMobileDriver());

	public String abrirManifestacao() {
		message = "";
		try {


			scrollElementIsPresent(elements.btnFalarComSAS, 70, 1);
			tap(elements.btnFalarComSAS);
			tap(elements.btnEnviarMensagem);
		
			Thread.sleep(1000);
			screenShot();

			if (mapTestCase.get("Plataforma").equals("Android")) {
				@SuppressWarnings("static-access")
				String assunto = mapTestCase.get("Assunto") + " " + tools.getDate();
				sendKeysAnnotations(elements.inputAssunto, assunto);
				String mensagem = mapTestCase.get("Mensagem");
				if (mensagem.equals("#mensagem"))
					mensagem = tools.getTextRandom();
				sendKeysAnnotations(elements.inputMensagem, mensagem);
			} else {
				sendKeysWithPosition(163, 246, mapTestCase.get("Assunto"));
				String mensagem = mapTestCase.get("Mensagem");
				if (mensagem.equals("#mensagem"))
					mensagem = tools.getTextRandom();
				sendKeysWithPosition(208, 347, tools.getTextRandom());
			}
			tap(elements.btnEnviarManifestacao);
			tap(elements.btnVamosLa);
			screenShot();
			Thread.sleep(1000);
			waitLoading();
			if (isPresent(elements.telaManifestacao)) {
				message = "Falha ao abrir manifestação";
			}

		} catch (Exception e) {
			message = "Falha ao abrir manifestação";
		} finally {
			screenShot();
		}
		return message;
	}

}