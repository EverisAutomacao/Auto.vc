# language: pt
@Deslogado
Funcionalidade: Cadastrar usuário
  JIRA: XPTO
  Como usuário desejo criar um cadastro no aplicativo

  Contexto: 
    Dado que o usuário aceite os termos e leia o Tour Inicial

  @CadastroEmail
  Cenário: Realizar cadastro com e-mail
    Dado que o usuário acionou o botão cadastrar
    E informou seu email
    Quando preencher os demais campos e confirmar
    Então será cadastrado com sucesso
