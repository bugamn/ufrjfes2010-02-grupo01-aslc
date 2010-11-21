package teste.model.base;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import model.base.Bicicleta;
import model.base.Estacao;
import model.base.Locacao;
import model.base.Usuario;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocacaoTest {
	private static long id;
	private static Estacao estacao;
	private static Usuario usuario;
	private static Estacao destino;
	private static Bicicleta bicicleta;
	private static Date data;
	private static Locacao locacao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2010, 4, 1, 0, 0);
		
		locacao = new Locacao();
		id = 1;
		estacao = new Estacao();
		estacao.setId(0);
		usuario = new Usuario();
		usuario.setCpf("12345678900");
		destino = new Estacao();
		estacao.setId(2);
		bicicleta = new Bicicleta();
		bicicleta.setPlaca("XKCD1");
		data = new Date(calendar.getTimeInMillis());
	}
	
	@Before
	public void setUp() throws Exception {
		locacao.setId(id);
		locacao.setEstacao(estacao);
		locacao.setDestino(destino);
		locacao.setUsuario(usuario);
		locacao.setBicicleta(bicicleta);
		locacao.setData(data);
	}

	@Test
	public void testGetId() {
		assertEquals("getId não funciona.", id, locacao.getId());
	}

	@Test
	public void testSetId() {
		long novaId = 10;
		locacao.setId(novaId);
		assertEquals("setId não funciona.", novaId, locacao.getId());
	}

	@Test
	public void testGetEstacao() {
		assertEquals("getEstacao não funciona.", estacao, locacao.getEstacao());
	}

	@Test
	public void testSetEstacao() {
		Estacao novaEstacao = new Estacao();
		estacao.setId(10);
		locacao.setEstacao(novaEstacao);
		assertEquals("setEstacao não funciona.", novaEstacao, locacao.getEstacao());
	}

	@Test
	public void testGetUsuario() {
		assertEquals("getUsuario não funciona.", usuario, locacao.getUsuario());
	}

	@Test
	public void testSetUsuario() {
		Usuario novoUsuario = new Usuario();
		novoUsuario.setCpf("98765432100");
		locacao.setUsuario(novoUsuario);
		assertEquals("setUsuario não funciona.", novoUsuario, locacao.getUsuario());
	}

	@Test
	public void testGetDestino() {
		assertEquals("getDestino não funciona.", destino, locacao.getDestino());
	}

	@Test
	public void testSetDestino() {
		Estacao novoDestino = new Estacao();
		novoDestino.setId(10);
		locacao.setDestino(novoDestino);
		assertEquals("setDestino não funciona.", novoDestino, locacao.getDestino());
	}
	
	@Test
	public void testGetBicicleta() {
		assertEquals("getBicicleta não funciona.", bicicleta, locacao.getBicicleta());
	}
	
	@Test
	public void testSetBicicleta() {
		Bicicleta novoBicicleta = new Bicicleta();
		novoBicicleta.setPlaca("ABCD2");
		locacao.setBicicleta(novoBicicleta);
		assertEquals("setDestino não funciona.", novoBicicleta, locacao.getBicicleta());
	}

	@Test
	public void testGetData() {
		assertEquals("getData não funciona.", data, locacao.getData());
	}

	@Test
	public void testSetData() {
		Date novaData = new Date();
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(2010, 12, 25, 0, 0);
		novaData.setTime(calendar.getTimeInMillis());
		locacao.setData(novaData);
		assertEquals("setData não funciona.", novaData, locacao.getData());
	}

}
