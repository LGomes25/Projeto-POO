package csv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import calculos.FolhaPagamento;
import classes.Dependente;
import classes.Funcionario;

public class CsvExport {

	public static void exportFuncionario(List<Funcionario> listaFuncionarios) {

		FileWriter fw;
		try {
			fw = new FileWriter("/serratec-2025-1/curso/funcionario.csv");
			PrintWriter pw = new PrintWriter(fw);

			for (Funcionario func : listaFuncionarios) {
				String linha = func.getNome() + " ; " + func.getCpf() + " ; " + func.getDataNascimento() + " ; "
						+ func.getSalarioBruto() + " ; " + func.getDescontoInss() + " ; " + func.getDescontoIr() + "\n";
				pw.printf(linha);
			}
			pw.close();
			System.out.println("\nArquivo de Funcionarios criado com sucesso!!!");
			System.out.println("Caminho: c:/serratec-2025-1/curso/funcionario.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void exportDependentes(List<Dependente> listaDependentes) {

		FileWriter fw;
		try {
			fw = new FileWriter("/serratec-2025-1/curso/dependentes.csv");
			PrintWriter pw = new PrintWriter(fw);

			for (Dependente dep : listaDependentes) {
				String linha = dep.getNome() + " ; " + dep.getCpf() + " ; " + dep.getDataNascimento() + " ; "
						+ dep.getParentesco() + "\n";
				pw.printf(linha);
			}
			pw.close();
			System.out.println("\nArquivo de Dependentes criado com sucesso!!!");
			System.out.println("Caminho: c:/serratec-2025-1/curso/dependentes.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void exportFolha(List<FolhaPagamento> listafolha) {
		
		FileWriter fw;
		try {
			fw = new FileWriter("/serratec-2025-1/curso/folha.csv");
			PrintWriter pw = new PrintWriter(fw);
			
			for (FolhaPagamento flh : listafolha) {
				String folha = flh.getNome() + " ; " + flh.getCpf() + " ; " + flh.getDataPagamento() + " ; "
						+ flh.getDescontoInss() + " ; " + flh.getDescontoIr() + " ; " + flh.getSalarioLiquido() + "\n";
				pw.printf(folha);
			}
			pw.close();
			System.out.println("\nArquivo de Folha de Pagamento criado com sucesso!!!");
			System.out.println("Caminho: c:/serratec-2025-1/curso/folha.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
