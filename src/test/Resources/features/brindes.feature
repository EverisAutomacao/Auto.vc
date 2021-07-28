# language: pt
@Brindes @Deslogado
Funcionalidade: Brindes
  Como usuário desejo ver meus brindes

  Contexto: 
    Dado que o usuário possua os brindes

  @AgendaDoCarro 
  Cenário: Deve ver detalhes do brinde Agenda do Carro
    Dado que o usuário esteja na tela minha carteira
    Quando selecionar o brinde Agenda do Carro
    Então os detalhes do brinde serão exibidos corretamente

  @CheckUpAutomotivo
  Cenário: Deve ver detalhes do brinde Check Up Automotivo
    Dado que o usuário esteja na tela minha carteira
    Quando selecionar o brinde Check Up Automotivo
    Então os detalhes do brinde serão exibidos corretamente

  @Smiles
  Cenário: Deve ver detalhes do brinde Smiles
    Dado que o usuário esteja na tela minha carteira
    Quando selecionar o brinde Smiles
    Então os detalhes do brinde serão exibidos corretamente
