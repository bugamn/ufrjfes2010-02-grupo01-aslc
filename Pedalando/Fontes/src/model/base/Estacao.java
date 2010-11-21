package model.base;

import javax.persistence.Id;

public class Estacao {
	// TODO adicionar tags do hibernate
	
	@Id
	private int id;
	
	private String nome;
	
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
