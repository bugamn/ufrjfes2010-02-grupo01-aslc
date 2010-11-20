package controller;

import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Result;
import model.base.Reserva;
import model.dao.ReservaDAO;

public class ReservasController {
	private final ReservaDAO reservaDAO;
	private final Result result;
	
	public ReservasController(ReservaDAO reservaDAO, Result result) {
		this.reservaDAO = reservaDAO;
		this.result = result;
	}

	public void adiciona(Reserva reserva) {
		reservaDAO.salva(reserva);
		result.redirectTo(this).lista(".*", ".*", ".*", null, null);
	}
	
	
	public List<Reserva> lista(String estacaoBusca, String cpfBusca, String destinoBusca, Date before, Date after) {
		if (before == null) {
			
		}
		if (after == null) {
			
		}
		return reservaDAO.lista(estacaoBusca, cpfBusca, destinoBusca, before, after);
	}

}
