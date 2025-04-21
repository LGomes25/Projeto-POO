package classes;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

	// Atributos
	private Double salarioBruto;
	private Double descontoInss;
	private Double descontoIr;
	private Double salarioLiquido;

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

}
