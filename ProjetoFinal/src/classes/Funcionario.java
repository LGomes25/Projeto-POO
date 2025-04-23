package classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import enumEinterface.CalcSalInterface;
import enumEinterface.ParentescoEnum;

public class Funcionario extends Pessoa implements CalcSalInterface{

	// Atributos
	protected Double salarioBruto;
	protected Double descontoInss;
	protected Double descontoIr;
	protected Double salarioLiquido;
	protected List<Dependente> dependentes = new ArrayList<>();

	// Construtor
	public Funcionario(Integer id, String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
		super(id, nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoInss = 0.;
		this.descontoIr = 0.;
		this.salarioLiquido = 0.;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + "Sal. Bruto: " + salarioBruto + ", Desc. INSS: " + descontoInss + ", Desc. IR: "
				+ descontoIr + ", Sal. Líquido: " + salarioLiquido;
	}

	// Getters Setters
	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getDescontoInss() {
		return descontoInss;
	}

	
	public void setDescontoInss(Double descontoInss) {
		this.descontoInss = descontoInss;
	}

	public double getDescontoIr() {
		return descontoIr;
	}

	public void setDescontoIr(Double descontoIr) {
		this.descontoIr = descontoIr;
	}

	public Double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}


	public void adicionarDependente(Dependente dependente) {
		if (Period.between(dataNascimento, LocalDate.now()).getYears() < 18) {
			dependentes.add(dependente);
		}
	}
	
	public int contadorDependente() {
		int contador = dependentes.size();
		return contador;
	}

	@Override
	public void atualizarDesconto() {
		descontoInss = calcularINSS();
		descontoIr = calcularIR();
		salarioLiquido = calcularSalarioLiquido();
	}

	private Double calcularINSS() {
		if (getSalarioBruto() <= 1518.0) {
			Double faixa1 = Math.round((getSalarioBruto() * 0.075 - (contadorDependente() * calcularDescontoDependentes())) * 100.0) / 100.0;
			return faixa1;
		} else if (getSalarioBruto() >= 1518.01 && getSalarioBruto() <= 2793.88) {
			Double faixa2 = Math.round((getSalarioBruto() * 0.09 - (contadorDependente() * calcularDescontoDependentes())) * 100.0) / 100.0;
			return faixa2;
		} else if (getSalarioBruto() >= 2793.89 && getSalarioBruto() <= 4190.83) {
			Double faixa3 = Math.round((getSalarioBruto() * 0.12 - (contadorDependente() * calcularDescontoDependentes())) * 100.0) / 100.0;
			return faixa3;
		} else if (getSalarioBruto() >= 4190.84 && getSalarioBruto() <= 8157.41) {
			Double faixa4 = Math.round((getSalarioBruto() * 0.14 - (contadorDependente() * calcularDescontoDependentes())) * 100.0) / 100.0;
			return faixa4;
		} else {
			Double faixa5 = Math.round((8157.41 * 0.14 - (contadorDependente() * calcularDescontoDependentes())) * 100.0) / 100.0;
			return faixa5;
		}
	}
	
	private Double calcularIR() {
		if (getSalarioBruto() <= 2259.00) {
			Double faixair0 = 0.0;
			return faixair0;
		} else if (getSalarioBruto() >= 2259.21 && getSalarioBruto() <= 2826.65){
			Double faixair1 = Math.round((((getSalarioBruto() - (contadorDependente()
					* calcularDescontoDependentes()) - getDescontoInss()) * 0.075) - 169.44) * 100.0 ) / 100.0;
			return faixair1;
		} else if(getSalarioBruto() >= 2826.66 && getSalarioBruto() <= 3751.05) {
			Double faixair2 = Math.round((((getSalarioBruto() - (contadorDependente()
					* calcularDescontoDependentes()) - getDescontoInss()) * 0.15) - 381.44) * 100.0) / 100.0;
			return faixair2;
		} else if(getSalarioBruto() >= 3751.06 && getSalarioBruto() <= 4664.68) {
			Double faixair3 = Math.round((((getSalarioBruto() - (contadorDependente()
					* calcularDescontoDependentes()) - getDescontoInss()) * 0.225) - 662.77) * 100.0) / 100.0;
			return faixair3;
		} else {
			Double faixair4 = Math.round((((getSalarioBruto() - (contadorDependente()
					* calcularDescontoDependentes()) - getDescontoInss()) * 0.275) - 896.00) * 100.0) / 100.0;
			return faixair4;
		}	
	}
	 private Double calcularSalarioLiquido() {
		 Double salarioliquido = Math.round((getSalarioBruto() - calcularINSS() - calcularIR()) * 100.0) / 100.0;
		 return salarioliquido;
		 
	 }
	public Double calcularDescontoDependentes() {
		Double descontoDependente = ParentescoEnum.FILHO.getDesconto();
		return descontoDependente;
	}

}
