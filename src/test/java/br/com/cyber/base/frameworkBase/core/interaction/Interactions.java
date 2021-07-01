package br.com.cyber.base.frameworkBase.core.interaction;

import br.com.cyber.base.frameworkBase.core.DriverFactory;
import br.com.cyber.base.frameworkBase.core.exceptions.InteractionsException;
import br.com.cyber.base.frameworkBase.core.interaction.interfaces.IAwait;
import br.com.cyber.base.frameworkBase.core.interaction.interfaces.IClick;
import br.com.cyber.base.frameworkBase.enums.ExceptionsMessages;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Classe de <i>interações</i> genéricas para ser utilizada no padrão
 * <strong>Page Object</strong>.
 * 
 * @author Felipe Gadelha
 * @author Jonathan Daflon
 * @author Thyago Sasso
 * @since 1.0
 * @see InteractionsException
 */
public class Interactions implements IBrowser, IAwait, IClick {
	public static final Logger log = LoggerFactory.getLogger(Interactions.class.getSimpleName());

	/**
	 * <p>
	 * <strong>Função:</strong> acessar uma URL.
	 *
	 * @param url {@link String string}.
	 */
	public void url(String url) {

		log.info(String.format("Método: url() - Acessando o endereço: %s.", url));

		try {
			DriverFactory.getDriver().get(url);
		} catch (Exception e) {
			ExceptionsMessages.WEBDRIVER.getException(e, url);
		}
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>escrever()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> escreve uma {@link String string} no elemento
	 * especificado.
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param text        é a {@link String string} a ser escrita no elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public void write(By by, String text, String description) {
		log.info(String.format("Método: write() - Escrevendo '%s' no elemento %s.", text, description));
		try {
			DriverFactory.getDriver().findElement(by).sendKeys(text);

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>escreverSlow()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> escreve lentamente uma {@link String string} no
	 * elemento especificado.
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param text        é a {@link String string} a ser escrita no elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public void writeSlowly(By by, String text, String description) {
		log.info(String.format("Método: writeSlowly() - Escrevendo lentamente '%s' no elemento %s.", text, description));
		try {
			textClear(by, description);
			WebElement txtValor = DriverFactory.getDriver().findElement(by);
			List<String> list = Arrays.asList(text.split(""));
			//TODO Refatorar o forEach
			list.forEach(txtValor::sendKeys);


		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>limpar()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> limpa o texto no elemento especificado.
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public void textClear(By by, String description) {
		log.info(String.format("Método: textClear() - Apagando o texto no elemento: %s.", description));
		try {
			DriverFactory.getDriver().findElement(by).clear();

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}


	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>isRadioMarcado()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> verifica se o elemento especificado está
	 * selecionado/marcado.
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @return {@link Boolean boolean}
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public boolean isRadioSelected(By by, String description) {
		log.info(String.format("Método: isRadioSelected() - Verificando se o elemento %s está marcado/selecionado.", description));
		try {
			return DriverFactory.getDriver().findElement(by).isSelected();

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
		return false;
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>obterTexto()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> obtém, loga e retorna o valor textual do elemento
	 * especificado ou {@link null} em caso de falha.
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @return {@link String string}
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public String getText(By by, String description) {
		log.info(String.format("Método: getText() - Obtendo texto do elemento %s.", description));
		try {
			String text = DriverFactory.getDriver().findElement(by).getText();
			log.info(String.format("O texto obtido foi: %s.", text));
			return text;

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
		return null;
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>validaPagina()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> Valida se a página atual é a página desejada e
	 * verifica se a mesma está carregada.
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param text        é a {@link String string} validadora à ser comparada com o
	 *                    texto obtido do elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 * @see #awaitElement
	 * @see #getText(By, String)
	 */
	public void pageValidation(By by, String text, String description) {
		log.info(String.format("Método: pageValidation() - Validando a página atual pelo elemento: %s.", description));
		try {
			awaitElement(by, description);
			Assert.assertTrue("A página falhou no processo de verificação.", getText(by, description).contains(text));

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>obterTitleElemento()</li>
	 * <li>obterLinkElemento()</li>
	 * <li>obterClasseElemento()</li>
	 * <li>obterReadOnlyElemento()</li>
	 * </ul>
	 *
	 * <p>
	 * <strong>Função:</strong> esta interação tem a função de retornar um atributo
	 * específico de um elemento ou {@link null} caso o atributo não exista.
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param attribute   é o {@link String atributo} que será obtido.
	 * @param description é o {@link String nome} do elemento.
	 * @return {@link String string}
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public String getAttribute(By by, String attribute, String description) {
		log.info(String.format("Método: getAttribute() - Obtendo o atributo %s do elemento: %s.", attribute, description));
		try {
			String text = DriverFactory.getDriver().findElement(by).getAttribute(attribute);
			log.info(String.format("O atributo obtido foi: %s.", text));
			return text;

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
		return null;
	}

	/**
	 * @deprecated
	 *             <p>
	 *             Ao invés disso utilize o método
	 *             {@link #awaitElement(By, String)}.
	 *             <p>
	 *             <strong>Substitui:</strong>
	 *             <ul>
	 *             <li>aguarda()</li>
	 *             </ul>
	 *             <p>
	 *             <strong>Função:</strong> faz com que a thread entre no modo
	 *             "sleep" por um determinado período de tempo.
	 * @param milissegundos um {@link Integer int} em milissegundos.
	 * @see InteractionsException
	 */
	public void wait(int milissegundos) {
		log.info(String.format("Método: wait() - Aguardando implicitamente por %.1f segundos", ((float) milissegundos / 1000)));
		try {
			Thread.sleep(milissegundos);
		} catch (InterruptedException e) {
			ExceptionsMessages.INTERRUPTED.getException(e, "");
		}
	}


	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>elementExists()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> verifica se o elemento especificado está visível na
	 * tela.
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @return {@link Boolean boolean}
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public boolean isElementDisplayed(By by, String description) {
		log.info(String.format("Método: isElementDisplayed() - Verificando se o elemento %s está visível.", description));
		try {
			return DriverFactory.getDriver().findElement(by).isDisplayed();

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
		return false;
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>listaParaClicks()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> cria uma lista de elementos e clica em um deles
	 * aleatoriamente.
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param description é o {@link String nome} geral do elementos.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public void randomClickList(By by, String description) {
		log.info(String.format("Método: randomClickList() - Gerando uma lista randômica para clicks nos elementos %s.", description));
		try {

			List<WebElement> elementos = DriverFactory.getDriver().findElements(by);
			log.info(String.format("O número de elementos é %d", elementos.size()));
			Integer n = (int) (Math.random() * (elementos.size() - 1));
			log.info(String.format("Selecionando o elemento de número %s.", n.toString()));
			elementos.get(n).click();

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>combo()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> seleciona um elemento de uma lista dropdown (combo)
	 * através do atributo "value" (e não do texto aparente).
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param value       é o {@link String valor} da opção do combo (e não o seu
	 *                    texto).
	 * @param description é o {@link String nome} do elemento.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public void selectComboByValue(By by, String value, String description) {
		log.info(String.format("Método: selectComboByValue() - Selecionando o elemento %s do combo através do valor %s.", description, value));
		try {

			new Select(DriverFactory.getDriver().findElement(by)).selectByValue(value);

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <p>
	 * <strong>Função:</strong> manipula um elemento do tipo slider apenas em seu
	 * eixo horizontal. Caso esse método não funcione, experimente o
	 * {@link #sliderSendKeys(By, Integer, String)}
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param number      é o {@link Integer número} utilizado para quantificar o
	 *                    movimento do elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 * @see #sliderSendKeys(By, Integer, String)
	 */
	public void slider(By by, Integer number, String description) {
		log.info(String.format("Método: slider() - movendo o elemento %s %s unidades.", description, number.toString()));
		try {

			new Actions(DriverFactory.getDriver()).dragAndDropBy(DriverFactory.getDriver().findElement(by), number, 0).build().perform();

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>sliderComSeta()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> manipula um elemento do tipo slider apenas em seu
	 * eixo horizontal utilizando o método sendKeys para a direita. Caso esse método
	 * não funcione, experimente o {@link #slider(By, Integer, String)}
	 *
	 * @param by          é o {@link By seletor} do elemento.
	 * @param repetitions é a {@link Integer quantidade} de vezes que o comando de
	 *                    seta será enviada.
	 * @param description é o {@link String nome} do elemento.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 * @see #slider(By, Integer, String)
	 */
	public void sliderSendKeys(By by, Integer repetitions, String description) {
		log.info(String.format("Método: sliderSendKeys() - movendo o elemento %s com %s repetições de sendKeys.", description, repetitions.toString()));
		try {

			click(by, "Clicando no Slider");
			for (int i = 0; i <= repetitions; i++) {
				DriverFactory.getDriver().findElement(by).sendKeys(Keys.ARROW_RIGHT);
			}

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>entrarFrame()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> troca o frame atual pelo index especificado no
	 * parâmetro.
	 *
	 * @param index       é o {@link Integer index} do frame a ser acessado.
	 * @param description é o {@link String nome} do elemento.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 * @see #switchFrame(String, String)
	 */
	public void switchFrame(Integer index, String description) {
		log.info(String.format("Método: entrarFrame() - no elemento índice %s.", index.toString()));
		try {

			DriverFactory.getDriver().switchTo().frame(index);

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (NoSuchFrameException e) {
			ExceptionsMessages.NO_SUCH_FRAME.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>entrarFrame()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> troca o frame atual pelo nome especificado no
	 * parâmetro.
	 *
	 * @param frame       é o {@link String nome} do frame a ser acessado.
	 * @param description é o {@link String nome} do elemento.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 * @see #switchFrame(Integer, String)
	 */
	public void switchFrame(String frame, String description) {
		log.info(String.format("Método: entrarFrame() - no elemento de nome %s.", description));
		try {

			DriverFactory.getDriver().switchTo().frame(frame);

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (NoSuchFrameException e) {
			ExceptionsMessages.NO_SUCH_FRAME.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <p>
	 * <strong>Função:</strong> retorna para o frame do conteúdo principal.
	 *
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public void frameDefault() {
		log.info("Método: frameDefault() - Voltando ao conteúdo principal.");
		String description = "Frame Default";

		try {

			DriverFactory.getDriver().switchTo().defaultContent();

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (NoSuchFrameException e) {
			ExceptionsMessages.NO_SUCH_FRAME.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 *
	 * <p>
	 * <strong>Função:</strong> atualiza a página e valida.
	 *
	 * @param by          é o {@link By seletor} que valida a página.
	 * @param validation  é o {@link String texto} a ser validado.
	 * @param description é a {@link String descrição} do campo a ser validado.
	 *
	 *
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public void refresh(By by, String validation, String description) {
		log.info("Método: refresh() - Atualizando página");

		try {

			DriverFactory.getDriver().navigate().refresh();

			pageValidation(by, validation, description);

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (NoSuchFrameException e) {
			ExceptionsMessages.NO_SUCH_FRAME.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}

	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>combo()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> verifica quantos elementos existem dentro da lista
	 * de elementos.
	 *
	 * @param by          é o {@link By seletor} da lista de elementos.
	 * @param description é o {@link String nome} da lista de elementos.
	 * @return {@link int int}
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public int sizeListElements(By by, String description) {
		log.info(String.format("Método: sizeListElements() - Contando quantos elemento tem dentro do %s.", description));
		try {
			return DriverFactory.getDriver().findElements(by).size();

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
		return 0;
	}

	/**
	 * <p>
	 * <strong>Substitui:</strong>
	 * <ul>
	 * <li>combo()</li>
	 * </ul>
	 * <p>
	 * <strong>Função:</strong> verifica quantos elementos existem dentro da lista
	 * de elementos.
	 *
	 * @param by é o {@link By seletor} da lista de elementos.
	 * @param description é o {@link String nome} da lista de elementos.
	 * @throws NoSuchElementException          caso o elemento não existir.
	 * @throws TimeoutException                caso exceder o tempo de carregamento
	 *                                         do elemento.
	 * @throws ElementNotVisibleException      caso a visão do elemento estiver
	 *                                         obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException  caso o elemento não estiver mais
	 *                                         visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas
	 *                                         em um estado não interagível.
	 * @see InteractionsException
	 */
	public void moverMouse(By by, String description) {
		log.info(String.format("Método: moverMouse() - movendo mouse %s", description));
		try {

			Actions mouse = new Actions(DriverFactory.getDriver());
			WebElement elemento = DriverFactory.getDriver().findElement(by);
			mouse.moveToElement(elemento).perform();

		} catch (NoSuchElementException e) {
			ExceptionsMessages.NO_SUCH_ELEMENT.getException(e, description);

		} catch (TimeoutException e) {
			ExceptionsMessages.TIMEOUT.getException(e, description);

		} catch (ElementNotVisibleException e) {
			ExceptionsMessages.NOT_VISIBLE.getException(e, description);

		} catch (StaleElementReferenceException e) {
			ExceptionsMessages.STALE_REFERENCE.getException(e, description);

		} catch (ElementNotInteractableException e) {
			ExceptionsMessages.NOT_INTERACTABLE.getException(e, description);

		} catch (Exception e) {
			ExceptionsMessages.EXCEPTION.getException(e, description);
		}
	}

	/**
	 * <p>
	 *     <strong>Esse é um método simplificado do moverMouser()</strong>
	 *	   <strong>Substitui:</strong>
	 *     <ul>
	 *         <li>combo()</li>
	 *     </ul>
	 * </p>
	 * <strong>Função:</strong> verifica quantos elementos existem dentro da lista
	 * de elementos.
	 *
	 * @param by é o {@link By seletor} da lista de elementos.
	 * @see #moverMouse(By, String)
	 */
	public void moverMouse(By by) {
		moverMouse(by, "");
	}
}

	
