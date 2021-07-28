package com.everis.page;

import static com.everis.utils.DriverFactory.getWebDriver;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.everis.dslCommands.DslWeb;
import com.everis.elements.CotadorElements;
import com.everis.excel.Planilha;
import com.everis.runners.Automation;
import com.everis.utils.Global;

public class Cotacao extends DslWeb {
	String message = "";

	CotadorElements elements = new CotadorElements();
	
	/**
	 * Lê os dados da aba cotador
	 */
	public String lerDadosLinha() {
		String message = "";
		try {
			Planilha excel = new Planilha();
			excel.ds_startExcel(Global.spreadsheetFolder + "/" + Global.planilha, Global.folha);
			int coluna = 0;
			System.out.println(mapTestCase.get("Linha Cotador"));
			int linhaCotador = Integer.parseInt(mapTestCase.get("Linha Cotador")) - 1;
			excel.trocarAba("Cotador");
			while (!excel.getValue(linhaCotador, coluna).isEmpty()) {
				mapCotador.put(excel.getValue(0, coluna), excel.getValue(linhaCotador, coluna));
				coluna++;
			}
			excel.ds_closeData();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;
	}

	public String login() {
		try {
			
			String url = mapCotador.get("URL");
			getWebDriver().navigate().to(url);

			sendKeys(elements.inputUsername, mapCotador.get("USUARIO"));
			sendKeys(elements.inputUpassword, mapCotador.get("SENHA"));
			screenShot();
			click(elements.btnEntrar);
			Thread.sleep(2000);
			if (isPresent(elements.spanError)) {
				message = "Não foi possível autenticar";
			} else {
				System.out.println("Login efetuado com sucesso.");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			screenShot();
		}
		return message;
	}

	public String calcular() {
		message = "";
		System.out.println("Calculando...");
		
		try {

			waitInvisibility(elements.loading);
			// SE O HAMBIENTE FOR HOMOLOGÃO
			if (mapCotador.get("URL").contains("stg")) {
				getWebDriver().switchTo().frame(0);
				screenShot();
				click(elements.calculista);
			}

			// DADOS DO SEGURADO ================================================
			sendKeys(elements.inputCPF, mapCotador.get("CPF") + Keys.TAB);
			esperaCarregar();

			String nome = getValue(elements.inputNome);
			String sexo;
			String dataNascimento;
			if (nome.isEmpty()) {
				nome = mapCotador.get("NOME");
				sexo = mapCotador.get("SEXO");
				dataNascimento = mapCotador.get("DATA DE NASCIMENTO");
				sendKeys(elements.inputNome, nome);
				sendKeys(elements.inputNascimento, dataNascimento);
				if (sexo.equalsIgnoreCase("Masculino"))
					click(elements.inputSexoM);
				else
					click(elements.inputSexoF);

			}
			screenShot();
			sendKeys(elements.inputCep, mapCotador.get("CEP-RESIDÊNCIA") + Keys.TAB);
			esperaCarregar();

			if (mapCotador.get("CEP-PERNOITE-IGUAL").equals("Sim")) {
				click(elements.inputCepPernoiteIgual);
			} else {
				sendKeys(elements.inputCepPernoite, mapCotador.get("CEP-PERNOITE") + Keys.TAB);
			}
			esperaCarregar();
			select(elements.cmbTipoResidencia, mapCotador.get("TIPO DE RESIDÊNCIA"));

			screenShot();
			// DADOS DO VEICULO ===================================================

			sendKeys(elements.inputPlaca, mapCotador.get("PLACA"));
			select(elements.cmbUf, mapCotador.get("UF"));

			sendKeys(elements.inputChassi, mapCotador.get("CHASSI"));

			System.out.println("ANO MODELO");
			Thread.sleep(1000);
			sendKeys(elements.inputAnoModelo, mapCotador.get("ANO MODELO"));
			Thread.sleep(1000);
			System.out.println("FABRICANTE");
			jSelect(elements.cmbFabricante, mapCotador.get("FABRICANTE"));
			Thread.sleep(1000);
			System.out.println("MODELO");
			click(elements.inputModelo);
			Thread.sleep(5000);
			sendKeys(elements.inputModelo, mapCotador.get("MODELO"));
			esperaCarregar();
			Thread.sleep(2000);
			click(elements.modeloSelecionado);
			Thread.sleep(5000);
			String modelo = getValue(elements.inputModelo);
			if (modelo.isEmpty()) {
				message = "Falha ao selecionar modelo do veículo";
				// return message;
			} else {
				System.out.println("MODELO: " + modelo);
			}

			
			String fipe = getText(elements.codigoFipePreenchido);
			System.out.println("Fipe: " + fipe);

			sendKeys(elements.cmbCombustivel, mapCotador.get("COMBUSTÍVEL"));
			sendKeys(elements.cmbUso, mapCotador.get("USO"));

			screenShot();
			// QAR - AVALIAÇÃO DE PERFIL E RISCO
			// =================================================
			Scroll();
			Thread.sleep(4000);

			click(elements.inputPrincipalCondutor);
			
			String cpf = getValue(elements.cpfPreenchido);
			System.out.println("CPF: " + cpf);
			Thread.sleep(3000);
			select(elements.cmbEstadoCivil, mapCotador.get("ESTADO CIVIL"));
			click(elements.inputQarNao);

			select(elements.cmbInsecaoTributaria, mapCotador.get("ISENÇÃO TRIBUTÁRIA"));

			click(elements.btnCalcular);
			esperaCalcular();

			if (mapCotador.get("SEXO").equals("Feminino")) {

				Thread.sleep(3000);
				getWebDriver().switchTo().frame(1);
				
				if (isPresent(elements.autoMulher)) {
					click(elements.autoMulher);
					esperaCalcular();
				}
				screenShot();
			}

			System.out.println("Calculado com sucesso.");

			String numeroDoCalculo = getText(elements.numeroCalculo);
			System.out.println("Nº DO CÁLCULO: " + numeroDoCalculo);
			salvarNaPlanilha(numeroDoCalculo, Automation.linhaConstrutor, "Nº do cálculo");
		} catch (Exception e) {
			e.printStackTrace();
			message = "Falha ao calcular";
		} finally {
			screenShot();
		}
		return message;

	}

	public void esperaCarregar() {
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(getWebDriver(), 20);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elements.loading));
		} catch (Exception e) {

		}
	}

	public void esperaCalcular() {
		try {
			Thread.sleep(3000);

			
			WebDriverWait wait = new WebDriverWait(getWebDriver(), 20);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elements.loading));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elements.loading2));
		} catch (Exception e) {

		}
	}

	public String validarCupom() {

		

		try {
			Thread.sleep(3000);

			WebDriverWait wait = new WebDriverWait(getWebDriver(), 15);
			wait.until(ExpectedConditions.presenceOfElementLocated(elements.modalTelemetria));

			String codigo = getText(elements.codigoCupom);
			String validade = getText(elements.validadeCupom);

			System.out.println("Código [" + codigo + "]");
			System.out.println("Validade [" + validade + "]");

			if (isPresent(elements.modalTelemetria)) {
				screenShot();
				click(elements.inputCupom);
				click(elements.btnCalcular);
				esperaCalcular();
			}

			Thread.sleep(5000);
			String desconto = getText(elements.txtDescontoAplicado);
			System.out.println(desconto);
		} catch (Exception e) {
			message = "Cupom não foi apresentado";
		} finally {
			screenShot();
		}
		return message;
	}

}
