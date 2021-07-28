# language: pt

Funcionalidade: Desconto de amigos
  Como usuário desejo receber desconto ao convidar amigos

@ConvidarAmigos
  Cenário: Deve enviar convites para amigos
    Dado que o usuário esteja na tela desconto de amigos
    Quando clicar em convide seus amigos
    Então será exibido um painel permitindo o envio do convite
