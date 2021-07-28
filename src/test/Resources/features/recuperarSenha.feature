# language: pt
@Deslogado
Funcionalidade: Recuperar senha
  JIRA: XPTO
  @RecuperarSenha
  Cenário: deve recuperar a senha do usuário
    Dado que o usuário esteja na tela recuperar senha
    Quando quando informar seu email e confirmar
    Então o sistema retornará uma mensagem.
