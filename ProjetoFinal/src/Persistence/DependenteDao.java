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
        String sql = "INSERT INTO dependentes (nome, cpf, datanascimento, status) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, dependente.getNome());
            stmt.setString(2, dependente.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(dependente.getDataNascimento()));
            stmt.setString(4, dependente.getParentesco().name());
            stmt.execute();
            System.out.println("Dependente cadastrado com sucesso!");
        } catch (Exception e) {
            System.err.println("Dependente não cadastrado !!!");
        }
    }

}