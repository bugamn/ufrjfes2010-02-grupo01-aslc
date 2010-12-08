package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import model.base.Estacao;
import model.base.Reserva;
import model.dao.EstacaoDAO;
import model.dao.ReservaDAO;
import model.dao.UsuarioDAO;
import model.vo.ReservaVO;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class ReservasController {
	private final ReservaDAO reservaDAO;
	private final EstacaoDAO estacaoDAO;
	private final UsuarioDAO usuarioDAO;
	private final Result result;
	private final Validator validator;
	
	public ReservasController(ReservaDAO reservaDAO, EstacaoDAO estacaoDAO, UsuarioDAO usuarioDAO, Result result, Validator validator) {
		this.reservaDAO = reservaDAO;
		this.estacaoDAO = estacaoDAO;
		this.usuarioDAO = usuarioDAO;
		this.result = result;
		this.validator = validator;
	}

	public void adiciona(int origem, int destino, String cpf, int dia, int mes, int ano, int hora, int minuto) {
		Reserva reserva = new Reserva();
		
		reserva.setEstacao(estacaoDAO.encontra(origem));
		reserva.setDestino(estacaoDAO.encontra(destino));
		reserva.setUsuario(usuarioDAO.encontra(cpf));
		if (dia != 0 && mes != 0 && ano != 0) {
			mes--;
			reserva.setData(new Date(new GregorianCalendar(ano, mes, dia, hora, minuto).getTimeInMillis()));
		}
		
		validator.validate(reserva);
		if(validator.onErrorUsePageOf(ReservasController.class) != null)
			validator.onErrorUsePageOf(ReservasController.class).formulario();		
		
		reservaDAO.salva(reserva);
		result.redirectTo(this).lista("", "", "", 0, 0, 0, 0, 0, 0);
	}
	
	
	public List<Reserva> lista(String estacaoBusca, String cpfBusca, String destinoBusca, 
			int diaAntes, int mesAntes, int anoAntes, int diaDepois, int mesDepois, int anoDepois) {
		Date antes, depois;
		GregorianCalendar calendar = new GregorianCalendar();
		antes = new Date(new GregorianCalendar(anoAntes, mesAntes, diaAntes).getTimeInMillis());
		depois = new Date(new GregorianCalendar(anoDepois, mesDepois, diaDepois).getTimeInMillis());
		
		if (estacaoBusca == null) {
			estacaoBusca = "";
		}
		if (cpfBusca == null) {
			cpfBusca = "";
		}
		if (destinoBusca == null) {
			destinoBusca = "";
		}
		
		estacaoBusca = ".*" + estacaoBusca + ".*";
		cpfBusca = ".*" + cpfBusca + ".*";
		destinoBusca = ".*" + destinoBusca + ".*";
		
		if (diaAntes == 0 && mesAntes == 0 && anoAntes == 0 && diaDepois == 0 && mesDepois == 0 && anoDepois == 0) {
			return reservaDAO.lista(estacaoBusca, cpfBusca, destinoBusca);
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
		
		return reservaDAO.lista(estacaoBusca, cpfBusca, destinoBusca, antes, depois);
	}
	
	public ReservaVO edita(int id) {
		ReservaVO reservaVO = new ReservaVO();
		Reserva reserva = reservaDAO.encontra(id);
		Calendar data = Calendar.getInstance();
		data.setTime(reserva.getData());
		
		reservaVO.setUsuario(reserva.getUsuario());
		reservaVO.setDestino(reserva.getDestino());
		reservaVO.setEstacao(reserva.getEstacao());
		reservaVO.setEstacoes(estacaoDAO.lista(".*"));
		reservaVO.setDia(data.get(Calendar.DAY_OF_MONTH));
		reservaVO.setMes(data.get(Calendar.MONTH)+1);
		reservaVO.setAno(data.get(Calendar.YEAR));
		reservaVO.setHora(data.get(Calendar.HOUR_OF_DAY));
		reservaVO.setMinuto(data.get(Calendar.MINUTE));
		
		return reservaVO;
	}
	
	public void altera(int origem, int destino, String cpf, int dia, int mes, int ano, int hora, int minuto) {
Reserva reserva = new Reserva();
		
		reserva.setEstacao(estacaoDAO.encontra(origem));
		reserva.setDestino(estacaoDAO.encontra(destino));
		reserva.setUsuario(usuarioDAO.encontra(cpf));
		if (dia != 0 && mes != 0 && ano != 0) {
			mes--;
			reserva.setData(new Date(new GregorianCalendar(ano, mes, dia, hora, minuto).getTimeInMillis()));
		}
		
		validator.validate(reserva);
		validator.onErrorUsePageOf(ReservasController.class).formulario();		
		
		reservaDAO.atualiza(reserva);
		result.redirectTo(this).lista("", "", "", 0, 0, 0, 0, 0, 0);
	}
	
	public void remove(int id) {
		Reserva reserva = reservaDAO.encontra(id);
		reservaDAO.remove(reserva);
		result.redirectTo(this).lista(".*", ".*", ".*", 0, 0, 0, 0, 0, 0);
	}
	
	public List<Estacao> formulario() {
		return estacaoDAO.lista(".*");
	}
	
	public List<Estacao> busca() {
		return estacaoDAO.lista(".*");
	}
	
	public void realizarLocacao(int id) {
		result.redirectTo(LocacoesController.class).locacaoComReserva(id);
	}
}
