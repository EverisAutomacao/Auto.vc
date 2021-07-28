# language: pt
@Web
Funcionalidade: Cupons
  Como usuário desejo ver meus cupons

@LandingPage
  Cenário: Deve se cadastrar através do link de convite
    Dado que o usuário possua um link de convite
    Quando acessar o link e preencher as informações
    Então o cadastro é efetuado com sucesso
