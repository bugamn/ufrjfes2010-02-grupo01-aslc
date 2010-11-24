package model.vo;

import java.util.List;

import model.base.Bicicleta;
import model.base.Estacao;

public class BicicletaVO {
	private String placa;
	private String tipo;
	private Estacao estacao;
	private List<Estacao> estacoes;
	private List<Bicicleta> bicicletas;
	private int reserva;
	
	public List<Estacao> getEstacoes() {
		return estacoes;
	}
	public void setEstacoes(List<Estacao> estacoes) {
		this.estacoes = estacoes;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Estacao getEstacao() {
		return estacao;
	}
	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}
	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}
	public void setBicicletas(List<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}
	public int getReserva() {
		return reserva;
	}
	public void setReserva(int reserva) {
		this.reserva = reserva;
	}
	
}
