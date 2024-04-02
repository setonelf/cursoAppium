package bc.ce.thiagoFreitas.page;
import org.openqa.selenium.By;
import appium.core.BasePage;
import io.appium.java_client.AppiumBy;
public class FormularioPage extends BasePage{
	
	public void escreverNome(String nome) {
		escrever(AppiumBy.accessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return obterTexto(AppiumBy.accessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		clicarNoCombo(AppiumBy.accessibilityId("console"), valor);
	}
	
	public String  obterValorCombo() {
		return obterTexto(By.id("android:id/text1"));
		
	}
	
	public boolean isCheckTrue() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwittchTrue() {
		return isCheckMarcado(AppiumBy.accessibilityId("switch"));
	}
	
	public void clicarCheck() {
		clickElement(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		clickElement(AppiumBy.accessibilityId("switch"));
	}
	
	public void clicarBotaoSalvar() {
		clickElement(AppiumBy.accessibilityId("save"));
	}
	
	public String obterNomeResultado() {
		return obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Nome:')]"));
	}
	
	public String obterConsoleResultado() {
		return obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Console:')]"));
	}
	
	public String obterSwitchResultado() {
		return obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Switch:')]"));
	}
	
	public String obterCheckboxResultado() {
		return obterTexto(By.xpath("//android.widget.TextView[contains(@text, 'Checkbox:')]"));
	}
	
}
