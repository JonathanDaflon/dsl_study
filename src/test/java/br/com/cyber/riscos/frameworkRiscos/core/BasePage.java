package br.com.cyber.riscos.frameworkRiscos.core;

import br.com.cyber.riscos.frameworkRiscos.core.interacao.Interactions;

/**
 * Uma classe base para todos os PageObjects.
 *
 * @author Matheus Gonçalves
 * @author Luis Uehara
 */
public abstract class BasePage {

    protected Interactions interactions;

    public BasePage() {
        interactions = new Interactions();
    }
}