package com.everis.page;

import static com.everis.utils.DriverFactory.getMobileDriver;

import com.everis.dslCommands.DslMobile;
import com.everis.elements.PerfilElements;
import com.everis.utils.DriverFactory;
import com.everis.utils.Tools;

public class Perfil extends DslMobile {

	String message = "";
	PerfilElements elements = new PerfilElements(DriverFactory.getMobileDriver());

	public String editarAvatar() {
		try {

			String numeroAvatar = mapTestCase.get("Avatar");
			if (numeroAvatar.isEmpty()) {
				message = "Numero do avatar não foi informado";
				return message;
			}

			screenShot();
			tap(elements.btnAvatar);
			Thread.sleep(1000);
			screenShot();
			tap(elements.imgAvatar(numeroAvatar));
			System.out.println(numeroAvatar);
			Thread.sleep(1000);
			scroll(90, 10, 1);
			tap(elements.btnSalvar);
			screenShot();
			waitLoading();

//			/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView
//			/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView
//			/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView


			if (!isPresent(elements.sucessoMsgXpath)) {
				message = "Falha ao atualizar Avatar";
			}
		} catch (Exception e) {
			message = "Falha ao atualizar avatar";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}

	public String editarPerfil() {
		message = "";
		
		try {
			
			if (!mapTestCase.get("NomeEditar").isEmpty()) {
				clear(elements.edtNome);
				
				sendKeysAnnotations(elements.edtNome, mapTestCase.get("NomeEditar"));
				getMobileDriver().hideKeyboard();
			}

			if (!mapTestCase.get("ApelidoEditar").isEmpty()) {
				clear(elements.edtApelido);
				sendKeysAnnotations(elements.edtApelido, mapTestCase.get("ApelidoEditar"));
				getMobileDriver().hideKeyboard();
			}
//			if (!mapTestCase.get("Telefone").isEmpty()) {
//				clear(elements.edtTelefone);
//				sendKeysAnnotations(elements.edtTelefone, mapTestCase.get("Telefone"));
//				getMobileDriver().hideKeyboard();
//			}

			screenShot();
			Thread.sleep(1000);
			scroll(90, 10, 1);
			tap(elements.btnSalvar);
			waitLoading();
			if (!isPresent(elements.sucessoMsgXpath)) {
				message = "Falha ao atualizar perfil";
			}

		} catch (Exception e) {
			message = "Falha ao atualizar perfil";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
	
	public String verificaPerfil() {
		message = "";
		try {
			Thread.sleep(1000);
			tap(elements.getBtnMenu);
			Thread.sleep(1000);
			tap(elements.menuMinhasDefinicoes);
			Thread.sleep(1000);
			tap(elements.subMenuEditarPerfil);
	
			String apelidoEsperado = mapTestCase.get("ApelidoEditar");
			String apelidoRecebido = getText(elements.edtApelido);
			System.out.println("O apelido inserido anteriormente no perfil é " + apelidoRecebido  );
			
			if (!apelidoEsperado.equalsIgnoreCase(apelidoRecebido)) {
				message = "Versão incorreta. Esperada[" + apelidoEsperado + "] - Encontrada[" + apelidoRecebido + "]";
			}

		} catch (Exception e) {
			message = "Falha ao verificar Perfil";
			e.printStackTrace();
		} finally {
			screenShot();
		}
		return message;
	}
}