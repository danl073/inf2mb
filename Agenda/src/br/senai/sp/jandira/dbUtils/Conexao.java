package br.senai.sp.jandira.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao { 
	
	private static Connection con;
	
	public static Connection abrirConexao() {
		con = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = "jdbc:ucanaccess://C:/Users/17259197/Documents/Gitinf2mb/inf2mb/agenda.accdb";
			con = DriverManager.getConnection(dbURL) ;
			System.out.println("Banco conectado com sucesso");
		} catch (Exception erro) {
			System.out.println("A Torre");
			System.out.println(erro.getMessage());
		}
		
		return con;
	}

}
