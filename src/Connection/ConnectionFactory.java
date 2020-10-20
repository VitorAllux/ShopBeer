/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
	public static Connection getConnection(final String nomeBanco, final String usuario, final String senha) {
		return getConnection("localhost", "5432", nomeBanco, usuario, senha);
	}
	
	public static Connection getConnection(final String ipBanco, final String portaBanco, final String nomeBanco, final String usuario, final String senha) {
		Connection Conn = null;
		
		try {
			Conn = DriverManager.getConnection("jdbc:postgresql://"+ipBanco+":"+portaBanco+"/"+nomeBanco, usuario, senha);
			System.out.println("conectado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("falha ao conectar!");
		}
		
		return Conn;
	}
}
