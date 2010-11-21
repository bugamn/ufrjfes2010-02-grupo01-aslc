package controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.base.Bicicleta;
import model.base.Estacao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;

@Resource
public class EstacoesController {
	private final EstacaoDAO estacaoDAO;
	private final BicicletaDAO bicicletaDAO;
	private final Result result;
	
	
	public EstacoesController(EstacaoDAO estacaoDAO, BicicletaDAO bicicletaDAO, Result result) {
		this.estacaoDAO = estacaoDAO;
		this.bicicletaDAO = bicicletaDAO;
		this.result = result;
	}
	
	public class Consulta {
		private Estacao estacao;
		private List<Dados> lista;
		public Estacao getEstacao() {
			return estacao;
		}
		public void setEstacao(Estacao estacao) {
			this.estacao = estacao;
		}
		public List<Dados> getLista() {
			return lista;
		}
		public void setLista(List<Dados> lista) {
			this.lista = lista;
		}
	}
	
	public class Dados {
		private String tipo;
		private int quantidade;
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
	}
	
	public void adiciona(final Estacao estacao) {
		
		estacaoDAO.salva(estacao);
		result.redirectTo(this).lista(".*");
	}
	
	public void formulario() {}
	
	public void busca() {}
	
	public List<Estacao> lista(String nomeBusca) {
		if (nomeBusca == null) {
			nomeBusca = "";
		}
		nomeBusca = ".*" + nomeBusca + ".*";
		return estacaoDAO.lista(nomeBusca);
	}
	
	//Em desenvolvimento deverá retornar uma lista de Consulta
	public void consulta(String nomeBusca) {
		List<Estacao> lista;
		if (nomeBusca == null) {
			nomeBusca = "";
		}
		nomeBusca = ".*" + nomeBusca + ".*";
		lista = estacaoDAO.lista(nomeBusca);
		
		for (Estacao estacao : lista) {
			
		}
	}
	
	public Estacao edita(int id) {
		return estacaoDAO.encontra(id);
	}
	
	public void altera(Estacao estacao) {
		estacaoDAO.atualiza(estacao);
		result.redirectTo(EstacoesController.class).lista(estacao.getNome());
	}
	
	public void remove(int id) {
		Estacao estacao = estacaoDAO.encontra(id);
		estacaoDAO.remove(estacao);
		result.redirectTo(EstacoesController.class).lista("");
	}
}
