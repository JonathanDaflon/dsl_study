package br.com.cyber.base.frameworkBase.execute.runners;

import br.com.cyber.base.frameworkBase.core.utils.Utils;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
		glue = "br.com.cyber.base.frameworkBase.execute",
		tags = {
				"@CompraSimples"
		},
		plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/evidencias/json/report.json",
		},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false, 
		strict = true
		)
public class RunnerTest {
	
	@BeforeClass
	public static void screenshotFileCheck() {
		Utils.createFiles();
		Utils.deleteFiles();
	}
}


