package teste.controller;


import model.base.Bicicleta;
import model.base.Estacao;
import model.base.Locacao;
import model.dao.BicicletaDAO;
import model.dao.EstacaoDAO;
import model.dao.LocacaoDAO;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.LocacoesController;

public class LocacoesControllerTest {
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
		
		locacao.setBicicleta(bicicleta);
	}

	@Test
	public void testAdiciona() {
		
	}
	
	@Test
	public void testLista() {
		
	}
	
	@Test
	public void testFormulario() {
		
	}
	
	@Test
	public void testBusca() {
		
	}
}
