package br.com.cyber.base.frameworkBase.pages.ecommerce;

import br.com.cyber.base.frameworkBase.core.BasePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EcommercePage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(EcommercePage.class.getSimpleName());

    private final String url = "https://www.saucedemo.com";

    private final By inputUsername = By.xpath("//input[@id='user-name']");
    private final By inputPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@id='login-button']");

    public void acessarPlataforma(){
        interactions.url(url);
    }

    public void login(String username){
        interactions.click(inputUsername, "inputUsername");
        interactions.write(inputUsername, username, "inputUsername");

        interactions.click(inputPassword, "inputPassword");
        interactions.write(inputPassword, "secret_sauce", "inputPassword");

        interactions.click(btnLogin, "btnLogin");
    }
}