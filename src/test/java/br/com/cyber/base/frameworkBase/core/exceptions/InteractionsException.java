package br.com.cyber.base.frameworkBase.core.exceptions;


import br.com.cyber.base.frameworkBase.core.utils.InputDeDados;
import br.com.cyber.base.frameworkBase.core.interaction.Interactions;
import br.com.cyber.base.frameworkBase.core.utils.Utils;

/**
 *<p><strong>Excessões Personalizadas</strong> para a classe {@link Interactions Interactions}.
 * 
 * @author Felipe Gadelha
 * @author Jonathan Daflon
 * @author Thyago Sasso
 */
public class InteractionsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public InteractionsException(String message) {
		
		this.message = String.format("%s - %s", Utils.formatter(), message);
	}

	@Override
	public String toString() {
	
		return 
		"============================ ERRO ============================"
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ this.getClass().getSimpleName() + ": " + message
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ "====================== MASSA UTILIZADA ======================"
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ InputDeDados.getInput()
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ "=========================== DICAS ==========================="
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ "Verifique se o seu Xpath está correto."
		+ System.lineSeparator()
		+ "Verifique se não existe um Iframe nessa página."
		+ System.lineSeparator()
		+ "Verifique se seu PageObject foi instanciado corretamente em caso de nullPointer."
		+ System.lineSeparator()
		;
	}
}
