package bc.ce.thiagoFreitas.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.FormularioPage;
import bc.ce.thiagoFreitas.page.MenuPage;

public class CalculadoraTeste extends BaseTest{
	

	private MenuPage menuPage = new MenuPage();
	private FormularioPage formularioPage = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException{
		
		menuPage.acessarFormulario();
	}				
	
	

	@Test
	 public void devePreencherCampoTexto() throws MalformedURLException {
		formularioPage.escreverNome("Thiago");
		assertEquals("Thiago", formularioPage.obterNome());
		 		 
	 }
	
	@Test
	 public void deveInteragirComCombo() throws MalformedURLException {		
		formularioPage.selecionarCombo("Nintendo Switch");
		assertEquals("Nintendo Switch", formularioPage.obterValorCombo());
		
	 }
	
	@Test
	 public void deveInteragirComSwitchECheckbox() throws MalformedURLException {
		 assertFalse(formularioPage.isCheckTrue());
		 assertTrue(formularioPage.isSwittchTrue());				 
		 formularioPage.clicarCheck();
		 formularioPage.clicarSwitch();
		 
		 assertTrue(formularioPage.isCheckTrue());
		 assertFalse(formularioPage.isSwittchTrue());
	 }
	
	@Test
	 public void desafioFormulario() throws MalformedURLException {
		formularioPage.escreverNome("Thiago");
		formularioPage.selecionarCombo("Nintendo Switch");
		formularioPage.clicarCheck();
		formularioPage.clicarSwitch();

		formularioPage.clicarBotaoSalvar();

		assertEquals("Nome: Thiago", formularioPage.obterNomeResultado());
		assertEquals("Console: switch", formularioPage.obterConsoleResultado());
		assertEquals("Switch: Off", formularioPage.obterSwitchResultado());
		assertEquals("Checkbox: Marcado", formularioPage.obterCheckboxResultado());
	 }
}
