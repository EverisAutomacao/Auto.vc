package com.everis.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.UsuarioElements;
import com.everis.utils.DriverFactory;
import com.everis.utils.GeraCpfCnpj;
import com.everis.utils.Tools;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class Usuario extends DslMobile {

	String message = "";
	Tools tools = new Tools();
	GeraCpfCnpj gerador = new GeraCpfCnpj();
	String divisor = ";";
	UsuarioElements userElements = new UsuarioElements(DriverFactory.getMobileDriver());

	/**
	 * Verifica se o texto "Minha carteira Auto.VC está presente" Caso esteja, o
	 * usuario está logado na tela inicial e com as devidas permissões concedidas
	 */
	public String verificarSeEstaNaTelaInicial() {
		message = "";
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfAllElements(userElements.telaInicial));
		} catch (Exception e) {
			message = "Não esta na tela inicial";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	
	public String verificarCadastroInválido() {
		message = "";
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfAllElements(userElements.telaInicial));
		} catch (Exception e) {
			message = "Email inválido ou já existente";
			e.printStackTrace();
//		} finally {
//			screenShot();
		}
		return message;
	}
	
	public String verificarBtnConcluir() {
		message = "";
		try {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfAllElements(userElements.btnConcluir));
		} catch (Exception e) {
			message = "Email inválido, não é possível concluir o cadastro";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	
	
	
	

	public boolean verificarSeEstaLogado() {
		boolean logado = false;
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(userElements.telaInicial));
			message = "Está na tela inicial";
			System.out.println(message);
			logado = true;
		} catch (Exception e) {
			message = "Não está logado";
			System.out.println(message);
			logado = false;
		} finally {
			screenShot();
		}
		return logado;
	}
	
	public boolean verificarSeEstaLogadoFace() {
		boolean logado = false;
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(userElements.telaPermissoes));
			message = "Login Ok";
			System.out.println(message);
			logado = true;
		} catch (Exception e) {
			message = "Não esta logado";
			System.out.println(message);
			logado = false;
		} finally {
			screenShot();
		}
		return logado;
	}

	public String loginGmail() {
		message = "";

		try {
			tap(userElements.btnEntreAqui);
			screenShot();
			tap(userElements.btnGoogle);
			Thread.sleep(5000);
			screenShot();
			tap(userElements.primeiraContaGmailLogada);
			waitLoading();
		} catch (Exception e) {
			message = "Falha ao logar com Gmail";
		} finally {
			screenShot();
		}
		return message;
	}

	public String loginFacebook() {
		message = "";

		try {
			tap(userElements.btnEntreAqui);
			screenShot();
			tap(userElements.btnFacebook);
			screenShot();
			Thread.sleep(3000);
			screenShot();
			waitLoading();
		} catch (Exception e) {
			message = "Falha ao logar com Facebook";

		}
		return message;
	}

	public String loginEmail() {
		message = "";
		try {
			tap(userElements.btnEntreAqui);
			screenShot();
			sendKeysAnnotations(userElements.edtEmail, mapTestCase.get("EmailLogin"));
			sendKeysAnnotations(userElements.edtSenha, mapTestCase.get("SenhaLogin"));
			Thread.sleep(1500);
			screenShot();
			tap(userElements.btnEntrar2);
			screenShot();
			Thread.sleep(2500);
			screenShot();
			waitLoading();
			Thread.sleep(1500);
			tap(userElements.otmBateria);
			tap(userElements.permitirAndroidbat);
			
			
			
			if (isPresent(userElements.errorMsg)) {
				message = "Email e/ou senha incorreta(s)";
			}
		} catch (Exception e) {
			message = "Falha ao logar com email";
			e.printStackTrace();
		} 
		return message;
	}

	public String Gmail() {
		String btnGmail = "//*[@content-desc='googleOnboard']";
		String primeiraContaGmailLogada = "(//android.widget.TextView[@resource-id='com.google.android.gms:id/account_display_name'])[1]";

		try {
			tap(By.xpath(btnGmail));
			screenShot();
			tap(By.xpath(primeiraContaGmailLogada));
			waitLoading();
			screenShot();
			message = "Campos do cadastro parte1 preenchidos com sucesso!";

		} catch (Exception e) {
			message = "Cadastro: Falha ao preencher campos";
			e.printStackTrace();
		} finally {
		}
		return message;
	}

	public String Facebook() {
		String btnLogin = "//*[@content-desc='goToSignInButton']";
		String btnFacebook = "//*[@content-desc='facebookOnboard']";
		try {

			tap(By.xpath(btnLogin));
			screenShot();
			tap(By.xpath(btnFacebook));
			waitLoading();
			waitLoading();
			// preencher campos do webview
			// digitar login
			// digitar senha
			// clicar em confirmar
			// aguardar carregamento
			// clicar em continuar

			message = "Autenticado no facebook com sucesso!";

		} catch (Exception e) {
			message = "Cadastro: Falha ao preencher campos";
			e.printStackTrace();
		} finally {
		}
		return message;
	}

	public String cadastroJaExistente(String tipo) {
		message = "";
		Tools.logCadastro = "";
		try {

			tap(userElements.btnCadastrar);
			screenShot();
			switch (tipo) {
			case "email":
				message = preencheEmailNome();
				break;
			case "gmail":
				Gmail();
				break;
			case "facebook":
				Facebook();
				break;
			}
			if (!message.isEmpty())
				return message;

			String cpf = mapTestCase.get("CPF");
			if (cpf.equalsIgnoreCase("#CPF")) {
				cpf = gerador.cpf();
			}
			Tools.logCadastro = Tools.logCadastro + divisor + cpf;
			sendKeysAnnotations(userElements.edtCpf, cpf);
			message = verificarCriticasCampos("CPF");
			if (!message.isEmpty())
				return message;

			screenShot();
			scroll(75, 1, 1);

			String telefone = mapTestCase.get("Telefone");
			if (telefone.equalsIgnoreCase("#telefone")) {
				telefone = tools.getPhoneNumberRandom();

				System.out.println("Telefone: " + telefone);
			}
			sendKeysAnnotations(userElements.edtTelefone, telefone);
			message = verificarCriticasCampos("Telefone");
			if (!message.isEmpty())
				return message;
			String senha = mapTestCase.get("SenhaCadastro");
			sendKeysAnnotations(userElements.edtSenha, senha);
			message = verificarCriticasCampos("Senha");
			if (!message.isEmpty())
				return message;
			sendKeysAnnotations(userElements.edtConfirmarSenha, senha);
			message = verificarCriticasCampos("Senha");
			if (!message.isEmpty())
				return message;

			Tools.logCadastro = Tools.logCadastro + divisor + senha;

			tap(userElements.chkMaiorIdade);
			screenShot();
			scroll(90, 20, 1);
			tap(userElements.btnConcluir);
			waitLoading();
			if (!message.isEmpty())
				return message;
			Permissoes permissoes = new Permissoes();
			permissoes.verificarPermissoes();
			message = verificarCadastroInválido();
			if (!message.isEmpty())
				return message;
			Tools.logCadastro = Tools.logCadastro + divisor + Tools.getDate() + "\n";
			Tools.writeInCSV(Tools.logCadastro);
		} catch (Exception e) {
			message = "[Cadastro] Falha ao preencher campos";
			e.printStackTrace();
//		} finally {
//			screenShot();
		}
		return message;
	}
	

	public String cadastroInválido(String tipo) {
		message = "";
		Tools.logCadastro = "";
		try {

			tap(userElements.btnCadastrar);
			screenShot();
			switch (tipo) {
			case "email":
				message = preencheEmailNome();
				break;
			case "gmail":
				Gmail();
				break;
			case "facebook":
				Facebook();
				break;
			}
			if (!message.isEmpty())
				return message;

			String cpf = mapTestCase.get("CPF");
			if (cpf.equalsIgnoreCase("#CPF")) {
				cpf = gerador.cpf();
			}
			Tools.logCadastro = Tools.logCadastro + divisor + cpf;
			sendKeysAnnotations(userElements.edtCpf, cpf);
			message = verificarCriticasCampos("CPF");
			if (!message.isEmpty())
				return message;

			screenShot();
			scroll(75, 1, 1);

			String telefone = mapTestCase.get("Telefone");
			if (telefone.equalsIgnoreCase("#telefone")) {
				telefone = tools.getPhoneNumberRandom();

				System.out.println("Telefone: " + telefone);
			}
			sendKeysAnnotations(userElements.edtTelefone, telefone);
			message = verificarCriticasCampos("Telefone");
			if (!message.isEmpty())
				return message;
			String senha = mapTestCase.get("SenhaCadastro");
			sendKeysAnnotations(userElements.edtSenha, senha);
			message = verificarCriticasCampos("Senha");
			if (!message.isEmpty())
				return message;
			sendKeysAnnotations(userElements.edtConfirmarSenha, senha);
			message = verificarCriticasCampos("Senha");
			if (!message.isEmpty())
				return message;
			Tools.logCadastro = Tools.logCadastro + divisor + senha;

			tap(userElements.chkMaiorIdade);
			scroll(90, 20, 1);
			
			message = verificarBtnConcluir();
		} catch (Exception e) {
			message = "[Cadastro] Falha ao preencher campos";
			e.printStackTrace();
		} finally {
			screenShot();

		}
		return message;
	}
	
	public String cadastro(String tipo) {
		message = "";
		Tools.logCadastro = "";
		try {

			tap(userElements.btnCadastrar);
			screenShot();
			switch (tipo) {
			case "email":
				message = preencheEmailNome();
				break;
			case "gmail":
				Gmail();
				break;
			case "facebook":
				Facebook();
				break;
			}
			if (!message.isEmpty())
				return message;

			String cpf = mapTestCase.get("CPF");
			if (cpf.equalsIgnoreCase("#CPF")) {
				cpf = gerador.cpf();
			}
			Tools.logCadastro = Tools.logCadastro + divisor + cpf;
			sendKeysAnnotations(userElements.edtCpf, cpf);
			message = verificarCriticasCampos("CPF");
			if (!message.isEmpty())
				return message;

			screenShot();
			scroll(75, 1, 1);

			String telefone = mapTestCase.get("Telefone");
			if (telefone.equalsIgnoreCase("#telefone")) {
				telefone = tools.getPhoneNumberRandom();

				System.out.println("Telefone: " + telefone);
			}
			sendKeysAnnotations(userElements.edtTelefone, telefone);
			message = verificarCriticasCampos("Telefone");
			if (!message.isEmpty())
				return message;
			String senha = mapTestCase.get("SenhaCadastro");
			sendKeysAnnotations(userElements.edtSenha, senha);
			message = verificarCriticasCampos("Senha");
			if (!message.isEmpty())
				return message;
			sendKeysAnnotations(userElements.edtConfirmarSenha, senha);
			message = verificarCriticasCampos("Senha");
			if (!message.isEmpty())
				return message;

			Tools.logCadastro = Tools.logCadastro + divisor + senha;

			tap(userElements.chkMaiorIdade);
			screenShot();
			scroll(90, 20, 1);
			tap(userElements.btnConcluir);
			waitLoading();
			message = verificarCriticas();
			if (!message.isEmpty())
				return message;
			Permissoes permissoes = new Permissoes();
			permissoes.verificarPermissoes();
			message = verificarSeEstaNaTelaInicial();
			if (!message.isEmpty())
				return message;
			Tools.logCadastro = Tools.logCadastro + divisor + Tools.getDate() + "\n";
			Tools.writeInCSV(Tools.logCadastro);
		} catch (Exception e) {
			message = "[Cadastro] Falha ao preencher campos";
			e.printStackTrace();
		} finally {
			screenShot();

		}
		return message;
	}

	
	
	public String preencheEmailNome() {
		message = "";
		try {
			String email = mapTestCase.get("EmailCadastro");
			if (email.equalsIgnoreCase("#email")) {
				email = tools.getEmailRandom();
			}

			Tools.logCadastro = email;
			sendKeysAnnotations(userElements.edtEmail, email);
			message = verificarCriticasCampos("Email");
			if (!message.isEmpty())
				return message;

			String nome = mapTestCase.get("Nome");
			if (nome.equalsIgnoreCase("#nome")) {
				nome = tools.getNameRandom();
			}

			sendKeysAnnotations(userElements.edtNome, nome);
			message = verificarCriticasCampos("Nome");

		} catch (Exception e) {
			message = "Falha ao preencher email e nome";
			e.printStackTrace();
		} finally {
			//screenShot();
		}
		return message;
	}

	public String verificarCriticasCampos(String campo) {

		message = "";
		try {
			// Email
			String msgEmailCurto = "//android.widget.TextView[@text='E-Mail muito curto.']";
			//String msgEmailInvalido = "//android.widget.TextView[@text='E-Mail inválido.']";
			
			// Senha
			String senhaMin = "//android.widget.TextView[@text='Senha requer pelo menos 8 caracteres.']";
			String msgSenhaLetraObrig = "//android.widget.TextView[@text='Pelo menos uma letra minuscula é obrigatória.']";
			String msgSenhaCaracObrig = "//android.widget.TextView[@text='Senha requer pelo menos uma letra maiúscula e um caractere especial.']";
			String msgSenhasDiferem = "//android.widget.TextView[@text='Senhas diferem.']";
			// CPF
			String msgCpfInvalido = "//android.widget.TextView[@text='CPF inválido.']";
			// Telefone
			String msgTelCurto = "//android.widget.TextView[@text='Número de telefone muito curto']";

			// Nome
			String msgSobrenomeObrigatorio = "//android.widget.TextView[@text='Sobrenome é obrigatório.']";

			switch (campo) {
			case "Email":
				if (isPresent(By.xpath(msgEmailCurto))) {
					message = "E-Mail muito curto.";
				}
			
			case "CPF":
				if (isPresent(By.xpath(msgCpfInvalido))) {
					message = "CPF inválido.";
				}
				break;
			case "Senha":

				if (isPresent(By.xpath(senhaMin))) {
					message = "Senha requer pelo menos 8 caracteres.";
				}
				if (isPresent(By.xpath(msgSenhaLetraObrig))) {
					message = "Pelo menos uma letra minuscula é obrigatória.";
				}
				if (isPresent(By.xpath(msgSenhaCaracObrig))) {
					message = "Senha requer pelo menos uma letra maiúscula e um caractere especial.";
				}
				if (isPresent(By.xpath(msgSenhasDiferem))) {
					message = "Senhas diferem.";
				}
				break;
			case "Telefone":
				if (isPresent(By.xpath(msgTelCurto))) {
					message = "Número de telefone muito curto.";
				}
			case "Nome":
				if (isPresent(By.xpath(msgSobrenomeObrigatorio))) {
					message = "Sobrenome é obrigatório";
				}
				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "Falha ao verificar criticas em campos";
		}
		return message;
	}

	/**
	 * Verifica se o sistema apresentou alguma critica após salvar o cadastro
	 * 
	 * @return
	 */
	public String verificarCriticas() {
		message = "";

		try {
			screenShot();
			System.out.println("Validando criticas do sistema");
			
			if (isPresent(userElements.msgEmailExistente)) {
				message = "Email existente. Email existente.";
				System.out.println(message);
			} else {
				System.out.println("Não apresentou a mensagem");
			}
			if (isPresent(userElements.msgCPFJaRegistrado)) {
				message = "CPF informado já está registrado no sistema.";
				System.out.println(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	public String recuperarSenha() {
		message = "";

		try {
			tap(userElements.btnEntreAqui);
			Thread.sleep(1000);
			screenShot();
			tap(userElements.btnEsqueciMinhaSenha);
			sendKeysAnnotations(userElements.edtCPFRecuperacao, mapTestCase.get("CPF"));
			screenShot();
			Thread.sleep(1000);
			tap(userElements.btnRecuperarSenha);
			wait.until(ExpectedConditions.visibilityOf(userElements.txtEmailRecuperacaoEnviado));
			//screenShot();
		} catch (Exception e) {
			message = "Falha ao recuperar senha";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}

}