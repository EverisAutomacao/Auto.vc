#language: pt
@Deslogado @pular
Funcionalidade: Login
      JIRA-XPTO 
  Como usuario desejo realizar login no sistema através do gmail, facebook ou email e verificar meus dados

Contexto: 
    Dado que o usuário aceite os termos e leia o Tour Inicial

@LoginEmail
  Cenário: Realizar novo login utilizando e-mail
    Dado que o usuário esteja na tela de login
    Quando acionar o login por email e informar seus dados
    Então será direcionado para tela inicial

@LoginFacebook
  Cenário: Realizar novo login utilizando facebook
    Dado que o usuário esteja na tela de login
    Quando acionar o login por facebook e informar seus dados
    Então será direcionado para tela inicial

@LoginGmail
  Cenário: Realizar novo login utilizando gmail
    Dado que o usuário esteja na tela de login
    Quando acionar o login por gmail e informar seus dados
    Então será direcionado para tela inicial
