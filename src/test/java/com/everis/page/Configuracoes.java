package com.everis.page;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.CommonElements;
import com.everis.utils.DriverFactory;

public class Configuracoes extends DslMobile {

	String message = "";
	Common common = new Common();
	CommonElements commonElements = new CommonElements(DriverFactory.getMobileDriver());

	public String verificarVersao() {
		message = "";
		try {
			String versaoEsperada = mapTestCase.get("Versão do Aplicativo");
			String versaoRecebida = getText(commonElements.getTxtVersaoApp());

			String vetor[] = versaoRecebida.split(" v");
			versaoRecebida = vetor[1];
			String vetor2[] = versaoRecebida.split("\n");
			versaoRecebida = vetor2[0];

			if (!versaoEsperada.equalsIgnoreCase(versaoRecebida)) {
				message = "Versão incorreta. Esperada[" + versaoEsperada + "] - Encontrada[" + versaoRecebida + "]";
			}

		} catch (Exception e) {
			message = "Falha ao verificar versão do app";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
}