package csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import calculos.FolhaPagamento;
import classes.Funcionario;
import classes.Dependente;
import classes.Pessoa;
import enumEinterface.ParentescoEnum;
import exceptions.ArquivoNaoEncontrado;
import exceptions.CpfDuplicado;
import exceptions.IdadeInvalida;

public class CsvImport {

	public static void importar(List<Pessoa> listaPessoas, List<Funcionario> listaFuncionarios,
			List<Dependente> listaDependentes, List<FolhaPagamento> listafolha)
			throws CpfDuplicado, IdadeInvalida, ArquivoNaoEncontrado {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int contdependente=0;//contador de dependente individual

		Set<String> cpfsUnicos = new HashSet<>(); // Para garantir unicidade dos CPFs

		try {
			System.out.println("Digite o caminho do arquivo: ");
			String nomeArquivo = sc.next();

			// Verificar se o arquivo existe
			try {
				FileReader file = new FileReader(nomeArquivo);
				@SuppressWarnings("resource") // sc2 nunca fecha
				Scanner sc2 = new Scanner(file);

				while (sc2.hasNextLine()) {
					String linha = sc2.nextLine();

					if (linha.isEmpty()) {// Ignorar linhas em branco
					
						if (!listaFuncionarios.isEmpty()) {//Add dependentes
							listaFuncionarios.get(listaFuncionarios.size() - 1).setContdependente(contdependente);
						}
						if (!listafolha.isEmpty()) {//Add dependentes em
							listafolha.get(listafolha.size() - 1).setContdependente(contdependente);
						}
						continue;
					}

					String[] dados = linha.split(";");

					String nome = dados[0];
					String cpf = dados[1];
					LocalDate dataNascimento = LocalDate.of(Integer.parseInt(dados[2].substring(0, 4)),
							Integer.parseInt(dados[2].substring(4, 6)), Integer.parseInt(dados[2].substring(6, 8)));

					// Verificar duplicidade do CPF
					if (!cpfsUnicos.add(cpf)) {
						throw new CpfDuplicado("CPF duplicado encontrado: " + cpf);
					}

					// Condicional no último campo
					if (dados[3].contains(".")) { // Funcionário identificado pelo salário bruto
						contdependente = 0;
						Double salario = Double.parseDouble(dados[3]);
						Funcionario funcionario = new Funcionario(listaFuncionarios.size() + 1, nome, cpf,
								dataNascimento, salario);
						listaPessoas.add(funcionario);
						listaFuncionarios.add(funcionario);

						FolhaPagamento folhaPagamento = new FolhaPagamento(funcionario.getId(), funcionario.getNome(),
								funcionario.getCpf(), funcionario.getDataNascimento(), funcionario.getSalarioBruto());
						listafolha.add(folhaPagamento);

					} else { // Dependente identificado pelo parentesco
						ParentescoEnum parentesco = ParentescoEnum.valueOf(dados[3]);
						
						// Validação de idade do dependente
						if (LocalDate.now().getYear() - dataNascimento.getYear() >= 18) {
							throw new IdadeInvalida("Dependente inválido (18 anos ou mais): " + nome);
						}
						
						Dependente dependente = new Dependente(listaDependentes.size() + 1, nome, cpf, dataNascimento,
								parentesco);
						listaPessoas.add(dependente);
						listaDependentes.add(dependente);
						
						contdependente++;
					}
				}
				sc2.close();
			} catch (FileNotFoundException e) {
				throw new ArquivoNaoEncontrado(
						"Erro: O arquivo especificado não foi encontrado. Caminho: " + nomeArquivo);
			}

			System.out.println("Dados carregados com sucesso!!!");

		} catch (CpfDuplicado | IdadeInvalida | ArquivoNaoEncontrado e) {
			System.out.println("Erro ao processar o arquivo: " + e.getMessage());
		} 
	}

	// Método lista completa de Pessoa
	public static void exibirListaPessoa(List<Pessoa> listaPessoas) {
		System.out.println("\n--------------------- Lista Completa de Pessoas ---------------------");
		for (Pessoa pessoa : listaPessoas) {
			System.out.println(pessoa);
		}
	}

	// Método lista de Funcionários
	public static void exibirListaFuncionario(List<Funcionario> listaFuncionarios) {
		System.out.println("\n--------------------- Lista de Funcionários ---------------------");
		for (Funcionario funcionario : listaFuncionarios) {
			System.out.println(funcionario);
		}
	}

	// Método lista de Dependentes
	public static void exibirListaDependentes(List<Dependente> listaDependentes) {
		System.out.println("\n--------------------- Lista de Dependentes ---------------------");
		for (Dependente dependente : listaDependentes) {
			System.out.println(dependente);
		}
	}

	// Método lista folha pgmt
	public static void exibirListafolha(List<FolhaPagamento> listafolha) {
		System.out.println("\n--------------------- Lista Folha ---------------------");
		for (FolhaPagamento folha : listafolha) {
			System.out.println(folha);
		}
	}

}
