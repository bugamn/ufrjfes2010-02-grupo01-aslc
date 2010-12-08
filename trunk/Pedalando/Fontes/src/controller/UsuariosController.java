package controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import model.base.Usuario;
import model.base.Usuario.Permissao;
import model.dao.UsuarioDAO;

@Resource
public class UsuariosController {
	private final UsuarioDAO usuarioDAO;
	private final Result result;
	private final Validator validator;
	
	public UsuariosController(UsuarioDAO usuarioDAO, Result result, Validator validator) {
		this.usuarioDAO = usuarioDAO;
		this.result = result;
		this.validator = validator;
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
		
		validator.validate(usuario);
		if(validator.onErrorUsePageOf(UsuariosController.class) != null)
			validator.onErrorUsePageOf(UsuariosController.class).formulario();
		
		usuarioDAO.salva(usuario);
		result.redirectTo(this).lista(".*", ".*", ".*", 0);
	}
	
	/**
	 * Método executado quando a 
	 * 
	 * 
	 * 
	 * 
	 */
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
	
	public Usuario edita(String cpf) {
		return usuarioDAO.encontra(cpf);
	}
	
	public void altera(Usuario usuario, int permissao) {
		Enum<Permissao> p = conversao(permissao);
		usuario.setPermissao(p);
		
		validator.validate(usuario);
		validator.onErrorUsePageOf(UsuariosController.class).edita(usuario.getCpf());
		
		usuarioDAO.atualiza(usuario);
		result.redirectTo(UsuariosController.class).lista(usuario.getCpf(), ".*", ".*", -1);
	}
	
	public void remove(String cpf) {
		Usuario usuario = usuarioDAO.encontra(cpf);
		usuarioDAO.remove(usuario);
		result.redirectTo(UsuariosController.class).lista(".*", ".*", ".*", -1);
	}
}
