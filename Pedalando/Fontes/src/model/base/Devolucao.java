package model.base;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Devolucao {
	@Id @NotNull
	Locacao locacao;
	
	@NotNull
	Estacao estacao;
	
	@NotNull
	Date data;

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		return locacao.equals(((Devolucao)obj).getLocacao());
	}
}
