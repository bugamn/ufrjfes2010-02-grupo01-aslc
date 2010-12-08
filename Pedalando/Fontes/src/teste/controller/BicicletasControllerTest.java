package teste.controller;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import model.base.Bicicleta;
import model.base.Estacao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.View;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Validations;

import controller.BicicletasController;

public class BicicletasControllerTest {
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
	private static BicicletasController bicicletasController;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
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
		
		bicicletasController = new BicicletasController(bicicletaDAO, estacaoDAO, new Result() {
			
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
		}, new Validator() {
			
			@Override
			public void validate(Object arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public <T> T onErrorUsePageOf(T arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}
			
			@Override
			public <T> T onErrorUsePageOf(Class<T> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T extends View> T onErrorUse(Class<T> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void onErrorSendBadRequest() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public <T> T onErrorRedirectTo(T arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T onErrorRedirectTo(Class<T> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T onErrorForwardTo(T arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <T> T onErrorForwardTo(Class<T> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean hasErrors() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void checking(Validations arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addAll(Collection<? extends Message> arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void add(Message arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Test
	public void testAdiciona() {
		String placa = "ABCD";
		int tamanho = bicicletaDAO.lista(".*", ".*", ".*", false).size();
		Bicicleta bicicletaNova = new Bicicleta();
		
		bicicletaNova.setEstacao(estacao);
		bicicletaNova.setPlaca(placa);
		bicicletaNova.setTipo(tipoBicicleta);
		
		bicicletasController.adiciona(bicicletaNova, estacao.getId());
		
		assertEquals("O método adiciona não funciona.", tamanho + 1, bicicletaDAO.lista(".*", ".*", ".*",false).size());
		
		bicicletaDAO.remove(bicicletaNova);
	}

	@Test
	public void testFormulario() {
		assertEquals("O método formulario não funciona.", estacaoDAO.lista(".*").size(), bicicletasController.formulario().size());
	}

	@Test
	public void testBusca() {
		assertEquals("O método formulario não funciona.", estacaoDAO.lista(".*").size(), bicicletasController.busca().size());
	}

	@Test
	public void testLista() {
		assertEquals("O método lista não funciona.",
				bicicletaDAO.lista(placaBicicleta, ".*", ".*",false).size(), bicicletasController.lista(placaBicicleta, null, null).size());
		assertEquals("O método lista não funciona.",
				bicicletaDAO.lista(".*", tipoBicicleta, ".*",false).size(), bicicletasController.lista(null, tipoBicicleta, null).size());
		assertEquals("O método lista não funciona.",
				bicicletaDAO.lista(".*", ".*", nomeEstacao,false).size(), bicicletasController.lista(null, null, nomeEstacao).size());
	}

}
