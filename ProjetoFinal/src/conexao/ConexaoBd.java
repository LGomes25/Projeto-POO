package conexao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	public class ConexaoBd {
	
	private String url = "jdbc:postgresql://localhost:5432/POO-FINAL-POSTGREE";
	private String username = "postgres";
	private String password = "123456";

	public Connection getConnection() {
	System.out.println("Fazendo a conexão....");
	Connection connection = null;
	try {
	connection = DriverManager.getConnection(url, username, password);
	System.out.println("Conectado com sucesso!");
	} catch (SQLException e) {
	System.err.println("Conexão não efetuada!");
	e.printStackTrace();
	}
	return connection;
	}

}