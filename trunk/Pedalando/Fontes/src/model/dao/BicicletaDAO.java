package model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.vraptor.ioc.Component;

import model.base.Bicicleta;
import model.base.Estacao;

@Component
public class BicicletaDAO {
	private static ArrayList<Bicicleta> arrayList = new ArrayList<Bicicleta>();
	
	public BicicletaDAO() {
		if (arrayList == null) {
			arrayList = new ArrayList<Bicicleta>();
		}
	}

	public void salva(Bicicleta bicicleta) {
		arrayList.add(bicicleta);
	}
	
	public void atualiza(Bicicleta bicicleta) {
		if (arrayList.contains(bicicleta)) {
			arrayList.remove(bicicleta);
			arrayList.add(bicicleta);
		}
	}
	
	public void remove(Bicicleta bicicleta) {
		arrayList.remove(bicicleta);
	}
	
	public Bicicleta encontra(String placa) {
		for (Bicicleta bicicleta : arrayList) {
			if (bicicleta.getPlaca().equals(placa)) {
				return bicicleta;
			}
		}
		return null;
	}
	
	public ArrayList<Bicicleta> encontraBicicletasEmEstacao(Estacao estacao) {
		ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
		
		for (Bicicleta bicicleta : arrayList) {
			if (bicicleta.getEstacao().equals(estacao)) {
				bicicletas.add(bicicleta);
			}
		}
		return bicicletas;
	}
	
	// TODO ajustar documento, retirei busca por capacidade: não faz muito sentido
	/**
	 * Cria e retorna uma lista com todas as bicicletas que são qualificadas pelos parâmetros da busca.
	 * @param placaBusca
	 * Expressão regular para identificar a placa da bicicleta;
	 * @param tipoBusca
	 * Expressão regular para identificar o tipo da bicicleta;
	 * @param estacaoBusca
	 * Expressão regular para identificar o nome da estação da bicicleta;
	 */
	public List<Bicicleta> lista(String placaBusca, String tipoBusca, String estacaoBusca) {
		ArrayList<Bicicleta> list = new ArrayList<Bicicleta>();
		Pattern placaPattern = Pattern.compile(placaBusca);
		Pattern tipoPattern = Pattern.compile(tipoBusca);
		Pattern estacaoPattern = Pattern.compile(estacaoBusca);
		
		for (Bicicleta bicicleta : arrayList) {
			if (placaPattern.matcher(bicicleta.getPlaca()).matches() && 
					tipoPattern.matcher(bicicleta.getTipo()).matches() &&
					estacaoPattern.matcher(bicicleta.getEstacao().getNome()).matches()) {
				list.add(bicicleta);
			}
		}
		
		return list;
	}
	
	/**
	 * Cria e retorna uma lista com todas as bicicletas que são qualificadas pelos parâmetros da busca.
	 * @param placaBusca
	 * Expressão regular para identificar a placa da bicicleta;
	 * @param tipoBusca
	 * Expressão regular para identificar o tipo da bicicleta;
	 * @param estacaoBusca
	 * Id da estacao que hospeda a bicicleta;
	 */
	public List<Bicicleta> lista(String placaBusca, String tipoBusca, int estacaoBusca) {
		ArrayList<Bicicleta> list = new ArrayList<Bicicleta>();
		Pattern placaPattern = Pattern.compile(placaBusca);
		Pattern tipoPattern = Pattern.compile(tipoBusca);
		
		for (Bicicleta bicicleta : arrayList) {
			if (placaPattern.matcher(bicicleta.getPlaca()).matches() && 
					tipoPattern.matcher(bicicleta.getTipo()).matches() &&
					estacaoBusca == bicicleta.getEstacao().getId()) {
				list.add(bicicleta);
			}
		}
		
		return list;
	}
}
