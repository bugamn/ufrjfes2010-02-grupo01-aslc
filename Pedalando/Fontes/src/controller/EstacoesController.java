package controller;

import java.util.ArrayList;
import java.util.List;

import model.base.Estacao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;
import model.vo.EstacaoVO;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class EstacoesController {
	private final EstacaoDAO estacaoDAO;
	private final BicicletaDAO bicicletaDAO;
	private final Validator validator;
	private final Result result;
	
	/**
	 * Construtor do controlador de estacoes
	 * @param estacaoDAO
	 * DAO da classe Estacao
	 * @param bicicletaDAO
	 * DAO da classe Bicicleta
	 * @param result
	 * Utilizado pelo vRaptor para redirecionamento
	 * @param validator
	 * Utilizado pelo vRaptor para fazer validacao
	 */
	public EstacoesController(EstacaoDAO estacaoDAO, BicicletaDAO bicicletaDAO, Result result, Validator validator) {
		this.estacaoDAO = estacaoDAO;
		this.bicicletaDAO = bicicletaDAO;
		this.result = result;
		this.validator = validator;
	}
	
	/**
	 * Adiciona uma nova estacao
	 * @param estacao
	 * A estacao a ser adicionada
	 */
	public void adiciona(final Estacao estacao) {
		
		validator.validate(estacao);
		if(validator.onErrorUsePageOf(EstacoesController.class) != null)
			validator.onErrorUsePageOf(EstacoesController.class).formulario();
		
		estacaoDAO.salva(estacao);
		result.redirectTo(this).lista(".*");
	}
	
	/**
	 * Metodo chamado pelo vRaptor para criar
	 * a jsp de insercao de estacao  
	 */
	public void formulario() {}
	
	/**
	 * Metodo chamado pelo vRaptor para criar
	 * a jsp de busca de estacao
	 */
	public void busca() {}
	
	/**
	 * Metodo utilizado para listar
	 * @param nomeBusca
	 * Expressao regular para o nome
	 * @return
	 * Lista de estacoes encontradas pelo listar
	 */
	public List<Estacao> lista(String nomeBusca) {
		if (nomeBusca == null) {
			nomeBusca = "";
		}
		nomeBusca = ".*" + nomeBusca + ".*";
		return estacaoDAO.lista(nomeBusca);
	}
	
	/**
	 * Metodo que consulta estacoes e suas bicicletas
	 * @param nomeBusca
	 * Expressao regular para o nome da estacao a 
	 * ser buscado
	 * @return
	 * Retorna um array de estacaoVO, que contém
	 * uma estacao e bicicletas associadas
	 */
	public List<EstacaoVO> consulta(String nomeBusca) {
		List<Estacao> lista;
		ArrayList<EstacaoVO> estacaoVOs = new ArrayList<EstacaoVO>();
		EstacaoVO vo;
		
		if (nomeBusca == null) {
			nomeBusca = "";
		}
		nomeBusca = ".*" + nomeBusca + ".*";
		lista = estacaoDAO.lista(nomeBusca);
		
		for (Estacao estacao : lista) {
			vo = new EstacaoVO();
			vo.setEstacao(estacao);
			vo.setBicicletas(bicicletaDAO.lista(".*", ".*", estacao.getNome(),false));
			estacaoVOs.add(vo);
		}
		
		return estacaoVOs;
	}
	
	/**
	 * Metodo chamado pelo vRaptor para criar a jsp 
	 * de edicao de uma estacao
	 * @param id
	 * id da estacao a ser alterada
	 * @return
	 * retorna a estacao para que seja possivel exibir
	 * as informacoes na tela
	 */
	public Estacao edita(int id) {
		return estacaoDAO.encontra(id);
	}
	
	/**
	 * Metodo utilizado para alterar as infomacoes de 
	 * uma estacao
	 * @param estacao
	 * Estacao com os novos dados a serem alterados 
	 */
	public void altera(Estacao estacao) {
		validator.validate(estacao);
		validator.onErrorUsePageOf(EstacoesController.class).edita(estacao.getId());
		
		estacaoDAO.atualiza(estacao);
		result.redirectTo(EstacoesController.class).lista(estacao.getNome());
	}
	
	/**
	 * Metodo que remove uma estacao
	 * @param id
	 * id da estacao a ser removida
	 */
	public void remove(int id) {
		Estacao estacao = estacaoDAO.encontra(id);
		estacaoDAO.remove(estacao);
		result.redirectTo(EstacoesController.class).lista(".*");
	}
}
