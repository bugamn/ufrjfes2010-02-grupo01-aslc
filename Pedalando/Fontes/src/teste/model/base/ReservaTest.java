package teste.model.base;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import model.base.Estacao;
import model.base.Reserva;
import model.base.Usuario;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReservaTest {
	private static long id;
	private static Estacao estacao;
	private static Usuario usuario;
	private static Estacao destino;
	private static Date data;
	private static Reserva reserva;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2010, 4, 1, 0, 0);
		
		reserva = new Reserva();
		id = 1;
		estacao = new Estacao();
		estacao.setId(0);
		usuario = new Usuario();
		usuario.setCpf("12345678900");
		destino = new Estacao();
		estacao.setId(2);
		data = new Date(calendar.getTimeInMillis());
	}
	
	@Before
	public void setUp() throws Exception {
		reserva.setId(id);
		reserva.setEstacao(estacao);
		reserva.setDestino(destino);
		reserva.setUsuario(usuario);
		reserva.setData(data);
	}

	@Test
	public void testGetId() {
		assertEquals("getId não funciona.", id, reserva.getId());
	}

	@Test
	public void testSetId() {
		long novaId = 10;
		reserva.setId(novaId);
		assertEquals("setId não funciona.", novaId, reserva.getId());
	}

	@Test
	public void testGetEstacao() {
		assertEquals("getEstacao não funciona.", estacao, reserva.getEstacao());
	}

	@Test
	public void testSetEstacao() {
		Estacao novaEstacao = new Estacao();
		estacao.setId(10);
		reserva.setEstacao(novaEstacao);
		assertEquals("setEstacao não funciona.", novaEstacao, reserva.getEstacao());
	}

	@Test
	public void testGetUsuario() {
		assertEquals("getUsuario não funciona.", usuario, reserva.getUsuario());
	}

	@Test
	public void testSetUsuario() {
		Usuario novoUsuario = new Usuario();
		novoUsuario.setCpf("98765432100");
		reserva.setUsuario(novoUsuario);
		assertEquals("setUsuario não funciona.", novoUsuario, reserva.getUsuario());
	}

	@Test
	public void testGetDestino() {
		assertEquals("getDestino não funciona.", destino, reserva.getDestino());
	}

	@Test
	public void testSetDestino() {
		Estacao novoDestino = new Estacao();
		novoDestino.setId(10);
		reserva.setDestino(novoDestino);
		assertEquals("setDestino não funciona.", novoDestino, reserva.getDestino());
	}

	@Test
	public void testGetData() {
		assertEquals("getData não funciona.", data, reserva.getData());
	}

	@Test
	public void testSetData() {
		Date novaData = new Date();
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(2010, 12, 25, 0, 0);
		novaData.setTime(calendar.getTimeInMillis());
		reserva.setData(novaData);
		assertEquals("setData não funciona.", novaData, reserva.getData());
	}

}
