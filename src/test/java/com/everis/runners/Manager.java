package com.everis.runners;

import java.lang.reflect.Method;

import com.everis.excel.Dados;
import com.everis.page.CarteiraAutoVc;
import com.everis.page.Common;
import com.everis.page.Configuracoes;
import com.everis.page.Contrato;
import com.everis.page.Convite;
import com.everis.page.Cotacao;
import com.everis.page.LandingPage;
import com.everis.page.Manifestacao;
import com.everis.page.MinhasViagens;
import com.everis.page.Perfil;
import com.everis.page.Permissoes;
import com.everis.page.Ranking;
import com.everis.page.Termos;
import com.everis.page.Usuario;
import com.everis.utils.DriverFactory;
import com.everis.utils.Tools;

/**
 * Controla qual funcionalidade deve ser executada
 * 
 * @author Michael Batista
 *
 */
public class Manager extends Dados {
	String message = "";
	// Instanciando classes ================================

	Usuario usuario;
	Termos termos;
	Common common;
	Configuracoes config;
	Perfil perfil;
	Contrato contrato;
	CarteiraAutoVc carteiraAutoVc;
	LandingPage land;
	Permissoes permissoes;
	Ranking ranking;
	Manifestacao manifestacao;
	MinhasViagens minhasViagens;
	Cotacao cotacao;
	Convite convite;

	Manager(String platform) {
		// Se a plataforma for web
		if (platform.equalsIgnoreCase("Web")) {
			land = new LandingPage();
			cotacao = new Cotacao();
			// se for android ou ios
		} else {
			usuario = new Usuario();
			termos = new Termos();
			common = new Common();
			config = new Configuracoes();
			perfil = new Perfil();
			contrato = new Contrato();
			carteiraAutoVc = new CarteiraAutoVc();
			permissoes = new Permissoes();
			ranking = new Ranking();
			manifestacao = new Manifestacao();
			minhasViagens = new MinhasViagens();
			convite = new Convite();
		}
	}
	// ====================================================

	/**
	 * Chama o método de execução Atualmente não esta sendo usada no projeto
	 * 
	 * @throws Exception
	 */
//	public void callExecution() throws Exception {
//		String func = mapTestCase.get("Funcionalidade");
//		Class<?> c = Class.forName("com.everis.runners");
//		Object obj = c.newInstance();
//		Method setNameMethod = obj.getClass().getMethod(func);
//		setNameMethod.invoke(obj);
//	}

