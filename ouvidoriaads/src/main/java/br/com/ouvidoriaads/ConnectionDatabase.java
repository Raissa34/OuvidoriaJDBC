package br.com.ouvidoriaads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionDatabase {
	static final String url = "jdbc:mysql://localhost:3306/sistemajdbc";
	static final String userdb = "root";
	static final String password = "Raissa11@";
	static Connection conn;

	public static Connection getConnection() throws SQLException {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection(url, userdb, password);
				return conn;
			}
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao acessar banco! Erro (getConnection): " + erro.getMessage());
		}
		return conn;
	}

	public static Connection closeConnection() {
				try {
					if (conn != null) {
					conn.close();
					return conn;}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null,
							"Ocorreu um erro ao encerrar conexão com o banco! Erro (closeConnection): " + erro.getMessage());
				}return conn;
			}

}


