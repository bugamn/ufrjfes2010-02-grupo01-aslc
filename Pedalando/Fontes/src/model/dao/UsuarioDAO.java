package model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.vraptor.ioc.Component;

import model.base.Usuario;

@Component
public class UsuarioDAO {
	private static ArrayList<Usuario> arrayList = new ArrayList<Usuario>();

	public void salva(Usuario usuario) {
		arrayList.add(usuario);
	}
	
	public void atualiza(Usuario usuario) {
		if (arrayList.contains(usuario)) {
			arrayList.remove(usuario);
			arrayList.add(usuario);
		}
	}
	
	public void remove(Usuario usuario) {
		arrayList.remove(usuario);
	}
	
	public Usuario encontra(String cpf) {
		for (Usuario usuario : arrayList) {
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
		
		if (cpfBusca == null) {
			cpfBusca = "";
		}
		if (nomeBusca == null) {
			nomeBusca = "";
		}
		if (enderecoBusca == null) {
			enderecoBusca = "";
		}
		
		cpfBusca = ".*" + cpfBusca + ".*";
		nomeBusca = ".*" + nomeBusca + ".*";
		enderecoBusca = ".*" + enderecoBusca + ".*";
		
		Pattern cpfPattern = Pattern.compile(cpfBusca);
		Pattern nomePattern = Pattern.compile(nomeBusca);
		Pattern enderecoPattern = Pattern.compile(enderecoBusca);
		
		for (Usuario usuario : arrayList) {
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
		
		if (cpfBusca == null) {
			cpfBusca = "";
		}
		if (nomeBusca == null) {
			nomeBusca = "";
		}
		if (enderecoBusca == null) {
			enderecoBusca = "";
		}
		
		cpfBusca = ".*" + cpfBusca + ".*";
		nomeBusca = ".*" + nomeBusca + ".*";
		enderecoBusca = ".*" + enderecoBusca + ".*";
		
		Pattern cpfPattern = Pattern.compile(cpfBusca);
		Pattern nomePattern = Pattern.compile(nomeBusca);
		Pattern enderecoPattern = Pattern.compile(enderecoBusca);
		
		for (Usuario usuario : arrayList) {
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
