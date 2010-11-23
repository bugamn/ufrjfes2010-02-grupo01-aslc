package model.vo;

import java.util.List;

import model.base.Estacao;
import model.base.Locacao;

public class DevolucaoVO {
	private Locacao locacao;
	private List<Estacao> estacaos;
	
	public Locacao getLocacao() {
		return locacao;
	}
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	public List<Estacao> getEstacaos() {
		return estacaos;
	}
	public void setEstacaos(List<Estacao> estacaos) {
		this.estacaos = estacaos;
	}
}
