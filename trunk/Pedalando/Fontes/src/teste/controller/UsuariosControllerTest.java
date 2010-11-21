package teste.controller;

import static org.junit.Assert.*;

import java.util.Map;

import model.base.Usuario;
import model.base.Usuario.Permissao;
import model.dao.UsuarioDAO;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.View;

import controller.UsuariosController;

public class UsuariosControllerTest {
	private static UsuariosController usuariosController;
	private static UsuarioDAO usuarioDAO = new UsuarioDAO();
	private static Usuario usuario = new Usuario();
	private static Usuario usuario2 = new Usuario();
	private static String nome = "Zé Sá";
	private static String nome2 = "Mário";
	private static String cpf = "12345678900";
	private static String cpf2 = "98765432100";
	private static String endereco = "Imaginação";
	private static String endereco2 = "Armário";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usuario.setCpf(cpf);
		usuario.setEndereco(endereco);
		usuario.setNome(nome);
		usuario.setPermissao(Permissao.ADMIN);
		usuarioDAO.salva(usuario);
		
		usuario2.setCpf(cpf2);
		usuario2.setEndereco(endereco2);
		usuario2.setNome(nome2);
		usuario2.setPermissao(Permissao.OPERATOR);
		usuarioDAO.salva(usuario2);
		
		usuariosController = new UsuariosController(usuarioDAO, new Result() {
			
			@Override
			public boolean used() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public <T extends View> T use(Class<T> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T redirectTo(T arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}
			
			@Override
			public <T> T redirectTo(Class<T> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void redirectTo(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public <T> T permanentlyRedirectTo(T arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T permanentlyRedirectTo(Class<T> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void permanentlyRedirectTo(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Result on(Class<? extends Exception> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T of(T arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T of(Class<T> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void nothing() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void notFound() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Map<String, Object> included() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Result include(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T forwardTo(T arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T forwardTo(Class<T> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void forwardTo(String arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Test
	public void testAdiciona() {
		Usuario novo = new Usuario();
		String novoNome = "Euzim";
		String novoCpf = "65432178900";
		String novoEnd = "Algum lugar";
		
		int tamanho = usuarioDAO.lista(".*", ".*", ".*").size();
		
		novo.setCpf(novoCpf);
		novo.setEndereco(novoEnd);
		novo.setNome(novoNome);
		
		usuariosController.adiciona(novo, 3);
		
		assertEquals("O método adiciona não funciona.", tamanho + 1, usuarioDAO.lista(".*", ".*", ".*").size());
	}

	@Test
	public void testLista() {
		fail("Not yet implemented");
	}

}
