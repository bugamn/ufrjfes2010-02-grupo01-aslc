package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.vraptor.ioc.Component;

import model.base.Devolucao;

@Component
public class DevolucaoDAO {
	private static ArrayList<Devolucao> arrayList = new ArrayList<Devolucao>();
	
	public void salva(Devolucao devolucao) {
		arrayList.add(devolucao);
	}
	
	public void atualiza(Devolucao devolucao) {
		if (arrayList.contains(devolucao)) {
			arrayList.remove(devolucao);
			arrayList.add(devolucao);
		}
		
	}
	
	public void remove(Devolucao devolucao) {
		arrayList.remove(devolucao);
	}
	
	/**
	 * 
	 * @param id
	 * id da locação correspondente
	 * @return
	 */
	public Devolucao encontra(int id) {
		for (Devolucao devolucao : arrayList) {
			if (devolucao.getLocacao().getId() == id) {
				return devolucao;
			}
		}
		
		return null;
	}
	
	public List<Devolucao> lista(String estacaoBusca, String nomeBusca) {
		ArrayList<Devolucao> lista = new ArrayList<Devolucao>();
		Pattern estacaoPattern = Pattern.compile(estacaoBusca);
		Pattern nomePattern = Pattern.compile(nomeBusca);
		
		for (Devolucao devolucao : arrayList) {
			if (estacaoPattern.matcher(devolucao.getEstacao().getNome()).matches() &&
					nomePattern.matcher(devolucao.getLocacao().getUsuario().getNome()).matches()) {
				lista.add(devolucao);
			}
		}
		
		
		return lista;
	}
	
	public List<Devolucao> lista(String estacaoBusca, String nomeBusca, Date min, Date max) {
		ArrayList<Devolucao> lista = new ArrayList<Devolucao>();
		Pattern estacaoPattern = Pattern.compile(estacaoBusca);
		Pattern nomePattern = Pattern.compile(nomeBusca);
		
		for (Devolucao devolucao : arrayList) {
			if (estacaoPattern.matcher(devolucao.getEstacao().getNome()).matches() &&
					nomePattern.matcher(devolucao.getLocacao().getUsuario().getNome()).matches() &&
					min.before(devolucao.getData()) &&
					max.after(devolucao.getData())) {
				lista.add(devolucao);
			}
		}
		
		
		return lista;
	}
}
