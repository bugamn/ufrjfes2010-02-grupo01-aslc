package controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import model.base.Bicicleta;
import model.base.Estacao;
import model.base.Locacao;
import model.base.Reserva;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;
import model.dao.LocacaoDAO;
import model.dao.ReservaDAO;
import model.dao.UsuarioDAO;
import model.vo.BicicletaVO;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

@Resource
public class LocacoesController {
	private final LocacaoDAO locacaoDAO;
	private final EstacaoDAO estacaoDAO;
	private final BicicletaDAO bicicletaDAO;
	private final UsuarioDAO usuarioDAO;
	private final ReservaDAO reservaDAO;
	private final Result result;
	private final Validator validator;
	
	public LocacoesController(LocacaoDAO locacaoDAO, EstacaoDAO estacaoDAO, BicicletaDAO bicicletaDAO, UsuarioDAO usuarioDAO, 
			ReservaDAO reservaDAO, Result result, Validator validator) {
		this.locacaoDAO = locacaoDAO;
		this.estacaoDAO = estacaoDAO;
		this.bicicletaDAO = bicicletaDAO;
		this.usuarioDAO = usuarioDAO;
		this.reservaDAO = reservaDAO;
		this.result = result;
		this.validator = validator;
	}

	public void adiciona(int destino, String cpf, String placa) {
		Locacao locacao = new Locacao();
		Bicicleta bicicleta = bicicletaDAO.encontra(placa);

		if(bicicleta != null) {
			locacao.setBicicleta(bicicleta);
			locacao.setEstacao(bicicleta.getEstacao());
		}
		locacao.setDestino(estacaoDAO.encontra(destino));
		locacao.setUsuario(usuarioDAO.encontra(cpf));
		locacao.setData(new Date(System.currentTimeMillis()));
		
		validator.validate(locacao);
		validator.onErrorUsePageOf(LocacoesController.class).formulario();
		
		locacaoDAO.salva(locacao);
		result.redirectTo(this).lista("", "", "", "", 0, 0, 0, 0, 0, 0);
	}
	
	public List<Estacao> formulario() {
		return estacaoDAO.lista(".*");
	}
	
	public List<Estacao> busca() {
		return estacaoDAO.lista(".*");
	}
	
	public List<Locacao> lista(String estacaoBusca, String placaBusca, String cpfBusca, String destinoBusca,
			int diaAntes, int mesAntes, int anoAntes, int diaDepois, int mesDepois, int anoDepois) {
		Date antes, depois;
		GregorianCalendar calendar = new GregorianCalendar();
		
		antes = new Date();
		depois = new Date();
		if (placaBusca == null) {
			placaBusca = "";
		}
		if (cpfBusca == null) {
			cpfBusca = "";
		}
		if (destinoBusca == null) {
			destinoBusca = "";
		}
		if (estacaoBusca == null) {
			estacaoBusca = "";
		}
		
		estacaoBusca = ".*" + estacaoBusca + ".*";
		placaBusca = ".*" + placaBusca + ".*";
		cpfBusca = ".*" + cpfBusca + ".*";
		destinoBusca = ".*" + destinoBusca + ".*";
		
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
			depois.setTime(System.currentTimeMillis());
		} else {
			mesDepois--;
			calendar.set(anoDepois, mesDepois, diaDepois);
			depois.setTime(calendar.getTimeInMillis());
		}
		return locacaoDAO.lista(estacaoBusca, placaBusca, cpfBusca, destinoBusca, antes, depois);
	}
	
	public BicicletaVO locacaoComReserva(int id) {
		BicicletaVO bicicletaVO = new BicicletaVO();
		Reserva reserva = reservaDAO.encontra(id);
		bicicletaVO.setReserva(id);
		bicicletaVO.setBicicletas(bicicletaDAO.lista(".*", ".*", reserva.getEstacao().getNome()));
		
		return bicicletaVO;
	}
	
	public void salvaLocacaoComReserva(int id, String placa) {
		Locacao locacao = new Locacao();
		Date data = new Date(System.currentTimeMillis());
		Bicicleta bicicleta = bicicletaDAO.encontra(placa);
		Reserva reserva = reservaDAO.encontra(id);
		
		locacao.setBicicleta(bicicleta);
		locacao.setEstacao(reserva.getEstacao());
		locacao.setDestino(reserva.getDestino());
		locacao.setUsuario(reserva.getUsuario());
		locacao.setData(data);
		
		validator.validate(locacao);
		validator.onErrorUsePageOf(LocacoesController.class).locacaoComReserva(id);
		
		locacaoDAO.salva(locacao);
		reservaDAO.remove(reserva);
		result.redirectTo(LocacoesController.class).lista(locacao.getEstacao().getNome(), locacao.getBicicleta().getPlaca(), locacao.getUsuario().getCpf(), locacao.getDestino().getNome(), 0, 0, 0, 0, 0, 0);
	}
}
