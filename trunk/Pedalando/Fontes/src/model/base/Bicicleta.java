package model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Bicicleta {
	// TODO adicionar tags do hibernate
	
	@Id @NotNull
	@Length(min=3)
	private String placa;
	
	@NotNull
	@Length(min=3)
	private String tipo;
	
	@NotNull
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
