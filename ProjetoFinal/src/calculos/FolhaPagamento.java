package calculos;

import java.time.LocalDate;

import classes.Funcionario;
import enumEinterface.CalcSalInterface;
import enumEinterface.ParentescoEnum;

public class FolhaPagamento extends Funcionario implements CalcSalInterface {

	// atributos
	private Integer id;
	private LocalDate dataPagamento;
	private int contdependente2; // ->contador dependentes

	// construtor
	public FolhaPagamento(Integer id, String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
		super(id, nome, cpf, dataNascimento, salarioBruto);
		this.dataPagamento = LocalDate.now();
		this.contdependente2 = 0;

	}// toString

	@Override
	public String toString() {
		return "Nome: " + nome + " CPF: " + cpf + " D. pgt.: " + dataPagamento + " Desc. INSS: " + descontoInss
				+ " Desc. IR: " + descontoIr + " Sal. Liq.: " + salarioLiquido;
	}

	@Override
	public void atualizarDesconto() {
		Double descontoinss = calcularINSS();
		Double descontoir = calcularIR();
		Double salarioliquidofinal = calcularSalarioLiquido();
		setDescontoInss(descontoinss);
		setDescontoIr(descontoir);
		setSalarioLiquido(salarioliquidofinal);
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

		Double descDep = contdependente2 * calcularDescontoDependentes();
		Double salBase = salarioBruto - descDep - this.calcularINSS();

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
		Double salarioliquido = Math.round((getSalarioBruto() - calcularINSS() - calcularIR()) * 100.0) / 100.0;
		return salarioliquido;
	}

	public Double calcularDescontoDependentes() {
		Double descontoDependente = ParentescoEnum.FILHO.getDesconto();
		return descontoDependente;
	}

	// Getters Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public int getContdependente2() {
		return contdependente2;
	}

	public void setContdependente2(int contdependente2) {
		this.contdependente2 = contdependente2;
	}

}
