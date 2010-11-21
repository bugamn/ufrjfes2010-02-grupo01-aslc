package teste.controller;

import static org.junit.Assert.*;

import java.util.Map;

import model.base.Bicicleta;
import model.base.Estacao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.View;

import controller.EstacoesController;

public class EstacoesControllerTest {
	private static EstacoesController estacoesController;
	private static String nomeEstacao = "CCMN";
	private static String outraEstacao = "CCS";
	private static String placaBicicleta = "XKCD";
	private static String tipoBicicleta = "normal";
	private static int capacidadeEstacao = 100;
	private static EstacaoDAO estacaoDAO = new EstacaoDAO();
	private static BicicletaDAO bicicletaDAO = new BicicletaDAO();
	private static Estacao estacao = new Estacao();
	private static Estacao estacao2 = new Estacao();
	private static Bicicleta bicicleta = new Bicicleta();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		estacao.setCapacidade(capacidadeEstacao );
		estacao.setNome(nomeEstacao);
		
		estacaoDAO.salva(estacao);
		
		estacao2.setCapacidade(capacidadeEstacao);
		estacao2.setNome(outraEstacao);
		
		estacaoDAO.salva(estacao2);
		
		bicicleta.setEstacao(estacao);
		bicicleta.setPlaca(placaBicicleta);
		bicicleta.setTipo(tipoBicicleta);
		
		estacoesController = new EstacoesController(estacaoDAO, bicicletaDAO, new Result() {
			
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
		Estacao novaEstacao = new Estacao();
		String novoNome = "CT";
		int novaCapacidade = 200;
		int tamanho = estacaoDAO.lista(".*").size();
		
		novaEstacao.setNome(novoNome);
		novaEstacao.setCapacidade(novaCapacidade);

		estacoesController.adiciona(novaEstacao);

		assertEquals("O método adiciona não funciona.", tamanho + 1, estacaoDAO.lista(".*").size());
		
		estacaoDAO.remove(novaEstacao);
	}

	@Test
	public void testLista() {
		assertEquals("O método lista não funciona de modo genérico.", 
				estacaoDAO.lista(".*").size(), estacoesController.lista(".*").size());
		assertEquals("O método lista não funciona quando encontra uma só.", 
				estacaoDAO.lista(nomeEstacao).size(), estacoesController.lista(nomeEstacao).size());
		assertEquals("O método lista não funciona quando não encontra.", 
				estacaoDAO.lista(nomeEstacao + nomeEstacao).size(), estacoesController.lista(nomeEstacao + nomeEstacao).size());
	}

	@Test
	public void testConsulta() {
		fail("Not yet implemented");
	}

}