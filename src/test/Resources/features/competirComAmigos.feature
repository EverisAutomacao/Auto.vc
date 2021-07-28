# language: pt
@CompetirComAmigos @Deslogado @pular
Funcionalidade: Competir com amigos
  Como usuário desejo competir com meus amigos

@ConvidarParaRanking
  Cenário: Deve chamar amigos para competir
    Dado que esteja na tela de convite
    Quando informar o email do amigo e clicar em convidar
    Então aparecerá uma mensagem de confirmação de envio
    
@RecusarConvite
  Cenário: Deve recusar um convite
    Dado que o usuário recebeu um convite
    Quando recusar o convite
    Então o amigo não será exibido no ranking


@ConvidarParaRanking 
  Cenário: Deve chamar amigos para competir 2
    Dado que esteja na tela de convite
    Quando informar o email do amigo e clicar em convidar
    Então aparecerá uma mensagem de confirmação de envio

    
@AceitarConvite
  Cenário: Deve aceitar um convite
    Dado que o usuário recebeu um convite
    Quando aceitar o convite
    Então o amigo será exibido no ranking
