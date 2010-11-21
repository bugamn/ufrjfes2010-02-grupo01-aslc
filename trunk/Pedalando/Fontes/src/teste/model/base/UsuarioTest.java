package teste.model.base;

import static org.junit.Assert.*;

import model.base.Usuario;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsuarioTest {
	private static String cpf;
	private static String nome;
	private static String endereco;
	private static Enum<Usuario.Permissao> permissao;
	private static Usuario usuario;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usuario = new Usuario();
		cpf = "12345678900";
		nome = "Zé Sá";
		endereco = "Casa Amarela";
		permissao = Usuario.Permissao.USER;
	}
	
	@Before
	public void setUp() throws Exception {
		usuario.setCpf(cpf);
		usuario.setEndereco(endereco);
		usuario.setNome(nome);
		usuario.setPermissao(permissao);
	}

	@Test
	public void testGetCpf() {
		assertEquals("getCpf apresenta erros", usuario.getCpf(), cpf);
	}

	@Test
	public void testSetCpf() {
		//se incluirmos validacao de cpf, testaremos aqui
		String novoCpf = "98765432100";
		usuario.setCpf(novoCpf);
		assertEquals("setCpf apresenta erros", novoCpf, usuario.getCpf());
	}

	@Test
	public void testGetNome() {
		assertEquals("getNome apresenta erros", nome, usuario.getNome());
	}

	@Test
	public void testSetNome() {
		String novoNome = "Joaquim";
		usuario.setNome(novoNome);
		assertEquals("setNome apresenta erros", novoNome, usuario.getNome());
	}

	@Test
	public void testGetEndereco() {
		assertEquals("getEndereco apresenta erros", endereco, usuario.getEndereco());
	}

	@Test
	public void testSetEndereco() {
		String novoEndereco = "Casa Azul";
		usuario.setEndereco(novoEndereco);
		assertEquals("setEndereco apresenta erros", novoEndereco, usuario.getEndereco());
	}

	@Test
	public void testGetPermissao() {
		assertEquals("getPermissao apresenta erros", permissao, usuario.getPermissao());
	}

	@Test
	public void testSetPermissao() {
		Enum<Usuario.Permissao> novaPermissao = Usuario.Permissao.ADMIN;
		usuario.setPermissao(novaPermissao);
		assertEquals("setPermissao apresenta erros", novaPermissao, usuario.getPermissao());
	}

	@Test
	public void testGetAdminPermissao() {
		assertEquals("getAdminPermissao apresenta erros", Usuario.Permissao.ADMIN, usuario.getAdminPermissao());
	}

	@Test
	public void testGetOperatorPermissao() {
		assertEquals("getOperatorPermissao apresenta erros", Usuario.Permissao.OPERATOR, usuario.getOperatorPermissao());
	}

	@Test
	public void testGetUserPermissao() {
		assertEquals("getUserPermissao apresenta erros", Usuario.Permissao.USER, usuario.getUserPermissao());
	}

}
