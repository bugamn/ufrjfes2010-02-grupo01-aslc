package controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.base.Bicicleta;
import model.dao.BicicletaDAO;

@Resource
public class BicicletasController {
	private final BicicletaDAO bicicletaDAO;
	private final Result result;

	public BicicletasController(BicicletaDAO bicicletaDAO, Result result) {
		this.bicicletaDAO = bicicletaDAO;
		this.result = result;
	}
	
	public void adiciona(Bicicleta bicicleta) {
		bicicletaDAO.salva(bicicleta);
		result.redirectTo(this).lista(".*", ".*", ".*");
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
		tipoBusca = ".*" + estacaoBusca + ".*";
		estacaoBusca = ".*" + estacaoBusca + ".*";
		return bicicletaDAO.lista(placaBusca, tipoBusca, estacaoBusca);		
	}
}
