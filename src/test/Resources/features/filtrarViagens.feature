# language: pt
@Deslogado
@FiltrarViagens
Funcionalidade: Detalhes de Viagens
Como usuário desejo ver detalhes das minhas viagens


Contexto:
	Dado que o usuário possua viagens como passageiro e motorista

@ViagensComoMotorista
Cenário: Deve ver detalhes de uma viagem
	Dado que o usuário esteja na tela minhas viagens
	Quando selecionar o filtro motorista
	Então somente as viagens como motorista serão exibidas

@ViagensComoPassageiro
Cenário: Deve ver detalhes de uma viagem
	Dado que o usuário esteja na tela minhas viagens
	Quando selecionar o filtro passageiro
	Então somente as viagens como passageiro serão exibidas
