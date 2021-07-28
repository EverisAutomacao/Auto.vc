package com.everis.page;

import static com.everis.utils.DriverFactory.getWebDriver;

import org.openqa.selenium.WebElement;

import com.everis.dslCommands.DslWeb;
import com.everis.elements.LandingPageElements;
import com.everis.utils.GeraCpfCnpj;
import com.everis.utils.Tools;

public class LandingPage extends DslWeb {

	String message = "";
	Tools tools = new Tools();
	GeraCpfCnpj gerador = new GeraCpfCnpj();
	LandingPageElements landElements = new LandingPageElements();
	String divisor = ";";

	public String cadastrarUsuario() {

		try {

			String url = mapTestCase.get("Link Convite");
			getWebDriver().navigate().to(url);
			screenShot();
			// preenche nome
			// ================================================================
			String nome = mapTestCase.get("Nome");
			if (nome.equalsIgnoreCase("#nome")) {
				nome = tools.getNameRandom();
			}
			sendKeys(landElements.edtNome, nome);


			// preenche email
			// ================================================================
			String email = mapTestCase.get("EmailCadastro");
			if (email.equalsIgnoreCase("#email")) {
				email = tools.getEmailRandom().toLowerCase();
			}
			Tools.logCadastro = email;
			sendKeys(landElements.edtEmail, email);

			// preenche cpf ================================================================
			String cpf = mapTestCase.get("CPF");
			if (cpf.equalsIgnoreCase("#cpf")) {
				cpf = gerador.cpf();
			}
			Tools.logCadastro = Tools.logCadastro + divisor + cpf;
			sendKeys(landElements.edtCpf, cpf);
			screenShot();
			// preenche celular
			// ================================================================
			String telefone = mapTestCase.get("Telefone");
				if (telefone.equalsIgnoreCase("#telefone")) {
					telefone = tools.getPhoneNumberRandom();
				}
				Tools.logCadastro = Tools.logCadastro + divisor + telefone;
				sendKeys(landElements.edtTelefone, telefone);

			// ================================================================
			sendKeys(landElements.edtSenha, mapTestCase.get("SenhaCadastro"));
			sendKeys(landElements.edtConfirmarSenha, mapTestCase.get("SenhaCadastro"));
			Tools.logCadastro = Tools.logCadastro + divisor + mapTestCase.get("SenhaCadastro");
			// preenche check maior de idade
			// ================================================================
			Thread.sleep(1000);
			click(landElements.chkMaiorIdade);
	
			Tools.logCadastro = Tools.logCadastro + divisor + Tools.getDate() + "\n";
		} catch (Exception e) {
			message = "[Cadastro] Falha ao preencher campos";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}

	public String cadastroSalvar() {
		message = "";

		try {
			Thread.sleep(1000);
			click(landElements.btnConcluirCadastro);
			screenShot();
			waitIsPresent(landElements.iframe);
			Thread.sleep(1000);
			String texto = getText(landElements.sucess);
			screenShot();
			System.out.println(texto);
//			Tools.writeInCSV(Tools.logCadastro);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Falha ao criar cadastro";
//		} finally {
//			screenShot();
		}

		return message;

	}

}