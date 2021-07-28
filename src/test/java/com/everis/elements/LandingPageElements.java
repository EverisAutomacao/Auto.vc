package com.everis.elements;

import org.openqa.selenium.By;

public class LandingPageElements {
	
	public By edtNome = By.xpath("//*[@id='nome']");
	public By edtEmail = By.xpath("//*[@id='email']");
	public By edtCpf = By.xpath("//*[@id='cpf']");
	public By edtTelefone = By.xpath("//*[@id='celular']");
	public By edtSenha = By.xpath("	//*[@id='senha']");
	public By edtConfirmarSenha = By.xpath("//*[@id='confirmarSenha']");
	public By chkMaiorIdade = By.xpath("//*[@id='soumaiorde18\']");
	public By btnConcluirCadastro = By.xpath("//*[@id=\'btnCadastrar\']");
	
	public By btnCadastrar = By.xpath("//input[@automacao='btncadastro_form']");
	public By imgLoading = By.xpath("//div[@class='Feedback_AjaxWait_OVERRIDE']");
	public By iframe = By.xpath("//[@id='painelCadastrado']");
	public By sucess = By.xpath("//*[@id='painelCadastrado']/div/p[1]");
	
	//*[@id='painelCadastrado']/div/p[1]
	//public By sucess = By.xpath("//div[@automacao='msgSucesso']");
}

//public By sucess = By.xpath("//[@id='painelCadastrado']/div/p[1]");
//*[@id="painelCadastrado"]/div
//public By iframe = By.xpath("//[@id='painelCadastrado']");

