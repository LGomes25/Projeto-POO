package classes;

import java.time.LocalDate;
import enumEinterface.CalcSalInterface;
import enumEinterface.ParentescoEnum;

public class Funcionario extends Pessoa implements CalcSalInterface {

	// Atributos
	protected Double salarioBruto;
	protected Double descontoInss;
	protected Double descontoIr;
	protected Double salarioLiquido;
	protected int contdependente; 

	// Construtor
	public Funcionario(Integer id, String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
		super(id, nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoInss = 0.;
		this.descontoIr = 0.;
		this.salarioLiquido = 0.;
		this.contdependente = 0;
	}

	// toString
	@Override
	public String toString() {
		return "Nome: " + nome + " CPF: " + cpf + " D. Nasc.: " + dataNascimento 
				+ " Sal. Bruto: "+ salarioBruto + " Desc. INSS: " + descontoInss 
				+ " Desc. IR: " + descontoIr;
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

	public int getContdependente() {
		return contdependente;
	}

	public void setContdependente(int contdependente) {
		this.contdependente = contdependente;
	}
	@Override
	public void atualizarDesconto() {
		descontoInss = calcularINSS();
		descontoIr = calcularIR();
		salarioLiquido = calcularSalarioLiquido();
	}

	private Double calcularINSS() {
		if (salarioBruto <= 1518.0) {
			Double faixa1 = Math.round(((salarioBruto * 0.075) - 0.) * 100.0) / 100.0;
			return faixa1;
		} else if (salarioBruto >= 1518.01 & salarioBruto <= 2793.88) {
			Double faixa2 = Math.round(((salarioBruto * 0.09) - 22.77) * 100.0) / 100.0;
			return faixa2;
		} else if (salarioBruto >= 2793.89 & salarioBruto <= 4190.83) {
			Double faixa3 = Math.round(((salarioBruto * 0.12) - 106.60) * 100.0) / 100.0;
			return faixa3;
		} else if (salarioBruto >= 4190.84 & salarioBruto <= 8157.41) {
			Double faixa4 = Math.round(((salarioBruto * 0.14) - 190.42) * 100.0) / 100.0;
			return faixa4;
		} else {
			Double limite = Math.round((8157.41 * 0.14) * 100.0) / 100.0;
			Double faixa5 = 0.;
			if (limite > 951.62) {
				faixa5 = 951.62;
			} else {
				faixa5 = limite;
			}
			return faixa5;
		}
	}

	private Double calcularIR() {

		Double descDep = contdependente * calcularDescontoDependentes();
		Double salBase = salarioBruto - descDep - calcularINSS();

		if (salBase <= 2259.20) {
			Double faixair0 = 0.0;
			return faixair0;
		} else if (salBase <= 2826.65) {
			Double faixair1 = Math.round(((salBase * 0.075) - 169.44) * 100.0) / 100.0;
			return faixair1;
		} else if (salBase <= 3751.05) {
			Double faixair2 = Math.round(((salBase * 0.15) - 381.44) * 100.0) / 100.0;
			return faixair2;
		} else if (salBase <= 4664.68) {
			Double faixair3 = Math.round(((salBase * 0.225) - 662.77) * 100.0) / 100.0;
			return faixair3;
		} else {
			Double faixair4 = Math.round(((salBase * 0.275) - 896.00) * 100.0) / 100.0;
			return faixair4;
		}
	}

	private Double calcularSalarioLiquido() {
		Double salarioliquido = Math.round((salarioBruto - calcularINSS() - calcularIR()) * 100.0) / 100.0;
		return salarioliquido;

	}

	public Double calcularDescontoDependentes() {
		Double descontoDependente = ParentescoEnum.FILHO.getDesconto();
		return descontoDependente;
	}

}
