package br.com.cyber.base.frameworkBase.core.interaction.interfaces;

import br.com.cyber.base.frameworkBase.core.exceptions.InteractionsException;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static br.com.cyber.base.frameworkBase.core.DriverFactory.getDriver;
import static br.com.cyber.base.frameworkBase.enums.ExceptionsMessages.*;
import static br.com.cyber.base.frameworkBase.enums.ExceptionsMessages.EXCEPTION;

/**
 * Interface voltada para o desenvolvimento do Click
 */
public interface IClick extends IAwait {

    Logger log = LoggerFactory.getLogger(IClick.class.getSimpleName());

    /**
     * <p>
     * <strong>Substitui:</strong>
     * <ul>
     * <li>clicar()</li>
     * </ul>
     * <p>
     * <strong>Função:</strong> clica no elemento especificado.
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
    default void click(By by, String description) {
        log.info(String.format("Método: click() - Clicando no elemento %s", description));
        try {

            awaitElement(by, description);
            getDriver().findElement(by).click();

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

}
