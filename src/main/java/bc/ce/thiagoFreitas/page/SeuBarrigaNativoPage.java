package bc.ce.thiagoFreitas.page;

import org.openqa.selenium.By;

import appium.core.BasePage;
import appium.core.DriverFactory;

public class SeuBarrigaNativoPage extends BasePage {
	public void fillName() {
		escrever(By.xpath("//android.widget.EditText[@text= 'Nome']"), "tf@email.com");
	}
	
	public void fillPassword() {
		escrever(By.xpath("//android.widget.EditText[@text= 'Senha']"), "1234");
	}
	
	public void clickEnterButton() {
		clicarPorTexto("ENTRAR");
	}
	
	public void clickResetButton() {
		clicarPorTexto("RESET");
	}
	
	public void clickTabContas() {
		clickElement(By.xpath("//android.widget.TextView[@text='Contas']"));
	}
	
	public void clickTabMov() {
		clickElement(By.xpath("//android.widget.TextView[@text='Mov...']"));
	}
	
	public void clickTabResumo() {
		clickElement(By.xpath("//android.widget.TextView[@text='Resumo']"));
	}
	
	public void clickTabHome() {
		clickElement(By.xpath("//android.widget.TextView[@text='Home']"));
	}
	
	public void fillNomeConta() {
		escrever(By.xpath("//android.widget.EditText[@text='Conta']"), "teste conta");
	}
	
	public void fillDescricaoMov() {
		escrever(By.xpath("//android.widget.EditText[@text='Descrição']"), "Movimentação adicionada teste");
	}
	
	public void fillValorMov() {
		escrever(By.xpath("//android.widget.EditText[@text='Valor']"), "1234");
	}
	
	public void clickBotaoSalvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void clickBotaoExcluirConta() {
		clicarPorTexto("EXCLUIR");
	}
	
	public boolean getContaAdicionadaAlert() {
		return existeElementoPorTexto("Conta adicionada com sucesso");
	}
	
	public boolean verificaContaDeletada() {
		 return existeElementoPorTexto("Conta para alterar");
	}
	
	public String getTextAlert() {
		return obterTexto(By.xpath("//*[contains (@text, 'é um campo obrigatório')]"));
	}
	
	public boolean getMovimentacaoAdicionadaAlert() {
		return existeElementoPorTexto("Movimentação cadastrada com sucesso");
	}
	
	public boolean getMovimentacaoRemovidaAlert() {
		return existeElementoPorTexto("Movimentação removida com sucesso!");
	}
	
	public boolean getContaComMovimentacao() {
		return existeElementoPorTexto("Conta com movimentacao");
	}
	
	public void deleteContaComMovimentação() {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Conta com movimentacao']/../..")), 0.9, 0.1);
		clicarPorTexto("Del");
	}
}
