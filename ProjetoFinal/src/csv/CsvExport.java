package csv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import classes.Funcionario;
import classes.Dependente;

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
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
