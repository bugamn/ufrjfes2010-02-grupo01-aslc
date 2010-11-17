package teste;

import junit.framework.Assert;
import model.base.Estacao;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EstacaoTest {
	
	private static Estacao estacao;
	private static int id;
	private static String nome;
	private static int capacidade;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		estacao = new Estacao();
		id = 1;
		nome = "CCMN";
		capacidade = 1;
	}

	@Before
	public void setUpBefore() {
		estacao.setId(id);
		estacao.setNome(nome);
		estacao.setCapacidade(capacidade);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetId() {
		Assert.assertEquals("Método getId não retorna igual ao valor armazenado.", id, estacao.getId());
	}

	@Test
	public void testSetId() {
		int novo_id = 2;
		
		estacao.setId(novo_id);
		Assert.assertEquals("Método setId não armazena corretamenta.", novo_id, estacao.getId());
	}

	@Test
	public void testGetNome() {
		Assert.assertEquals("Método getNome não retorna igual ao valor armazenado.", nome, estacao.getNome());
	}

	@Test
	public void testSetNome() {
		String novo_nome = "CT";
		
		estacao.setNome(novo_nome);
		Assert.assertEquals("Método set Nomenão armazena corretamenta.", novo_nome, estacao.getNome());
	}

	@Test
	public void testGetCapacidade() {
		Assert.assertEquals("Método getCapacidade não retorna igual ao valor armazenado.", capacidade, estacao.getCapacidade());
	}

	@Test
	public void testSetCapacidade() {
		int nova_capacidade = 100;
		estacao.setCapacidade(nova_capacidade);
		Assert.assertEquals("Método setCapacidade não armazena corretamenta.", nova_capacidade, estacao.getCapacidade());
	}

}
