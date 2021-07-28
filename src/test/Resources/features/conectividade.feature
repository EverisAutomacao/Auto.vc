#language: pt
@Deslogado @pular
Funcionalidade: Conectividade
      JIRA-XPTO 
  Como usuario desejo realizar cadastro/login no sistema

  Contexto: 
    Dado que o usuário aceite os termos e leia o Tour Inicial

  Cenário: Realizar tentativa login sem conexão no dispostivo
    Dado que o usuário esteja na tela de login
    Quando acionar o login por email e informar seus dados
    Então receberá uma critica do distema

  Cenário: Tentativa de cadastro sem conexão
    Dado que o usuário acionou o botão cadastrar
    E informou seu email
    Quando preencher os demais campos e confirmar
    Então receberá uma critica do sistema
