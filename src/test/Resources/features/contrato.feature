# language: pt
@Deslogado @Politicas
Funcionalidade: Política de uso de dados

  @PoliticasDePrivacidade
  Cenário: Deve visualizar as políticas de privacidade
    Dado que o usuário esteja na tela contrato de licença
    Quando clicar no link políticas de privacidade
    Então abrira uma pagina web com as politicas

  @ConcordarComContrato
  Cenário: Deve concordar com o contrato
    Dado que o usuário esteja na tela contrato de licença
    Quando clicar no botão li e concordo
    Então avançará para tela declaração de privacidade

  @Regulamento
  Cenário: Deve visualizar o regulamento do programa
    Dado que o usuário esteja na tela declaração de privacidade
    Quando clicar no link sobre o regulamento
    Então abrira um PDF contendo o regulamento

  @EmailAutoVc
  Cenário: Deve abrir o email
    Dado que o usuário esteja na tela declaração de privacidade
    Quando clicar no link do email
    Então abrira abrira o aplicativo de email do celular

  @Concordar
  Cenário: Deve concordar com a declaração
    Dado que o usuário esteja na tela declaração de privacidade
    Quando ler e concordar com os termos
    Então avançará para a tela tour inicial
