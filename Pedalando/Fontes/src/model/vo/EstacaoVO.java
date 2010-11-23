package model.vo;

import java.util.List;

import model.base.Bicicleta;
import model.base.Estacao;

public class EstacaoVO {
	Estacao estacao;
	List<Bicicleta> bicicletas;
	
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
}
