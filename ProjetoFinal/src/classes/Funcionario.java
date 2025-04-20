package classes;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

	//Atributos
	private double salarioBruto;
    private double descontoInss;
    private double descontoIr;
	
    //Construtor
    public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto, double descontoInss,
			double descontoIr) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoInss = descontoInss;
		this.descontoIr = descontoIr;
	}

    //toString
	@Override
	public String toString() {
		return "Salario Bruto: " + salarioBruto + ", Desconto INSS: " + descontoInss + ", Desconto IR: "
				+ descontoIr;
	}

	//Getters Setters
	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getDescontoInss() {
		return descontoInss;
	}

	public void setDescontoInss(double descontoInss) {
		this.descontoInss = descontoInss;
	}

	public double getDescontoIr() {
		return descontoIr;
	}

	public void setDescontoIr(double descontoIr) {
		this.descontoIr = descontoIr;
	}
	
	
    
	
}
