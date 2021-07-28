# language: pt
Funcionalidade:  Tela de permissão
JIRA: XPTO

@Permissoes @Deslogado
  Cenário: Habilitar todas as permissões 
    Dado que esteja na tela de permissões do app
    Quando fornecer as permissões
    Então o app avança para a tela principal automáticamente
