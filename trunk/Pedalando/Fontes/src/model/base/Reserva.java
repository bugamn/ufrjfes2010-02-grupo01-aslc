package model.base;

import java.util.Date;

public class Reserva {
	// TODO adicionar tags do hibernate
	private long id;
	private Estacao estacao;
	private Usuario usuario;
	private Estacao destino;
	private Date data;
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
}
