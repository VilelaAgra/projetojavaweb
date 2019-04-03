package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private static Connection conexao = null;	
	private static final String USER = "postgres";
	private static final String PASS = "post";
	private static final String URL = "localhost:5432/aula_27-03-2019";
	
	public static Connection getConnection() {		
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://"+URL, USER, PASS);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}		
		return conexao;
	}
	
	public static void closeConnection() {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
