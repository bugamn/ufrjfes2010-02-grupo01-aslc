package controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import model.base.Usuario;
import model.base.Usuario.Permissao;
import model.dao.UsuarioDAO;

@Resource
public class UsuariosController {
	private final UsuarioDAO usuarioDAO;
	private final Result result;
	
	public UsuariosController(UsuarioDAO usuarioDAO, Result result) {
		this.usuarioDAO = usuarioDAO;
		this.result = result;
	}
	
	private Usuario.Permissao conversao(int permissao) {
		
		switch (permissao) {			
		case 1:
			return Usuario.Permissao.ADMIN;
			
		case 2:
			return Usuario.Permissao.OPERATOR;
			
		case 3:
			return Usuario.Permissao.USER;
		}
		return null;
	}
	
	/**
	 * Adiciona um novo usuário ao sistema
	 * @param usuario
	 * Uma instância de usuário
	 * @param permissao
	 * Um código de permissão: 1 é para administrador, 2 para operador, 3 para usuário
	 */
	public void adiciona(Usuario usuario, int permissao) {
		Enum<Permissao> p = null;
		
		p = conversao(permissao);
		usuario.setPermissao(p);
		
		usuarioDAO.salva(usuario);
		result.redirectTo(this).lista(".*", ".*", ".*", 0);
	}
	
	public void formulario() {}
	
	public void busca() {}
	
	/**
	 * Busca por usuários
	 * @param cpfBusca
	 * Expressão regular para o CPF
	 * @param nomeBusca
	 * Expressão regular para o Nome
	 * @param enderecoBusca
	 * Expressão regular para o Endereço
	 * @param permissao
	 * Permissão do Usuário: 0 significa que qualquer permissão serve, 1 é para administradores, 2 para operadores e 3 para usuários
	 * @return
	 * Lista de Usuários que atendem às condições da busca
	 */
	public List<Usuario> lista(String cpfBusca, String nomeBusca, String enderecoBusca, int permissao) {
		Enum<Permissao> p;
		
		if (cpfBusca == null) {
			cpfBusca = ".*";
		}
		if (nomeBusca == null) {
			nomeBusca = ".*";
		}
		if (enderecoBusca == null) {
			enderecoBusca = ".*";
		}
		p = conversao(permissao);
		
		if (p == null) {
			return usuarioDAO.lista(cpfBusca, nomeBusca, enderecoBusca);
		}
		
		return usuarioDAO.lista(cpfBusca, nomeBusca, enderecoBusca, p);
	}
}
