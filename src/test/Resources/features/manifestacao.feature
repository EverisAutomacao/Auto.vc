# language: pt
Funcionalidade: Manifestação
  JIRA: XPTO
  Como usuario desejo abrir um chamado no SAC

  Contexto: 
    Dado que o usuário esteja logado no sistema

	@Manifestacao
  Cenário: deve abrir uma nova manifestação
    Dado que o usuário esteja na tela de manifestação
    Quando quando preenche os dados obrigatórios
    E clica no botão enviar
    Então a manifestação é criada com sucesso