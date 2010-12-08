package controller;

import java.util.ArrayList;
import java.util.List;

import model.base.Bicicleta;
import model.base.Estacao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;
import model.vo.BicicletaVO;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class BicicletasController {
	private final BicicletaDAO bicicletaDAO;
	private final EstacaoDAO estacaoDAO;
	private final Result result;
	private final Validator validator;
	
	/**
	 * Construtor do Controlador de jsp das Bicicletas
	 * 
	 * @param bicicletaDAO	Objeto para armazenar as bicicletas
	 * @param estacaoDAO
	 * @param result
	 * @param validator
	 */
	public BicicletasController(BicicletaDAO bicicletaDAO, EstacaoDAO estacaoDAO, Result result, Validator validator) {
		this.bicicletaDAO = bicicletaDAO;
		this.estacaoDAO = estacaoDAO;
		this.result = result;
		this.validator = validator;
	}
	
	public void adiciona(Bicicleta bicicleta, int id) {
		bicicleta.setEstacao(estacaoDAO.encontra(id));
		bicicleta.setAlugada(false);
		validator.validate(bicicleta);
		
		if(validator.onErrorUsePageOf(BicicletasController.class) != null)
			validator.onErrorUsePageOf(BicicletasController.class).formulario();
		
		ArrayList<Bicicleta> bicicletas = 
			bicicletaDAO.encontraBicicletasEmEstacao(
					bicicleta.getEstacao());
		if ( bicicletas.size() >= bicicleta.getEstacao().getCapacidade()) {
	        validator.add(new ValidationMessage("Capacidade da estação está esgotada", "Estação"));
	    }
		
		if(validator.onErrorUsePageOf(this) != null)
			validator.onErrorUsePageOf(this).formulario();
		
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
		return bicicletaDAO.lista(placaBusca, tipoBusca, estacaoBusca, false);		
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
		Bicicleta bic = bicicletaDAO.encontra(bicicleta.getPlaca());
		bicicleta.setAlugada(bic.isAlugada());
		
		validator.validate(bicicleta);
		validator.onErrorUsePageOf(BicicletasController.class).edita(bicicleta.getPlaca());
		
		bicicletaDAO.atualiza(bicicleta);
		result.redirectTo(BicicletasController.class).lista(bicicleta.getPlaca(), ".*", ".*");
	}
	
	public void remove(String placa) {
		Bicicleta bicicleta = bicicletaDAO.encontra(placa);
		bicicletaDAO.remove(bicicleta);
		result.redirectTo(BicicletasController.class).lista(".*", ".*", ".*");
	}
}
