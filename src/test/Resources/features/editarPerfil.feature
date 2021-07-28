# language: pt
Funcionalidade: Editar Perfil do Usuário
  Como usuário desejo atualizar meus dados

  Contexto: 
    Dado que o usuário esteja logado

 @EditarAvatar
  Cenário: deve editar o avatar do perfil
    Dado que o usuário esteja na tela editar perfil
    Quando selecionar um avatar e salvar
    Então o avatar é modificado com sucesso

 @EditarPerfil
  Cenário: Deve editar o perfil
    Dado que o usuário esteja na tela editar perfil
    Quando modificar uma informação e salvar
    Então o perfil é alterado com sucesso
