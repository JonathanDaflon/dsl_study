package br.com.cyber.base.frameworkBase.execute.steps.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.cyber.base.frameworkBase.pages.ecommerce.EcommercePage;
import br.com.cyber.base.frameworkBase.pages.ecommerce.EcommerceProductsPage;
import br.com.cyber.base.frameworkBase.pages.ecommerce.EcommerceResumePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EcommerceSteps {

    @Given("que acesso ao Swaglabs")
    public void queAcessoAoSwaglabs() {
        new EcommercePage().acessarPlataforma();
    }

    @And("utilizo o {string} para logar")
    public void utilizoOUsernameParaLogar(String username) {
        new EcommercePage().login(username);
    }

    @And("compro uma mochila")
    public void comproUmaMochila() {
        new EcommerceProductsPage().comprarMochila();

        assertEquals("Sauce Labs Backpack",new EcommerceProductsPage().obterNomeProduto());
        assertEquals("$29.99", new EcommerceProductsPage().obterValorProduto());

        new EcommerceProductsPage().fazerCheckout();

        new EcommerceProductsPage().escreverDados();
    }

    @Then("finalizo a compra")
    public void finalizoACompra() {
        new EcommerceResumePage().finalizarCompra();

        assertEquals("THANK YOU FOR YOUR ORDER", new EcommerceResumePage().obterTexto());
    }
}
