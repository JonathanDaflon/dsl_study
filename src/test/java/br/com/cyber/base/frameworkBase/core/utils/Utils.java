package br.com.cyber.base.frameworkBase.core.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

import javax.imageio.ImageIO;

import br.com.cyber.base.frameworkBase.core.interaction.Interactions;
import br.com.cyber.base.frameworkBase.enums.ExceptionsMessages;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utils {

	private static final File fileSuccess = new File(pathScreenshot() + "sucesso");
	private static final File fileError = new File(pathScreenshot() + "erro");

	private static final Logger log = LoggerFactory.getLogger(Utils.class.getSimpleName());

	public static void fullPageScreenshot(String path, String nome, WebDriver driver) {
		log.info(String.format("Método: fullPageScreenshot() - Tirando Screenshot do arquivo %s", nome));

		try {
			new Interactions().frameDefault();
			Screenshot screenshot = new AShot()
					.shootingStrategy(
							ShootingStrategies
							.viewportPasting(1000)
					).takeScreenshot(driver);

			ImageIO.write(
					screenshot.getImage(),
					"PNG",
					new File(String.format("%s_%s.png", path, nome))
			);
			log.info(String.format("Salvando a Printscreen no Caminho %s", path));
			log.info(String.format("O nome da Printscreen é %s", nome));

		} catch (IOException e) {
			ExceptionsMessages.IO_EXCEPTION.getException(e, "");
		}
	}

	public static String formatter() {
		return DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss").format(LocalDateTime.now());
	}

	public static String pathScreenshot() {
		return "target" + File.separator + "evidencias"	+ File.separator + "screenshots" + File.separator;
	}

	public static void deleteFiles() {
		if (Objects.requireNonNull(fileSuccess.listFiles()).length > 0)
			Arrays.stream(Objects.requireNonNull(fileSuccess.listFiles()))
				.forEach(f -> {
					if(!f.delete())
						log.error("Erro ao tentar esvaziar a pasta de Evidencias/Sucesso");
				});

		if (Objects.requireNonNull(fileError.listFiles()).length > 0)
			Arrays.stream(Objects.requireNonNull(fileError.listFiles()))
				.forEach(f -> {
					if(!f.delete())
						log.error("Erro ao tentar esvaziar a pasta de Evidencias/Erro");
				});
	}

	public static void createFiles() {
		if(new File(pathScreenshot()).mkdirs())
			log.info("Criando diretório de Screenshots");

		if(fileSuccess.mkdirs())
			log.info("Criando subdiretório de erro em Screenshots");

		if(fileError.mkdirs())
			log.info("Criando subdiretório de sucesso em Screenshots");
	}
}
