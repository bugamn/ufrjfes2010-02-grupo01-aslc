package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;

import model.base.Locacao;

public class LocacaoDAO {
private final TreeSet<Locacao> treeSet;
	
	public LocacaoDAO() {
		treeSet = new TreeSet<Locacao>();
	}

	public void salva(Locacao locacao) {
		treeSet.add(locacao);
	}
	
	public void atualiza(Locacao locacao) {
		if (treeSet.contains(locacao)) {
			treeSet.remove(locacao);
			treeSet.add(locacao);
		}
	}
	
	public void remove(Locacao locacao) {
		treeSet.remove(locacao);
	}
	
	public Locacao encontra(int id) {
		for (Locacao locacao : treeSet) {
			if (locacao.getId() == id) {
				return locacao;
			}
		}
		return null;
	}
	
	// TODO ajustar documento, retirei busca por capacidade: não faz muito sentido
	/**
	 * Cria e retorna uma lista com todas as locações que são qualificadas pelos parâmetros da busca.
	 * @param cpfBusca
	 * Expressão regular para identificar o cpf do Locacao;
	 * @param nomeBusca
	 * Expressão regular para identificar o nome do Locacao;
	 * @param enderecoBusca
	 * Expressão regular para identificar o endereco do Locacao;
	 */
	public List<Locacao> lista(String estacaoBusca, String placaBusca, String cpfBusca, String destinoBusca) {
		ArrayList<Locacao> list = new ArrayList<Locacao>();
		Pattern estacaoPattern = Pattern.compile(estacaoBusca);
		Pattern cpfPattern = Pattern.compile(cpfBusca);
		Pattern placaPattern = Pattern.compile(placaBusca);
		Pattern destinoPattern = Pattern.compile(destinoBusca);
		
		for (Locacao locacao : treeSet) {
			if (estacaoPattern.matcher(locacao.getEstacao().getNome()).matches() &&
					cpfPattern.matcher(locacao.getUsuario().getCpf()).matches() &&
					destinoPattern.matcher(locacao.getDestino().getNome()).matches() &&
					placaPattern.matcher(locacao.getBicicleta().getPlaca()).matches()) {
				list.add(locacao);
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
	public List<Locacao> lista(String estacaoBusca, String placaBusca, String cpfBusca, String destinoBusca, Date before, Date after) {
		ArrayList<Locacao> list = new ArrayList<Locacao>();
		Pattern estacaoPattern = Pattern.compile(estacaoBusca);
		Pattern cpfPattern = Pattern.compile(cpfBusca);
		Pattern placaPattern = Pattern.compile(placaBusca);
		Pattern destinoPattern = Pattern.compile(destinoBusca);
		
		for (Locacao locacao : treeSet) {
			if (estacaoPattern.matcher(locacao.getEstacao().getNome()).matches() &&
					cpfPattern.matcher(locacao.getUsuario().getCpf()).matches() &&
					destinoPattern.matcher(locacao.getDestino().getNome()).matches() &&
					placaPattern.matcher(locacao.getBicicleta().getPlaca()).matches() &&
					before.before(locacao.getData()) && after.after(locacao.getData())) {
				list.add(locacao);
			}
		}
		
		return list;
	}
}
