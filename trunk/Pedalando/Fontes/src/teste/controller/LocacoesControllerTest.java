package teste.controller;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import model.base.Bicicleta;
import model.base.Estacao;
import model.base.Locacao;
import model.base.Usuario;
import model.base.Usuario.Permissao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;
import model.dao.LocacaoDAO;
import model.dao.UsuarioDAO;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.View;

import controller.LocacoesController;

public class LocacoesControllerTest {
	private static Usuario usuario = new Usuario();
	private static Usuario usuario2 = new Usuario();
	private static String nome = "Zé Sá";
	private static String nome2 = "Mário";
	private static String cpf = "12345678900";
	private static String cpf2 = "98765432100";
	private static String endereco = "Imaginação";
	private static String endereco2 = "Armário";
	private static UsuarioDAO usuarioDAO = new UsuarioDAO();
	private static String nomeEstacao = "CCMN";
	private static String outraEstacao = "CCS";
	private static String placaBicicleta = "XKCD";
	private static String outraPlacaBicicleta = "QWER";
	private static String tipoBicicleta = "normal";
	private static String outroTipoBicicleta = "longa";
	private static int capacidadeEstacao = 100;
	private static EstacaoDAO estacaoDAO = new EstacaoDAO();
	private static BicicletaDAO bicicletaDAO = new BicicletaDAO();
	private static Estacao estacao = new Estacao();
	private static Estacao estacao2 = new Estacao();
	private static Bicicleta bicicleta = new Bicicleta();
	private static Bicicleta bicicleta2 = new Bicicleta();
	private static Locacao locacao = new Locacao();
	private static Locacao locacao2 = new Locacao();
	private static LocacaoDAO locacaoDAO = new LocacaoDAO();
	private static LocacoesController locacoesController;
	private static Date data = new Date(System.currentTimeMillis());
	private static Date data2 = new Date(new GregorianCalendar(2010, 1, 1, 1, 1).getTimeInMillis());

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
		
		estacao.setCapacidade(capacidadeEstacao);
		estacao.setNome(nomeEstacao);
		estacaoDAO.salva(estacao);
		
		estacao2.setCapacidade(capacidadeEstacao);
		estacao2.setNome(outraEstacao);
		estacaoDAO.salva(estacao2);
		
		bicicleta.setPlaca(placaBicicleta);
		bicicleta.setTipo(tipoBicicleta);
		bicicleta.setEstacao(estacao);
		bicicletaDAO.salva(bicicleta);
		
		bicicleta2.setPlaca(outraPlacaBicicleta);
		bicicleta2.setTipo(outroTipoBicicleta);
		bicicleta2.setEstacao(estacao2);
		bicicletaDAO.salva(bicicleta2);
		
		locacao.setBicicleta(bicicleta);
		locacao.setData(data);
		locacao.setDestino(estacao2);
		locacao.setUsuario(usuario);
		locacaoDAO.salva(locacao);
		
		locacao2.setBicicleta(bicicleta2);
		locacao2.setData(data2);
		locacao2.setDestino(estacao);
		locacao2.setUsuario(usuario2);
		locacaoDAO.salva(locacao2);
		
		locacoesController = new LocacoesController(locacaoDAO, estacaoDAO, bicicletaDAO, usuarioDAO, new Result() {
			
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
		int tamanho = locacaoDAO.lista(".*", ".*", ".*").size();
		
		locacoesController.adiciona(estacao.getId(), usuario.getCpf(), bicicleta2.getPlaca());
		
		assertEquals("O método adiciona não funciona.", tamanho + 1, locacaoDAO.lista(".*", ".*", ".*").size());
		
		locacaoDAO.remove(locacao);
	}
	
	@Test
	public void testLista() {
		
		assertEquals("O método lista não funciona.", 
				locacaoDAO.lista(".*", ".*", ".*").size(), locacoesController.lista("", "", "", 0, 0, 0, 0, 0, 0).size());
		
	}
	
	@Test
	public void testFormulario() {
		assertEquals("O método formulário não funciona", estacaoDAO.lista(".*"), locacoesController.formulario());
	}
	
	@Test
	public void testBusca() {
		assertEquals("O método busca não funciona", estacaoDAO.lista(".*"), locacoesController.busca());

	}
}
