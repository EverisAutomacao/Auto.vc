package com.everis.page;

import java.awt.datatransfer.Clipboard;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.ConviteElements;
import com.everis.utils.DriverFactory;

public class Convite  extends DslMobile {
	
	String message = "";
	ConviteElements conviteElements = new ConviteElements(DriverFactory.getMobileDriver());
	
	public String copiarLinkConvite() {
		message = "";
		try {
			tap(conviteElements.btnConvidar);
			Thread.sleep(1000);
			screenShot();
			tap(conviteElements.btnCopiar);
			Thread.sleep(3000);
			
			String linkConvite = getClipboardText();
			System.out.println(linkConvite);
			
			
			String[] v = linkConvite.split("link: ");
			linkConvite = v[1];
			
//			//salva na linha do CT44
//			int linha = Automation.linhaConstrutor+2;
//			salvarNaPlanilha(linkConvite, linha,"Link Convite");
			
			
		} catch (Exception e) {
			message = "Falha ao enviar convite.";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	public String convidarViaGmail() {
		message = "";
		try {
			Thread.sleep(1000);
			screenShot();
			tap(conviteElements.btnConvidar);
			Thread.sleep(1000);
			tap(conviteElements.btnGmail);
			wait.until(ExpectedConditions.visibilityOfAllElements(conviteElements.appGmail));
		} catch (Exception e) {
			message = "Falha ao enviar convite.";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}

}