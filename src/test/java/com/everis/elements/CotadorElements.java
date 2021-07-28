package com.everis.elements;

import org.openqa.selenium.By;

public class CotadorElements {
	
	public By inputUsername = By.xpath("//input[@id='wtLoginWB:wtUser_Username']");
	public By inputUpassword = By.xpath("//input[@id='wtLoginWB:wtUser_Password']");
	public By btnEntrar = By.xpath("//input[@id='wtLoginWB:wtEntrarBtn']/..");
	public By spanError = By.xpath("//span[text()='Não foi possível autenticar.']");
	
	public By calculista = By.xpath("(//div[@class='NomeCalculista'][.='Roboo'])[1]");
	public By inputCPF = By.xpath("//legend[text()='CPF/CNPJ:']/..//input");
	public By inputNome = By.xpath("//legend[text()='Nome']/..//input");
	public By inputNascimento = By.xpath("//input[@automacao='DataNascimento']");
	public By inputSexoM = By.xpath("//input[@automacao='OptMasculino']");
	public By inputSexoF = By.xpath("//input[@automacao='OptFeminino']");
	public By inputCep = By.xpath("//legend[text()='CEP-Residência']/..//input");
	public By inputCepPernoite = By.xpath("//legend[text()='CEP-Pernoite']/..//input");
	public By inputCepPernoiteIgual = By.xpath("//input[@automacao='OptCEPIguais_Sim']");
	public By cmbTipoResidencia = By.xpath("//legend[text()='Tipo de Residência']/..//select");
	public By inputPlaca = By.xpath("//legend[text()='Placa']/..//input");
	public By cmbUf = By.xpath("//legend[text()='UF']/..//select");
	public By inputChassi = By.xpath("//legend[text()='Chassi']/..//input");
	public By inputAnoModelo = By.xpath("//legend[text()='Ano Modelo']/..//input");

	public By cmbFabricante = By.xpath("//select[@automacao='Fabricante']");

	public By inputModelo = By.xpath("//input[@automacao='Modelo']");
	public By cmbCombustivel = By.xpath("//legend[text()='Combustível']/..//select");
	public By cmbUso = By.xpath("//legend[text()='USO']/..//select");
	public By cmbInsecaoTributaria = By.xpath("//legend[text()='Isenção Tributária']/..//select");
	public By inputPrincipalCondutor = By.xpath("//input[contains(@id,'PrincipalCondutorProprioSeguradoCheckbox')]");
	public By cmbEstadoCivil = By.xpath("//legend[text()='Estado Civil']/..//select");
	public By inputQarNao = By.xpath("//input[@automacao='QAR_Estender_18a15_Nao']");
	public By btnCalcular = By.xpath("//input[@automacao='btn_calcular']");

	public By modeloSelecionado = By.xpath("//div[@automacao='autocompleteList'][contains(@class,'active')]");
	public By loading = By.xpath("//div[contains(text(),'Aguarde enquanto o conteúdo é  carregado...')]");
	public By loading2 = By.xpath("//div[@class='Feedback_AjaxWait_OVERRRIDE']");
	public By modalTelemetria = By.xpath("//div[@automacao='modalTelemetria']");
	public By codigoCupom = By.xpath("//div[@automacao='BoxTelem0']/div/div[2]/span");
	public By validadeCupom = By.xpath("//div[contains(text(),'Válido até')]/span");
	public By inputCupom = By.xpath("//input[@automacao='radioTelemetria0']");
	public By btnCalcularTelemetria = By.xpath("//input[@automacao='okTelemetria']");

	public By txtDescontoAplicado = By.xpath("//div[@class='divContentCupom']/div[contains(text(),'DESCONTO APLICADO')]");
	
	public By codigoFipePreenchido = By.xpath("//span[@automacao='CodigoFipe'][not(text()='-')]");
	public By cpfPreenchido = By.xpath("//input[@automacao='QAR_CPF_CNPJ'][@value]");
	public By numeroCalculo = By.xpath("//span[@automacao='NumeroCalculo']");
	public By autoMulher = By.xpath("//input[@automacao='nao_mulher']");
}