	public String executar(String funcionalidade) {
		switch (funcionalidade) {

		// Versao ==================================================
		case "Versão":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = usuario.verificarSeEstaNaTelaInicial();
			message = common.acessarMenu("Editar Configurações");
			if (!message.isEmpty())
				return message;
			message = config.verificarVersao();
			break;
		// Login Email ==================================================
		case "Login Email":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.loginEmail();
			if (!message.isEmpty())
				return message;
			message = usuario.verificarSeEstaNaTelaInicial();
			break;

		// Login Email Sem Viagens==================================================
		case "Login Email Sem Viagens":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.loginEmail();
			if (!message.isEmpty())
				return message;
			message = usuario.verificarSeEstaNaTelaInicial();
			break;
		// Login Email Manipulado 3 viagens <70==================================================
		case "Login Email Manipulado 3 viagens score>70":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.loginEmail();
			if (!message.isEmpty())
				return message;
			message = usuario.verificarSeEstaNaTelaInicial();
			break;

		// Login Gmail ==================================================
		case "Login Gmail":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.loginGmail();
			if (!message.isEmpty())
				return message;
			message = usuario.verificarSeEstaNaTelaInicial();
			break;
		// Login Facebook ==================================================
		case "Login Facebook":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;

			message = usuario.loginFacebook();
			message = usuario.verificarSeEstaNaTelaInicial();
			if (!message.isEmpty())
				return message;
			break;

		// Cadastro Email ==============================================
		case "Cadastro Email":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.cadastro("email");
			if (!message.isEmpty())
				return message;
			break;
		case "Cadastro Gmail":
			message = "Cadastro Gmail indisponível";
			break;

		// Cadastro Email Inválido ==============================================
		case "Cadastro Já existente":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.cadastroJaExistente("email");
			if (!message.isEmpty())
				return message;
			break;

		// Cadastro Email Inválido ==============================================
		case "Cadastro Email Inválido":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.cadastroInválido("email");
			if (!message.isEmpty())
				return message;
			break;

		// Tour Inicial ==============================================
		case "Tour Inicial":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.tourInicial();
			break;

		// Recuperar senha ============================================
		case "Recuperar Senha":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.recuperarSenha();
			if (!message.isEmpty())
				return message;

			break;
		// Editar Perfil ===============================================
		case "Editar Perfil":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = common.acessarMenu("Editar Perfil");
			if (!message.isEmpty())
				return message;
			message = perfil.editarPerfil();
			break;
		// Verficar Perfil ===============================================
		case "Verificar Perfil":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = perfil.verificaPerfil();
			if (!message.isEmpty())
				return message;
			break;

		// Editar Avatar ===============================================
		case "Editar Avatar":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = common.acessarMenu("Editar Perfil");
			if (!message.isEmpty())
				return message;
			message = perfil.editarAvatar();
			break;

		// Declaração de Privacidade ====================================
		case "Declaração de Privacidade":
			message = contrato.validarDeclaracaoDePrivacidade();
			break;

		// Regulamento =================================================
		case "Regulamento":
			message = contrato.lerContratoDeLicenca();
			if (!message.isEmpty())
				return message;
			message = contrato.verRegulamento();
			break;
		// Email Auto.Vc ================================================
		case "Email Auto.Vc":
			message = contrato.lerContratoDeLicenca();
			if (!message.isEmpty())
				return message;
			message = contrato.clicarEmailAutovc();
			break;

		// Usuário sem viagem - Cards ================================================
		case "Usuario sem viagem - Cards":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = usuario.verificarSeEstaNaTelaInicial();
			message = carteiraAutoVc.telaInicialCapturaCards();
			if (!message.isEmpty())
				return message;
			break;

		// Usuario sem viagem - Brindes ================================================
		case "Usuario sem viagem - Brindes":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.minhaCarteiraAutoVc();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.capturaTelaBrindes();
			if (!message.isEmpty())
				return message;
			break;

		// Usuario sem viagem - Cupons ================================================
		case "Usuario sem viagem - Cupons":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.minhaCarteiraAutoVc();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.capturaTelaCupons();
			if (!message.isEmpty())
				return message;
			break;
			
			// Usuário com 3 viagens - Cards ================================================
		case "Usuario com 3 viagens - Progresso Card":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = usuario.verificarSeEstaNaTelaInicial();
			message = carteiraAutoVc.telaInicialCapturaCardDirecao();
			if (!message.isEmpty())
				return message;
			break;
			// Usuário com 3 viagens - Brindes ================================================
			case "Usuario com 3 viagens - Brinde Desconto Iniciante":
				message = common.verificaLogin();
				if (!message.isEmpty())
					return message;
				message = usuario.verificarSeEstaNaTelaInicial();
				message = carteiraAutoVc.minhaCarteiraAutoVc();
				if (!message.isEmpty())
					return message;
				message = carteiraAutoVc.capturaTelaBrindeDescontoIniciante();
				if (!message.isEmpty())
					return message;
				break;

		// Sem brindes ================================================
		case "Sem Brinde":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.loginEmail();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.minhaCarteiraAutoVc();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.semCupom();
			break;

		// Sem brindes Desconto Iniciante
		// ================================================
		case "Sem Brinde Desconto Iniciante":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.minhaCarteiraAutoVc();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.semBrindeIniciante();
			break;

		// Agenda do Carro ================================================
		case "Agenda do Carro":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = usuario.verificarSeEstaNaTelaInicial();
			message = carteiraAutoVc.minhaCarteiraAutoVc();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.validarBrindeAgendaDoCarro();
			break;
			

		// Check Up Automotivo ================================================
		case "Check Up Automotivo":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.minhaCarteiraAutoVc();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.validarBrindeCheckUpAutomotivo();
			break;

		// Smiles ================================================
		case "Smiles":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.minhaCarteiraAutoVc();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.validarSmiles();
			break;

		// Desconto Seguro ================================================
		case "Desconto Seguro":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.loginEmail();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.minhaCarteiraAutoVc();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.validarCupom("Desconto Seguro");
			break;

		// Gerar Cupom Largada ================================================
		case "Gerar Cupom Largada":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.minhaCarteiraAutoVc();
			if (!message.isEmpty())
				return message;
			message = carteiraAutoVc.gerarCupomLargada();
			break;

		// Gerar link de convite ================================================
		case "Gerar link de convite":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = common.acessarMenu("Desconto de amigos");
			if (!message.isEmpty())
				return message;
			message = convite.copiarLinkConvite();// falha ao tentar colar ou imprimir link após copiar
			break;
		// Compartilhar cupom =================================================
		case "Convidar via Gmail":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = common.acessarMenu("Desconto de amigos");
			if (!message.isEmpty())
				return message;
			message = convite.convidarViaGmail();
			break;
		// Cadastro Landing Page ================================================
		case "Cadastro Landing Page":
			message = land.cadastrarUsuario();
			if (!message.isEmpty())
				return message;
			message = land.cadastroSalvar();
			break;

		// Permissões ================================================
		case "Permissões":
			message = termos.concordar();
			if (!message.isEmpty())
				return message;
			message = common.pularTourInicial();
			if (!message.isEmpty())
				return message;
			message = usuario.loginEmail();
			if (!message.isEmpty())
				return message;
			message = permissoes.verificarPermissoes();
			if (!message.isEmpty())
				return message;
			message = permissoes.fornecerPermissoesIndividual();
			if (!message.isEmpty())
				return message;
			message = usuario.verificarSeEstaNaTelaInicial();

			break;

		// Ranking Geral ================================================
		case "Ranking Geral":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = ranking.acessarTelaRanking();
			if (!message.isEmpty())
				return message;
			message = ranking.popupAlterarApelido(false);
			if (!message.isEmpty())
				return message;
			message = ranking.verRankingGeral();
			break;

		// Ranking de Amigos ================================================
		case "Ranking de Amigos":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = ranking.acessarTelaRanking();
			if (!message.isEmpty())
				return message;
			message = ranking.popupAlterarApelido(false);
			if (!message.isEmpty())
				return message;
			message = ranking.verRankingDeAmigos();
			break;

		// Ranking por Viagens ================================================
		case "Ranking por Viagens":
			// message = common.verificaLogin();
			// if (!message.isEmpty())
			// return message;
			message = ranking.acessarTelaRanking();
			if (!message.isEmpty())
				return message;
			message = ranking.popupAlterarApelido(false);
			if (!message.isEmpty())
				return message;
			message = ranking.verRankingPorNumViagens();
			break;
		// Ranking por KM ================================================
		case "Ranking por KM":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = ranking.acessarTelaRanking();
			if (!message.isEmpty())
				return message;
			message = ranking.popupAlterarApelido(false);
			if (!message.isEmpty())
				return message;
			message = ranking.verRankingPorKm();
			break;
		// Manifestação ================================================
		case "Manifestação":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = common.acessarMenu("FAQ");
			if (!message.isEmpty())
				return message;
			message = manifestacao.abrirManifestacao();
			break;
		// Confirmar viagens como Motorista
		// ================================================
		case "Confirmar viagens como Motorista":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = minhasViagens.confirmarViagensComo("Motorista");
			if (!message.isEmpty())
				return message;
			break;
		// Confirmar viagens como Passageiro
		// ================================================
		case "Confirmar viagens como Passageiro":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = minhasViagens.confirmarViagensComo("Passageiro");
			if (!message.isEmpty())
				return message;
			break;
		// Validar viagem ================================================
		case "Validar Viagem":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = minhasViagens.validarViagem();
			break;
		// Viagens como Motorista ================================================
		case "Filtro Viagens Motorista":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = minhasViagens.filtrarViagensComo("Motorista");
			if (!message.isEmpty())
				return message;
			message = minhasViagens.validarViagensComo("Motorista");
			break;
		// Viagens como Passageiro ================================================
		case "Filtro Viagens Passageiro":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = minhasViagens.filtrarViagensComo("Passageiro");
			if (!message.isEmpty())
				return message;
			message = minhasViagens.validarViagensComo("Passageiro");
			break;
		// Convidar Amigos ================================================
		case "Convidar Amigos":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
			message = ranking.convidarAmigo();
			break;
		// Recusar Convite ================================================
		case "Rejeitar Convite":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
//			message = common.verNotificacoes();
//			if (!message.isEmpty())
//				return message;
			message = ranking.verConvite();
			if (!message.isEmpty())
				return message;
			message = ranking.rejeitarConvite();
			break;
		// Aceitar Convite ================================================
		case "Aceitar Convite":
			message = common.verificaLogin();
			if (!message.isEmpty())
				return message;
//			message = common.verNotificacoes();
//			if (!message.isEmpty())
//				return message;
			message = ranking.verConvite();
			if (!message.isEmpty())
				return message;
			message = ranking.aceitarConvite();
			break;
		// Viagens como Passageiro ================================================
		case "Calcular":
			message = cotacao.lerDadosLinha();
			if (!message.isEmpty())
				return message;
			message = cotacao.login();
			if (!message.isEmpty())
				return message;
			message = cotacao.calcular();// falha
			if (!message.isEmpty())
				return message;
			message = cotacao.validarCupom();
			break;


		default:
			message = "Funcionalidade [" + funcionalidade + "] não encontrado";
			break;
		}
		return message;
	}

}
