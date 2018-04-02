
package les12015.controle.web.command.impl;

import les12015.core.aplicacao.Resultado;
import les12015.dominio.EntidadeDominio;


public class SalvarCommand extends AbstractCommand{

	
	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.salvar(entidade);
	}

}
