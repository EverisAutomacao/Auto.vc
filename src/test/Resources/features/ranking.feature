# language: pt
@Ranking @pular
Funcionalidade: Ranking
  Como usuário desejo visualizar meu ranking

@RankingAmigos
  Cenário: deve visualizar o Ranking de Amigos
    Dado que o usuário esteja na tela Ranking
    Quando selecionar Ranking de Amigos
    Então o Ranking de Amigos será exibido
    
@RankingGeral
  Cenário: deve visualizar o Ranking Geral
    Dado que o usuário esteja na tela Ranking
    Quando selecionar Ranking Geral
    Então o Ranking Geral será exibido
    
@RankingKms
  Cenário: deve visualizar o Ranking Por Kms
    Dado que o usuário esteja na tela Ranking
    Quando selecionar Ranking Por Kms
    Então o Ranking Por Kms será exibido
    
@RankingViagens
  Cenário: deve visualizar o Ranking Por Viagens
    Dado que o usuário esteja na tela Ranking
    Quando selecionar Ranking Por Viagens
    Então o Ranking Por Viagens será exibido
