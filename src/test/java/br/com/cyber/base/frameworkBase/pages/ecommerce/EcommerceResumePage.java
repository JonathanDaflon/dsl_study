package br.com.cyber.base.frameworkBase.pages.ecommerce;

import br.com.cyber.base.frameworkBase.core.BasePage;
import org.openqa.selenium.By;

public class EcommerceResumePage extends BasePage {

    private final By btnFinish = By.xpath("//button[@id='finish']");

    private final By h2Complete = By.xpath("//h2[@class='complete-header']");

    public void finalizarCompra(){
        interactions.click(btnFinish, "btnFinish");
    }

    public String obterTexto() {
        return interactions.getText(h2Complete, "h2Complete");
    }
}
