package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.vraptor.ioc.Component;

import model.base.Reserva;

@Component
public class ReservaDAO {
	private final ArrayList<Reserva> arrayList = new ArrayList<Reserva>();

	public void salva(Reserva reserva) {
		reserva.setId(arrayList.size());
		arrayList.add(reserva);
	}
	
	public void atualiza(Reserva reserva) {
		if (arrayList.contains(reserva)) {
			arrayList.remove(reserva);
			arrayList.add(reserva);
		}
	}
	
	public void remove(Reserva reserva) {
		arrayList.remove(reserva);
	}
	
	public Reserva encontra(int id) {
		for (Reserva reserva : arrayList) {
			if (reserva.getId() == id) {
				return reserva;
			}
		}
		return null;
	}
	
	// TODO ajustar documento, retirei busca por capacidade: não faz muito sentido
	/**
	 * Cria e retorna uma lista com todas as locações que são qualificadas pelos parâmetros da busca.
	 * @param cpfBusca
	 * Expressão regular para identificar o cpf do Reserva;
	 * @param nomeBusca
	 * Expressão regular para identificar o nome do Reserva;
	 * @param enderecoBusca
	 * Expressão regular para identificar o endereco do Reserva;
	 */
	public List<Reserva> lista(String estacaoBusca, String cpfBusca, String destinoBusca) {
		ArrayList<Reserva> list = new ArrayList<Reserva>();
		Pattern estacaoPattern = Pattern.compile(estacaoBusca);
		Pattern cpfPattern = Pattern.compile(cpfBusca);
		Pattern destinoPattern = Pattern.compile(destinoBusca);
		
		for (Reserva reserva : arrayList) {
			if (estacaoPattern.matcher(reserva.getEstacao().getNome()).matches() &&
					cpfPattern.matcher(reserva.getUsuario().getCpf()).matches() &&
					destinoPattern.matcher(reserva.getDestino().getNome()).matches()) {
				list.add(reserva);
			}
		}
		
		return list;
	}
	
	/**
	 * Cria e retorna uma lista com todas as locações que são qualificadas pelos parâmetros da busca.
	 * @param estacaoBusca
	 * Expressão regular para identificar o nome da estacao de partida da Locação;
	 * @param placaBusca
	 * Expressão regular para identificar a bicicleta da Locação;
	 * @param cpfBusca
	 * Expressão regular para identificar o cpf do usuario da Locação;
	 * @param destinoBusca
	 * Expressão regular para identificar o nome da estacao de destino da Locação;
	 * @param before
	 * Limite mínimo para as datas de locações;
	 * @param after
	 * Limite máximo para as datas de locações;
	 */
	public List<Reserva> lista(String estacaoBusca, String cpfBusca, String destinoBusca, Date before, Date after) {
		ArrayList<Reserva> list = new ArrayList<Reserva>();
		Pattern estacaoPattern = Pattern.compile(estacaoBusca);
		Pattern cpfPattern = Pattern.compile(cpfBusca);
		Pattern destinoPattern = Pattern.compile(destinoBusca);
		
		for (Reserva reserva : arrayList) {
			if (estacaoPattern.matcher(reserva.getEstacao().getNome()).matches() &&
					cpfPattern.matcher(reserva.getUsuario().getCpf()).matches() &&
					destinoPattern.matcher(reserva.getDestino().getNome()).matches() &&
					before.before(reserva.getData()) && after.after(reserva.getData())) {
				list.add(reserva);
			}
		}
		
		return list;
	}

}
