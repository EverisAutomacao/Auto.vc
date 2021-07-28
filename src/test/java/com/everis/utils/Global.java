package com.everis.utils;

/**
 * Esta classe contém todas constantes globais do script
 * As contantes indicam o caminho para os arquivos do projeto
 * @author Michael Batista
 *
 */
public class Global {
	
	private static String projectFolder = System.getProperty("user.dir");
	
	public final static String chromedriverFolder = projectFolder + "\\driver\\chromedriver.exe";
	public final static String evidenceFolder = projectFolder + "\\output\\";
	public final static String spreadsheetFolder = projectFolder + "\\data\\";
	public final static String backupSpreadsheetFolder = projectFolder + "\\data\\backup\\";
	
	public final static String planilha = "AutoVC.xlsx";
	public final static String folha = "Testes";
}
