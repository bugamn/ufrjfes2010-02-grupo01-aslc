package teste.model.dao;

import static org.junit.Assert.*;

import model.base.Estacao;
import model.dao.EstacaoDAO;

import org.junit.BeforeClass;
import org.junit.Test;

public class EstacaoDAOTest {
	private static EstacaoDAO estacaoDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		estacaoDAO = new EstacaoDAO();
	}

	@Test
	public void testSalva() {
		Estacao estacao = new Estacao();
		estacao.setNome("CCMN");
		estacao.setCapacidade(10);
		estacaoDAO.salva(estacao);
		estacao.setNome("CT");
		estacao.setCapacidade(20);
		estacaoDAO.salva(estacao);
		assertEquals("salva não funciona.", 2, estacaoDAO.lista(".*").size());
	}

	@Test
	public void testAtualiza() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testEncontra() {
		fail("Not yet implemented");
	}

	@Test
	public void testLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testListaBicicletasStringStringInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testListaBicicletasStringStringString() {
		fail("Not yet implemented");
	}

}
