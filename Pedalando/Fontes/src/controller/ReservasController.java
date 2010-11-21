package controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import model.base.Estacao;
import model.base.Reserva;
import model.dao.EstacaoDAO;
import model.dao.ReservaDAO;
import model.dao.UsuarioDAO;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ReservasController {
	private final ReservaDAO reservaDAO;
	private final EstacaoDAO estacaoDAO;
	private final UsuarioDAO usuarioDAO;
	private final Result result;
	
	public ReservasController(ReservaDAO reservaDAO, EstacaoDAO estacaoDAO, UsuarioDAO usuarioDAO, Result result) {
		this.reservaDAO = reservaDAO;
		this.estacaoDAO = estacaoDAO;
		this.usuarioDAO = usuarioDAO;
		this.result = result;
	}

	public void adiciona(int origem, int destino, String cpf, int dia, int mes, int ano, int hora, int minuto) {
		Reserva reserva = new Reserva();
		
		reserva.setEstacao(estacaoDAO.encontra(origem));
		reserva.setDestino(estacaoDAO.encontra(destino));
		reserva.setUsuario(usuarioDAO.encontra(cpf));
		reserva.setData(new Date(new GregorianCalendar(ano, mes, dia, hora, minuto).getTimeInMillis()));		
		
		reservaDAO.salva(reserva);
		//result.redirectTo(this).lista(".*", ".*", ".*", null, null);
	}
	
	
	//é necessário melhorar isso!
	public List<Reserva> lista(String estacaoBusca, String cpfBusca, String destinoBusca, 
			int diaAntes, int mesAntes, int anoAntes, int diaDepois, int mesDepois, int anoDepois) {
		Date antes, depois;
		antes = new Date(new GregorianCalendar(anoAntes, mesAntes, diaAntes).getTimeInMillis());
		depois = new Date(new GregorianCalendar(anoDepois, mesDepois, diaDepois).getTimeInMillis());
		
		estacaoBusca = ".*" + estacaoBusca + ".*";
		cpfBusca = ".*" + cpfBusca + ".*";
		destinoBusca = ".*" + destinoBusca + ".*";
		
		return reservaDAO.lista(estacaoBusca, cpfBusca, destinoBusca, antes, depois);
	}
	
	public Reserva edita(int id) {
		return reservaDAO.encontra(id);
	}
	
	public void altera(Reserva reserva) {
		reservaDAO.atualiza(reserva);
		result.redirectTo(this).lista(reserva.getEstacao().getNome(), reserva.getUsuario().getCpf(), ".*", 0, 0, 0, 0, 0, 0);
	}
	
	public void remove(int id) {
		Reserva reserva = reservaDAO.encontra(id);
		reservaDAO.remove(reserva);
		result.redirectTo(this).lista(".*", ".*", ".*", 0, 0, 0, 0, 0, 0);
	}
	
	public List<Estacao> formulario() {
		return estacaoDAO.lista(".*");
	}

}
