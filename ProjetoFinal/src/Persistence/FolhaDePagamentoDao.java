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
		String sql = "INSERT INTO folhapagamento(nomefuncionario, cpf, datapagamento, descontoinss, descontoir, salarioliquido) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, folha.getNome());
			stmt.setString(2, folha.getCpf());
			stmt.setDate(3, java.sql.Date.valueOf(folha.getDataPagamento()));
			stmt.setDouble(4, folha.getDescontoInss());
			stmt.setDouble(5, folha.getDescontoIr());
			stmt.setDouble(6, folha.getSalarioLiquido());
			stmt.execute();
			System.out.println("Folha de Pagamento processada com sucesso!");
		} catch (Exception e) {
			System.err.println("Folha de Pagamento não processada!");
		}
	}

}