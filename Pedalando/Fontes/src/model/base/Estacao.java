package model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Estacao {
	// TODO adicionar tags do hibernate
	
	@Id @GeneratedValue
	private int id;
	
	@NotNull
	@Length(min=3)
	private String nome;
	
	@Min(1)
	private int capacidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(getClass().equals(obj.getClass())) {
			return id == ((Estacao) obj).getId();
		}
			
		return false;
	}

}
