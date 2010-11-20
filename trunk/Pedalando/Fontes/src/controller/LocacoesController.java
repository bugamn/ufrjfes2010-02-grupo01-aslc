package controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.vraptor.Result;
import model.base.Locacao;
import model.dao.LocacaoDAO;

public class LocacoesController {
	private final LocacaoDAO locacaoDAO;
	private final Result result;
	
	public LocacoesController(LocacaoDAO locacaoDAO, Result result) {
		this.locacaoDAO = locacaoDAO;
		this.result = result;
	}

	public void adiciona(Locacao locacao) {
		locacaoDAO.salva(locacao);
		result.redirectTo(this).lista(".*", ".*", ".*", ".*", null, null);
	}
	
	
	public List<Locacao> lista(String estacaoBusca, String placaBusca, String cpfBusca, String destinoBusca, Date before, Date after) {
		if (before == null) {
			before = new Date(new GregorianCalendar(2010, 01, 01).getTimeInMillis());
		}
		if (after == null) {
			after = new Date(System.currentTimeMillis());
		}
		return locacaoDAO.lista(estacaoBusca, placaBusca, cpfBusca, destinoBusca, before, after);
	}
}
