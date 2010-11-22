package model.base;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Reserva {
	// TODO adicionar tags do hibernate
	
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	private Estacao estacao;
	
	@NotNull
	private Usuario usuario;
	
	@NotNull
	private Estacao destino;
	
	@NotNull
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
	
	@Override
	public boolean equals(Object obj) {
		if(getClass().equals(obj.getClass())) {
			return id == ((Reserva) obj).getId();
		}
			
		return false;
	}
}
