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
	 * @param bicicletaDAO	Objeto DAO para armazenar e acessar as bicicletas
	 * @param estacaoDAO	Objeto DAO para armazenar e acessar as estacoes
	 * @param result		Usado pelo vraptor para fazer redirecionamentos
	 * @param validator		Objeto do vraptor para validar os modelos do dominio
	 */
	public BicicletasController(BicicletaDAO bicicletaDAO, EstacaoDAO estacaoDAO, Result result, Validator validator) {
		this.bicicletaDAO = bicicletaDAO;
		this.estacaoDAO = estacaoDAO;
		this.result = result;
		this.validator = validator;
	}
	
	/**
	 * Metodo correspondente a pagina adiciona.jsp que adiciona a bicicleta recebida
	 * na estacao referenciada por id
	 * 
	 * @param bicicleta		Bicicleta a ser inserida
	 * @param id			Id da estacao que a bicicleta sera inserida
	 */
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
	
	/**
	 * Metodo que retorna a lista de estacoes existentes no dominio para ser usada pelo formulario.jsp
	 * 
	 * @return		Lista de estacoes
	 */
	public List<Estacao> formulario() {
		return estacaoDAO.lista(".*");
	}
	
	/**
	 * Metodo que retorna a lista de estacoes existentes no dominio para ser usada pelo busca
	 * 
	 * @return		Lista de estacoes
	 */
	public List<Estacao> busca() {
		return estacaoDAO.lista(".*");
	}

	/**
	 * Metodo que retorna uma lista de bicicletas que passam pelas expressoes 
	 * regulares recebidas
	 * 
	 * @param placaBusca		Expressao regular para filtrar os resultados correspondente por placa 
	 * @param tipoBusca			Expressao regular para filtrar os resultados correspondente por tipo
	 * @param estacaoBusca		Expressao regular para filtrar os resultados correspondente por estacao
	 * @return					Lista de bicicletas cujos atributos atendem as expressoes regulares recebidas
	 */
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
	
	/**
	 * Prepara os dados da bicicleta que sera editada para serem utilizados na edita.jsp e os retorna
	 * como um bicicletaVO que pode ser lido na edita.jsp para preencher o formulario de edicao  
	 * 
	 * @param placa		Placa da bicicleta que sera editada
	 * @return			bicicletaVO com os dados da bicicleta que deve ser editada
	 */
	public BicicletaVO edita(String placa) {
		BicicletaVO bicicletaVO = new BicicletaVO();
		Bicicleta bicicleta = bicicletaDAO.encontra(placa);
		
		bicicletaVO.setPlaca(bicicleta.getPlaca());
		bicicletaVO.setTipo(bicicleta.getTipo());
		bicicletaVO.setEstacao(bicicleta.getEstacao());
		bicicletaVO.setEstacoes(estacaoDAO.lista(".*"));
		
		return bicicletaVO;
	}
	
	/**
	 * Atualiza os atributos da bicicleta com id = id e os atualiza com os atributos atualizados 
	 * recebidos em bicicleta
	 * 
	 * @param bicicleta		Instancia de bicicleta com os atributos atualizados
	 * @param id			Id da biciceta que deve ser atualizada no bicicletasDAO
	 */
	public void altera(Bicicleta bicicleta, int id) {
		bicicleta.setEstacao(estacaoDAO.encontra(id));
		Bicicleta bic = bicicletaDAO.encontra(bicicleta.getPlaca());
		bicicleta.setAlugada(bic.isAlugada());
		
		validator.validate(bicicleta);
		validator.onErrorUsePageOf(BicicletasController.class).edita(bicicleta.getPlaca());
		
		bicicletaDAO.atualiza(bicicleta);
		result.redirectTo(BicicletasController.class).lista(bicicleta.getPlaca(), ".*", ".*");
	}
	
	/**
	 * Remove a bicicleta com a placa recebida
	 * 
	 * @param placa		Placa da bicicleta a ser removida
	 */
	public void remove(String placa) {
		Bicicleta bicicleta = bicicletaDAO.encontra(placa);
		bicicletaDAO.remove(bicicleta);
		result.redirectTo(BicicletasController.class).lista(".*", ".*", ".*");
	}
}
