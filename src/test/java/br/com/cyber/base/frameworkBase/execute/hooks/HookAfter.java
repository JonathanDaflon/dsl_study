package br.com.cyber.base.frameworkBase.execute.hooks;

import java.io.File;

import br.com.cyber.base.frameworkBase.core.DriverFactory;
import br.com.cyber.base.frameworkBase.core.Properties;
import br.com.cyber.base.frameworkBase.core.utils.Utils;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class HookAfter {
	
	@After(order = 1)
	public void screenshot(Scenario scenario) {

		String nome = String.format("%s_%s", scenario.getName().replace(" ", "_"), Utils.formatter());
		String evidencia = (!scenario.isFailed()) ? evidencia = "sucesso" : "erro";
		String caminho = Utils.pathScreenshot() + evidencia + File.separator;

		Utils.fullPageScreenshot(caminho, nome, DriverFactory.getDriver());
	}

	@After(order = 0)
	public void finalizar() {
		if (Properties.CLOSE)
			DriverFactory.killDriver();
	}
}
