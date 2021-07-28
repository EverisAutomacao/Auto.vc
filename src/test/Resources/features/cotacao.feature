# language: pt
@Web @pular
Funcionalidade: Calculo
  Como corretor quer relizar uma cotação utilizando cupom de desconto

@Calcular
  Cenário: Deve criar uma cotação
    Dado que o usuário possou um cupom de desconto
    Quando criar uma cotação
    Então será apresentado o cupom de desconto
