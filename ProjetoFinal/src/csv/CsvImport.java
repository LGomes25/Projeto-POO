package csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import classes.Funcionario;
import classes.Parentesco;
import classes.Pessoa;
import enumEinterface.ParentescoEnum;
import exceptions.ArquivoNaoEncontrado;
import exceptions.CpfDuplicado;
import exceptions.IdadeInvalida;

public class CsvImport {

	public static void importar(List<Pessoa> listaPessoas, List<Funcionario> listaFuncionarios,
			List<Parentesco> listaDependentes) throws CpfDuplicado, IdadeInvalida, ArquivoNaoEncontrado {
		Scanner sc = new Scanner(System.in);
		Set<String> cpfsUnicos = new HashSet<>(); // Para garantir unicidade dos CPFs

		try {
			System.out.println("Digite o caminho do arquivo: ");
			String nomeArquivo = sc.next();

			// Verificar se o arquivo existe e lançar a exceção personalizada se não
			// encontrado
			try {
				FileReader file = new FileReader(nomeArquivo);
				@SuppressWarnings("resource")
				Scanner sc2 = new Scanner(file);

				while (sc2.hasNextLine()) {
					String linha = sc2.nextLine();

					if (linha.isEmpty()) {
						continue; // Ignorar linhas em branco
					}

					String[] dados = linha.split(";");

					// Dados comuns para funcionário e dependente
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
						Double salario = Double.parseDouble(dados[3]);
						Funcionario funcionario = new Funcionario(listaFuncionarios.size() + 1, nome, cpf,
								dataNascimento, salario);
						listaPessoas.add(funcionario);
						listaFuncionarios.add(funcionario);
					} else { // Dependente identificado pelo parentesco
						ParentescoEnum parentesco = ParentescoEnum.valueOf(dados[3]);

						// Validação de idade do dependente
						if (LocalDate.now().getYear() - dataNascimento.getYear() >= 18) {
							throw new IdadeInvalida("Dependente inválido (18 anos ou mais): " + nome);
						}

						Parentesco dependente = new Parentesco(listaDependentes.size() + 1, nome, cpf, dataNascimento,
								parentesco);
						listaPessoas.add(dependente);
						listaDependentes.add(dependente);
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
		} finally {
			sc.close();
		}
	}

	// Método lista completa de Pessoa
	public static void exibirListaPessoa(List<Pessoa> listaPessoas) {
		System.out.println("--------------------- Lista Completa de Pessoas ---------------------");
		for (Pessoa pessoa : listaPessoas) {
			if (pessoa instanceof Funcionario) {
				System.out.println("Funcionário:");
			} else if (pessoa instanceof Parentesco) {
				System.out.println("Dependente:");
			}
			System.out.println(pessoa);
		}
	}

	// Método lista de Funcionários
	public static void exibirListaFuncionario(List<Funcionario> listaFuncionarios) {
		System.out.println("--------------------- Lista de Funcionários ---------------------");
		for (Funcionario funcionario : listaFuncionarios) {
			System.out.println(funcionario);
		}
	}

	// Método lista de Dependentes
	public static void exibirListaDependentes(List<Parentesco> listaDependentes) {
		System.out.println("--------------------- Lista de Dependentes ---------------------");
		for (Parentesco dependente : listaDependentes) {
			System.out.println(dependente);
		}
	}

}
