package com.everis.dslCommands;


import static com.everis.utils.DriverFactory.getMobileDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everis.excel.Dados;
import com.everis.excel.Planilha;
import com.everis.utils.DriverFactory;
import com.everis.utils.Global;
import com.everis.utils.Tools;

import android.content.Context;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class DslMobile extends Dados {

	
	
	public static int screenShotNumber = 0;
	Planilha excel = new Planilha();
	By xpathWaitLoading = By.xpath("//android.widget.ProgressBar[@enabled='true'][1]");

	public WebDriverWait wait = new WebDriverWait((WebDriver) DriverFactory.getMobileDriver(), 20);

	public boolean isPresent(By by) {
		try {
			return getMobileDriver().findElement(by).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Aguarda o carrgamento
	 * 
	 */
	public boolean waitLoading() {
		try {
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathWaitLoading));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void sendKeys(By by, String text) {
		if (!text.isEmpty()) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			getMobileDriver().findElement(by).sendKeys(text);
		}
	}

	public void sendKeysAnnotations(WebElement element, String text) {
		if (!text.isEmpty()) {
			element.sendKeys(text);
		}
	}

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void sendKeysWithPosition(int x, int y, String text) {
		if (!text.isEmpty()) {
			new TouchAction(getMobileDriver()).tap(PointOption.point(163, 246)).perform();
			getMobileDriver().getKeyboard().sendKeys(text);
		}
	}

	public void clear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		element.click();
		element.clear();
	}

	public void clear2(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		String text = element.getAttribute("value");
		element.click();
		while (!text.isEmpty()) {
			element.sendKeys(Keys.DELETE);
		}
	}

	public String getText(By by) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		return getMobileDriver().findElement(by).getText();
	}

	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		return element.getText();
	}

//	@SuppressWarnings({ "rawtypes" })
//	
//	public String getClipboardText() {
//		IOSDriver iosDriver;
//		AndroidDriver androidDriver;
	
