package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	//método para conectar com o banco de dados
	
	public static Connection getConnetion() {

		if(conn == null) {
			try {
			
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			
			conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			
				throw new DbException(e.getMessage());
			}
		}
		
		return conn;
	}
	
	//leitura das propriedades
	private static Properties loadProperties() {

		// Abrir o arquivo, ler os dados e guardar no objeto
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	//Fechar a conexão com o banco
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
