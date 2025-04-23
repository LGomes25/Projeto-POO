package Persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;

import calculos.FolhaPagamento;
import conexao.ConexaoBd;

public class FolhaDePagamentoDao {
    private Connection connection;

    public FolhaDePagamentoDao() {
        this.connection = new ConexaoBd().getConnection();
    }

    public void inserir(FolhaPagamento folha) {
        String sql = "INSERT INTO folha_pagamento(id, nomefuncionario, cpf, datapagamento, salariobruto, descontoinss, descontoir, salarioliquido) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, folha.getId());
            stmt.setString(2, folha.getNome());
            stmt.setString(3, folha.getCpf());
            stmt.setDate(4, java.sql.Date.valueOf(folha.getDataPagamento()));
            stmt.setDouble(5, folha.getDescontoInss());
            stmt.setDouble(6, folha.getDescontoIr());
            stmt.setDouble(7, folha.getSalarioLiquido());
            stmt.execute();
            System.out.println("Folha de pagamento cadastrada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar folha de pagamento!");
        }
    }

//    public static void main(String[] args) {
//        FolhaDePagamentoDao daoFolhaDePagamento = new Persistence.FolhaDePagamentoDao();
//
//        Folha folha = new Folha(1, "Taiane", "11111111111", LocalDate.parse("2025/04/22"), 10000.0, 900.0, 1200.0, 8800.0);
//        dao.inserir(folha);
//    }
}