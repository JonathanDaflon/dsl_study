package br.com.cyber.riscos.frameworkRiscos.core.interacao;

import static br.com.cyber.riscos.frameworkRiscos.core.DriverFactory.getDriver;
import static br.com.cyber.riscos.frameworkRiscos.enums.ExceptionsMessages.*;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.cyber.riscos.frameworkRiscos.core.exceptions.InteractionsException;

/**
 * Interface que organiza métodos de manipulação do navegador.
 * 
 * @author Matheus Gonçalves
 * @author Luis Uehara
 */
public interface IBrowser {

	static final Logger log = LoggerFactory.getLogger(IBrowser.class.getSimpleName());
	
	/**
	 * <p><strong>Substitui:</strong>
	 * <ul>
	 * <li>novaAba()</li>
	 * </ul>
	 * <p><strong>Função:</strong> abre uma nova guia no navegador.
	 * @return {@link Void void}
	 */
	default void newTab() {
		log.info("Método: newTab() - Abrindo uma nova guia.");
		((JavascriptExecutor) getDriver()).executeScript("window.open('about:blank', '-blank')");
	}
	
	/**
	 * <p><strong>Substitui:</strong>
	 * <ul>
	 * <li>trocarAba()</li>
	 * </ul>
	 * <p><strong>Função:</strong> abre uma nova guia no navegador.
	 * @param tab é a {@link Integer aba} do navegador que terá foco.
	 * @return {@link Void void}
	 */
	default void switchTab(Integer tab) {
		log.info(String.format("Método: switchTab() - Trocando para a guia %s.", tab.toString()));
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		tabs.forEach(t -> log.info(t));
		getDriver().switchTo().window(tabs.get(tab));
	}
	
	/**
	 * <p><strong>Substitui:</strong>
	 * <ul>
	 * <li>fecharAba()</li>
	 * </ul>
	 * <p><strong>Função:</strong> encerra a guia atual do navegador.
	 * @return {@link Void void}
	 */
	default void closeTab() {
		log.info("Método: closeTab() - Fechando a guia atual.");
		getDriver().close();
	}
	
	/**
	 * <p><strong>Função:</strong> realiza um scroll na tela até o elemento especificado.
	 * @param by é o {@link By seletor} do elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @return {@link Void void}
	 * @throws NoSuchElementException caso o elemento não existir.
	 * @throws TimeoutException caso exceder o tempo de carregamento do elemento.
	 * @throws ElementNotVisibleException caso a visão do elemento estiver obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException caso o elemento não estiver mais visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas em um estado não interagível.
	 * @throws Exception caso ocorra uma exceção não tratada.
	 * @see InteractionsException
	 */
	public default void scroll(By by, String description) {
		log.info(String.format("Método: scroll() - Descendo a tela até o elemento %s.", description));
		try {
			
			WebElement e = getDriver().findElement(by);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", e);
			
		} catch (NoSuchElementException e) {
			NO_SUCH_ELEMENT.getException(e, description);
			
		} catch (TimeoutException e) {
			TIMEOUT.getException(e, description);
			
		} catch (ElementNotVisibleException e) {
			NOT_VISIBLE.getException(e, description);
			
		} catch (StaleElementReferenceException e) {
			STALE_REFERENCE.getException(e, description);
			
		} catch (ElementNotInteractableException e) {
			NOT_INTERACTABLE.getException(e, description);
			
		} catch (Exception e) {
			EXCEPTION.getException(e, description);
		}
	}
	/** 
	 * 
	 * <p>
	 * <strong>Função:</strong> atualiza a página e valida.
	 * 
	 * @param by            é o {@link By seletor} que valida a página.
	 * @param validation    é o {@link String texto} a ser validado.
	 * @param description    é a {@link String descrição} do campo a ser validado.
	 * 
	 * 
	 * @return {@link Void void}
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @throws Exception                       caso ocorra uma exceção não tratada.
	 * @see InteractionsException
	 */
//	public void refresh(By by, String validation, String description) {
//		log.info("Método: refresh() - Atualizando página");
//
//		try {
//
//			getDriver().navigate().refresh();
//
//			pageValidation(by, validation, description);
//
//		} catch (NoSuchElementException e) {
//			NO_SUCH_ELEMENT.getException(e, description);
//
//		} catch (TimeoutException e) {
//			TIMEOUT.getException(e, description);
//
//		} catch (ElementNotVisibleException e) {
//			NOT_VISIBLE.getException(e, description);
//
//		} catch (StaleElementReferenceException e) {
//			STALE_REFERENCE.getException(e, description);
//
//		} catch (ElementNotInteractableException e) {
//			NOT_INTERACTABLE.getException(e, description);
//
//		} catch (NoSuchFrameException e) {
//			NO_SUCH_FRAME.getException(e, description);
//
//		} catch (Exception e) {
//			EXCEPTION.getException(e, description);
//		}
//
//	}
	
	
}
