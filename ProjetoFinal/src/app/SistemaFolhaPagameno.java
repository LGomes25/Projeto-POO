package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import calculos.FolhaPagamento;
import classes.Dependente;
import classes.Funcionario;
import classes.Pessoa;
import csv.CsvExport;
import csv.CsvImport;

public class SistemaFolhaPagameno {

	public static void main(String[] args) {

		System.out.println("lucas");
		System.out.println("Maxwel");
		FolhaPagamento funcionario = new FolhaPagamento(1, "Carlos Silva", "12345678901", LocalDate.of(1985, 5, 20), 3000.00);
		funcionario.atualizarDesconto();
		System.out.println("Desconto INSS atualizado: R$ " + funcionario.getDescontoInss());

//		List<Pessoa> listaPessoas = new ArrayList<>();
//	    List<Funcionario> listaFuncionarios = new ArrayList<>();
//	    List<Dependente> listaDependentes = new ArrayList<>();
//	    
//		
//	    try {
//			//Importar arquivo csv
//	    	CsvImport.importar(listaPessoas, listaFuncionarios, listaDependentes);
//	
//	    	
//	    	// Exibição das listas
//	    	CsvImport.exibirListaPessoa(listaPessoas);
//	    	CsvImport.exibirListaFuncionario(listaFuncionarios);
//	    	CsvImport.exibirListaDependentes(listaDependentes);
//	    	
//	    	//Exportar arquivo csv
//	    	CsvExport.exportFuncionario(listaFuncionarios);
//	    	CsvExport.exportDependentes(listaDependentes);
//	   
//	    } catch (Exception e) {
//	        // Captura todas as exceções lançadas pelo método chamado
//	        System.out.println("Erro ao processar o arquivo: " + e.getMessage());
//	    }
	        
	        
	}

}
