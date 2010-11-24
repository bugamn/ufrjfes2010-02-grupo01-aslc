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
	
	
	public EstacoesController(EstacaoDAO estacaoDAO, BicicletaDAO bicicletaDAO, Result result, Validator validator) {
		this.estacaoDAO = estacaoDAO;
		this.bicicletaDAO = bicicletaDAO;
		this.result = result;
		this.validator = validator;
	}
	
	public void adiciona(final Estacao estacao) {
		
		validator.validate(estacao);
		validator.onErrorUsePageOf(EstacoesController.class).formulario();
		
		estacaoDAO.salva(estacao);
		result.redirectTo(this).lista(".*");
	}
	
	public void formulario() {}
	
	public void busca() {}
	
	public List<Estacao> lista(String nomeBusca) {
		if (nomeBusca == null) {
			nomeBusca = "";
		}
		nomeBusca = ".*" + nomeBusca + ".*";
		return estacaoDAO.lista(nomeBusca);
	}
	
	//Em desenvolvimento deverá retornar uma lista de Consulta
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
			vo.setBicicletas(bicicletaDAO.lista(".*", ".*", estacao.getNome()));
			estacaoVOs.add(vo);
		}
		
		return estacaoVOs;
	}
	
	public Estacao edita(int id) {
		return estacaoDAO.encontra(id);
	}
	
	public void altera(Estacao estacao) {
		validator.validate(estacao);
		validator.onErrorUsePageOf(EstacoesController.class).edita(estacao.getId());
		
		estacaoDAO.atualiza(estacao);
		result.redirectTo(EstacoesController.class).lista(estacao.getNome());
	}
	
	public void remove(int id) {
		Estacao estacao = estacaoDAO.encontra(id);
		estacaoDAO.remove(estacao);
		result.redirectTo(EstacoesController.class).lista(".*");
	}
}
