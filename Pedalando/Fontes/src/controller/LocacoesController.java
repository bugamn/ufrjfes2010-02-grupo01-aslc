package controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.base.Estacao;
import model.base.Locacao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;
import model.dao.LocacaoDAO;
import model.dao.UsuarioDAO;

@Resource
public class LocacoesController {
	private final LocacaoDAO locacaoDAO;
	private final EstacaoDAO estacaoDAO;
	private final BicicletaDAO bicicletaDAO;
	private final UsuarioDAO usuarioDAO;
	private final Result result;
	
	public LocacoesController(LocacaoDAO locacaoDAO, EstacaoDAO estacaoDAO, BicicletaDAO bicicletaDAO, UsuarioDAO usuarioDAO, Result result) {
		this.locacaoDAO = locacaoDAO;
		this.estacaoDAO = estacaoDAO;
		this.bicicletaDAO = bicicletaDAO;
		this.usuarioDAO = usuarioDAO;
		this.result = result;
	}

	public void adiciona(int origem, int destino, String cpf, String placa) {
		Locacao locacao = new Locacao();
		
		locacao.setEstacao(estacaoDAO.encontra(origem));
		locacao.setDestino(estacaoDAO.encontra(destino));
		locacao.setBicicleta(bicicletaDAO.encontra(placa));
		locacao.setUsuario(usuarioDAO.encontra(cpf));
		locacao.setData(new Date(System.currentTimeMillis()));
		
		locacaoDAO.salva(locacao);
		//result.redirectTo(this).lista(".*", ".*", ".*", ".*", null, null);
	}
	
	public List<Estacao> formulario() {
		return estacaoDAO.lista(".*");
	}
	
	public List<Estacao> busca() {
		return estacaoDAO.lista(".*");
	}
	
	public List<Locacao> lista(String estacaoBusca, String placaBusca, String cpfBusca, String destinoBusca,
			int diaAntes, int mesAntes, int anoAntes, int diaDepois, int mesDepois, int anoDepois) {
		Date before, after;
		GregorianCalendar calendar = new GregorianCalendar();
		
		before = new Date();
		after = new Date();
		
		calendar.set(anoAntes, mesAntes, diaAntes);
		before.setTime(calendar.getTimeInMillis());
		
		calendar.set(anoDepois, mesDepois, diaDepois);
		after.setTime(calendar.getTimeInMillis());
		
		estacaoBusca = ".*" + estacaoBusca + ".*";
		placaBusca = ".*" + placaBusca + ".*";
		cpfBusca = ".*" + cpfBusca + ".*";
		destinoBusca = ".*" + destinoBusca + ".*";
		
		return locacaoDAO.lista(estacaoBusca, placaBusca, cpfBusca, destinoBusca, before, after);
	}
}
