package br.com.cyber.base.frameworkBase.pages.ecommerce;

import br.com.cyber.base.frameworkBase.core.BasePage;
import org.openqa.selenium.By;

public class EcommerceProductsPage extends BasePage {

    private final By divBackpack = By.xpath("//div[@class='inventory_item_name']");
    private final By divPrice = By.xpath("//div[@class='inventory_item_price']");
    private final By btnAddCart = By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']");

    private final By btnCart = By.xpath("//a[@class='shopping_cart_link']");

    private final By btnCheckout = By.xpath("//button[@id='checkout']");

    private final By inputFirstName = By.xpath("//input[@id='first-name']");
    private final By inputLastName = By.xpath("//input[@id='last-name']");
    private final By inputPostalCode = By.xpath("//input[@id='postal-code']");

    private final By inputContinue = By.xpath("//input[@id='continue']");

    public void comprarMochila(){
        interactions.awaitElement(divBackpack, "divBackpack");
    }

    public String obterNomeProduto(){
        return interactions.getText(divBackpack, "divBackpack");
    }

    public String obterValorProduto(){
        return interactions.getText(divPrice, "divPrice");
    }

    public void fazerCheckout(){
        interactions.click(btnAddCart, "btnAddCart");

        interactions.click(btnCart, "btnCart");

        interactions.click(btnCheckout, "btnCheckout");

    }

    public void escreverDados(){
        interactions.write(inputFirstName, "Luis", "inputFirstName");
        interactions.write(inputLastName, "Michael", "inputLastName");
        interactions.write(inputPostalCode, "000000", "inputPostalCode");

        interactions.click(inputContinue, "inputContinue");
    }
}
