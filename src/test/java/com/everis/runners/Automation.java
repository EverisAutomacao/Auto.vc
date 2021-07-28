package com.everis.runners;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.everis.dslCommands.DslMobile;
import com.everis.excel.Dados;
import com.everis.utils.DriverFactory;
import com.everis.utils.Tools;

@RunWith(Parameterized.class)
public class Automation extends Dados {

	public static String resultadoRecebido = "";
	/**
	 * Para executar o script via linha do comando utilize:
	 * mvn surefire:test -Dtest=Automation
	 */

	public static int linhaConstrutor;
	int linhaPlanilha;

	@Parameterized.Parameters(name = "{1}")
	public static List<Object> loadTestData() throws Exception {
		return Arrays.asList(verificarTestes());
	}

	public Automation(int linha, String testID) {
		linhaConstrutor = linha;
		linhaPlanilha = linha + 1;
		System.out.println(testID + " Linha " + linhaPlanilha);
		lerDadosLinha(linha);
	}

	@BeforeClass
	public static void beforeClass() {
		Tools.setNameFolderEvidence();
		Tools.excelBackup();
	}

	@Before
	public void before() {
		// Reseta a contagem de prints de tela
		DslMobile.screenShotNumber = 1;
		Tools.tempoInicioExecucao();

		switch (mapTestCase.get("Plataforma")) {
		case "Android":
			DriverFactory.createDriveMobile("Android");
			break;
		case "iOS":
			DriverFactory.createDriveMobile("iOS");
			break;
		case "Web":
			DriverFactory.createWebDriver();
			break;
		default:
			System.out.println("Plataforma não localizada");
		}
	}
	

	@Test
	public void testCase() {
		Manager manager = new Manager(mapTestCase.get("Plataforma"));
		resultadoRecebido = manager.executar(mapTestCase.get("Funcionalidade"));
	}

	
	@After
	public void after() throws Exception {
		System.out.println("Resultado do teste: "+resultadoRecebido);
		if (resultadoRecebido.isEmpty()) {
			resultadoRecebido = getValue("Resultado Esperado");
		}

		Tools.encerraExecucao();

		Tools.tempoFimExecucao();
		Tools.resultado(resultadoRecebido, linhaConstrutor);
		assertEquals(getValue("Resultado Esperado"), resultadoRecebido);
		resultadoRecebido = "";
	}
	

}