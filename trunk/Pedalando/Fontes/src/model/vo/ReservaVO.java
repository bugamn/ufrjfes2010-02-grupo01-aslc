package model.vo;

import java.util.Date;
import java.util.List;

import model.base.Estacao;
import model.base.Usuario;

public class ReservaVO {
	private long id;
	private Estacao estacao;
	private Usuario usuario;
	private Estacao destino;
	private Date data;
	private List<Estacao> estacoes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Estacao getEstacao() {
		return estacao;
	}
	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Estacao getDestino() {
		return destino;
	}
	public void setDestino(Estacao destino) {
		this.destino = destino;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<Estacao> getEstacoes() {
		return estacoes;
	}
	public void setEstacoes(List<Estacao> estacoes) {
		this.estacoes = estacoes;
	}

}
