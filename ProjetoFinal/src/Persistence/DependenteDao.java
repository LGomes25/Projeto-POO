package Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;

import classes.Dependente;
import conexao.ConexaoBd;

public class DependenteDao {
    private Connection connection;

    public DependenteDao() {
        this.connection = new ConexaoBd().getConnection();
    }

    public void inserir(Dependente dependente) {
        String sql = "INSERT INTO dependente(id, nome, cpf, data_nascimento, status) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, dependente.getId());
            stmt.setString(2, dependente.getNome());
            stmt.setString(3, dependente.getCpf());
            stmt.setDate(4, java.sql.Date.valueOf(dependente.getDataNascimento()));
            stmt.setString(5, dependente.getParentesco().name());
            stmt.execute();
            System.out.println("Dependente cadastrado com sucesso!");
        } catch (Exception e) {
            System.err.println("Dependente não cadastrada!");
        }
    }

//    public static void main(String[] args) {
//        DependenteDao daoPessoaDao = new DependenteDao();
//        Pessoa pessoa = new Pessoa(1, "Taiane", "00000000000", LocalDate.parse("2025/04/22", "Parentesco"));
//        dao.inserir(pessoa);
//    }
}