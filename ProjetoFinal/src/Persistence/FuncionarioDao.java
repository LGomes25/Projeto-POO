package Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;

import classes.Funcionario;
import conexao.ConexaoBd;


public class FuncionarioDao {
    private Connection connection;

    public FuncionarioDao() {
        this.connection = new ConexaoBd().getConnection(); // Corrigido para usar o atributo da classe
    }

    public void inserir(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario(nome, cpf, datanascimento, salariobruto, descontoinss, descontoir) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCpf());
			stmt.setDate(3, java.sql.Date.valueOf(funcionario.getDataNascimento()));
			stmt.setDouble(4, funcionario.getSalarioBruto());
			stmt.setDouble(5, funcionario.getDescontoInss());
			stmt.setDouble(6, funcionario.getDescontoIr());
			stmt.execute();
			System.out.println("Funcionário cadastrado com sucesso!");
		} catch (Exception e) {
			System.err.println("Funcionário não cadastrado!");
		}
	}
}