package model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.vraptor.ioc.Component;

import model.base.Bicicleta;
import model.base.Estacao;

@Component
public class EstacaoDAO {
	private static ArrayList<Estacao> arrayList = new ArrayList<Estacao>();
	
	

	public void salva(Estacao estacao) {
		estacao.setId(arrayList.size());
		arrayList.add(estacao);
	}
	
	public void atualiza(Estacao estacao) {
		if (arrayList.contains(estacao)) {
			arrayList.remove(estacao);
			arrayList.add(estacao);
		}
	}
	
	public void remove(Estacao estacao) {
		arrayList.remove(estacao);
	}
	
	public Estacao encontra(int id) {
		for (Estacao estacao : arrayList) {
			if (estacao.getId() == id) {
				return estacao;
			}
		}
		return null;
	}
	
	// TODO ajustar documento, retirei busca por capacidade: não faz muito sentido
	/**
	 * Cria e retorna uma lista com todas as estações que são qualificadas pelos parâmetros da busca.
	 * @param nomeBusca
	 * Expressão regular para identificar o nome da estação;
	 */
	public List<Estacao> lista(String nomeBusca) {
		ArrayList<Estacao> list = new ArrayList<Estacao>();
		Pattern nomePattern = Pattern.compile(nomeBusca);
		
		for (Estacao estacao : arrayList) {
			if (nomePattern.matcher(estacao.getNome()).matches()) {
				list.add(estacao);
			}
		}
		
		return list;
	}
	
	// Esses métodos tem sobreposição com o método do BicicletaDAO, seria realmente necessário?
	/**
	 * Cria e retorna uma lista com todas as bicicletas que são qualificadas pelos parâmetros da busca.
	 * @param placaBusca
	 * Expressão regular para identificar a placa da bicicleta;
	 * @param tipoBusca
	 * Expressão regular para identificar o tipo da bicicleta;
	 * @param estacaoBusca
	 * Id da estacao que hospeda a bicicleta;
	 */
	public List<Bicicleta> listaBicicletas(String placaBusca, String tipoBusca, int estacaoBusca) {
		BicicletaDAO bicicletaDAO = new BicicletaDAO();
		
		return bicicletaDAO.lista(placaBusca, tipoBusca, estacaoBusca, false);
	}
	
	/**
	 * Cria e retorna uma lista com todas as bicicletas que são qualificadas pelos parâmetros da busca.
	 * @param placaBusca
	 * Expressão regular para identificar a placa da bicicleta;
	 * @param tipoBusca
	 * Expressão regular para identificar o tipo da bicicleta;
	 * @param estacaoBusca
	 * Expressão regular para identificar o nome da estação da bicicleta;
	 */
	public List<Bicicleta> listaBicicletas(String placaBusca, String tipoBusca, String estacaoBusca) {
		BicicletaDAO bicicletaDAO = new BicicletaDAO();
		
		return bicicletaDAO.lista(placaBusca, tipoBusca, estacaoBusca, false);
		
	}
}
