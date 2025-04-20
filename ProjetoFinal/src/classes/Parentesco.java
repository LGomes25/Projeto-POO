package classes;

import java.time.LocalDate;

import enumEinterface.ParentescoEnum;

public class Parentesco extends Pessoa{

	//Atributos 
	private ParentescoEnum parentesco;

	//Construtor
	public Parentesco(String nome, String cpf, LocalDate dataNascimento, ParentescoEnum parentesco) {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	//toString
	@Override
	public String toString() {
		return "Parentesco [parentesco=" + parentesco + "]";
	}

	//Getters Setters
	public ParentescoEnum getParentesco() {
		return parentesco;
	}

	public void setParentesco(ParentescoEnum parentesco) {
		this.parentesco = parentesco;
	}

	
	
	 
	
}
