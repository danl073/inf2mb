package br.senai.sp.jandira.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao { 
	
	private static Connection con;
	
	public static Connection abrirConexao() {
		con = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			//String dbURL = "jdbc:ucanaccess://C:/Users/17259197/Documents/GitInf2m/inf2mb/agenda.accdb";
			String dbURL = "jdbc:ucanaccess:////10.107.134.03/banco/agenda.accdb";
			con = DriverManager.getConnection(dbURL) ;
			System.out.println("Banco conectado com sucesso");
		} 
		catch (Exception erro) {
			System.out.println("Erro");
			System.out.println(erro.getMessage());
		}
		
		return con;
	}

}
