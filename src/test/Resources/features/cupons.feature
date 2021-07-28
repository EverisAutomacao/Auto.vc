# language: pt
@Cupons @Deslogado
Funcionalidade: Cupons
  Como usuário desejo ver meus cupons

 Contexto: 
    Dado que o usuário possua um cupom disponível para gerar
@pular
@GerarCupomLargada
  Cenário: Deve gerar um cupom de largada
    Dado que o usuário esteja na tela minha carteira AutoVc
    Quando acionar o botão Gerar cupom de desconto
    Então o cupom será gerado com sucesso

  @VerDetalhesCupomLargada
  Cenário: Deve ver detalhes do cupom de largada
    Dado que o usuário esteja na tela minha carteira AutoVc
    E possua um cupom de largada
    Quando acessar o cupom
    Então os dados do cupom serão exibidos corretamente  