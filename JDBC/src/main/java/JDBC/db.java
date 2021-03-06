package JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class db {
	
	
	private static Connection Conexao;
	
	public static Properties getPropriedades() throws IOException {
		Properties propriedades = new Properties();
		FileInputStream file = new FileInputStream("./propriedades/db.properties");
		propriedades.load(file);
		
		return propriedades;
	}
	
	public static Connection getConexao() throws IOException, SQLException {
		
		Properties p = db.getPropriedades();
		
		Conexao = DriverManager.getConnection(p.getProperty("host"),
												p.getProperty("user"), 
												p.getProperty("password"));
		return Conexao;
	}
	
	public static void closeConexao() throws SQLException {
		if(Conexao != null) {
			Conexao.close();
		}
			
	}
}
