package controller;

import java.util.List;

import model.base.Bicicleta;
import model.base.Estacao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;
import model.vo.BicicletaVO;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class BicicletasController {
	private final BicicletaDAO bicicletaDAO;
	private final EstacaoDAO estacaoDAO;
	private final Result result;
	private final Validator validator;

	public BicicletasController(BicicletaDAO bicicletaDAO, EstacaoDAO estacaoDAO, Result result, Validator validator) {
		this.bicicletaDAO = bicicletaDAO;
		this.estacaoDAO = estacaoDAO;
		this.result = result;
		this.validator = validator;
	}
	
	public void adiciona(Bicicleta bicicleta, int id) {
		bicicleta.setEstacao(estacaoDAO.encontra(id));
		
		validator.validate(bicicleta);
		validator.onErrorUsePageOf(BicicletasController.class).formulario();
		
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
	
	public BicicletaVO edita(String placa) {
		BicicletaVO bicicletaVO = new BicicletaVO();
		Bicicleta bicicleta = bicicletaDAO.encontra(placa);
		
		bicicletaVO.setPlaca(bicicleta.getPlaca());
		bicicletaVO.setTipo(bicicleta.getTipo());
		bicicletaVO.setEstacao(bicicleta.getEstacao());
		bicicletaVO.setEstacoes(estacaoDAO.lista(".*"));
		
		return bicicletaVO;
	}
	
	public void altera(Bicicleta bicicleta, int id) {
		bicicleta.setEstacao(estacaoDAO.encontra(id));
		bicicletaDAO.atualiza(bicicleta);
		result.redirectTo(BicicletasController.class).lista(bicicleta.getPlaca(), ".*", ".*");
	}
	
	public void remove(String placa) {
		Bicicleta bicicleta = bicicletaDAO.encontra(placa);
		bicicletaDAO.remove(bicicleta);
		result.redirectTo(BicicletasController.class).lista(".*", ".*", ".*");
	}
}
