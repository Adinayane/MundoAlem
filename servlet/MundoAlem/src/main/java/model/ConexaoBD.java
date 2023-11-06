package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	 private static final String driver = "com.mysql.cj.jdbc.Driver";
	 private static final String username = "root";
	 private static final String password = "adysouza";
	 private static final String url = "jdbc:mysql://localhost:3306/mundoalem";

	 public static Connection fazConexao() throws ClassNotFoundException, SQLException {
	      Class.forName(driver);
	      Connection conexao = DriverManager.getConnection(url, username, password);
	      return conexao;
	 }
}
