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
        String sql = "INSERT INTO funcionario(id, nome, cpf, datanascimento, salariobruto, descontoinss, descontoir) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setDate(4, java.sql.Date.valueOf(funcionario.getDataNascimento()));
            stmt.setDouble(5, funcionario.getSalarioBruto());
            stmt.setDouble(6, funcionario.getDescontoInss());
            stmt.setDouble(7, funcionario.getDescontoIr());
            stmt.execute();
            System.out.println("Cadastrado com sucesso!");
        } catch (Exception e) {
            System.err.println("Funcionário não cadastrado!");
        }
    }

//    public static void main(String[] args) {
//        FuncionarioDao dao = new FuncionarioDao();
//Funcionario funcionario = new Funcionario(null, "Taiane", "11111111111", LocalDate.parse("2025/04/22"), 10000.0, 900.0, 1200.0);
//        dao.inserir(funcionario);
//    }
}