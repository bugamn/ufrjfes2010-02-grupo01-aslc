package controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.base.Estacao;
import model.dao.EstacaoDAO;

@Resource
public class EstacoesController {
	private final EstacaoDAO estacaoDAO;
	private final Result result;
	
	public EstacoesController(EstacaoDAO estacaoDAO, Result result) {
		this.estacaoDAO = estacaoDAO;
		this.result = result;
	}
	
	public void adiciona(final Estacao estacao) {
		
		estacaoDAO.salva(estacao);
		result.redirectTo(this).lista(".*");
	}
	
	public void formulario() {}
	
	public void busca() {}
	
	public List<Estacao> lista(String nomeBusca) {
		if (nomeBusca == null) {
			nomeBusca = ".*";
		}
		return estacaoDAO.lista(nomeBusca);
	}
}
