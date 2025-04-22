package app;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import calculos.FolhaPagamento;
import classes.Dependente;
import classes.Funcionario;
import classes.Pessoa;
import conexao.ConexaoBd;
import csv.CsvExport;
import csv.CsvImport;

public class SistemaFolhaPagameno {

	public static void main(String[] args) {
		
		List<Pessoa> listaPessoas = new ArrayList<>();
	    List<Funcionario> listaFuncionarios = new ArrayList<>();
	    List<Dependente> listaDependentes = new ArrayList<>();
	    List<FolhaPagamento> listafolha = new ArrayList<>();
		
	    try {
			//Importar arquivo csv
	    	CsvImport.importar(listaPessoas, listaFuncionarios, listaDependentes, listafolha);
	
	    	for (FolhaPagamento folha : listafolha) {
	            folha.atualizarDesconto();
	    	}
	    	
	    	for (Funcionario funcionarios : listaFuncionarios) {
	    	    funcionarios.atualizarDesconto();
	    	}
	    	
	    	// Exibição das listas
	    	CsvImport.exibirListaPessoa(listaPessoas);
	    	CsvImport.exibirListaFuncionario(listaFuncionarios);
	    	CsvImport.exibirListaDependentes(listaDependentes);
	    	CsvImport.exibirListafolha(listafolha);
	    	
	    	//Exportar arquivo csv
	    	CsvExport.exportFuncionario(listaFuncionarios);
	    	CsvExport.exportDependentes(listaDependentes);
	    	CsvExport.exportFolha(listafolha);
	    	
	    	//Conexão BD
	    	@SuppressWarnings("unused")
	        Connection connection = new ConexaoBd().getConnection();
	    	
	    } catch (Exception e) {
	        // Captura todas as exceções lançadas pelo método chamado
	        System.out.println("Erro ao processar o arquivo: " + e.getMessage());
	    }
	        
	        
	}

}
