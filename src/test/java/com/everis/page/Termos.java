package com.everis.page;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.TermosElements;
import com.everis.utils.DriverFactory;

public class Termos  extends DslMobile {
	
	String message = "";
	
	public String concordar() {
		message = "";
		try {
			TermosElements termosElements = new TermosElements(DriverFactory.getMobileDriver());
			wait.until(ExpectedConditions.visibilityOfAllElements(termosElements.btnConcordo));
			screenShot();
			Thread.sleep(1000);
			scrollElementIsPresent(termosElements.linkDeclaracao, 75, 1);
			Thread.sleep(1000);
			screenShot();
			tap(termosElements.btnConcordo);
			Thread.sleep(1000);
			screenShot();
			scrollElementIsPresent(termosElements.ultimaAtualicazao, 75, 1);
			screenShot();
			tap(termosElements.btnConcordo);
		} catch (Exception e) {
			e.printStackTrace();
			message = "Falha ao concordar com os termos";
		} 
		return message;
	}

}