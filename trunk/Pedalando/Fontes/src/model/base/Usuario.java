package model.base;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Usuario {
	
	@Id @NotNull
	@Length(min=11,max=11)
	private String cpf;
	
	@NotNull
	@Length(min=3)
	private String nome;
	
	@NotNull
	@Length(min=5)
	private String endereco;
	
	@NotNull
	private Enum<Permissao> permissao;
	public enum Permissao {ADMIN, OPERATOR, USER};
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Enum<Permissao> getPermissao() {
		return permissao;
	}
	public void setPermissao(Enum<Permissao> permissao) {
		this.permissao = permissao;
	}
	
	//Funções para recuperar os enum, acho que talvez sejam necessário para os beans
	//se não forem, podemos retirar
	public Enum<Permissao> getAdminPermissao() {
		return Permissao.ADMIN;
	}
	public Enum<Permissao> getOperatorPermissao() {
		return Permissao.OPERATOR;
	}
	public Enum<Permissao> getUserPermissao() {
		return Permissao.USER;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(getClass().equals(obj.getClass())) {
			return cpf.equals(((Usuario) obj).getCpf());
		}
			
		return false;
	}
}
