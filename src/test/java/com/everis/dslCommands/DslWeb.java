package com.everis.dslCommands;

import static com.everis.utils.DriverFactory.getWebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everis.excel.Dados;
import com.everis.excel.Planilha;
import com.everis.utils.DriverFactory;
import com.everis.utils.Global;
import com.everis.utils.Tools;

public class DslWeb extends Dados {

	public static int screenShotNumber = 0;
	Planilha excel = new Planilha();
	public int linha = 1;
	public WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), 20);

	public void waitInvisibility(By by) {
		try {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (Exception e) {
		}

	}

	public void waitIsPresent(By by) {
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		} catch (Exception e) {
		}

	}

	public void sendKeys(By by, String text) {
		if (!text.isEmpty()) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			getWebDriver().findElement(by).sendKeys(text);
		}
	}

	public void slowSendKeys(By by, String text) throws InterruptedException {
		if (!text.isEmpty()) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			String letras[] = text.split("");
			for (String letra : letras) {
				Thread.sleep(1000);
				getWebDriver().findElement(by).sendKeys(letra);
			}
		}

	}

	public void select(By by, String text) {
		if (!text.isEmpty()) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			new org.openqa.selenium.support.ui.Select(getWebDriver().findElement(by)).selectByVisibleText(text);
		}
	}

	/*
	 * public void jSelect(String id, String value) { if (!value.isEmpty()) {
	 * JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
	 * js.executeScript("document.getElementById('" + id + "').value='" + value +
	 * "';"); } }
	 */
	public void jSelect(By by, String value) {
		if (!value.isEmpty()) {
			WebElement element = getWebDriver().findElement(by);
			JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
			js.executeScript("arguments[0].value='" + value + "';", element);

		}
	}

	public void click(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		getWebDriver().findElement(by).click();
	}

	/**
	 * Clica em um elemento usando javascript
	 * 
	 * @param xpath = xpath do elemento
	 */
	public void jClick(String locator) throws Exception {
		WebElement element = getWebDriver().findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		js.executeScript("arguments[0].click();", element);

	}

	public String getText(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		return getWebDriver().findElement(by).getText();
	}

	public String getValue(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		return getWebDriver().findElement(by).getAttribute("value");
	}

	public boolean isPresent(By by) {
		try {
			getWebDriver().findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void Scroll() {
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		js.executeScript("window.scrollBy(0,-300)", "");
	}

	public void screenShot() {
		screenShotNumber++;
		File imagem = ((TakesScreenshot) DriverFactory.getWebDriver()).getScreenshotAs(OutputType.FILE);
		String path = Global.evidenceFolder + Tools.folderDateExecution + "//"
				+ mapTestCase.get("ID") + "//imagem" + screenShotNumber + ".png";
		try {
			FileUtils.copyFile(imagem, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void salvarNaPlanilha(String valor, int linha, String coluna) throws IOException {
		excel.ds_startExcel(Global.spreadsheetFolder + "/" + Global.planilha, Global.folha);
		excel.ds_writeData(valor, linha, coluna);
		excel.ds_saveData();
		excel.ds_closeData();
		
		
	}

}
