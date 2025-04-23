package app;

import java.util.ArrayList;
import java.util.List;

import Persistence.DependenteDao;
import Persistence.FolhaDePagamentoDao;
import Persistence.FuncionarioDao;
import calculos.FolhaPagamento;
import classes.Dependente;
import classes.Funcionario;
import classes.Pessoa;
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
	
	    	//Calcular Folha
	    	for (FolhaPagamento folha : listafolha) {
	            folha.atualizarDesconto();
	    	}
	    	for (Funcionario funcionarios : listaFuncionarios) {
	    	    funcionarios.atualizarDesconto();
	    	}
	    	
	    	//Exportar para BD
	    	DependenteDao dependenteDao = new DependenteDao();
	    	for (Dependente dep : listaDependentes) {
				dependenteDao.inserir(dep);
			}
	    	FuncionarioDao funcionarioDao = new FuncionarioDao();
	    	for (Funcionario fun : listaFuncionarios) {
	    		funcionarioDao.inserir(fun);
	    	}
	    	FolhaDePagamentoDao folhaDao = new FolhaDePagamentoDao();
	    	for (FolhaPagamento fol : listafolha) {
	    		folhaDao.inserir(fol);
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
	    	
	    	
	    } catch (Exception e) {
	        System.out.println("Erro ao processar o arquivo: " + e.getMessage());
	    }
	        
	        
	}

}
