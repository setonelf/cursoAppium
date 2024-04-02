package bc.ce.thiagoFreitas.appium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import appium.core.DSL;
import appium.core.DriverFactory;
import io.appium.java_client.AppiumBy;




public class CalculadoraTeste {
	
	private DSL dsl = new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException{
		
		//Selecionar Formulário
		dsl.clicarPorTexto("Formulário");
	}
				
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	 public void devePreencherCampoTexto() throws MalformedURLException {
		 //Escrever Nome
		dsl.escrever(AppiumBy.accessibilityId("nome"), "Thiago");
		
		 //Checar nome escrito
		assertEquals("Thiago", dsl.obterTexto(AppiumBy.accessibilityId("nome")));
		 		 
	 }
	
	@Test
	 public void deveInteragirComCombo() throws MalformedURLException {	
		
		dsl.clicarNoCombo(AppiumBy.accessibilityId("console"), "Nintendo Switch");
		Assert.assertEquals("Nintendo Switch", dsl.obterTexto(By.id("android:id/text1")));
		
	 }
	
	@Test
	 public void deveInteragirComSwitchECheckbox() throws MalformedURLException {
		 //Verificar status dos elementos
		 Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		 Assert.assertTrue(dsl.isCheckMarcado(AppiumBy.accessibilityId("switch")));
				 
		 //Clicar nos elementos
		 dsl.clickElement(By.className("android.widget.CheckBox"));
		 dsl.clickElement(AppiumBy.accessibilityId("switch"));
		 
		 //Verificar estados alterados
		 Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		 Assert.assertFalse(dsl.isCheckMarcado(AppiumBy.accessibilityId("switch")));
	 }
	
	@Test
	 public void desafioFormulario() throws MalformedURLException {
		 //Preencher campos
		dsl.escrever(AppiumBy.accessibilityId("nome"), "Thiago");
		dsl.clickElement(AppiumBy.accessibilityId("console"));
		dsl.clicarPorTexto("Nintendo Switch");
		dsl.clickElement(AppiumBy.accessibilityId("check")); 
		dsl.clickElement(AppiumBy.accessibilityId("switch")); 
		 		 
		 //Salvar
		dsl.clickElement(AppiumBy.accessibilityId("save"));
		 
		 //Validar Campos		 
		 Assert.assertEquals("Nome: Thiago", dsl.obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Nome:')]")));
		 Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Console:')]")));
		 Assert.assertEquals("Switch: Off", dsl.obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Switch:')]")));
		 Assert.assertEquals("Checkbox: Marcado", dsl.obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Checkbox:')]")));
	 }
}
