package br.com.cyber.base.frameworkBase.core;

import br.com.cyber.base.frameworkBase.core.interaction.Interactions;

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