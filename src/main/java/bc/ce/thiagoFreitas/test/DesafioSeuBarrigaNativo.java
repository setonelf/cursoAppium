package bc.ce.thiagoFreitas.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import appium.core.BaseTest;
import bc.ce.thiagoFreitas.page.MenuPage;
import bc.ce.thiagoFreitas.page.SeuBarrigaNativoPage;

public class DesafioSeuBarrigaNativo extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private SeuBarrigaNativoPage seuBarrigaNativoPage =  new SeuBarrigaNativoPage();
	
	@Before
	public void setUp() {
		menuPage.acessarSeuBarrigaNativo();
		seuBarrigaNativoPage.fillName();
		seuBarrigaNativoPage.fillPassword();
		seuBarrigaNativoPage.clickEnterButton();
		seuBarrigaNativoPage.clickResetButton();
	}
	
	@Test
	public void inserirConta() {
		seuBarrigaNativoPage.clickTabContas();
		seuBarrigaNativoPage.fillNomeConta();
		seuBarrigaNativoPage.clickBotaoSalvar();
		
		Assert.assertTrue(seuBarrigaNativoPage.getContaAdicionadaAlert());
	}
	
	@Test
	public void excluirConta() {
		seuBarrigaNativoPage.clickTabContas();
		seuBarrigaNativoPage.cliqueLongoPorElemento(By.xpath("//*[@text='Conta para alterar']"));
		seuBarrigaNativoPage.clickBotaoExcluirConta();
		
		esperar(2000);
		Assert.assertFalse(seuBarrigaNativoPage.verificaContaDeletada());		
	}
	
	@Test
	public void validaMovimentacaoForm() {
		seuBarrigaNativoPage.clickTabMov();
		seuBarrigaNativoPage.clickBotaoSalvar();
		Assert.assertEquals("Descrição é um campo obrigatório", seuBarrigaNativoPage.getTextAlert());
		
		seuBarrigaNativoPage.fillDescricaoMov();;
		Assert.assertEquals("Interessado é um campo obrigatório", seuBarrigaNativoPage.getTextAlert());
		
		seuBarrigaNativoPage.fillValorMov();
		Assert.assertEquals("Conta é um campo obrigatório", seuBarrigaNativoPage.getTextAlert());
		
		seuBarrigaNativoPage.clicarNoCombo(By.id("android:id/text1"), "Conta para movimentacoes");
		Assert.assertTrue(seuBarrigaNativoPage.getContaAdicionadaAlert());
		
	}
	
	@Test
	public void exclusaoDeMovESaldo() {
		Assert.assertTrue(seuBarrigaNativoPage.getContaComMovimentacao());
		
		seuBarrigaNativoPage.clickTabResumo();
		esperar(1000);
		seuBarrigaNativoPage.deleteContaComMovimentação();
		Assert.assertTrue(seuBarrigaNativoPage.getMovimentacaoRemovidaAlert());
		seuBarrigaNativoPage.clickTabHome();
		seuBarrigaNativoPage.scrollDown();
		Assert.assertFalse(seuBarrigaNativoPage.getContaComMovimentacao());
	}
}
