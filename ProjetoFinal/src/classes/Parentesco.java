package classes;

import java.time.LocalDate;

import enumEinterface.ParentescoEnum;

public class Parentesco extends Pessoa{

	//Atributos 
	private ParentescoEnum parentesco;

	//Construtor
	public Parentesco(Integer id, String nome, String cpf, LocalDate dataNascimento, ParentescoEnum parentesco) {
		super(id, nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	//toString
	@Override
	public String toString() {
		return super.toString() + "Parentesco: " + parentesco;
	}

	//Getters Setters
	public ParentescoEnum getParentesco() {
		return parentesco;
	}

	public void setParentesco(ParentescoEnum parentesco) {
		this.parentesco = parentesco;
	}

	
	
	 
	
}
