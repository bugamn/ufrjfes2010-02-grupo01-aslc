package teste;

import static org.junit.Assert.*;

import model.base.Bicicleta;
import model.base.Estacao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BicicletaTeste {
	static Bicicleta bicicleta;
	static String tipo = "comum";
	static String placa = "XKCD1";
	static Estacao estacao = new Estacao();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bicicleta = new Bicicleta();
		bicicleta.setTipo(tipo);
		bicicleta.setPlaca(placa);
		bicicleta.setEstacao(estacao);
	}

	@Before
	public void setUp() throws Exception {
		bicicleta.setTipo(tipo);
		bicicleta.setPlaca(placa);
		bicicleta.setEstacao(estacao);
	}

	@Test
	public void testGetPlaca() {
		assertEquals("getPlaca nao funciona!", bicicleta.getPlaca(), placa);
	}

	@Test
	public void testSetPlaca() {
		String placaNova = "AJDO2";
		bicicleta.setPlaca(placaNova);
		assertEquals("setPlaca nao funciona!", bicicleta.getPlaca(), placaNova);
	}

	@Test
	public void testGetTipo() {
		assertEquals("getTipo nao funciona!", bicicleta.getTipo(), tipo);
	}

	@Test
	public void testSetTipo() {
		String tipoNovo = "Longa";
		bicicleta.setTipo(tipoNovo);
		assertEquals("setTipo nao funciona!", bicicleta.getTipo(), tipoNovo);
	}

	@Test
	public void testGetEstacao() {
		assertEquals("getEstacao nao funciona!", bicicleta.getEstacao(), estacao);
	}

	@Test
	public void testSetEstacao() {
		Estacao estacaoNova = new Estacao();
		bicicleta.setEstacao(estacaoNova);
		assertEquals("setEstacao nao funciona!", bicicleta.getEstacao(), estacaoNova);
	}

}
