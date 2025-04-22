package calculos;


import java.time.LocalDate;
import classes.Funcionario;
import enumEinterface.CalcSalInterface;
import enumEinterface.ParentescoEnum;


public class FolhaPagamento  extends Funcionario implements CalcSalInterface{
	
	
		public FolhaPagamento(Integer id, String nome, String cpf, LocalDate dataNascimento, Double salarioBruto) {
			super(id, nome, cpf, dataNascimento, salarioBruto);
			
		}
		
		public void atualizarDesconto() {
			double desconto = calcularINSS();
			setDescontoInss(desconto);
		}
		
		private Double calcularINSS() {
			if (getSalarioBruto() <= 1518.0) {
				Double faixa1 = (getSalarioBruto() * 0.075 - (contadorDependente() * calcularDescontoDependentes()));
				return faixa1;
			} else if (getSalarioBruto() >= 1518.01 && getSalarioBruto() <= 2793.88) {
				Double faixa2 = (getSalarioBruto () * 0.09 - (contadorDependente() * calcularDescontoDependentes()));
				return faixa2;
			} else if (getSalarioBruto() >= 2793.89 && getSalarioBruto() <= 4190.83) {
				Double faixa3 = (getSalarioBruto() * 0.12 - (contadorDependente() * calcularDescontoDependentes()));
				return faixa3;
			} else if(getSalarioBruto() >= 4190.84 && getSalarioBruto() <= 8157.41 ) {
				Double faixa4 = (getSalarioBruto() * 0.14 - (contadorDependente() * calcularDescontoDependentes()));
				return faixa4;
			} else {
				Double faixa5 = (8157.41 * 0.14 - (contadorDependente() * calcularDescontoDependentes()));
				return faixa5;
			}
		}

		
		public Double calcularDescontoDependentes() {
			Double descontoDependente = ParentescoEnum.FILHO.getDesconto();
			return descontoDependente;
		}
}

