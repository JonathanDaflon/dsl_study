package br.com.cyber.riscos.frameworkRiscos.pages.apolices;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.cyber.riscos.frameworkRiscos.core.BasePage;

public class ApolicesPage extends BasePage{

    private static final Logger log = LoggerFactory.getLogger(ApolicesPage.class.getSimpleName());

    private final By btnEnviar = By.xpath("//button");

    public void enviarApolice() {
        log.info("Metodo: nomeDoMetodo() - Breve descrição " + btnEnviar);
        interactions.awaitElement(btnEnviar, "btnEnviar");
        interactions.click(btnEnviar, "Botão Enviar");
    }

}