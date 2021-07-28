# Telemetria

### Descrição do Projeto
Este projeto é um script de testes regressivos automatizados da aplicação mobile <b>SulAmérica Auto.Vc</b>
### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua maquina as seguinte ferramentas:
[Microsoft Excel](), [Appium Desktop](http://appium.io/downloads.html), [Git](), [Eclipse IDE]()
Dispositivo físico ou virtual com sistema Android 5.0 ou superior
### Executando os testes
- Faça a instalação do aplicativo [App Auto.Vc](https://play.google.com/store/apps/details?id=br.com.sulamerica.autovc) em seu dispositivo.
Caso esteja utilizando um dispositivo físico e seja a primeira vez em que o projeto é executado, será necessário habilitar a <b>Depuração USB</b>. A forma de habilitar essa configuração varia muito de acordo com o dispostivo, por isso recomendo que faça uma pesquisa de acordo com o modelo.
- Clone este repositório em sua máquina:
```sh
$ git clone https://github.com/EverisAutomacao/SAS_Telemetria.git
```
- Após clonar o projeto, abra a planilha de testes, localizada no caminho:  LocalDoProjeto\Telemetria\data\AutoVC.xlsx
- Na folha "Testes" marque a coluna "Executar?" com o valor "Sim" de acordo com os testes que deseja executar.
- Inicie o servidor do appium destktop
- Abra o Eclipse, importe o projeto como "Existing Maven Project" e aguarde o maven baixar as dependencias do projeto.
- A execução inicia através da classe 'Automation.java' localizada no pacote 'com.everis.runners'
### Tecnologias
As seguintes ferramentas foram usadas na construção do projeto
- [JAVA]() - Linguagem de programação
- [jUnit]() - Suporte á criação de testes automatizados
- [Apache Poi]() - Biblioteca resposável pela leitura da panilha Excel