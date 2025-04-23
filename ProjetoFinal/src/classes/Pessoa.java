package classes;

import java.sql.Date;
import java.time.LocalDate;

public abstract class Pessoa {

	// Atributos
	protected Integer id;
	protected String nome;
	protected String cpf;
	protected LocalDate dataNascimento;

	// Construtor
	public Pessoa(Integer id, String nome, String cpf, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	//toString
	@Override
	public String toString() {
		return "Nome: " + nome + ", cpf: " + cpf + ", D. Nasc: " + dataNascimento;
	}

	// Getters Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