//		if (getMobileDriver() instanceof IOSDriver) {
//			iosDriver = (IOSDriver) getMobileDriver();
//			return iosDriver.getClipboardText();
//		} else {
//			
//			androidDriver = (AndroidDriver) getMobileDriver();
//			return androidDriver.getClipboardText();
//		}
//	}
//	
	
	@SuppressWarnings({ "rawtypes" })
    public String getClipboardText() {
        IOSDriver iosDriver;
        AndroidDriver androidDriver;
        if (getMobileDriver() instanceof IOSDriver) {
            iosDriver = (IOSDriver) getMobileDriver();
            return iosDriver.getClipboardText();
        } else {
            androidDriver = (AndroidDriver) getMobileDriver();
            return androidDriver.getClipboard(ClipboardContentType.PLAINTEXT);
          
        }
    }

	public String getAtrribute(By by, String atrribute) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		return getMobileDriver().findElement(by).getAttribute(atrribute);
	}

	public String getAtrributeAnnotation(WebElement element, String atrribute) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		return element.getAttribute(atrribute);
	}

	public void tap(By by) throws IOException {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		getMobileDriver().findElement(by).click();
	}

	public void tap(WebElement element) throws IOException {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	/**
	 * Toca na tela a partir da coordenada do elemento
	 *
	 * @param by = Localização do elemento
	 */
	@SuppressWarnings("rawtypes")
	public void tapByCoordinates(By by) throws IOException {

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		MobileElement element = (MobileElement) getMobileDriver().findElement(by);
		int positionX = element.getLocation().x;
		int positionY = element.getLocation().y;
		System.out.println("Tocou na Coordenada [x=" + positionX + "]" + "[y=" + positionY + "]");
		new TouchAction(getMobileDriver()).tap(PointOption.point(positionX, positionY)).perform();

	}

	/**
	 * Toca na tela a partir da coordenada do elemento somada com os valores X e Y
	 *
	 * @param by = Localização do elemento
	 * @param x  = Coordenada X a ser adicionada
	 * @param y  = Coordenada Y a ser adicionada
	 */
	@SuppressWarnings("rawtypes")
	public void tapByCoordinatesPlus(By by, int x, int y) throws IOException {

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		MobileElement element = (MobileElement) getMobileDriver().findElement(by);
		int positionX = element.getLocation().x + x;
		int positionY = element.getLocation().y + y;
		System.out.println("x=" + positionX + ", y=" + positionY);
		new TouchAction(getMobileDriver()).tap(PointOption.point(positionX, positionY)).perform();
	}

	@SuppressWarnings("rawtypes")
	public void tapByCoordinatesPlus(WebElement element, int x, int y) throws IOException {
		int positionX = element.getLocation().x + x;
		int positionY = element.getLocation().y + y;
		System.out.println("Clicou na coordenada X=" + positionX + ", Y=" + positionY);
		new TouchAction(getMobileDriver()).tap(PointOption.point(positionX, positionY)).perform();
	}

	/**
	 * Toca na tela a partir da coordenada do elemento somada com os valores X e Y
	 *
	 * @param x = Coordenada X a ser adicionada
	 * @param y = Coordenada Y a ser adicionada
	 */
	@SuppressWarnings("rawtypes")
	public void tapByCoordinatesPlusAnnotations(WebElement element, int x, int y) throws IOException {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		int positionX = element.getLocation().x + x;
		int positionY = element.getLocation().y + y;
		System.out.println("x=" + positionX + ", y=" + positionY);
		new TouchAction(getMobileDriver()).tap(PointOption.point(positionX, positionY)).perform();
	}

	@SuppressWarnings("rawtypes")
	public void scroll(float inicio, float fim, int quantasVezes) {

		Dimension size = getMobileDriver().manage().window().getSize();
		int positoinX = size.width / 2;
		int start_y = (int) (size.height * (inicio / 100));
		int end_y = (int) (size.height * (fim / 100));
		for (int i = 1; i <= quantasVezes; i++) {
			new TouchAction(getMobileDriver()).press(PointOption.point(positoinX, start_y))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(525)))
					.moveTo(PointOption.point(positoinX, end_y)).release().perform();
		}
	}

	@SuppressWarnings("rawtypes")
	public void scrollHorizontal(int eixoY) {
		Dimension size = getMobileDriver().manage().window().getSize();
		// int posicaoY = (int) (size.height * 0.75);
		int inicioX = (int) (size.width * 0.90);
		int fimX = (int) (size.width * 0.10);
		new TouchAction(getMobileDriver()).press(PointOption.point(inicioX, eixoY))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
				.moveTo(PointOption.point(fimX, eixoY)).release().perform();
	}

	
	/**
	 * Realiza um scroll vertical, até que o elemento desejado esta presente na tela
	 * @param element = identificação do elemento
	 * @param inicio = posição do toque inicial na tela (OBS: em porcentagem)
	 * @param fim = posição final do toque (OBS: em porcentagem)
	 */
	@SuppressWarnings("rawtypes")
	public void scrollElementIsPresent(WebElement element, float inicio, float fim) throws Exception {
		Dimension size = getMobileDriver().manage().window().getSize();
		int positoinX = size.width / 2;
		int start_y = (int) (size.height * (inicio / 100));
		int end_y = (int) (size.height * (fim / 100));
		int timeOut = 1;
		do {
			new TouchAction(getMobileDriver()).press(PointOption.point(positoinX, start_y))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(400)))
					.moveTo(PointOption.point(positoinX, end_y)).release().perform();
			if (timeOut >= 8) {
				throw new Exception("Scroll time out");
			}
			timeOut++;
		} while (!isPresent(element));
		Thread.sleep(200);
	}
	@SuppressWarnings("rawtypes")
	public void scrollElementIsPresent(By by, float inicio, float fim) throws Exception {
		Dimension size = getMobileDriver().manage().window().getSize();
		int positoinX = size.width / 2;
		int start_y = (int) (size.height * (inicio / 100));
		int end_y = (int) (size.height * (fim / 100));
		int timeOut = 1;
		do {
			new TouchAction(getMobileDriver()).press(PointOption.point(positoinX, start_y))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
					.moveTo(PointOption.point(positoinX, end_y)).release().perform();
			if (timeOut >= 10) {
				throw new Exception("Scroll time out");
			}
			timeOut++;
		} while (!isPresent(by));
		Thread.sleep(300);
	}

	public void screenShot() {
		screenShotNumber++;
		File imagem = ((TakesScreenshot) DriverFactory.getMobileDriver()).getScreenshotAs(OutputType.FILE);
		String path = Global.evidenceFolder + Tools.folderDateExecution + "\\"
				+ mapTestCase.get("ID") + "\\imagem" + screenShotNumber + ".png";
		
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



	public int getPositionY(WebElement element) throws IOException {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		int positionY = element.getLocation().y;
		return positionY;

	}
	public void teste(MobileElement botao2)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(botao2));
		
        botao2 = (MobileElement) DriverFactory.getMobileDriver().findElementByXPath("//android.widget.TextView[@text='https://c2.qa.amil.com.br']");
        botao2.click();
	}
}
