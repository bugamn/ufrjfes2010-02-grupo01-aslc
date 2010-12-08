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
	
	public DevolucoesController(LocacaoDAO locacaoDAO, EstacaoDAO estacaoDAO, DevolucaoDAO devolucaoDAO, Result result, Validator validator) {
		
		this.locacaoDAO = locacaoDAO;
		this.estacaoDAO = estacaoDAO;
		this.devolucaoDAO = devolucaoDAO;
		this.result = result;
		this.validator = validator;
	}
	
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
	
	public DevolucaoVO formulario(int id) {
		DevolucaoVO devolucaoVO = new DevolucaoVO();
		
		devolucaoVO.setLocacao(locacaoDAO.encontra(id));
		devolucaoVO.setEstacaos(estacaoDAO.lista(".*"));
		
		if (devolucaoVO.getLocacao() == null) {
			result.redirectTo(this).lista("", "", 0, 0, 0, 0, 0, 0);
		}
		
		return devolucaoVO;
	}
	
	public void busca() {}
	
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
