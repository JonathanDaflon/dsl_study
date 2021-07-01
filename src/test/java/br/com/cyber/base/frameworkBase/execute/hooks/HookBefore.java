package br.com.cyber.base.frameworkBase.execute.hooks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import br.com.cyber.base.frameworkBase.core.utils.InputDeDados;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;

public class HookBefore {
	
	@Before(order = 0)
	public static void coletarDados(Scenario scenario) throws IOException {
		
		String pathScenario = scenario.getUri().replace("file:", "");
		
		List<String> allLines = Files.readAllLines(Paths.get(pathScenario));
		int count = 1;
		for (String line : allLines) {
			if (count == scenario.getLine()) {
				InputDeDados.setInput(line);
			}
			count++;
		}
	}
}
