# language: pt
@Versao
Funcionalidade: Configurações
  Como usuário desejo verificar minha versão do aplicativo

  Contexto: 
    Dado que o usuário esteja logado

 
  Cenário: Deve visualizar a versão atual
    Dado que o usuário esteja na tela de configurações
    Quando acessar a versão do aplicativo
    Então a versão estara igual a esperada
