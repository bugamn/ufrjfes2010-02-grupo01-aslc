package model.base;

import javax.persistence.Id;

public class Bicicleta {
	// TODO adicionar tags do hibernate
	
	@Id
	private String placa;
	
	private String tipo;
	
	private Estacao estacao;

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
	
	@Override
	public boolean equals(Object obj) {
		if(getClass().equals(obj.getClass())) {
			return placa.equals(((Bicicleta) obj).getPlaca());
		}
			
		return false;
	}
}
