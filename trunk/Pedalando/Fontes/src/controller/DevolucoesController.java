package controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import model.base.Bicicleta;
import model.base.Devolucao;
import model.base.Estacao;
import model.base.Locacao;
import model.dao.DevolucaoDAO;
import model.dao.EstacaoDAO;
import model.dao.LocacaoDAO;
import model.vo.DevolucaoVO;

@Resource
public class DevolucoesController {
	private final LocacaoDAO locacaoDAO;
	private final EstacaoDAO estacaoDAO;
	private final DevolucaoDAO devolucaoDAO;
	private final Result result;
	private final Validator validator;

	/**
	 * Construtor publico para o Controller de Devolucoes
	 * @param locacaoDAO
	 * Um objeto de acesso aos dados de Locacao
	 * @param estacaoDAO
	 * Um objeto de acesso aos dados de Estacao
	 * @param devolucaoDAO
	 * Um objeto de acesso aos dados de Devolucao
	 * @param result
	 * Um objeto de result do VRaptor
	 * @param validator
	 * Um objeto de validacao do VRaptor
	 */
	public DevolucoesController(LocacaoDAO locacaoDAO, EstacaoDAO estacaoDAO, DevolucaoDAO devolucaoDAO, Result result, Validator validator) {
		
		this.locacaoDAO = locacaoDAO;
		this.estacaoDAO = estacaoDAO;
		this.devolucaoDAO = devolucaoDAO;
		this.result = result;
		this.validator = validator;
	}
	
	/**
	 * Método para adicionar uma nova devolucao
	 * @param idLocacao
	 * Id da locacao que foi finalizada com a devolucao
	 * @param idEstacao
	 * Id da estação que recebeu a bicicleta
	 */
	public void adiciona(int idLocacao, int idEstacao) {
		Locacao locacao = locacaoDAO.encontra(idLocacao);
		Estacao estacao = estacaoDAO.encontra(idEstacao);
		Devolucao devolucao = new Devolucao();
		
		devolucao.setLocacao(locacao);
		devolucao.setEstacao(estacao);
		devolucao.setData(new Date(System.currentTimeMillis()));
		
		validator.validate(devolucao);
		if(validator.onErrorUsePageOf(this) != null)
			validator.onErrorUsePageOf(this).formulario(idLocacao);
		
		Bicicleta bicicleta = locacao.getBicicleta();
		bicicleta.setEstacao(estacao);
		bicicleta.setAlugada(false);
		
		devolucaoDAO.salva(devolucao);
		locacao.setWorking(false);
		locacaoDAO.atualiza(locacao);
		result.redirectTo(this).lista("", "", 0, 0, 0, 0, 0, 0);
	}
	
	/**
	 * Metodo para preparar um formulario para criacao de uma nova devolucao
	 * @param id
	 * Id da locacao que sera finalizada com a devolucao
	 * @return
	 * Um objeto com estacoes e a locacao a ser terminada para fornecer a jsp os dados para completar o formulário
	 */
	public DevolucaoVO formulario(int id) {
		DevolucaoVO devolucaoVO = new DevolucaoVO();
		
		devolucaoVO.setLocacao(locacaoDAO.encontra(id));
		devolucaoVO.setEstacaos(estacaoDAO.lista(".*"));
		
		if (devolucaoVO.getLocacao() == null) {
			result.redirectTo(this).lista("", "", 0, 0, 0, 0, 0, 0);
		}
		
		return devolucaoVO;
	}
	
	/**
	 * Metodo que o VRaptor chama para criar um formulario de busca
	 */
	public void busca() {}
	
	/**
	 * Metodo para formacao de listas para buscas
	 * @param estacaoBusca
	 * Expressao regular para o nome da estacao
	 * @param nomeBusca
	 * Expressao regular para o nome do usuario
	 * @param diaAntes
	 * Dia antes, 0 para qualquer (aproxima para 1), para o limite de data
	 * @param mesAntes
	 * Mes antes, 0 para qualquer (aproxima para Janeiro), para o limite de data
	 * @param anoAntes
	 * Ano antes, 0 para qualquer (aproxima para 2010), para o limite de data
	 * @param diaDepois
	 * Dia depois, para o limite de data
	 * @param mesDepois
	 * Mes depois, para o limite de data
	 * @param anoDepois
	 * Ano depois, para o limite de data
	 * @return
	 */
	public List<Devolucao> lista(String estacaoBusca, String nomeBusca, 
			int diaAntes, int mesAntes, int anoAntes, int diaDepois, int mesDepois, int anoDepois) {
		Date antes, depois;
		GregorianCalendar calendar = new GregorianCalendar();
		antes = new Date();
		depois = new Date();
		
		if (estacaoBusca == null) {
			estacaoBusca = "";
		}
		if (nomeBusca == null) {
			nomeBusca = "";
		}
		
		estacaoBusca = ".*" + estacaoBusca + ".*";
		nomeBusca = ".*" + nomeBusca + ".*";
		
		if (diaAntes == 0 && mesAntes == 0 && anoAntes == 0 && diaDepois == 0 && mesDepois == 0 && anoDepois == 0) {
			return devolucaoDAO.lista(estacaoBusca, nomeBusca);
		}
		
		if (diaAntes == 0) {
			diaAntes = 1;
		}
		if (mesAntes == 0) {
			mesAntes = 0;
		}
		if (anoAntes == 0) {
			anoAntes = 2010;
		}
		mesAntes--;
		
		calendar.set(anoAntes, mesAntes, diaAntes);
		antes.setTime(calendar.getTimeInMillis());
		if (diaDepois == 0 && mesDepois == 0 && anoDepois == 0) {
			depois.setTime(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 365);
		} else {
			mesDepois--;
			calendar.set(anoDepois, mesDepois, diaDepois);
			depois.setTime(calendar.getTimeInMillis());
			
		}
		return devolucaoDAO.lista(estacaoBusca, nomeBusca, antes, depois);
	}
}
