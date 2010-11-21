package controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.base.Bicicleta;
import model.base.Estacao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;

@Resource
public class BicicletasController {
	private final BicicletaDAO bicicletaDAO;
	private final EstacaoDAO estacaoDAO;
	private final Result result;

	public BicicletasController(BicicletaDAO bicicletaDAO, EstacaoDAO estacaoDAO, Result result) {
		this.bicicletaDAO = bicicletaDAO;
		this.estacaoDAO = estacaoDAO;
		this.result = result;
	}
	
	public void adiciona(Bicicleta bicicleta, int id) {
		bicicleta.setEstacao(estacaoDAO.encontra(id));
		bicicletaDAO.salva(bicicleta);
		result.redirectTo(this).lista(".*", ".*", ".*");
	}
	
	public List<Estacao> formulario() {
		return estacaoDAO.lista(".*");
	}
	
	public List<Estacao> busca() {
		return estacaoDAO.lista(".*");
	}

	public List<Bicicleta> lista(String placaBusca, String tipoBusca, String estacaoBusca) {
		if (placaBusca == null) {
			placaBusca = "";
		}
		if (tipoBusca == null) {
			tipoBusca = "";
		}
		if (estacaoBusca == null) {
			estacaoBusca = "";
		}
		placaBusca = ".*" + placaBusca + ".*";
		tipoBusca = ".*" + tipoBusca + ".*";
		estacaoBusca = ".*" + estacaoBusca + ".*";
		return bicicletaDAO.lista(placaBusca, tipoBusca, estacaoBusca);		
	}
}
