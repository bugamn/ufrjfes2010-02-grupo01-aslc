package controller;

import java.util.List;

import br.com.caelum.vraptor.Result;
import model.base.Usuario;
import model.base.Usuario.Permissao;
import model.dao.UsuarioDAO;

public class UsuariosController {
	private final UsuarioDAO usuarioDAO;
	private final Result result;
	
	public UsuariosController(UsuarioDAO usuarioDAO, Result result) {
		this.usuarioDAO = usuarioDAO;
		this.result = result;
	}
	
	public void adiciona(Usuario usuario) {
		usuarioDAO.salva(usuario);
		result.redirectTo(this).lista(".*", ".*", ".*", null);
	}
	
	public List<Usuario> lista(String cpfBusca, String nomeBusca, String enderecoBusca, Enum<Permissao> permissao) {
		if (cpfBusca == null) {
			cpfBusca = ".*";
		}
		if (nomeBusca == null) {
			nomeBusca = ".*";
		}
		if (enderecoBusca == null) {
			enderecoBusca = ".*";
		}
		if (permissao == null) {
			return usuarioDAO.lista(cpfBusca, nomeBusca, enderecoBusca);
		}
		return usuarioDAO.lista(cpfBusca, nomeBusca, enderecoBusca, permissao);
	}
}
