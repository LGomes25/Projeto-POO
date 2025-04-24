package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
		
		System.out.println("teste branch local");
		
		List<Pessoa> listaPessoas = new ArrayList<>();
		List<Funcionario> listaFuncionarios = new ArrayList<>();
		List<Dependente> listaDependentes = new ArrayList<>();
		List<FolhaPagamento> listafolha = new ArrayList<>();

		boolean opValido;// Garantir loop enquanto valor correto não existir
		Scanner sc = new Scanner(System.in);
		int opcao = 1;

		while (opcao != 0) {

			System.out.println("\n--- Sistema de Folha de Pagamento ---");
			System.out.println("1 - Importar dados de arquivos CSV e atualizar descontos");
			System.out.println("2 - Exibir listas");
			System.out.println("3 - Exportar dados para arquivos CSV");
			System.out.println("4 - Exportar dados para banco de dados");
			System.out.println("0 - Sair");
			
			opValido = false;// garantir estado false antes do loop
            while (!opValido) {// trata entradas diferentes do esperado
                try {
                	System.out.println("Escolha uma opção");
                	opcao = sc.nextInt();
                    sc.nextLine();// Limpar o buffer, evita capturas erradas
                    opValido = true;// reinicia variavel
                } catch (InputMismatchException e) {
                    System.out.println("Entrada Inválida, digite apenas números (0-4)");
                    sc.nextLine();// Limpar o buffer, evita loop infinito
                }
            }
			
		
			
			try {
				switch (opcao) {
					case 1:
						//Importar arquivo csv e atualiza os descontos
						CsvImport.importar(listaPessoas, listaFuncionarios, listaDependentes, listafolha);
						
						for (Funcionario funcionarios : listaFuncionarios) {
							funcionarios.atualizarDesconto();
						}
						for (FolhaPagamento folha : listafolha) {
							folha.atualizarDesconto();
						}

						System.out.println("Dados importados e descontos atualizados!");
						break;

					case 2:
						 //Exibição das listas
						CsvImport.exibirListaPessoa(listaPessoas);
						CsvImport.exibirListaFuncionario(listaFuncionarios);
						CsvImport.exibirListaDependentes(listaDependentes);
						CsvImport.exibirListafolha(listafolha);
						
						break;

					case 3:
						//Exportar arquivo csv
						CsvExport.exportFuncionario(listaFuncionarios);
						CsvExport.exportDependentes(listaDependentes);
						CsvExport.exportFolha(listafolha);
						
						break;

					case 4:
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
						
						break;
						
					case 0:
						System.out.println("Sistema encerrado.");
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
				}
			} catch (Exception e) {
				// Captura todas as exceções lançadas pelo método chamado
				System.out.println("Erro ao processar o arquivo: " + e.getMessage());
			}
			
		}
		sc.close();
		
	}
	
	
}
