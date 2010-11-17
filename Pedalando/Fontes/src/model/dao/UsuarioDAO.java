package model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;

import model.base.Usuario;

public class UsuarioDAO {
	private final TreeSet<Usuario> treeSet;
	
	public UsuarioDAO() {
		treeSet = new TreeSet<Usuario>();
	}

	public void salva(Usuario usuario) {
		treeSet.add(usuario);
	}
	
	public void atualiza(Usuario usuario) {
		if (treeSet.contains(usuario)) {
			treeSet.remove(usuario);
			treeSet.add(usuario);
		}
	}
	
	public void remove(Usuario usuario) {
		treeSet.remove(usuario);
	}
	
	public Usuario encontra(String cpf) {
		for (Usuario usuario : treeSet) {
			if (usuario.getCpf().equals(cpf)) {
				return usuario;
			}
		}
		return null;
	}
	
	// TODO ajustar documento, retirei busca por capacidade: não faz muito sentido
	/**
	 * Cria e retorna uma lista com todas as estações que são qualificadas pelos parâmetros da busca.
	 * @param cpfBusca
	 * Expressão regular para identificar o cpf do Usuario;
	 * @param nomeBusca
	 * Expressão regular para identificar o nome do Usuario;
	 * @param enderecoBusca
	 * Expressão regular para identificar o endereco do Usuario;
	 */
	public List<Usuario> lista(String cpfBusca, String nomeBusca, String enderecoBusca) {
		ArrayList<Usuario> list = new ArrayList<Usuario>();
		Pattern cpfPattern = Pattern.compile(cpfBusca);
		Pattern nomePattern = Pattern.compile(nomeBusca);
		Pattern enderecoPattern = Pattern.compile(enderecoBusca);
		
		for (Usuario usuario : treeSet) {
			if (cpfPattern.matcher(usuario.getCpf()).matches() &&
					nomePattern.matcher(usuario.getNome()).matches() &&
					enderecoPattern.matcher(usuario.getEndereco()).matches()) {
				list.add(usuario);
			}
		}
		
		return list;
	}
	
	/**
	 * Cria e retorna uma lista com todas as estações que são qualificadas pelos parâmetros da busca.
	 * @param cpfBusca
	 * Expressão regular para identificar o cpf do Usuário;
	 * @param nomeBusca
	 * Expressão regular para identificar o nome do Usuário;
	 * @param enderecoBusca
	 * Expressão regular para identificar o endereco do Usuário;
	 * @param
	 * Permissão que os usuários devem ter;
	 */
	public List<Usuario> lista(String cpfBusca, String nomeBusca, String enderecoBusca, Enum<Usuario.Permissao> permissao) {
		ArrayList<Usuario> list = new ArrayList<Usuario>();
		Pattern cpfPattern = Pattern.compile(cpfBusca);
		Pattern nomePattern = Pattern.compile(nomeBusca);
		Pattern enderecoPattern = Pattern.compile(enderecoBusca);
		
		for (Usuario usuario : treeSet) {
			if (cpfPattern.matcher(usuario.getCpf()).matches() &&
					nomePattern.matcher(usuario.getNome()).matches() &&
					enderecoPattern.matcher(usuario.getEndereco()).matches() &&
					usuario.getPermissao() == permissao) {
				list.add(usuario);
			}
		}
		
		return list;
	}
}
