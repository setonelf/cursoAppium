package bc.ce.thiagoFreitas.page;
import org.openqa.selenium.By;
import appium.core.DSL;
import io.appium.java_client.AppiumBy;

public class FormularioPage {
	private DSL dsl = new DSL();
	
	public void escreverNome(String nome) {
		dsl.escrever(AppiumBy.accessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return dsl.obterTexto(AppiumBy.accessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		dsl.clicarNoCombo(AppiumBy.accessibilityId("console"), valor);
	}
	
	public String  obterValorCombo() {
		return dsl.obterTexto(By.id("android:id/text1"));
		
	}
	
	public boolean isCheckTrue() {
		return dsl.isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwittchTrue() {
		return dsl.isCheckMarcado(AppiumBy.accessibilityId("switch"));
	}
	
	public void clicarCheck() {
		dsl.clickElement(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		dsl.clickElement(AppiumBy.accessibilityId("switch"));
	}
	
	public void clicarBotaoSalvar() {
		dsl.clickElement(AppiumBy.accessibilityId("save"));
	}
	
	public String obterNomeResultado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Nome:')]"));
	}
	
	public String obterConsoleResultado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Console:')]"));
	}
	
	public String obterSwitchResultado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Switch:')]"));
	}
	
	public String obterCheckboxResultado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Checkbox:')]"));
	}
	
}
