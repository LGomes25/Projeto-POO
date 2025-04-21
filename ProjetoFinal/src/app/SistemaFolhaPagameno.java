package app;

import java.util.ArrayList;
import java.util.List;

import classes.Funcionario;
import classes.Parentesco;
import classes.Pessoa;
import csv.CsvImport;

public class SistemaFolhaPagameno {

	public static void main(String[] args) {

		List<Pessoa> listaPessoas = new ArrayList<>();
	    List<Funcionario> listaFuncionarios = new ArrayList<>();
	    List<Parentesco> listaDependentes = new ArrayList<>();

		
	    try {
			//Método para importar arquivo csv
	    	CsvImport.importar(listaPessoas, listaFuncionarios, listaDependentes);
		
	    	 // Exibição das listas
	    	CsvImport.exibirListaPessoa(listaPessoas);
	    	CsvImport.exibirListaFuncionario(listaFuncionarios);
	    	CsvImport.exibirListaDependentes(listaDependentes);
	   
	    } catch (Exception e) {
	        // Captura todas as exceções lançadas pelo método chamado
	        System.out.println("Erro ao processar o arquivo: " + e.getMessage());
	    }
	        
	        
	}

}
